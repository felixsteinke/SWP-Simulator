package simulator.client.game.Frame.Dialog.Connect;

import simulator.client.game.Frame.SimulatorFrame;
import simulator.interfaces.Connection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActionConnectToGameIP extends AbstractAction {

    private final SimulatorFrame frame = SimulatorFrame.getInstance();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frame.connected) {
            JOptionPane.showMessageDialog(SimulatorFrame.getInstance(), "Already Connected");
            return;
        }
        String gameName = frame.connectDialog.getjTextField_GameName().getText();
        String gameCode = frame.connectDialog.getjTextField_GameCode().getText();

        if (gameName.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(frame.connectDialog, "False Input");
            return;
        }

        frame.gameName = gameName;
        frame.gameCode = gameCode;

        String ip = frame.calcIP();
        int port = frame.calcPort();
        System.out.println("Searching Server: " + ip + ":" + port);

        try {
            frame.registry = LocateRegistry.getRegistry(ip, port);
            frame.connection = (Connection) frame.registry.lookup(Connection.class.getName());

            frame.connect(gameName, gameCode);

            frame.connectDialog.dispose();

        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(simulator.client.game.Frame.SimulatorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
