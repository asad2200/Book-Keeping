package account;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dbconnection.DbConnection;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import other.CoustomTable;
import other.shortcutKey;

/**
 *
 * @author ASAD
 */
public class listacc extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     */
    
    Statement st=null;
    Connection con=null;
    ResultSet rs;
    static Point rr;
    static Dimension d1;
    
    static DbConnection db;
    Controller cntrl;
    
    public listacc(java.awt.Frame parent, boolean modal,Point rv,Dimension d,DbConnection db){
        super(parent, modal);
        rr=rv;
        d1=d;
        initComponents();
        this.setLocation(rr);
        this.setSize(d1);
        
        shortcutKey shortcutKey = new shortcutKey(this);
        
        cntrl=new Controller(db);
        this.db=db;
        addWindowListener(
                new WindowAdapter() {
                    public void windowActivated(WindowEvent e){
                        cntrl.acclist(jTable1,false,"");
                        accounttype.setSelectedIndex(0);
                    }
                }
        );
        
        int bg[]={38,115,103};
        int fg[]={255,255,255};
        
        CoustomTable.theader(jTable1,bg,fg);
                
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnhelp = new javax.swing.JButton();
        btnaddaccount = new javax.swing.JButton();
        btnadditem = new javax.swing.JButton();
        btnpayment = new javax.swing.JButton();
        btnreceipt = new javax.swing.JButton();
        btnpurchase = new javax.swing.JButton();
        btnsales = new javax.swing.JButton();
        btnaccdetail = new javax.swing.JButton();
        btnstocksts = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        accounttype = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(209, 237, 225));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(413, 373));

        jPanel1.setBackground(new java.awt.Color(38, 115, 103));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));

        btnhelp.setText(">> Help");
        btnhelp.setEnabled(false);
        btnhelp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnhelp.setMargin(new java.awt.Insets(0, 0, 0, 0));

        btnaddaccount.setText(">> Add Account");
        btnaddaccount.setEnabled(false);
        btnaddaccount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnaddaccount.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnaddaccount.setMargin(new java.awt.Insets(0, 0, 0, 0));

        btnadditem.setText(">> Add Item");
        btnadditem.setEnabled(false);
        btnadditem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnadditem.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnadditem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadditemActionPerformed(evt);
            }
        });

        btnpayment.setText(">> Payment");
        btnpayment.setEnabled(false);
        btnpayment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnpayment.setMargin(new java.awt.Insets(0, 0, 0, 0));

        btnreceipt.setText(">> Receipt");
        btnreceipt.setEnabled(false);
        btnreceipt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnreceipt.setMargin(new java.awt.Insets(0, 0, 0, 0));

        btnpurchase.setText(">> Purchase");
        btnpurchase.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnpurchase.setEnabled(false);
        btnpurchase.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnpurchase.setMargin(new java.awt.Insets(0, 0, 0, 0));

        btnsales.setText(">> Sales");
        btnsales.setEnabled(false);
        btnsales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnsales.setMargin(new java.awt.Insets(0, 0, 0, 0));

        btnaccdetail.setText(">> Account Detail");
        btnaccdetail.setEnabled(false);
        btnaccdetail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnaccdetail.setMargin(new java.awt.Insets(0, 0, 0, 0));

        btnstocksts.setText(">> Stock Status");
        btnstocksts.setEnabled(false);
        btnstocksts.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnstocksts.setMargin(new java.awt.Insets(0, 0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnhelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnaddaccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnadditem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnpayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnreceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnpurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnsales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnaccdetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnstocksts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnhelp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnaddaccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnadditem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnpayment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnreceipt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnpurchase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnaccdetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnstocksts)
                .addGap(0, 429, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(38, 115, 103));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel2.setText(" >>");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize_window_25px.png"))); // NOI18N
        jLabel12.setToolTipText("Minimize");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close_window_25px.png"))); // NOI18N
        jLabel13.setToolTipText("Close");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1193, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(3, 3, 3))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTable1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account Name", "Group", "Country", "State", "Address", "Mobile No", "Balance", "Gst No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(38, 115, 103));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(300);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setMinWidth(300);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(5).setMinWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(200);
        }

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        accounttype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--All--", "sundry creditiors", "sundry debtors" }));
        accounttype.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                accounttypeItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Select Type :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accounttype, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(accounttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1)
                .addGap(6, 6, 6))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1367, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1367, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void btnadditemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadditemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnadditemActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        try {
            Robot rob=new Robot();
            rob.keyPress(KeyEvent.VK_WINDOWS);
            rob.keyPress(KeyEvent.VK_D);
            rob.keyRelease(KeyEvent.VK_WINDOWS);
            rob.keyRelease(KeyEvent.VK_D);
        } catch (AWTException ex) {
            Logger.getLogger(listacc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MessageFormat header=new MessageFormat("List Of Accounts");
        MessageFormat footer=new MessageFormat("***End Of List***");
        try{
            jTable1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Cannot be Print");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void accounttypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_accounttypeItemStateChanged
        if((String)accounttype.getSelectedItem()=="--All--")
             cntrl.acclist(jTable1,false,"");
        else
            cntrl.acclist(jTable1,true,(String)accounttype.getSelectedItem());
    }//GEN-LAST:event_accounttypeItemStateChanged

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
            java.util.logging.Logger.getLogger(listacc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listacc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listacc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listacc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              listacc dialog = new listacc(new javax.swing.JFrame(),true,rr,d1,db);
               dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                     @Override
                    public void windowOpened(java.awt.event.WindowEvent e) {
                       
                    }
                });
                dialog.pack();
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accounttype;
    private javax.swing.JButton btnaccdetail;
    private javax.swing.JButton btnaddaccount;
    private javax.swing.JButton btnadditem;
    private javax.swing.JButton btnhelp;
    private javax.swing.JButton btnpayment;
    private javax.swing.JButton btnpurchase;
    private javax.swing.JButton btnreceipt;
    private javax.swing.JButton btnsales;
    private javax.swing.JButton btnstocksts;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
