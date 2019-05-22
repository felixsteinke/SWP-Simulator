/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulator.Frame.Dialog.Game;

import Simulator.Frame.ActionStartGame;
import Simulator.Frame.SimulatorFrame;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import simulator.interfaces.Client;
import simulator.interfaces.Connection;

/**
 *
 * @author Felix
 * TODO:!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Scroll down and implement the method!
 */
public class CreateGameLobby extends javax.swing.JDialog {

    private SimulatorFrame frame = SimulatorFrame.getInstance();
    /**
     * Creates new form StartDialog
     */
    public CreateGameLobby(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setBounds(50, 50, 400, 250);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_Player = new javax.swing.ButtonGroup();
        jRadioButton_1Player = new javax.swing.JRadioButton();
        jRadioButton_2Player = new javax.swing.JRadioButton();
        jRadioButton_3Player = new javax.swing.JRadioButton();
        jRadioButton_4Player = new javax.swing.JRadioButton();
        jRadioButton_5Player = new javax.swing.JRadioButton();
        jButton_Continue = new javax.swing.JButton();
        jLabel_GameName = new javax.swing.JLabel();
        jTextField_GameName = new javax.swing.JTextField();
        jTextField_GameCode = new javax.swing.JTextField();
        jLabel_Title = new javax.swing.JLabel();
        jLabel_GameCode = new javax.swing.JLabel();
        jButton_ContinuePort = new javax.swing.JButton();
        jButton_ContinueIP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonGroup_Player.add(jRadioButton_1Player);
        jRadioButton_1Player.setText("1 Player");

        buttonGroup_Player.add(jRadioButton_2Player);
        jRadioButton_2Player.setText("2 Player");

        buttonGroup_Player.add(jRadioButton_3Player);
        jRadioButton_3Player.setText("3 Player");

        buttonGroup_Player.add(jRadioButton_4Player);
        jRadioButton_4Player.setText("4 Player");

        buttonGroup_Player.add(jRadioButton_5Player);
        jRadioButton_5Player.setText("5 Player");

        jButton_Continue.setAction(new Simulator.Frame.Dialog.Game.ActionCreateGame());
        jButton_Continue.setText("Quick Game");

        jLabel_GameName.setText("Game-Name:");
        jLabel_GameName.setToolTipText("");

        jLabel_Title.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel_Title.setText("Game-Lobby Settings");

        jLabel_GameCode.setText("Game-Code");

        jButton_ContinuePort.setAction(new ActionCreateGamePort());
        jButton_ContinuePort.setText("Port Game");

        jButton_ContinueIP.setAction(new ActionCreateGameIP());
        jButton_ContinueIP.setText("IP Game");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_Title)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton_1Player)
                            .addComponent(jRadioButton_2Player)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton_4Player)
                                    .addComponent(jRadioButton_3Player)
                                    .addComponent(jRadioButton_5Player))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel_GameName, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                        .addComponent(jLabel_GameCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jButton_ContinueIP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton_ContinuePort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Continue))
                            .addComponent(jTextField_GameName, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_GameCode, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(37, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel_Title)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton_1Player)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_2Player)
                    .addComponent(jLabel_GameName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_GameName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_3Player)
                    .addComponent(jLabel_GameCode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_GameCode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton_4Player)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButton_5Player)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_ContinueIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_ContinuePort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Continue)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_Player;
    private javax.swing.JButton jButton_Continue;
    private javax.swing.JButton jButton_ContinueIP;
    private javax.swing.JButton jButton_ContinuePort;
    private javax.swing.JLabel jLabel_GameCode;
    private javax.swing.JLabel jLabel_GameName;
    private javax.swing.JLabel jLabel_Title;
    private javax.swing.JRadioButton jRadioButton_1Player;
    private javax.swing.JRadioButton jRadioButton_2Player;
    private javax.swing.JRadioButton jRadioButton_3Player;
    private javax.swing.JRadioButton jRadioButton_4Player;
    private javax.swing.JRadioButton jRadioButton_5Player;
    private javax.swing.JTextField jTextField_GameCode;
    private javax.swing.JTextField jTextField_GameName;
    // End of variables declaration//GEN-END:variables

    public ButtonGroup getButtonGroup_Player() {
        return buttonGroup_Player;
    }

    public void setButtonGroup_Player(ButtonGroup buttonGroup_Player) {
        this.buttonGroup_Player = buttonGroup_Player;
    }

    public JRadioButton getjRadioButton_1Player() {
        return jRadioButton_1Player;
    }

    public void setjRadioButton_1Player(JRadioButton jRadioButton_1Player) {
        this.jRadioButton_1Player = jRadioButton_1Player;
    }

    public JRadioButton getjRadioButton_2Player() {
        return jRadioButton_2Player;
    }

    public void setjRadioButton_2Player(JRadioButton jRadioButton_2Player) {
        this.jRadioButton_2Player = jRadioButton_2Player;
    }

    public JRadioButton getjRadioButton_3Player() {
        return jRadioButton_3Player;
    }

    public void setjRadioButton_3Player(JRadioButton jRadioButton_3Player) {
        this.jRadioButton_3Player = jRadioButton_3Player;
    }

    public JRadioButton getjRadioButton_4Player() {
        return jRadioButton_4Player;
    }

    public void setjRadioButton_4Player(JRadioButton jRadioButton_4Player) {
        this.jRadioButton_4Player = jRadioButton_4Player;
    }

    public JRadioButton getjRadioButton_5Player() {
        return jRadioButton_5Player;
    }

    public void setjRadioButton_5Player(JRadioButton jRadioButton_5Player) {
        this.jRadioButton_5Player = jRadioButton_5Player;
    }

    public JTextField getjTextField_GameCode() {
        return jTextField_GameCode;
    }

    public void setjTextField_GameCode(JTextField jTextField_GameCode) {
        this.jTextField_GameCode = jTextField_GameCode;
    }

    public JTextField getjTextField_GameName() {
        return jTextField_GameName;
    }

    public void setjTextField_GameName(JTextField jTextField_GameName) {
        this.jTextField_GameName = jTextField_GameName;
    }

    public int calcPlayerCount(){
        if (frame.gameDialog.getjRadioButton_5Player().isSelected()) {
            return 5;
        } else if (frame.gameDialog.getjRadioButton_4Player().isSelected()) {
            return 4;
        } else if (frame.gameDialog.getjRadioButton_3Player().isSelected()) {
            return 3;
        } else if (frame.gameDialog.getjRadioButton_2Player().isSelected()) {
            return 2;
        } else {
            return 1;
        }
    }
    
    //!!!!MISSING!!!!!!
    public boolean validateInputGameSettings(String name, String code, int count){
        return false;
    }
    
}