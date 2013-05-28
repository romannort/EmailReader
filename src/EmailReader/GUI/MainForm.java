/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailReader.GUI;

import EmailReader.AccountData;
import EmailReader.Commands.ICommand;
import EmailReader.Commands.MarkMessagesReadCommand;
import EmailReader.Commands.RemoveMessagesCommand;
import EmailReader.Commands.ShowAccountsListCommand;
import EmailReader.DateFormatter;
import EmailReader.MessageAddressFormatter;
import EmailReader.MessagesProvider;
import java.util.ArrayList;
import java.util.List;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Roman Nort
 */
public class MainForm extends javax.swing.JFrame {

    private Message[] messages;
    //private List<MessageView> messages;
    private MessagesProvider provider;
    
    private List<Message> selectedMessages;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        // We must set ActiveAccount first
        EditAccounts();
        provider = new MessagesProvider();
        UpdateView();

        tabMessages.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                boolean buttonsMode = false;
                if (lsm.isSelectionEmpty()) {
                    selectedMessages = null;
                } else {
                    selectedMessages = new ArrayList<>();
                    // Find out which indexes are selected.
                    int minIndex = lsm.getMinSelectionIndex();
                    int maxIndex = lsm.getMaxSelectionIndex();
                    for (int i = minIndex; i <= maxIndex; i++) {
                        if (lsm.isSelectedIndex(i)) {
                            selectedMessages.add( messages[i] );
                        }
                    }
                    buttonsMode = true;
                }
                ToggleButtons(buttonsMode);
            }
        });

    }

    /**
     * 
     * @param mode 
     */
    private void ToggleButtons(Boolean mode)
    {
        this.btnRead.setEnabled(mode);
        this.btnRemove.setEnabled(mode);
        this.btnUnread.setEnabled(mode);
    }
    
    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPaneTree = new javax.swing.JScrollPane();
        trFolders = new javax.swing.JTree();
        ScrollPaneTable = new javax.swing.JScrollPane();
        tabMessages = new javax.swing.JTable();
        btnRead = new javax.swing.JButton();
        btnUnread = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        mbMainFormMenu = new javax.swing.JMenuBar();
        mtFile = new javax.swing.JMenu();
        mtRefresh = new javax.swing.JMenuItem();
        mtCloseConnection = new javax.swing.JMenuItem();
        mtEdit = new javax.swing.JMenu();
        mtAccounts = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(795, 490));

        ScrollPaneTree.setViewportView(trFolders);

        tabMessages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Time", "From", "To", "Subject"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabMessages.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tabMessages.getTableHeader().setReorderingAllowed(false);
        ScrollPaneTable.setViewportView(tabMessages);

        btnRead.setText("Read");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnUnread.setText("Unread");
        btnUnread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnreadActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        mbMainFormMenu.setName("mbMainFormMenu"); // NOI18N

        mtFile.setText("File");

        mtRefresh.setText("Refresh");
        mtRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mtRefreshActionPerformed(evt);
            }
        });
        mtFile.add(mtRefresh);

        mtCloseConnection.setText("Close Connection");
        mtCloseConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mtCloseConnectionActionPerformed(evt);
            }
        });
        mtFile.add(mtCloseConnection);

        mbMainFormMenu.add(mtFile);

        mtEdit.setText("Edit");

        mtAccounts.setText("Accounts");
        mtAccounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mtAccountsActionPerformed(evt);
            }
        });
        mtEdit.add(mtAccounts);

        mbMainFormMenu.add(mtEdit);

        setJMenuBar(mbMainFormMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTree, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUnread)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ScrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRead)
                    .addComponent(btnUnread)
                    .addComponent(btnRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ScrollPaneTree, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mtAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mtAccountsActionPerformed
        EditAccounts();
    }//GEN-LAST:event_mtAccountsActionPerformed

    private void EditAccounts() {
        ICommand accountSettings = new ShowAccountsListCommand();
        accountSettings.Execute();
    }

    private void mtRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mtRefreshActionPerformed

        UpdateView();
    }//GEN-LAST:event_mtRefreshActionPerformed

    private void mtCloseConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mtCloseConnectionActionPerformed
        provider.CloseConnection();
    }//GEN-LAST:event_mtCloseConnectionActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        ICommand markMessages = new MarkMessagesReadCommand(selectedMessages, true);
        markMessages.Execute();
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnUnreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnreadActionPerformed
        ICommand markMessages = new MarkMessagesReadCommand(selectedMessages, false);
        markMessages.Execute();
    }//GEN-LAST:event_btnUnreadActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        ICommand removeCommand = new RemoveMessagesCommand(selectedMessages);
        removeCommand.Execute();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void UpdateView() {

        if (AccountData.ActiveAccount == null) {
            EditAccounts();
        }
        messages = provider.GetMessages();
        TableModel tabModel = new AbstractTableModel() {
            @Override
            public String getColumnName(int col) {
                switch (col) {
                    case 0:
                        return "Date";
                    case 1:
                        return "From";
                    case 2:
                        return "To";
                    case 3:
                        return "Subject";
                    default:
                        return "";
                }
            }

            @Override
            public int getRowCount() {
                return messages.length;
            }

            @Override
            public int getColumnCount() {
                return 4;
            }

            @Override
            public Object getValueAt(int row, int col) {
                try {
                    if (row >= 0 && row < getRowCount()) {
                        switch (col) {
                            case 0:
                                return DateFormatter.Format(messages[row].getReceivedDate());
                            case 1:
                                return MessageAddressFormatter.Format(messages[row].getFrom());
                            case 2:
                                return MessageAddressFormatter.Format(messages[row].getRecipients(Message.RecipientType.TO));
                            case 3:
                                return messages[row].getSubject();
                            default:
                                return "";
                        }
                    }
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                return "";
            }

            /**
             * All cells are immutable.
             */
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tabMessages.setModel(tabModel);
    }

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPaneTable;
    private javax.swing.JScrollPane ScrollPaneTree;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUnread;
    private javax.swing.JMenuBar mbMainFormMenu;
    private javax.swing.JMenuItem mtAccounts;
    private javax.swing.JMenuItem mtCloseConnection;
    private javax.swing.JMenu mtEdit;
    private javax.swing.JMenu mtFile;
    private javax.swing.JMenuItem mtRefresh;
    private javax.swing.JTable tabMessages;
    private javax.swing.JTree trFolders;
    // End of variables declaration//GEN-END:variables
}
