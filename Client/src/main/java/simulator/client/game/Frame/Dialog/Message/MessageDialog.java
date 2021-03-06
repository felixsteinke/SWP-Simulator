package simulator.client.game.Frame.Dialog.Message;

import javax.swing.*;

public class MessageDialog extends javax.swing.JDialog {

    private final DefaultListModel chatModel;

    /**
     * Creates new form MessageDialog
     */
    public MessageDialog(java.awt.Frame parent, boolean modal, DefaultListModel model) {
        super(parent, modal);
        this.setBounds(50, 50, 400, 250);
        this.chatModel = model;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        super.pack();
        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane_Chat = new javax.swing.JScrollPane();
        jList_Chat = new javax.swing.JList<>();
        jTextField_InputMesg = new javax.swing.JTextField();
        jButton_Send = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jList_Chat.setBorder(javax.swing.BorderFactory.createTitledBorder("Chat"));
        jList_Chat.setModel(chatModel);
        jScrollPane_Chat.setViewportView(jList_Chat);

        jTextField_InputMesg.setAction(new ActionSendButton());
        jTextField_InputMesg.setBorder(javax.swing.BorderFactory.createTitledBorder("Message"));

        jButton_Send.setAction(new ActionSendButton());
        jButton_Send.setText("Send");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField_InputMesg, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton_Send, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane_Chat))
                                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane_Chat, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField_InputMesg, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                        .addComponent(jButton_Send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Send;
    private javax.swing.JList<String> jList_Chat;
    private javax.swing.JScrollPane jScrollPane_Chat;
    private javax.swing.JTextField jTextField_InputMesg;
    // End of variables declaration//GEN-END:variables

    public JTextField getjTextField_InputMesg() {
        return jTextField_InputMesg;
    }
}
