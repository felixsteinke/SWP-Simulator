package simulator.client.game.Frame;

import simulator.data.PlayerDatabase;
import simulator.data.RaceTrack;
import simulator.interfaces.Client;

import javax.swing.*;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Peter Heusch
 */
public class ClientImpl implements Client { //old BarImpl

    public ClientImpl() {
    }

    @Override
    public void receiveString(String data) {
        System.out.println("Client: String received - " + data);
        SimulatorFrame.getInstance().chatModel.addElement(data);
        SimulatorFrame.getInstance().consoleModel.addElement("You got a Chat - Message.");
    }

    @Override
    public void receivePlayerDatabase(PlayerDatabase data) throws RemoteException {
        System.out.println("Client: PlayerDatabase received");
        SimulatorFrame.getInstance().playerDatabase = data;
        SimulatorFrame.getInstance().repaint();
    }

    @Override
    public void receiveRacetrack(RaceTrack data) throws RemoteException {
        System.out.println("Client: RaceTrack received");
        SimulatorFrame.getInstance().setRaceTrackToPlay(data);
        SimulatorFrame.getInstance().consoleModel.addElement("RaceTrack: " + data.getName() + " got selected.");
        SimulatorFrame.getInstance().repaint();
    }

    @Override
    public void receiveRacetracksList(String data) throws RemoteException {
        System.out.println("Client: RaceTrackList received");
        //Dialog mit jList machen, und dann auswählen welches genommen werden soll
        JOptionPane.showMessageDialog(SimulatorFrame.getInstance(), data, "RaceTrack - List", JOptionPane.INFORMATION_MESSAGE);
        SimulatorFrame.getInstance().consoleModel.addElement("RaceTrackList received");
    }

    @Override
    public void receiveFeedback(String data) throws RemoteException {
        System.out.println("Client: Feedback received: " + data);

        String[] feedback = data.split(":");
        int feedbackCode = Integer.valueOf(feedback[0]);
        String feedbackMessage = feedback[1];
        Thread t = new Thread(() -> {
            switch (feedbackCode) {
                case 111:
                    unexportClient();
                    SimulatorFrame.getInstance().consoleModel.addElement(feedbackMessage);
                    break;
                case 222:
                    JOptionPane.showMessageDialog(SimulatorFrame.getInstance(), feedbackMessage);
                    break;
                case 333:
                    break;
                case 444:
                    break;
                case 555:
                    enableTurn();
                    break;
                case 666:
                    break;
                case 777:
                    break;
                case 888:
                    JOptionPane.showMessageDialog(SimulatorFrame.getInstance(), feedbackMessage);
                    break;
                case 999:
                    SimulatorFrame.getInstance().consoleModel.addElement(feedbackMessage);
                    break;
                default:
                    System.out.println("False code for feedback.");
            }
        });
        t.start();
    }

    private void enableTurn() {
        SimulatorFrame.getInstance().jButton_Turn.setEnabled(true);
        SimulatorFrame.getInstance().jLabelTurn.setVisible(true);
    }

    private void unexportClient() {
        try {
            UnicastRemoteObject.unexportObject(SimulatorFrame.getInstance().ClientImpl, false);
            SimulatorFrame.getInstance().connected = false;
        } catch (NoSuchObjectException ex) {
            Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
