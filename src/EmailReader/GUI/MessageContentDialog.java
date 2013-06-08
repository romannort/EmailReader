package EmailReader.GUI;

import EmailReader.MessageAddressFormatter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;

/**
 * Shows message content.
 *
 * @author Roman Nort
 */
public class MessageContentDialog extends javax.swing.JDialog {

    private Message message;
    private String To = "";
    private String From = "";
    private String Subject = "";
    private String Content = "";

    /**
     *
     * @param message
     * @param parent
     * @param modal
     */
    public MessageContentDialog(Message message, java.awt.Frame parent, boolean modal) {
        this(parent, modal);
        this.message = message;
        PopulateFields();
    }

    /**
     *
     * @param parent
     * @param modal
     */
    public MessageContentDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    private void PopulateFields() {
        try {

            this.tbTO.setText( MessageAddressFormatter.FormatAll(message.getRecipients(Message.RecipientType.TO)));
            this.tbFrom.setText(MessageAddressFormatter.FormatAll(message.getFrom()));
            this.tbSubject.setText(message.getSubject());
            txtContent.setText(ParseMessageContent());
            
        } catch (MessagingException ex) {
            Logger.getLogger(MessageContentDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @return 
     */
    private String ParseMessageContent() {
        String result = "";
        try {
            result = ParsePart(message, 0);
        } catch (MessagingException ex) {
            Logger.getLogger(MessageContentDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MessageContentDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     * 
     * @param part
     * @param level
     * @return
     * @throws MessagingException
     * @throws IOException 
     */
    private String ParsePart(Part part, Integer level) throws MessagingException, IOException {

        if (part.isMimeType("text/*")) {
            return (String) part.getContent();
        } else if (part.isMimeType("multipart/*")) {
            
            Multipart mp = 
                    (Multipart) part.getContent();
            
            level++;
            int count = mp.getCount();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append(ParsePart(mp.getBodyPart(i), level));
            }
            level--;
            return sb.toString();
        } else if (part.isMimeType("message/rfc822")) {
            level++;
            return ParsePart((Part) part.getContent(), level);
        }
        return "";
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextPane();
        tbTO = new javax.swing.JTextField();
        lblTO = new javax.swing.JLabel();
        tbFrom = new javax.swing.JTextField();
        lblFrom = new javax.swing.JLabel();
        tbSubject = new javax.swing.JTextField();
        lblSubject = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 400));

        txtContent.setEditable(false);
        txtContent.setContentType("text/html"); // NOI18N
        jScrollPane1.setViewportView(txtContent);

        tbTO.setEditable(false);

        lblTO.setText("To");

        tbFrom.setEditable(false);

        lblFrom.setText("From");

        tbSubject.setEditable(false);

        lblSubject.setText("Subject");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTO)
                            .addComponent(lblFrom)
                            .addComponent(lblSubject, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tbFrom, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                            .addComponent(tbSubject)
                            .addComponent(tbTO))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTO))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFrom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubject))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MessageContentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MessageContentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MessageContentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MessageContentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MessageContentDialog dialog = new MessageContentDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFrom;
    private javax.swing.JLabel lblSubject;
    private javax.swing.JLabel lblTO;
    private javax.swing.JTextField tbFrom;
    private javax.swing.JTextField tbSubject;
    private javax.swing.JTextField tbTO;
    private javax.swing.JTextPane txtContent;
    // End of variables declaration//GEN-END:variables
}
