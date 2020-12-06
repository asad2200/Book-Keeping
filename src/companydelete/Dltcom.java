package companydelete;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import comapnycreate.Crtcmp;
import dbconnection.DbConnection;
import other.shortcutKey;




/**
 *
 * @author ASAD
 */
public class Dltcom extends javax.swing.JDialog {
    static Point rr;
    static Dimension d1;
    DefaultTableModel model1;
    DefaultTableModel model2;
    
    static DbConnection db;
    Controller cntrl;
    
    public Dltcom(java.awt.Frame parent, boolean modal,Point rv,Dimension d,DbConnection db){
        super(parent, modal);
        rr=rv;
        d1=d;
        initComponents();
        this.setLocation(rr);
        this.setSize(d1);
        tblcmpname.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
        tblcmpname.setRowHeight(25);
        tblcmpno.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
        tblcmpno.setRowHeight(25);
        
        shortcutKey shortcutKey = new shortcutKey(this);
        
        cntrl=new Controller(db);
        this.db=db;
        
        cntrl.fetchcmpdetail(tblcmpno,tblcmpname); 
        addWindowListener(
                new WindowAdapter(){
                 public void windowOpened(WindowEvent e){
                     tblcmpname.requestFocus();
                 }   
                }
        );
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcmpname = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblcmpno = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btndltcmp = new javax.swing.JButton();
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
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(209, 237, 225));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(209, 237, 225));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        tblcmpname.setBackground(new java.awt.Color(209, 237, 225));
        tblcmpname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblcmpname.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        tblcmpname.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblcmpname.setColumnSelectionAllowed(true);
        tblcmpname.setFocusable(false);
        tblcmpname.setGridColor(new java.awt.Color(0, 0, 0));
        tblcmpname.setOpaque(false);
        tblcmpname.setRowHeight(25);
        tblcmpname.setSelectionBackground(new java.awt.Color(38, 115, 103));
        tblcmpname.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblcmpname.getTableHeader().setReorderingAllowed(false);
        tblcmpname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblcmpnameKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblcmpname);
        tblcmpname.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        tblcmpno.setBackground(new java.awt.Color(38, 115, 103));
        tblcmpno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblcmpno.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        tblcmpno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblcmpno.setColumnSelectionAllowed(true);
        tblcmpno.setFocusable(false);
        tblcmpno.setGridColor(new java.awt.Color(0, 0, 0));
        tblcmpno.setRowHeight(25);
        tblcmpno.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tblcmpno.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblcmpno.getTableHeader().setReorderingAllowed(false);
        tblcmpno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblcmpnoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblcmpno);
        tblcmpno.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblcmpno.getColumnModel().getColumnCount() > 0) {
            tblcmpno.getColumnModel().getColumn(0).setResizable(false);
            tblcmpno.getColumnModel().getColumn(0).setPreferredWidth(35);
        }

        jPanel5.setBackground(new java.awt.Color(38, 115, 103));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_checkmark_30px.png"))); // NOI18N
        jLabel3.setText("Select Company");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btndltcmp.setBackground(new java.awt.Color(38, 115, 103));
        btndltcmp.setText("Delete");
        btndltcmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndltcmpActionPerformed(evt);
            }
        });
        btndltcmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btndltcmpKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btndltcmp))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btndltcmp))
        );

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

        jPanel6.setBackground(new java.awt.Color(38, 115, 103));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel2.setText(" >>");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize_window_25px.png"))); // NOI18N
        jLabel5.setToolTipText("Minimize");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close_window_25px.png"))); // NOI18N
        jLabel6.setToolTipText("Close");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1193, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(3, 3, 3))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(429, 429, 429)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 23, 1367, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void btnadditemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadditemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnadditemActionPerformed

    private void tblcmpnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcmpnoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblcmpnoMouseClicked
     
    private void btndltcmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndltcmpActionPerformed
        //String s=(String) tblcmpname.getValueAt(tblcmpname.getSelectedRow(),0);
           if(tblcmpname.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"company was not created");
           }
           else{
               String s=null;
                try{
                   s=(String) tblcmpname.getValueAt(tblcmpname.getSelectedRow(),0);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,"Please select Comapny");
                }
                if(!s.equals("")){
                    int n=JOptionPane.showConfirmDialog(this,"Do you want to DELETE this company ?","Delete ?",JOptionPane.YES_NO_OPTION);
                    if(n==JOptionPane.YES_OPTION)
                   // dispose();
                    new Chkuser4dlt(null,true,s,rr,d1,tblcmpno,tblcmpname,db).show();
                    //check(s,tblcmpno,tblcmpname);
                }
                else{
                    JOptionPane.showMessageDialog(this,"Please select Comapny");
                }
           }
    }//GEN-LAST:event_btndltcmpActionPerformed

    private void tblcmpnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblcmpnameKeyPressed
          ActionEvent ev = null;
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            btndltcmpActionPerformed(ev);
        }
    }//GEN-LAST:event_tblcmpnameKeyPressed

    private void btndltcmpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btndltcmpKeyPressed
       ActionEvent ev = null;
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            btndltcmpActionPerformed(ev);
        }
    }//GEN-LAST:event_btndltcmpKeyPressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        try {
            Robot rob=new Robot();
            rob.keyPress(KeyEvent.VK_WINDOWS);
            rob.keyPress(KeyEvent.VK_D);
            rob.keyRelease(KeyEvent.VK_WINDOWS);
            rob.keyRelease(KeyEvent.VK_D);
        } catch (AWTException ex) {
            Logger.getLogger(Crtcmp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(Dltcom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dltcom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dltcom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dltcom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dltcom dialog = new Dltcom(new javax.swing.JFrame(), true,rr,d1,db);
               dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                     @Override
                    public void windowActivated(java.awt.event.WindowEvent e) {
                       
                    }
                });
                dialog.pack();
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaccdetail;
    private javax.swing.JButton btnaddaccount;
    private javax.swing.JButton btnadditem;
    private javax.swing.JButton btndltcmp;
    private javax.swing.JButton btnhelp;
    private javax.swing.JButton btnpayment;
    private javax.swing.JButton btnpurchase;
    private javax.swing.JButton btnreceipt;
    private javax.swing.JButton btnsales;
    private javax.swing.JButton btnstocksts;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblcmpname;
    private javax.swing.JTable tblcmpno;
    // End of variables declaration//GEN-END:variables

}
