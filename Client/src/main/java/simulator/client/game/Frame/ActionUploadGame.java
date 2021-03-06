package simulator.client.game.Frame;

import simulator.data.RaceTrack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Felix
 */
public class ActionUploadGame extends AbstractAction {

    private final SimulatorFrame frame = SimulatorFrame.getInstance();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frame.getRaceTrackToUpload() == null) {
            JOptionPane.showMessageDialog(frame, "RaceTrack needs to be created first!");
            return;
        }
        if (!frame.connected) {
            JOptionPane.showMessageDialog(frame, "Not Connected.");
            return;
        }

        RaceTrack raceTrack = frame.getRaceTrackToUpload();

        if (validateRaceTrack(raceTrack)) {
            try {
                frame.server.addRaceTrack(raceTrack);
            } catch (RemoteException ex) {
                Logger.getLogger(ActionUploadGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(frame, raceTrack.getName() + " was not ready to upload!");
        }
    }

    private boolean validateRaceTrack(RaceTrack raceTrack) {
        return raceTrack.getName() != null
                && raceTrack.getWidthField() > 0
                && raceTrack.getHeightField() > 0
                && raceTrack.getPointsOutter() > 0
                && raceTrack.getPointsInner() > 0
                && (raceTrack.getCoordOuter().size() == raceTrack.getPointsOutter())
                && (raceTrack.getCoordInner().size() == raceTrack.getPointsInner())
                && (raceTrack.getCoordStart().size() == 2)
                && (raceTrack.getCoordControl().size() == 2)
                && raceTrack.getDistance() > 0
                && raceTrack.getGridSize() > 0
                && raceTrack.getGapSize() > 0
                && raceTrack.getValidPoints() != null
                && raceTrack.getStartPoints() != null;
    }
}
