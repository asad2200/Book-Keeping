package home;

import comapnyedit.Edtcmp;
import companydelete.Dltcom;
import companyopen.Opncmp;
import user.edituser;
import item.itmadd;
import item.listitm;
import item.lmoditm;
import account.lmodacc;
import account.listacc;
import account.accadd;
import com.formdev.flatlaf.FlatIntelliJLaf;
import dbconnection.DbConnection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import ledgerbook.LB_coustmer;
import ledgerbook.LB_suppliar;
import payment.LmodPayment;
import payment.Payment;
import purchase.lmodPurchase;
import purchase.purchase;
import purchasereturn.lmodPurchaseReturn;
import purchasereturn.purchaseReturn;
import receipt.LmodReceipt;
import receipt.Receipt;
import sale.lmodsale;
import sale.sale;
import salereturn.lmodSaleReturn;
import salereturn.saleReturn;

public class home extends javax.swing.JFrame {
    DbConnection db=new DbConnection();
    Controller cntrl =new Controller(db);
    public home(int i ) {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bookkeepingicon.png")));
        setExtendedState(MAXIMIZED_BOTH); 
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        //int width=d.width;
        //int height=d.height-50;
        d.width=d.width-400;
        d.height=d.height-100;
        //setMaximumSize(d);
        //setPreferredSize(new Dimension(width,height));
        setMinimumSize(d);
        setPreferredSize(d);
        setLocation(0, 0);
        unvisible();
        addWindowListener(new java.awt.event.WindowAdapter() {
                  @Override
                    public void windowOpened(java.awt.event.WindowEvent e) {
                      btnopencmp.requestFocusInWindow();
                    }
                    public void windowClosing(WindowEvent e){
                        if(!jLabel2.getText().equals("BookKeeping")){
                            JOptionPane.showMessageDialog(rootPane,"You have to close company Before quit","Can't Quit :(",0);
                            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                        }else
                            System.exit(0);
                    }
        });
        ActionListener scnotepad=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnnotepadActionPerformed(e); 
            }
        };
        getRootPane().registerKeyboardAction(scnotepad,KeyStroke.getKeyStroke(KeyEvent.VK_N,1),JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionListener sccalculator=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btncalculatorActionPerformed(e); 
            }
        };
        getRootPane().registerKeyboardAction(sccalculator,KeyStroke.getKeyStroke(KeyEvent.VK_C,1),JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        
         int j=i;
         if(j==1){
             jPanel5.setVisible(false);
         }
         //jMenu19.setVisible(false);
         jMenuItem39.setVisible(false);
         jMenu20.setVisible(false);
    }
    public void unvisible(){
//        jMenu1.setEnabled(false);
//        jMenu2.setEnabled(false);
//        jMenu3.setEnabled(false);
//        jMenu4.setEnabled(false);
//        jMenu5.setEnabled(false);
//        jMenu6.setEnabled(false);
        jLabel2.setText("BookKeeping");
        jLabel3.setVisible(true);
        jPanel5.setVisible(true);
        btnhelp.setEnabled(false);
        btnaddaccount.setEnabled(false);
        btnadditem.setEnabled(false);
        btnpayment.setEnabled(false);
        btnreceipt.setEnabled(false);
        btnpurchase.setEnabled(false);
        btnsales.setEnabled(false);
        btnaccdetail.setEnabled(false);
        btnstocksts.setEnabled(false);
     }
    public void visible(){
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu5.setEnabled(true);
        jMenu6.setEnabled(true);
        jLabel2.setText("BookKeeping");
        jLabel3.setVisible(true);
        jPanel5.setVisible(true);
        btnhelp.setEnabled(true);
        btnaddaccount.setEnabled(true);
        btnadditem.setEnabled(true);
        btnpayment.setEnabled(true);
        btnreceipt.setEnabled(true);
        btnpurchase.setEnabled(true);
        btnsales.setEnabled(true);
        btnaccdetail.setEnabled(true);
        btnstocksts.setEnabled(true);
     }
    public void min(home hm){
        hm.setExtendedState(home.ICONIFIED);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new other.JPanelGrediant(new Color(38,115,103),new Color(209,237,225));
        jPanel5 = new javax.swing.JPanel();
        btnexitsys = new javax.swing.JButton();
        btndltcmp = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnchk4updt = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnopencmp = new javax.swing.JButton();
        btncrtcmp = new javax.swing.JButton();
        btnabtus = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnadditem = new javax.swing.JButton();
        btnpayment = new javax.swing.JButton();
        btnreceipt = new javax.swing.JButton();
        btnpurchase = new javax.swing.JButton();
        btnsales = new javax.swing.JButton();
        btnaccdetail = new javax.swing.JButton();
        btnaddaccount = new javax.swing.JButton();
        btnhelp = new javax.swing.JButton();
        btnstocksts = new javax.swing.JButton();
        btnnotepad = new javax.swing.JButton();
        btncalculator = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu16 = new javax.swing.JMenu();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenu17 = new javax.swing.JMenu();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu19 = new javax.swing.JMenu();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenu20 = new javax.swing.JMenu();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BooK-Keeping");
        setBackground(new java.awt.Color(102, 102, 102));
        setFocusTraversalPolicyProvider(true);

        jPanel2.setBackground(new java.awt.Color(38, 115, 103));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(38, 115, 103));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoonly.png"))); // NOI18N
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 43)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(209, 237, 225));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BookKeeping");
        jLabel2.setToolTipText("WE ADD VALUE TO YOUR BUISNESS");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(209, 237, 225));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Grow Your Buisness With BookKeeping");

        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 618, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 616, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(209, 237, 225));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(209, 237, 225));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnexitsys.setBackground(new java.awt.Color(209, 237, 225));
        btnexitsys.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnexitsys.setText("Exit Book-Keeping");
        btnexitsys.setBorderPainted(false);
        btnexitsys.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnexitsys.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnexitsys.setInheritsPopupMenu(true);
        btnexitsys.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnexitsysMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnexitsysMouseExited(evt);
            }
        });
        btnexitsys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitsysActionPerformed(evt);
            }
        });

        btndltcmp.setBackground(new java.awt.Color(209, 237, 225));
        btndltcmp.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btndltcmp.setText("Delete Company");
        btndltcmp.setBorderPainted(false);
        btndltcmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndltcmp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btndltcmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btndltcmpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btndltcmpMouseExited(evt);
            }
        });
        btndltcmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndltcmpActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(38, 115, 103));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 3, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(209, 237, 225));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_details_30px_1.png"))); // NOI18N
        jLabel4.setText("Company Detail");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnchk4updt.setBackground(new java.awt.Color(209, 237, 225));
        btnchk4updt.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnchk4updt.setText("Cheak 4 Update");
        btnchk4updt.setBorderPainted(false);
        btnchk4updt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnchk4updt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnchk4updt.setInheritsPopupMenu(true);
        btnchk4updt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnchk4updtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnchk4updtMouseExited(evt);
            }
        });
        btnchk4updt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchk4updtActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_pane_30px.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_plus_30px_2.png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_trash_30px.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_update_30px.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_about_30px.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_shutdown_30px.png"))); // NOI18N

        btnopencmp.setBackground(new java.awt.Color(209, 237, 225));
        btnopencmp.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnopencmp.setText("Open Company");
        btnopencmp.setBorderPainted(false);
        btnopencmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnopencmp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnopencmp.setInheritsPopupMenu(true);
        btnopencmp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnopencmpFocusGained(evt);
            }
        });
        btnopencmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnopencmpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnopencmpMouseExited(evt);
            }
        });
        btnopencmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnopencmpActionPerformed(evt);
            }
        });

        btncrtcmp.setBackground(new java.awt.Color(209, 237, 225));
        btncrtcmp.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btncrtcmp.setText("Create Company");
        btncrtcmp.setBorderPainted(false);
        btncrtcmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncrtcmp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btncrtcmp.setInheritsPopupMenu(true);
        btncrtcmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncrtcmpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncrtcmpMouseExited(evt);
            }
        });
        btncrtcmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncrtcmpActionPerformed(evt);
            }
        });

        btnabtus.setBackground(new java.awt.Color(209, 237, 225));
        btnabtus.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnabtus.setText("About Us");
        btnabtus.setBorderPainted(false);
        btnabtus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnabtus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnabtus.setInheritsPopupMenu(true);
        btnabtus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnabtusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnabtusMouseExited(evt);
            }
        });
        btnabtus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnabtusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnexitsys, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btndltcmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnchk4updt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnopencmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncrtcmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnabtus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51)
                                                .addComponent(btnopencmp))
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(btncrtcmp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btndltcmp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel12))
                                .addGap(7, 7, 7)
                                .addComponent(btnchk4updt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13))
                        .addGap(7, 7, 7)
                        .addComponent(btnabtus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnexitsys, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(38, 115, 103));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));

        btnadditem.setBackground(new java.awt.Color(209, 237, 225));
        btnadditem.setText("F3  Add Item");
        btnadditem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnadditem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadditemActionPerformed(evt);
            }
        });
        btnadditem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnadditemKeyPressed(evt);
            }
        });

        btnpayment.setBackground(new java.awt.Color(209, 237, 225));
        btnpayment.setText("F4  Payment");
        btnpayment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpaymentActionPerformed(evt);
            }
        });
        btnpayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnpaymentKeyPressed(evt);
            }
        });

        btnreceipt.setBackground(new java.awt.Color(209, 237, 225));
        btnreceipt.setText("F5  Receipt");
        btnreceipt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnreceipt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnreceiptKeyPressed(evt);
            }
        });

        btnpurchase.setBackground(new java.awt.Color(209, 237, 225));
        btnpurchase.setText("F6  Purchase");
        btnpurchase.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnpurchase.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnpurchase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnpurchaseKeyPressed(evt);
            }
        });

        btnsales.setBackground(new java.awt.Color(209, 237, 225));
        btnsales.setText("F7  Sales");
        btnsales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnsales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalesActionPerformed(evt);
            }
        });
        btnsales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnsalesKeyPressed(evt);
            }
        });

        btnaccdetail.setBackground(new java.awt.Color(209, 237, 225));
        btnaccdetail.setText("F8  Account Detail");
        btnaccdetail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnaccdetail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnaccdetailKeyPressed(evt);
            }
        });

        btnaddaccount.setBackground(new java.awt.Color(209, 237, 225));
        btnaddaccount.setText("F2  Add Account");
        btnaddaccount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnaddaccount.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnaddaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddaccountActionPerformed(evt);
            }
        });
        btnaddaccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnaddaccountKeyPressed(evt);
            }
        });

        btnhelp.setBackground(new java.awt.Color(209, 237, 225));
        btnhelp.setText("F1  Help");
        btnhelp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnhelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhelpActionPerformed(evt);
            }
        });
        btnhelp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnhelpKeyPressed(evt);
            }
        });

        btnstocksts.setBackground(new java.awt.Color(209, 237, 225));
        btnstocksts.setText("F9  Stock Status");
        btnstocksts.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnstocksts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnstockstsKeyPressed(evt);
            }
        });

        btnnotepad.setBackground(new java.awt.Color(209, 237, 225));
        btnnotepad.setText("Shift+N  Notepad");
        btnnotepad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnnotepad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnotepadActionPerformed(evt);
            }
        });

        btncalculator.setBackground(new java.awt.Color(209, 237, 225));
        btncalculator.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btncalculator.setText("Shift+C  Calculator");
        btncalculator.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btncalculator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalculatorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnadditem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnpayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnreceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnpurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnsales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnaccdetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnaddaccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnhelp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnstocksts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btncalculator, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(btnnotepad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnnotepad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncalculator))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(581, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 578, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(38, 115, 103));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jMenuBar1.setInheritsPopupMenu(true);
        jMenuBar1.setNextFocusableComponent(jMenu2);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(339, 21));

        jMenu6.setBackground(new java.awt.Color(38, 115, 103));
        jMenu6.setText(">>");
        jMenu6.setEnabled(false);
        jMenu6.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jMenu6.setOpaque(true);
        jMenuBar1.add(jMenu6);

        jMenu1.setBackground(new java.awt.Color(38, 115, 103));
        jMenu1.setText("Company");
        jMenu1.setAutoscrolls(true);
        jMenu1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jMenu1.setName(""); // NOI18N
        jMenu1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jMenu1FocusGained(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setBackground(new java.awt.Color(38, 115, 103));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_edit_property_20px_1.png"))); // NOI18N
        jMenuItem1.setText("Edit Company");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_edit_user_male_20px_1.png"))); // NOI18N
        jMenuItem15.setText("Edit User ");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem15);
        jMenu1.add(jSeparator2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_shutdown_20px_3.png"))); // NOI18N
        jMenuItem3.setLabel("Close Company");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(38, 115, 103));
        jMenu2.setText("Master");
        jMenu2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_user_20px.png"))); // NOI18N
        jMenu8.setText("Account");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_20px.png"))); // NOI18N
        jMenuItem2.setText("ADD                   ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem2);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_edit_20px.png"))); // NOI18N
        jMenuItem4.setText("Modify");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_list_20px.png"))); // NOI18N
        jMenuItem5.setText("List");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem5);

        jMenu2.add(jMenu8);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_lift_cart_here_20px.png"))); // NOI18N
        jMenu10.setText("Item");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_20px.png"))); // NOI18N
        jMenuItem9.setText("ADD");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem9);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_edit_20px.png"))); // NOI18N
        jMenuItem10.setText("Modify");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem10);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_list_20px.png"))); // NOI18N
        jMenuItem11.setText("List");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem11);

        jMenu2.add(jMenu10);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(38, 115, 103));
        jMenu3.setText("Transaction");
        jMenu3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jMenu12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_sale_20px.png"))); // NOI18N
        jMenu12.setText("Sales");

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_20px.png"))); // NOI18N
        jMenuItem17.setText("Add");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem17);

        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_edit_20px.png"))); // NOI18N
        jMenuItem18.setText("Modify");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem18);

        jMenu3.add(jMenu12);

        jMenu13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_ticket_purchase_20px.png"))); // NOI18N
        jMenu13.setText("Purchase");

        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_20px.png"))); // NOI18N
        jMenuItem20.setText("Add");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem20);

        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_edit_20px.png"))); // NOI18N
        jMenuItem21.setText("Modify");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem21);

        jMenu3.add(jMenu13);

        jMenu14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_cash_in_hand_20px.png"))); // NOI18N
        jMenu14.setText("Payment");

        jMenuItem23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_20px.png"))); // NOI18N
        jMenuItem23.setText("Add");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem23);

        jMenuItem24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_edit_20px.png"))); // NOI18N
        jMenuItem24.setText("Modify");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem24);

        jMenu3.add(jMenu14);

        jMenu15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_receive_cash_20px.png"))); // NOI18N
        jMenu15.setText("Receipt");

        jMenuItem26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_20px.png"))); // NOI18N
        jMenuItem26.setText("Add");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem26);

        jMenuItem27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_edit_20px.png"))); // NOI18N
        jMenuItem27.setText("Modify");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem27);

        jMenu3.add(jMenu15);
        jMenu3.add(jSeparator3);

        jMenu16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_return_20px.png"))); // NOI18N
        jMenu16.setText("Sale Return");

        jMenuItem32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_20px.png"))); // NOI18N
        jMenuItem32.setText("Add");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem32);

        jMenuItem33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_edit_20px.png"))); // NOI18N
        jMenuItem33.setText("Modify");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem33);

        jMenu3.add(jMenu16);

        jMenu17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_return_purchase_20px.png"))); // NOI18N
        jMenu17.setText("Purchase Return                            ");

        jMenuItem35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_20px.png"))); // NOI18N
        jMenuItem35.setText("Add");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem35);

        jMenuItem36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_edit_20px.png"))); // NOI18N
        jMenuItem36.setText("Modify");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem36);

        jMenu3.add(jMenu17);

        jMenuBar1.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(38, 115, 103));
        jMenu4.setText("Display");
        jMenu4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jMenu19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_copybook_20px.png"))); // NOI18N
        jMenu19.setText("Account Book                               ");

        jMenuItem39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_day_view_20px.png"))); // NOI18N
        jMenuItem39.setText("Day Book");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem39);

        jMenuItem40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_reading_20px.png"))); // NOI18N
        jMenuItem40.setText("Ledger Book Coustmer");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem40);

        jMenuItem43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_reading_20px.png"))); // NOI18N
        jMenuItem43.setText("Ledger Book Suppliar");
        jMenuItem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem43ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem43);

        jMenu4.add(jMenu19);

        jMenu20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_stocks_20px.png"))); // NOI18N
        jMenu20.setText("Stock Status ");

        jMenuItem41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_stocks_20px.png"))); // NOI18N
        jMenuItem41.setText("Sale Analysys");
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        jMenu20.add(jMenuItem41);

        jMenu4.add(jMenu20);

        jMenuBar1.add(jMenu4);

        jMenu5.setBackground(new java.awt.Color(38, 115, 103));
        jMenu5.setText("Help");
        jMenu5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_user_manual_20px.png"))); // NOI18N
        jMenuItem16.setText("Guide");
        jMenu5.add(jMenuItem16);

        jMenuItem38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_about_20px.png"))); // NOI18N
        jMenuItem38.setText("About Us");
        jMenu5.add(jMenuItem38);

        jMenuBar1.add(jMenu5);

        jMenu7.setBackground(new java.awt.Color(38, 115, 103));
        jMenu7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jMenu7.setForeground(new java.awt.Color(255, 255, 255));
        jMenu7.setEnabled(false);
        jMenu7.setIconTextGap(0);
        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1659, 798));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    private void jMenu1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jMenu1FocusGained
    }//GEN-LAST:event_jMenu1FocusGained

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        unvisible();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        
        new Edtcmp(this,true,rr,d1,jLabel2.getText(),jLabel2,db).show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new accadd(this,true,rr,d1,jLabel2.getText(),db).show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new lmodacc(this,true,rr,d1,jLabel2.getText(),db).show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new itmadd(this,true,rr,d1,db).show();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new lmoditm(this,true,rr,d1,db).show();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
         Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new edituser(this,true,rr,d1,jLabel2.getText(),db).show();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem39ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new listacc(this,true,rr,d1,db).show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new listitm(this,true,rr,d1,db).show();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new sale(this,true,rr,d1,db).show();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem41ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new lmodsale(this,true,rr,d1,jLabel2.getText(),db).show();
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void btnhelpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnhelpKeyPressed
        ActionEvent ev = null;
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
            JOptionPane.showMessageDialog(this,"kom kar se");
        }
    }//GEN-LAST:event_btnhelpKeyPressed

    private void btnhelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhelpActionPerformed

    private void btnaddaccountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnaddaccountKeyPressed
        ActionEvent ev = null;
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
            JOptionPane.showMessageDialog(this,"kom kar se");
        }
    }//GEN-LAST:event_btnaddaccountKeyPressed

    private void btnaddaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddaccountActionPerformed
        JOptionPane.showMessageDialog(this,"kom kar se");
    }//GEN-LAST:event_btnaddaccountActionPerformed

    private void btnaccdetailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnaccdetailKeyPressed
        ActionEvent ev = null;
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
            JOptionPane.showMessageDialog(this,"kom kar se");
        }
    }//GEN-LAST:event_btnaccdetailKeyPressed

    private void btnsalesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnsalesKeyPressed
        ActionEvent ev = null;
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
            btnsalesActionPerformed(ev);
        }
    }//GEN-LAST:event_btnsalesKeyPressed

    private void btnpurchaseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnpurchaseKeyPressed
        ActionEvent ev = null;
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
            JOptionPane.showMessageDialog(this,"kom kar se");
        }
    }//GEN-LAST:event_btnpurchaseKeyPressed

    private void btnreceiptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnreceiptKeyPressed
        ActionEvent ev = null;
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
            JOptionPane.showMessageDialog(this,"kom kar se");
        }
    }//GEN-LAST:event_btnreceiptKeyPressed

    private void btnpaymentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnpaymentKeyPressed
        ActionEvent ev = null;
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
            JOptionPane.showMessageDialog(this,"kom kar se");
        }
    }//GEN-LAST:event_btnpaymentKeyPressed

    private void btnadditemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnadditemKeyPressed
        ActionEvent ev = null;
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
            JOptionPane.showMessageDialog(this,"kom kar se");
        }
    }//GEN-LAST:event_btnadditemKeyPressed

    private void btnadditemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadditemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnadditemActionPerformed

    private void btnchk4updtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchk4updtActionPerformed
        JOptionPane.showMessageDialog(this,"Softwere is upto date :)");
    }//GEN-LAST:event_btnchk4updtActionPerformed

    private void btnchk4updtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnchk4updtMouseExited
        btnchk4updt.setBackground(new Color(209,237,225));
        btnchk4updt.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnchk4updtMouseExited

    private void btnchk4updtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnchk4updtMouseEntered
        btnchk4updt.setBackground(new Color(38,115,103));
        btnchk4updt.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnchk4updtMouseEntered

    private void btndltcmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndltcmpActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new Dltcom(this,true,rr,d1,db).show();
    }//GEN-LAST:event_btndltcmpActionPerformed

    private void btndltcmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndltcmpMouseExited
        btndltcmp.setBackground(new Color(209,237,225));
        btndltcmp.setForeground(Color.BLACK);
    }//GEN-LAST:event_btndltcmpMouseExited

    private void btndltcmpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndltcmpMouseEntered
        btndltcmp.setBackground(new Color(38,115,103));
        btndltcmp.setForeground(Color.WHITE);
    }//GEN-LAST:event_btndltcmpMouseEntered

    private void btnexitsysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitsysActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnexitsysActionPerformed

    private void btnexitsysMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexitsysMouseExited
        btnexitsys.setBackground(new Color(209,237,225));
        btnexitsys.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnexitsysMouseExited

    private void btnexitsysMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexitsysMouseEntered
        btnexitsys.setBackground(new Color(38,115,103));
        btnexitsys.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnexitsysMouseEntered

    private void btnstockstsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnstockstsKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnstockstsKeyPressed

    private void btnsalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalesActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new sale(this,true,rr,d1,db).show();
    }//GEN-LAST:event_btnsalesActionPerformed

    private void btnpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpaymentActionPerformed

    private void btnopencmpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnopencmpMouseEntered
        btnopencmp.setBackground(new Color(38,115,103));
        btnopencmp.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnopencmpMouseEntered

    private void btnopencmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnopencmpMouseExited
        btnopencmp.setBackground(new Color(209,237,225));
        btnopencmp.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnopencmpMouseExited

    private void btnopencmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnopencmpActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new Opncmp(this,true,rr,d1,jMenu1,jMenu2,jMenu3,jMenu4,jMenu5,jMenu6,jLabel2,jLabel3,jPanel5,btnhelp,btnaddaccount,btnadditem,btnpayment,btnreceipt,btnpurchase,btnsales,btnaccdetail,btnstocksts,db).show();
    }//GEN-LAST:event_btnopencmpActionPerformed

    private void btncrtcmpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncrtcmpMouseEntered
        btncrtcmp.setBackground(new Color(38,115,103));
        btncrtcmp.setForeground(Color.WHITE);
    }//GEN-LAST:event_btncrtcmpMouseEntered

    private void btncrtcmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncrtcmpMouseExited
        btncrtcmp.setBackground(new Color(209,237,225));
        btncrtcmp.setForeground(Color.BLACK);
    }//GEN-LAST:event_btncrtcmpMouseExited

    private void btncrtcmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncrtcmpActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        cntrl.checkcompany(btncrtcmp,rr,d1,this);
    }//GEN-LAST:event_btncrtcmpActionPerformed

    private void btnabtusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnabtusMouseEntered
        btnabtus.setBackground(new Color(38,115,103));
        btnabtus.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnabtusMouseEntered

    private void btnabtusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnabtusMouseExited
        btnabtus.setBackground(new Color(209,237,225));
        btnabtus.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnabtusMouseExited

    private void btnabtusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnabtusActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        //new lmodsale(this,true,rr,d1,jLabel2.getText(),db).show();
        new sale(this,true,rr,d1,db).show();
        //       JOptionPane.showMessageDialog(this,"Team Book-Keeping");
    }//GEN-LAST:event_btnabtusActionPerformed

    private void btnnotepadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnotepadActionPerformed
        Runtime rntm = Runtime.getRuntime();
        try {
            rntm.exec("notepad");
        } catch (IOException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnnotepadActionPerformed

    private void btncalculatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalculatorActionPerformed
        ProcessBuilder pb=new ProcessBuilder("calc");
        try {
            pb.start();
        } catch (IOException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btncalculatorActionPerformed

    private void btnopencmpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnopencmpFocusGained
        
    }//GEN-LAST:event_btnopencmpFocusGained

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new purchase(this,true,rr,d1,db).show();
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new lmodPurchase(this,true,rr,d1,jLabel2.getText(),db).show();
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new saleReturn(this,true,rr,d1,db).show();
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new lmodSaleReturn(this,true,rr,d1,jLabel2.getText(),db).show();
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new purchaseReturn(this,true,rr,d1,db).show();
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new lmodPurchaseReturn(this,true,rr,d1,jLabel2.getText(),db).show();
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new Payment(this,true,rr,d1,db).show();
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new LmodPayment(this,true,rr,d1,db).show();
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new Receipt(this,true,rr,d1,db).show();
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new LmodReceipt(this,true,rr,d1,db).show();
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new LB_coustmer(this,true,rr,d1,db).show();
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void jMenuItem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem43ActionPerformed
        Point rr=jMenuBar1.getLocationOnScreen();
        Dimension dd=jMenuBar1.getSize();
        Dimension d1=jPanel3.getSize();
        d1.height=d1.height+dd.height;
        new LB_suppliar(this,true,rr,d1,db).show();
    }//GEN-LAST:event_jMenuItem43ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
          
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
//                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            }
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
        UIManager.setLookAndFeel(new FlatIntelliJLaf());
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home(0).setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnabtus;
    private javax.swing.JButton btnaccdetail;
    private javax.swing.JButton btnaddaccount;
    private javax.swing.JButton btnadditem;
    private javax.swing.JButton btncalculator;
    private javax.swing.JButton btnchk4updt;
    private javax.swing.JButton btncrtcmp;
    private javax.swing.JButton btndltcmp;
    private javax.swing.JButton btnexitsys;
    private javax.swing.JButton btnhelp;
    public javax.swing.JButton btnnotepad;
    private javax.swing.JButton btnopencmp;
    private javax.swing.JButton btnpayment;
    private javax.swing.JButton btnpurchase;
    private javax.swing.JButton btnreceipt;
    private javax.swing.JButton btnsales;
    private javax.swing.JButton btnstocksts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
