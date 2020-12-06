package purchase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.formdev.flatlaf.FlatIntelliJLaf;
import dbconnection.DbConnection;
import other.AutoCompletion;
import other.Format;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import other.shortcutKey;


/**
 *
 * @author ASAD
 */
public class modpurchase extends javax.swing.JDialog {
//    DefaultListModel model;
    static Point rr;
    static Dimension d1;
//    int cases=0;
    static String billno;
    static DbConnection db;
    Controller cntrl;
    static String gstp[]={"0","0","0"};
    DefaultTableModel modeltbl;
    double oldamount;
    String oldname,oldbillno;
    List<String> itemname;
    List<Double> itemqty;
    SimpleDateFormat date=new SimpleDateFormat("dd-MM-yyyy");
    public modpurchase(java.awt.Frame parent, boolean modal,Point rv,Dimension d,String billno,DbConnection db){
        super(parent, modal);
        rr=rv;
        d1=d;
        initComponents();
        this.setLocation(rr);
        this.setSize(d1);
        jPanel3.setSize(d1);
        modeltbl=(DefaultTableModel) tblitm.getModel();
         tblitm.setModel(modeltbl);
         tblitm.setDefaultEditor(Object.class,null);
        
         Date date2=new Date();
         billdate.setDate(date2);
        
        
        addbrow(0);
        new AutoCompletion(jname);
        new AutoCompletion(jitemlist);
        
        shortcutKey shortcutKey = new shortcutKey(this);
        
        cntrl=new Controller(db);
        this.db=db;
                   
        txtcgstp.setEditable(false);
        txtsgstp.setEditable(false);
        txtgstp.setEditable(false);
            
        jitemlist.removeAllItems();
        jname.removeAllItems();
        cntrl.fetchItems(jitemlist);
        cntrl.fetchaccounts(jname);
        jname.setSelectedIndex(0);
        ItemEvent evt=null;
        saleTypeItemStateChanged(evt);
        
        itemname=new ArrayList<>();
        itemqty=new ArrayList<>();
        cntrl.setBillData(itemname,itemqty,billno,saleType,txtbillno,billdate,jname,txtgstno,txtvehicalno,jitemlist,txtqty,txtunit,txtprice,txtamount,tblitm,modeltbl,lbltqty,lblamount,txtcgstp,txtcgst,txtsgstp,txtsgst,txtgstp,txtgst,txtdiscountp,txtdiscount,txtcessp,txtcessvalue,roundOff,txtroundoff,txtothercharges,lbltamount);
        oldamount=Double.parseDouble(lbltamount.getText());
        oldname=jname.getSelectedItem().toString();
        oldbillno=txtbillno.getText();
        billdate.getDateEditor().getUiComponent().addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt){
                try{
                    date.format(billdate.getDate());
                }catch(Exception e){
                    billdate.setDate(date2);
                }
            }
        });
        jname.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt){
                cntrl.fetchaccountdetail(jname.getSelectedItem().toString(), txtgstno, lblBalance);
            }
        });
        jitemlist.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt){
                cntrl.fetchitemdetail(jitemlist.getSelectedItem().toString(), txtunit, txtprice,txthsn,lblStock);
            }
        });
      }
    
    
    
    public void dltbrow(int start){
        for(int i=start-1;i>=start-10;i--)
            modeltbl.removeRow(i);
    }
    public void addbrow(int start){
        Object[] obj={" "," "," "," "," "," "};
        for(int i=start;i<start+10;i++)
            modeltbl.addRow(obj);
    }
    public void addrow(Object[] obj){
         Object[] data=obj;
         modeltbl.addRow(data);
         addbrow(modeltbl.getRowCount()-1);
    }
    
    public JTable tbl(){
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
               
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modpurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         JTable jTable1=new javax.swing.JTable();
         try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(modpurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
//         try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//               if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//               
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        return jTable1;
         
    }
    public JScrollPane scroll(){
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
               
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modpurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         JScrollPane scroll=new javax.swing.JScrollPane();
         try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(modpurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
//         try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//               if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//               
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        return scroll;
         
    }
    
    
    //for reset gst section
    public void reset(){
            FocusEvent evt=null;
            txtdiscountpFocusGained(evt);
            txtdiscountpFocusLost(evt);
            
            txtcgstpFocusGained(evt);
            txtcgstpFocusLost(evt);
            
            txtsgstpFocusGained(evt);
            txtsgstpFocusLost(evt);
            
            txtgstpFocusGained(evt);
            txtgstpFocusLost(evt);
            
            txtcesspFocusGained(evt);
            txtcesspFocusLost(evt);
    }
    
    
    //for remove row from 
    public void removeRow(int row){
        lbltqty.setText(Format.ToString(Double.parseDouble(lbltqty.getText())-Double.parseDouble((String) tblitm.getValueAt(row, 2))));
        lblamount.setText(Format.ToString(Double.parseDouble(lblamount.getText())-Double.parseDouble((String) tblitm.getValueAt(row, 13))));
        lbltamount.setText(Format.ToString(Double.parseDouble(lbltamount.getText())-Double.parseDouble((String) tblitm.getValueAt(row, 13))));
        modeltbl.removeRow(row);
        reset();
        for(int i=row;i<tblitm.getRowCount()-10;i++)
            tblitm.setValueAt(i+1, i,0);
    }
    
    
    //for hiding Column by Sale Table
    public void hideColumn(int arr[]){
        for (int i : arr){
            tblitm.getColumnModel().getColumn(i).setMaxWidth(0);
            tblitm.getColumnModel().getColumn(i).setMinWidth(0);
            tblitm.getColumnModel().getColumn(i).setPreferredWidth(0);
        }
    }
    
    //for set column in table for itemwise Igst
    public void itemWiseIgstColumn(){
        tblitm.getColumnModel().getColumn(0).setPreferredWidth(35);
        tblitm.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblitm.getColumnModel().getColumn(2).setPreferredWidth(70);
        tblitm.getColumnModel().getColumn(3).setPreferredWidth(90);
        tblitm.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblitm.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblitm.getColumnModel().getColumn(6).setPreferredWidth(130);
        tblitm.getColumnModel().getColumn(7).setPreferredWidth(0);
        tblitm.getColumnModel().getColumn(8).setPreferredWidth(0);
        tblitm.getColumnModel().getColumn(9).setPreferredWidth(0);
        tblitm.getColumnModel().getColumn(10).setPreferredWidth(0);
        
        tblitm.getColumnModel().getColumn(11).setMaxWidth(50);
        tblitm.getColumnModel().getColumn(11).setMinWidth(50);
        tblitm.getColumnModel().getColumn(11).setPreferredWidth(50);
        
        tblitm.getColumnModel().getColumn(12).setMaxWidth(100);
        tblitm.getColumnModel().getColumn(12).setMinWidth(100);
        tblitm.getColumnModel().getColumn(12).setPreferredWidth(100);
        
        tblitm.getColumnModel().getColumn(13).setMaxWidth(150);
        tblitm.getColumnModel().getColumn(13).setMinWidth(150);
        tblitm.getColumnModel().getColumn(13).setPreferredWidth(150);
    }
    
    //for set column in table for itemwise cgst/sgst
    public void itemWiseColumn(){
        tblitm.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblitm.getColumnModel().getColumn(1).setPreferredWidth(260);
        tblitm.getColumnModel().getColumn(2).setPreferredWidth(55);
        tblitm.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblitm.getColumnModel().getColumn(4).setPreferredWidth(90);
        tblitm.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblitm.getColumnModel().getColumn(6).setPreferredWidth(120);
        
        tblitm.getColumnModel().getColumn(7).setMaxWidth(45);
        tblitm.getColumnModel().getColumn(7).setMinWidth(45);
        tblitm.getColumnModel().getColumn(7).setPreferredWidth(45);
        
        tblitm.getColumnModel().getColumn(8).setMaxWidth(100);
        tblitm.getColumnModel().getColumn(8).setMinWidth(100);
        tblitm.getColumnModel().getColumn(8).setPreferredWidth(100);
        
        tblitm.getColumnModel().getColumn(9).setMaxWidth(45);
        tblitm.getColumnModel().getColumn(9).setMinWidth(45);
        tblitm.getColumnModel().getColumn(9).setPreferredWidth(45);
        
        tblitm.getColumnModel().getColumn(10).setMaxWidth(100);
        tblitm.getColumnModel().getColumn(10).setMinWidth(100);
        tblitm.getColumnModel().getColumn(10).setPreferredWidth(100);
        
        tblitm.getColumnModel().getColumn(11).setPreferredWidth(0);
        tblitm.getColumnModel().getColumn(12).setPreferredWidth(0);
        
        tblitm.getColumnModel().getColumn(13).setMaxWidth(130);
        tblitm.getColumnModel().getColumn(13).setMinWidth(130);
        tblitm.getColumnModel().getColumn(13).setPreferredWidth(130);
    }
    
    //for set column in table for without item
    public void itemColumn(){
        tblitm.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblitm.getColumnModel().getColumn(1).setPreferredWidth(400);
        tblitm.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblitm.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblitm.getColumnModel().getColumn(4).setPreferredWidth(150);
        tblitm.getColumnModel().getColumn(5).setPreferredWidth(150);
        tblitm.getColumnModel().getColumn(6).setPreferredWidth(185);
    }
    
    
    //for hide and show cess
    public void cess(boolean stage){
        if(stage==false){
            lblcess.setVisible(false);
            lblcess.setEnabled(false);
            lblcess1.setVisible(false);
            lblcess1.setEnabled(false);
            lblcess2.setVisible(false);
            lblcess2.setEnabled(false);
            txtcessp.setVisible(false);
            txtcessp.setEnabled(false);
            txtcessvalue.setVisible(false);
            txtcessvalue.setEnabled(false);
        }
        if(stage==true){
            lblcess.setVisible(true);
            lblcess.setEnabled(true);
            lblcess1.setVisible(true);
            lblcess1.setEnabled(true);
            lblcess2.setVisible(true);
            lblcess2.setEnabled(true);
            txtcessp.setVisible(true);
            txtcessp.setEnabled(true);
            txtcessvalue.setVisible(true);
            txtcessvalue.setEnabled(true);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtnote = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtbillno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblitm = tbl();
        lbltamount = new javax.swing.JLabel();
        lblamount = new javax.swing.JLabel();
        lbltqty = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtgstno = new javax.swing.JTextField();
        lblqty2 = new javax.swing.JLabel();
        lblqty3 = new javax.swing.JLabel();
        lblqty4 = new javax.swing.JLabel();
        txtqty = new javax.swing.JTextField();
        txtunit = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        txtamount = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        btndltitm = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jname = new javax.swing.JComboBox<>();
        jitemlist = new javax.swing.JComboBox<>();
        txtdiscount = new javax.swing.JTextField();
        txtdiscountp = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnupdateitem = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        saleType = new javax.swing.JComboBox<>();
        txtvehicalno = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txthsn = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtroundoff = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtothercharges = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        billdate = new com.toedter.calendar.JDateChooser();
        roundOff = new javax.swing.JComboBox<>();
        lblcess = new javax.swing.JLabel();
        txtcessp = new javax.swing.JTextField();
        lblcess1 = new javax.swing.JLabel();
        txtcessvalue = new javax.swing.JTextField();
        lblcess2 = new javax.swing.JLabel();
        gstPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtcgstp = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtgst = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtsgst = new javax.swing.JTextField();
        txtsgstp = new javax.swing.JTextField();
        txtgstp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtcgst = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btndeletebill = new javax.swing.JButton();

        txtnote.setBackground(new java.awt.Color(209, 237, 225));
        txtnote.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtnote.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnote.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnoteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnoteFocusLost(evt);
            }
        });
        txtnote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnoteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Note           :");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(209, 237, 225));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(413, 373));

        jPanel1.setBackground(new java.awt.Color(38, 115, 103));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));

        btnhelp.setText(">> Help");
        btnhelp.setEnabled(false);
        btnhelp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnaddaccount.setText(">> Add Account");
        btnaddaccount.setEnabled(false);
        btnaddaccount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnaddaccount.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnadditem.setText(">> Add Item");
        btnadditem.setEnabled(false);
        btnadditem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnadditem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadditemActionPerformed(evt);
            }
        });

        btnpayment.setText(">> Payment");
        btnpayment.setEnabled(false);
        btnpayment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnreceipt.setText(">> Receipt");
        btnreceipt.setEnabled(false);
        btnreceipt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnpurchase.setText(">> Purchase");
        btnpurchase.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnpurchase.setEnabled(false);
        btnpurchase.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnsales.setText(">> Sales");
        btnsales.setEnabled(false);
        btnsales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnaccdetail.setText(">> Account Detail");
        btnaccdetail.setEnabled(false);
        btnaccdetail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnstocksts.setText(">> Stock Status");
        btnstocksts.setEnabled(false);
        btnstocksts.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

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
            .addComponent(btnaccdetail, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
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
                .addGap(0, 373, Short.MAX_VALUE))
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edit Purchase Vouchar");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(470, 470, 470)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(3, 3, 3))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Party Name  :");

        txtbillno.setBackground(new java.awt.Color(255, 255, 255));
        txtbillno.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtbillno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtbillnoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbillnoFocusLost(evt);
            }
        });
        txtbillno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbillnoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Bill Date  :");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Bill No :");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Gst No :");

        tblitm.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        tblitm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblitm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Item", "Qty", "Unit", "HSN Code", "Price (Rs.)", "Amout (Rs.)", "Cgst%", "Cgst Value", "Sgst %", "Sgst Value", "Igst %", "Igst Value", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblitm.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblitm.setAutoscrolls(false);
        tblitm.setGridColor(new java.awt.Color(0, 0, 0));
        tblitm.setRowHeight(23);
        tblitm.setSelectionBackground(new java.awt.Color(38, 115, 103));
        tblitm.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblitm.getTableHeader().setResizingAllowed(false);
        tblitm.getTableHeader().setReorderingAllowed(false);
        tblitm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblitmMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblitmMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblitmMouseReleased(evt);
            }
        });
        tblitm.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tblitmInputMethodTextChanged(evt);
            }
        });
        tblitm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblitmKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblitm);
        if (tblitm.getColumnModel().getColumnCount() > 0) {
            tblitm.getColumnModel().getColumn(0).setResizable(false);
            tblitm.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblitm.getColumnModel().getColumn(1).setResizable(false);
            tblitm.getColumnModel().getColumn(1).setPreferredWidth(400);
            tblitm.getColumnModel().getColumn(2).setResizable(false);
            tblitm.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblitm.getColumnModel().getColumn(3).setResizable(false);
            tblitm.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblitm.getColumnModel().getColumn(4).setResizable(false);
            tblitm.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblitm.getColumnModel().getColumn(5).setResizable(false);
            tblitm.getColumnModel().getColumn(5).setPreferredWidth(150);
            tblitm.getColumnModel().getColumn(6).setResizable(false);
            tblitm.getColumnModel().getColumn(6).setPreferredWidth(185);
            tblitm.getColumnModel().getColumn(7).setResizable(false);
            tblitm.getColumnModel().getColumn(7).setPreferredWidth(45);
            tblitm.getColumnModel().getColumn(8).setResizable(false);
            tblitm.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblitm.getColumnModel().getColumn(9).setResizable(false);
            tblitm.getColumnModel().getColumn(9).setPreferredWidth(45);
            tblitm.getColumnModel().getColumn(10).setResizable(false);
            tblitm.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblitm.getColumnModel().getColumn(11).setResizable(false);
            tblitm.getColumnModel().getColumn(11).setPreferredWidth(50);
            tblitm.getColumnModel().getColumn(12).setResizable(false);
            tblitm.getColumnModel().getColumn(12).setPreferredWidth(100);
            tblitm.getColumnModel().getColumn(13).setResizable(false);
            tblitm.getColumnModel().getColumn(13).setPreferredWidth(130);
        }

        lbltamount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltamount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbltamount.setText("00.00");
        lbltamount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblamount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblamount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblamount.setText("00.00");
        lblamount.setAlignmentX(0.5F);
        lblamount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbltqty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltqty.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbltqty.setText("00.00");
        lbltqty.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSave.setBackground(new java.awt.Color(38, 115, 103));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(38, 115, 103));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Quit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtgstno.setEditable(false);
        txtgstno.setBackground(new java.awt.Color(255, 255, 255));
        txtgstno.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtgstno.setNextFocusableComponent(jitemlist);
        txtgstno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtgstnoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtgstnoFocusLost(evt);
            }
        });
        txtgstno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgstnoActionPerformed(evt);
            }
        });

        lblqty2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblqty2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblqty2.setText("Amount :");

        lblqty3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblqty3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblqty3.setText("Total Qty :");

        lblqty4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblqty4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblqty4.setText("Total Amount :");

        txtqty.setToolTipText("Add Qty");
        txtqty.setNextFocusableComponent(txtprice);
        txtqty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtqtyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqtyFocusLost(evt);
            }
        });
        txtqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtyActionPerformed(evt);
            }
        });
        txtqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtqtyKeyTyped(evt);
            }
        });

        txtunit.setEditable(false);
        txtunit.setToolTipText("Unit");

        txtprice.setToolTipText("Add Price");
        txtprice.setNextFocusableComponent(txtamount);
        txtprice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpriceFocusLost(evt);
            }
        });
        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });
        txtprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpriceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpriceKeyTyped(evt);
            }
        });

        txtamount.setToolTipText("Add Amount");
        txtamount.setNextFocusableComponent(btnadd);
        txtamount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtamountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtamountFocusLost(evt);
            }
        });
        txtamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamountActionPerformed(evt);
            }
        });
        txtamount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtamountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtamountKeyTyped(evt);
            }
        });

        btnadd.setBackground(new java.awt.Color(204, 204, 204));
        btnadd.setText("ADD");
        btnadd.setNextFocusableComponent(jitemlist);
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        btnadd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnaddKeyReleased(evt);
            }
        });

        btndltitm.setBackground(new java.awt.Color(38, 115, 103));
        btndltitm.setText("Delete Item");
        btndltitm.setOpaque(false);
        btndltitm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndltitmActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText(">> Add Item  :");

        jname.setEditable(true);
        jname.setNextFocusableComponent(txtgstno);
        jname.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jnameItemStateChanged(evt);
            }
        });
        jname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jnameFocusLost(evt);
            }
        });
        jname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnameActionPerformed(evt);
            }
        });
        jname.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jnamePropertyChange(evt);
            }
        });

        jitemlist.setEditable(true);
        jitemlist.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jitemlistFocusLost(evt);
            }
        });
        jitemlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jitemlistActionPerformed(evt);
            }
        });

        txtdiscount.setNextFocusableComponent(txtcgstp);
        txtdiscount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtdiscountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdiscountFocusLost(evt);
            }
        });
        txtdiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdiscountKeyTyped(evt);
            }
        });

        txtdiscountp.setNextFocusableComponent(txtcgstp);
        txtdiscountp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtdiscountpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdiscountpFocusLost(evt);
            }
        });
        txtdiscountp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdiscountpKeyTyped(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Discount :");

        jLabel19.setText("%");

        btnupdateitem.setBackground(new java.awt.Color(38, 115, 103));
        btnupdateitem.setText("Update Item");
        btnupdateitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateitemActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel20.setText("Available Balance :");

        lblBalance.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblBalance.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBalance.setText("( 00.00 )");
        lblBalance.setAlignmentX(0.5F);
        lblBalance.setAlignmentY(1.0F);
        lblBalance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Available Stock :");

        lblStock.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblStock.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStock.setText("( 00.00 )");
        lblStock.setAlignmentX(0.5F);
        lblStock.setAlignmentY(1.0F);

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Bill Type :");

        saleType.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        saleType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Regular", "ItemWise - cgst/sgst", "ItemWise -Igst", "CESS" }));
        saleType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                saleTypeItemStateChanged(evt);
            }
        });

        txtvehicalno.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtvehicalno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvehicalnoActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel23.setText("Vehical No :");

        txthsn.setEditable(false);
        txthsn.setToolTipText("Unit");
        txthsn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthsnActionPerformed(evt);
            }
        });

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText(" Round off :");

        txtroundoff.setNextFocusableComponent(txtothercharges);
        txtroundoff.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtroundoffFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtroundoffFocusLost(evt);
            }
        });
        txtroundoff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtroundoffKeyTyped(evt);
            }
        });

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Other charges (+) :");

        txtothercharges.setNextFocusableComponent(btnSave);
        txtothercharges.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtotherchargesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtotherchargesFocusLost(evt);
            }
        });
        txtothercharges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtotherchargesActionPerformed(evt);
            }
        });
        txtothercharges.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtotherchargesKeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Qty");

        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Unit");

        jLabel28.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Hsn Code");

        jLabel29.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Price");

        jLabel30.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Amount");

        billdate.setDateFormatString("dd-MM-yyyy");
        billdate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                billdateFocusLost(evt);
            }
        });
        billdate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                billdatePropertyChange(evt);
            }
        });

        roundOff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "+" }));
        roundOff.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                roundOffFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                roundOffFocusLost(evt);
            }
        });

        lblcess.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblcess.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblcess.setText("CESS :");

        txtcessp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcesspFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcesspFocusLost(evt);
            }
        });
        txtcessp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcesspActionPerformed(evt);
            }
        });
        txtcessp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcesspKeyTyped(evt);
            }
        });

        lblcess1.setText("%");

        txtcessvalue.setEditable(false);

        lblcess2.setText("+");

        gstPanel.setBackground(new java.awt.Color(209, 237, 225));

        jLabel16.setText("%");

        txtcgstp.setNextFocusableComponent(txtsgstp);
        txtcgstp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcgstpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcgstpFocusLost(evt);
            }
        });
        txtcgstp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcgstpKeyTyped(evt);
            }
        });

        jLabel17.setText("%");

        txtgst.setEditable(false);

        jLabel18.setText("%");

        txtsgst.setEditable(false);

        txtsgstp.setNextFocusableComponent(txtgstp);
        txtsgstp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtsgstpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtsgstpFocusLost(evt);
            }
        });
        txtsgstp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsgstpKeyTyped(evt);
            }
        });

        txtgstp.setNextFocusableComponent(btnSave);
        txtgstp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtgstpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtgstpFocusLost(evt);
            }
        });
        txtgstp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgstpActionPerformed(evt);
            }
        });
        txtgstp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtgstpKeyTyped(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("SGST :");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText(" IGST  :");

        txtcgst.setEditable(false);
        txtcgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcgstActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("CGST :");

        javax.swing.GroupLayout gstPanelLayout = new javax.swing.GroupLayout(gstPanel);
        gstPanel.setLayout(gstPanelLayout);
        gstPanelLayout.setHorizontalGroup(
            gstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gstPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(gstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(gstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(gstPanelLayout.createSequentialGroup()
                        .addComponent(txtcgstp, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel16))
                    .addGroup(gstPanelLayout.createSequentialGroup()
                        .addGroup(gstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtsgstp, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgstp, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(gstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcgst, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtgst, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtsgst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        gstPanelLayout.setVerticalGroup(
            gstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gstPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(gstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gstPanelLayout.createSequentialGroup()
                        .addComponent(txtcgst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(gstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gstPanelLayout.createSequentialGroup()
                                .addGroup(gstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtsgst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addGap(2, 2, 2)
                                .addGroup(gstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtgst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtgstp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(gstPanelLayout.createSequentialGroup()
                                .addGroup(gstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtsgstp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(gstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcgstp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)))
                .addGap(0, 0, 0))
        );

        jLabel4.setText("Re-fresh");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        btndeletebill.setBackground(new java.awt.Color(38, 115, 103));
        btndeletebill.setText("Delete Bill");
        btndeletebill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletebillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btndltitm, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnupdateitem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btndeletebill)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                                .addComponent(lblqty3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbltqty, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblqty2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addComponent(lblqty4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbltamount, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtdiscountp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel19)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblamount, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(lblcess2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtcessvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(lblcess)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtcessp, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblcess1)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(gstPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(1, 1, 1))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(billdate, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtbillno, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                                            .addComponent(jitemlist, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jname, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(2, 2, 2)
                                                .addComponent(saleType, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addGap(2, 2, 2)
                                                .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(txtvehicalno))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtgstno, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)))
                                        .addGap(90, 90, 90))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtunit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txthsn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtamount)
                                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(roundOff, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtroundoff, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtothercharges, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbillno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saleType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(txtvehicalno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(billdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStock)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtgstno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtunit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jitemlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthsn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnadd))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblamount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbltqty, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblqty3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblqty2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btndltitm)
                        .addComponent(btnupdateitem)
                        .addComponent(btndeletebill)))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdiscountp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(gstPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtroundoff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roundOff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtothercharges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltamount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblqty4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(btnSave)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcess, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcessp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcess1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcessvalue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcess2))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1376, 630);
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
            Logger.getLogger(modpurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void txtbillnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbillnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbillnoActionPerformed

    private void txtbillnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbillnoFocusGained
        
    }//GEN-LAST:event_txtbillnoFocusGained

    private void txtbillnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbillnoFocusLost
        if(!oldbillno.equals(txtbillno.getText())){
            String S=cntrl.checkBillno(txtbillno);
            if(!S.equals(""))
                JOptionPane.showMessageDialog(this,S,"Available..!",2);
        }
    }//GEN-LAST:event_txtbillnoFocusLost

    private void txtgstnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtgstnoFocusGained
        Color c=new Color(38,115,103);
        txtgstno.setBackground(c);
        txtgstno.setForeground(Color.WHITE);
    }//GEN-LAST:event_txtgstnoFocusGained

    private void txtgstnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtgstnoFocusLost
        Color c=new Color(209,237,225);
        txtgstno.setBackground(c);
        txtgstno.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtgstnoFocusLost

    private void txtgstnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgstnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgstnoActionPerformed

    private void tblitmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblitmMouseClicked
    
    }//GEN-LAST:event_tblitmMouseClicked

    private void tblitmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblitmKeyReleased
       
    }//GEN-LAST:event_tblitmKeyReleased

    private void tblitmInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblitmInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tblitmInputMethodTextChanged

    private void btndltitmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndltitmActionPerformed
            int row=tblitm.getSelectedRow();
            if(row<0){
               JOptionPane.showMessageDialog(this,"Select Row...","Select...",1);
            } 
            else if(row>=tblitm.getRowCount()-10){
                JOptionPane.showMessageDialog(this,"This Row will not Delete","Delete row",1);
            }
            else{
                int n=JOptionPane.showConfirmDialog(this,"Do you want to delete this?", "Delete?", JOptionPane.YES_NO_OPTION,3);
                if(n==JOptionPane.YES_OPTION){
                    removeRow(row);
                }
            }
    }//GEN-LAST:event_btndltitmActionPerformed

    private void btnaddKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnaddKeyReleased
//        ActionEvent ev = null;
//        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
//            jitemlist.requestFocusInWindow();
//            btnaddActionPerformed(ev);
//        }
    }//GEN-LAST:event_btnaddKeyReleased

    private void txtqtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqtyFocusGained

    }//GEN-LAST:event_txtqtyFocusGained

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
       FocusEvent ev=null;
       if(saleType.getSelectedItem()=="None" || saleType.getSelectedItem()=="Regular" || saleType.getSelectedItem()=="CESS"){
        if(!jitemlist.getSelectedItem().toString().equals("") && !txtqty.getText().equals("") && !txtprice.getText().equals("") && !txtamount.getText().equals("")){
            Object[] data=new Object[14];
            dltbrow(modeltbl.getRowCount());
            data[0]=tblitm.getRowCount()+1;
            data[1]=jitemlist.getSelectedItem().toString();
            data[2]=txtqty.getText();
            data[3]=txtunit.getText();
            data[4]=txthsn.getText();
            data[5]=txtprice.getText();
            data[6]=txtamount.getText();
            data[7]="0";
            data[8]="0";
            data[9]="0";
            data[10]="0";
            data[11]="0";
            data[12]="0";
            data[13]=txtamount.getText();
            addrow(data);
            lbltqty.setText(Format.ToString(Double.parseDouble(lbltqty.getText())+Double.parseDouble(txtqty.getText())));
            lblamount.setText(Format.ToString(Double.parseDouble(lblamount.getText())+Double.parseDouble((String)data[13])));
            lbltamount.setText(lblamount.getText());
            
            jitemlist.setSelectedIndex(0);
            txtqty.setText("");
            txtunit.setText("");
            txthsn.setText("");
            txtprice.setText("");
            txtamount.setText("");
            
            txtroundoffFocusLost(ev);
            txtotherchargesFocusLost(ev);
            
            reset();
        }
        else{
            JOptionPane.showMessageDialog(this,"Fill Item detail...","Fill up...",1);
        }
       }else if(saleType.getSelectedItem()=="ItemWise - cgst/sgst"){
           if(!jitemlist.getSelectedItem().toString().equals("") && !txtqty.getText().equals("") && !txtprice.getText().equals("") && !txtamount.getText().equals("")){
            Object[] data=new Object[14];
            dltbrow(modeltbl.getRowCount());
            data[0]=tblitm.getRowCount()+1;
            data[1]=jitemlist.getSelectedItem().toString();
            data[2]=txtqty.getText();
            data[3]=txtunit.getText();
            data[4]=txthsn.getText();
            data[5]=txtprice.getText();
            data[6]=txtamount.getText();
            data[7]=gstp[0];
            data[8]="0";
            data[9]=gstp[1];
            data[10]="0";
            data[11]=gstp[2];
            data[12]="0";
            data[13]="0";
            
            Object obj[]={data[6],data[7],data[8],data[9],data[10],data[13]};
            GstPurchase dlg=new GstPurchase(this, true,obj);
            obj = dlg.showDialog();
            data[7]=obj[1];
            data[8]=obj[2];
            data[9]=obj[3];
            data[10]=obj[4];
            data[13]=obj[5];
            
            addrow(data);
            lbltqty.setText(Format.ToString(Double.parseDouble(lbltqty.getText())+Double.parseDouble(txtqty.getText())));
            lblamount.setText(Format.ToString(Double.parseDouble(lblamount.getText())+Double.parseDouble((String) data[13])));
            lbltamount.setText(lblamount.getText());
            
            jitemlist.setSelectedIndex(0);
            txtqty.setText("");
            txtunit.setText("");
            txthsn.setText("");
            txtprice.setText("");
            txtamount.setText("");
            
            txtroundoffFocusLost(ev);
            txtotherchargesFocusLost(ev);
            
            reset();
        }
        else{
            JOptionPane.showMessageDialog(this,"Fill Item detail...","Fill up...",1);
        }
           
       }else if(saleType.getSelectedItem()=="ItemWise -Igst"){
           if(!jitemlist.getSelectedItem().toString().equals("") && !txtqty.getText().equals("") && !txtprice.getText().equals("") && !txtamount.getText().equals("")){
            Object[] data=new Object[14];
            dltbrow(modeltbl.getRowCount());
            data[0]=tblitm.getRowCount()+1;
            data[1]=jitemlist.getSelectedItem().toString();
            data[2]=txtqty.getText();
            data[3]=txtunit.getText();
            data[4]=txthsn.getText();
            data[5]=txtprice.getText();
            data[6]=txtamount.getText();
            data[7]=gstp[0];
            data[8]="0";
            data[9]=gstp[1];
            data[10]="0";
            data[11]=gstp[2];
            data[12]="0";
            data[13]="0";
            Object obj[]={data[6],data[11],data[12],data[13]};
            IgstPurchase dlg=new IgstPurchase(this, true,obj);
            obj = dlg.showDialog();
            data[11]=obj[1];
            data[12]=obj[2];
            data[13]=obj[3];
            
            addrow(data);
            lbltqty.setText(Format.ToString(Double.parseDouble(lbltqty.getText())+Double.parseDouble(txtqty.getText())));
            lblamount.setText(Format.ToString(Double.parseDouble(lblamount.getText())+Double.parseDouble((String) data[13])));
            lbltamount.setText(lblamount.getText());
            
            jitemlist.setSelectedIndex(0);
            txtqty.setText("");
            txtunit.setText("");
            txthsn.setText("");
            txtprice.setText("");
            txtamount.setText("");
            
            txtroundoffFocusLost(ev);
            txtotherchargesFocusLost(ev);
            
            reset();
        }
        else{
            JOptionPane.showMessageDialog(this,"Fill Item detail...","Fill up...",1);
        }
       }
       
    }//GEN-LAST:event_btnaddActionPerformed

    private void txtamountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtamountFocusGained
        if(!txtqty.getText().equals(""))
        txtamount.setText(Format.ToString(Double.parseDouble(txtqty.getText())*Double.parseDouble(txtprice.getText())));
    }//GEN-LAST:event_txtamountFocusGained

    private void txtqtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqtyFocusLost
        try{
        if(!txtqty.getText().equals(""))
        txtamount.setText(Format.ToString(Double.parseDouble(txtqty.getText())*Double.parseDouble(txtprice.getText())));
        }catch(Exception n){
            JOptionPane.showMessageDialog(this,"Check value...","Check",2);
        }
    }//GEN-LAST:event_txtqtyFocusLost

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(jname.getSelectedItem()!=""){
            if(tblitm.getRowCount()>=11){
                try{
                date.format(billdate.getDate());
                if(saleType.getSelectedItem()=="None"){
                    txtcgstp.setText("0");
                    txtcgst.setText("0"); 
                    txtsgstp.setText("0");
                    txtsgst.setText("0"); 
                    txtgstp.setText("0");
                    txtgst.setText("0"); 
                    txtcessp.setText("0");
                    txtcessvalue.setText("0"); 
                    if(txtdiscountp.getText().equals("")){
                      txtdiscountp.setText("0"); 
                    }
                    if(txtdiscount.getText().equals("")){
                      txtdiscount.setText("0"); 
                    }
                    if(txtroundoff.getText().equals("")){
                        txtroundoff.setText("0");
                    }
                    if(txtothercharges.getText().equals("")){
                        txtothercharges.setText("0");
                    }
                    int choice=JOptionPane.showConfirmDialog(this,"Do you want to save Bill?", "save?", JOptionPane.YES_NO_CANCEL_OPTION,3);
                    if(choice==JOptionPane.YES_OPTION){
                     cntrl.updateBill(oldbillno,oldamount,oldname,saleType.getSelectedItem().toString(),txtbillno.getText(),((JTextField)billdate.getDateEditor().getUiComponent()).getText(),jname.getSelectedItem().toString(),txtgstno.getText(),txtvehicalno.getText(),Double.parseDouble(lbltqty.getText()),Double.parseDouble(lblamount.getText()),Double.parseDouble(txtdiscountp.getText()),Double.parseDouble(txtdiscount.getText()),Double.parseDouble(txtcgstp.getText()),Double.parseDouble(txtcgst.getText()),Double.parseDouble(txtsgstp.getText()),Double.parseDouble(txtsgst.getText()),Double.parseDouble(txtgstp.getText()),Double.parseDouble(txtgst.getText()),Double.parseDouble(txtcessp.getText()),Double.parseDouble(txtcessvalue.getText()),Double.parseDouble(roundOff.getSelectedItem().toString()+txtroundoff.getText()),Double.parseDouble(txtothercharges.getText()),Double.parseDouble(lbltamount.getText()));
                     cntrl.dltItems(oldbillno,itemname,itemqty);
                     for(int i=0;i<tblitm.getRowCount()-10;i++)
                      cntrl.savebillitems(txtbillno.getText(), (String) tblitm.getValueAt(i,1),Double.parseDouble((String) tblitm.getValueAt(i, 2)),(String) tblitm.getValueAt(i,3),(String) tblitm.getValueAt(i,4),Double.parseDouble((String) tblitm.getValueAt(i, 5)),Double.parseDouble((String) tblitm.getValueAt(i, 6)),0.0,0.0,0.0,0.0,0.0,0.0,Double.parseDouble((String) tblitm.getValueAt(i, 13)));
                     JOptionPane.showMessageDialog(this,"Bill saved..","Saved.",1);
                     this.dispose();
                    }
                }else if(saleType.getSelectedItem()=="Regular"){
                    if(txtcgstp.getText().equals("")){
                        txtcgstp.setText("0");
                        txtcgst.setText("0"); 
                    }
                    if(txtsgstp.getText().equals("")){
                        txtsgstp.setText("0");
                        txtsgst.setText("0"); 
                    }
                    if(txtgstp.getText().equals("")){
                        txtgstp.setText("0");
                        txtgst.setText("0"); 
                    }
                    txtcessp.setText("0");
                    txtcessvalue.setText("0"); 
                    if(txtdiscountp.getText().equals("")){
                        txtdiscountp.setText("0"); 
                    }
                    if(txtdiscount.getText().equals("")){
                        txtdiscount.setText("0"); 
                    }
                    if(txtroundoff.getText().equals("")){
                        txtroundoff.setText("0");
                    }
                    if(txtothercharges.getText().equals("")){
                        txtothercharges.setText("0");
                    }
                    int choice=JOptionPane.showConfirmDialog(this,"Do you want to save Bill?", "save?", JOptionPane.YES_NO_CANCEL_OPTION,3);
                    if(choice==JOptionPane.YES_OPTION){
                       cntrl.updateBill(oldbillno,oldamount,oldname,saleType.getSelectedItem().toString(),txtbillno.getText(),((JTextField)billdate.getDateEditor().getUiComponent()).getText(),jname.getSelectedItem().toString(),txtgstno.getText(),txtvehicalno.getText(),Double.parseDouble(lbltqty.getText()),Double.parseDouble(lblamount.getText()),Double.parseDouble(txtdiscountp.getText()),Double.parseDouble(txtdiscount.getText()),Double.parseDouble(txtcgstp.getText()),Double.parseDouble(txtcgst.getText()),Double.parseDouble(txtsgstp.getText()),Double.parseDouble(txtsgst.getText()),Double.parseDouble(txtgstp.getText()),Double.parseDouble(txtgst.getText()),Double.parseDouble(txtcessp.getText()),Double.parseDouble(txtcessvalue.getText()),Double.parseDouble(roundOff.getSelectedItem().toString()+txtroundoff.getText()),Double.parseDouble(txtothercharges.getText()),Double.parseDouble(lbltamount.getText()));
                       cntrl.dltItems(oldbillno,itemname,itemqty);
                       for(int i=0;i<tblitm.getRowCount()-10;i++)
                        cntrl.savebillitems(txtbillno.getText(), (String) tblitm.getValueAt(i,1),Double.parseDouble((String) tblitm.getValueAt(i, 2)),(String) tblitm.getValueAt(i,3),(String) tblitm.getValueAt(i,4),Double.parseDouble((String) tblitm.getValueAt(i, 5)),Double.parseDouble((String) tblitm.getValueAt(i, 6)),0.0,0.0,0.0,0.0,0.0,0.0,Double.parseDouble((String) tblitm.getValueAt(i, 13)));
                       JOptionPane.showMessageDialog(this,"Bill saved..","Saved.",1);
                       this.dispose();
                    }
                }else if(saleType.getSelectedItem()=="ItemWise - cgst/sgst"){
                    txtcgstp.setText("0");
                    txtcgst.setText("0"); 
                    txtsgstp.setText("0");
                    txtsgst.setText("0"); 
                    txtgstp.setText("0");
                    txtgst.setText("0"); 
                    txtcessp.setText("0");
                    txtcessvalue.setText("0"); 
                    if(txtdiscountp.getText().equals("")){
                      txtdiscountp.setText("0"); 
                    }
                    if(txtdiscount.getText().equals("")){
                      txtdiscount.setText("0"); 
                    }
                    if(txtroundoff.getText().equals("")){
                        txtroundoff.setText("0");
                    }
                    if(txtothercharges.getText().equals("")){
                        txtothercharges.setText("0");
                    }
                    int choice=JOptionPane.showConfirmDialog(this,"Do you want to save Bill?", "save?", JOptionPane.YES_NO_CANCEL_OPTION,3);
                    if(choice==JOptionPane.YES_OPTION){
                        cntrl.updateBill(oldbillno,oldamount,oldname,saleType.getSelectedItem().toString(),txtbillno.getText(),((JTextField)billdate.getDateEditor().getUiComponent()).getText(),jname.getSelectedItem().toString(),txtgstno.getText(),txtvehicalno.getText(),Double.parseDouble(lbltqty.getText()),Double.parseDouble(lblamount.getText()),Double.parseDouble(txtdiscountp.getText()),Double.parseDouble(txtdiscount.getText()),Double.parseDouble(txtcgstp.getText()),Double.parseDouble(txtcgst.getText()),Double.parseDouble(txtsgstp.getText()),Double.parseDouble(txtsgst.getText()),Double.parseDouble(txtgstp.getText()),Double.parseDouble(txtgst.getText()),Double.parseDouble(txtcessp.getText()),Double.parseDouble(txtcessvalue.getText()),Double.parseDouble(roundOff.getSelectedItem().toString()+txtroundoff.getText()),Double.parseDouble(txtothercharges.getText()),Double.parseDouble(lbltamount.getText()));
                        cntrl.dltItems(oldbillno,itemname,itemqty);
                        for(int i=0;i<tblitm.getRowCount()-10;i++)
                         cntrl.savebillitems(txtbillno.getText(), (String) tblitm.getValueAt(i,1),Double.parseDouble((String) tblitm.getValueAt(i, 2)),(String) tblitm.getValueAt(i,3),(String) tblitm.getValueAt(i,4),Double.parseDouble((String) tblitm.getValueAt(i, 5)),Double.parseDouble((String) tblitm.getValueAt(i, 6)),Double.parseDouble((String) tblitm.getValueAt(i, 7)),Double.parseDouble((String) tblitm.getValueAt(i, 8)),Double.parseDouble((String) tblitm.getValueAt(i, 9)),Double.parseDouble((String) tblitm.getValueAt(i, 10)),0.0,0.0,Double.parseDouble((String) tblitm.getValueAt(i, 13)));
                        JOptionPane.showMessageDialog(this,"Bill saved..","Saved.",1);
                        this.dispose();
                    }
                }else if(saleType.getSelectedItem()=="ItemWise -Igst"){
                    txtcgstp.setText("0");
                    txtcgst.setText("0"); 
                    txtsgstp.setText("0");
                    txtsgst.setText("0"); 
                    txtgstp.setText("0");
                    txtgst.setText("0"); 
                    txtcessp.setText("0");
                    txtcessvalue.setText("0"); 
                    if(txtdiscountp.getText().equals("")){
                      txtdiscountp.setText("0"); 
                    }
                    if(txtdiscount.getText().equals("")){
                      txtdiscount.setText("0"); 
                    }
                    if(txtroundoff.getText().equals("")){
                        txtroundoff.setText("0");
                    }
                    if(txtothercharges.getText().equals("")){
                        txtothercharges.setText("0");
                    }
                    int choice=JOptionPane.showConfirmDialog(this,"Do you want to save Bill?", "save?", JOptionPane.YES_NO_CANCEL_OPTION,3);
                    if(choice==JOptionPane.YES_OPTION){
                        cntrl.updateBill(oldbillno,oldamount,oldname,saleType.getSelectedItem().toString(),txtbillno.getText(),((JTextField)billdate.getDateEditor().getUiComponent()).getText(),jname.getSelectedItem().toString(),txtgstno.getText(),txtvehicalno.getText(),Double.parseDouble(lbltqty.getText()),Double.parseDouble(lblamount.getText()),Double.parseDouble(txtdiscountp.getText()),Double.parseDouble(txtdiscount.getText()),Double.parseDouble(txtcgstp.getText()),Double.parseDouble(txtcgst.getText()),Double.parseDouble(txtsgstp.getText()),Double.parseDouble(txtsgst.getText()),Double.parseDouble(txtgstp.getText()),Double.parseDouble(txtgst.getText()),Double.parseDouble(txtcessp.getText()),Double.parseDouble(txtcessvalue.getText()),Double.parseDouble(roundOff.getSelectedItem().toString()+txtroundoff.getText()),Double.parseDouble(txtothercharges.getText()),Double.parseDouble(lbltamount.getText()));
                        cntrl.dltItems(oldbillno,itemname,itemqty);
                        for(int i=0;i<tblitm.getRowCount()-10;i++)
                          cntrl.savebillitems(txtbillno.getText(), (String) tblitm.getValueAt(i,1),Double.parseDouble((String) tblitm.getValueAt(i, 2)),(String) tblitm.getValueAt(i,3),(String) tblitm.getValueAt(i,4),Double.parseDouble((String) tblitm.getValueAt(i, 5)),Double.parseDouble((String) tblitm.getValueAt(i, 6)),0.0,0.0,0.0,0.0,Double.parseDouble((String) tblitm.getValueAt(i, 11)),Double.parseDouble((String) tblitm.getValueAt(i, 12)),Double.parseDouble((String) tblitm.getValueAt(i, 13)));
                        JOptionPane.showMessageDialog(this,"Bill saved..","Saved.",1);
                        this.dispose();
                    }
                }else if(saleType.getSelectedItem()=="CESS"){
                    txtcgstp.setText("0");
                    txtcgst.setText("0"); 
                    txtsgstp.setText("0");
                    txtsgst.setText("0"); 
                    txtgstp.setText("0");
                    txtgst.setText("0"); 
                    if(txtcessp.getText().equals("")){
                        txtcessp.setText("0");
                        txtcessvalue.setText("0"); 
                    }
                    if(txtdiscountp.getText().equals("")){
                      txtdiscountp.setText("0"); 
                    }
                    if(txtdiscount.getText().equals("")){
                      txtdiscount.setText("0"); 
                    }
                    if(txtroundoff.getText().equals("")){
                        txtroundoff.setText("0");
                    }
                    if(txtothercharges.getText().equals("")){
                        txtothercharges.setText("0");
                    }
                    int choice=JOptionPane.showConfirmDialog(this,"Do you want to save Bill?", "save?", JOptionPane.YES_NO_CANCEL_OPTION,3);
                    if(choice==JOptionPane.YES_OPTION){
                        cntrl.updateBill(oldbillno,oldamount,oldname,saleType.getSelectedItem().toString(),txtbillno.getText(),((JTextField)billdate.getDateEditor().getUiComponent()).getText(),jname.getSelectedItem().toString(),txtgstno.getText(),txtvehicalno.getText(),Double.parseDouble(lbltqty.getText()),Double.parseDouble(lblamount.getText()),Double.parseDouble(txtdiscountp.getText()),Double.parseDouble(txtdiscount.getText()),Double.parseDouble(txtcgstp.getText()),Double.parseDouble(txtcgst.getText()),Double.parseDouble(txtsgstp.getText()),Double.parseDouble(txtsgst.getText()),Double.parseDouble(txtgstp.getText()),Double.parseDouble(txtgst.getText()),Double.parseDouble(txtcessp.getText()),Double.parseDouble(txtcessvalue.getText()),Double.parseDouble(roundOff.getSelectedItem().toString()+txtroundoff.getText()),Double.parseDouble(txtothercharges.getText()),Double.parseDouble(lbltamount.getText()));
                        cntrl.dltItems(oldbillno,itemname,itemqty);
                        for(int i=0;i<tblitm.getRowCount()-10;i++)
                         cntrl.savebillitems(txtbillno.getText(), (String) tblitm.getValueAt(i,1),Double.parseDouble((String) tblitm.getValueAt(i, 2)),(String) tblitm.getValueAt(i,3),(String) tblitm.getValueAt(i,4),Double.parseDouble((String) tblitm.getValueAt(i, 5)),Double.parseDouble((String) tblitm.getValueAt(i, 6)),0.0,0.0,0.0,0.0,0.0,0.0,Double.parseDouble((String) tblitm.getValueAt(i, 13)));
                        JOptionPane.showMessageDialog(this,"Bill saved..","Saved.",1);
                        this.dispose();
                    }
                }
                //clearing bill after saving
                for(int i=tblitm.getRowCount()-1;i>=0;i--)
                    modeltbl.removeRow(i);
                addbrow(0);
                jname.setSelectedIndex(0);
                txtvehicalno.setText("");
                txtgstno.setText("");
                lblamount.setText("");
                lbltqty.setText("");
                lbltamount.setText("");
                txtcgstp.setText("");
                txtcgst.setText(""); 
                txtsgstp.setText("");
                txtsgst.setText("");
                txtgstp.setText("");
                txtgst.setText(""); 
                txtcessp.setText("");
                txtcessvalue.setText(""); 
                txtdiscountp.setText(""); 
                txtdiscount.setText("");
                txtroundoff.setText("");
                txtothercharges.setText("");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,"Bill not saved","Not saved!!",0);
                    System.out.println("Bill not Saved.."+e);          
                }
            }else{
              JOptionPane.showMessageDialog(this,"Insert items ","Insert!",1);   
            }
        }else{
            JOptionPane.showMessageDialog(this,"Check partyname ","check!",1); 
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtdiscountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdiscountFocusGained
       if (!txtdiscount.getText().equals("")){
           double value=Double.parseDouble(txtdiscount.getText());
           value+=Double.parseDouble(lbltamount.getText());
           lbltamount.setText(Format.ToString(value));
       }
    }//GEN-LAST:event_txtdiscountFocusGained

    private void txtdiscountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdiscountFocusLost
       if (!txtdiscount.getText().equals("")){
        double value=Double.parseDouble(txtdiscount.getText());
        value=Double.parseDouble(lbltamount.getText())-value;
        lbltamount.setText(Format.ToString(value));
        value=Double.parseDouble(txtdiscount.getText());
        value=(value*100)/Double.parseDouble(lblamount.getText());
        txtdiscountp.setText(Format.ToString(value));
        
        txtcgstpFocusGained(evt);
        txtsgstpFocusGained(evt);
        txtgstpFocusGained(evt);
        txtcesspFocusGained(evt);
            
        txtcgstpFocusLost(evt);
        txtsgstpFocusLost(evt);
        txtgstpFocusLost(evt);
        txtcesspFocusLost(evt);
        
       }
    }//GEN-LAST:event_txtdiscountFocusLost

    private void txtcgstpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcgstpFocusLost
        if (!txtcgstp.getText().equals("") ){
                double p = Double.parseDouble(txtcgstp.getText());
                double d=0;
                if(!txtdiscount.getText().equals(""))
                    d=Double.parseDouble(txtdiscount.getText());
                double value=((Double.parseDouble(lblamount.getText())-d)*p)/100;
                txtcgst.setText(Format.ToString(value));
                value=Double.parseDouble(lbltamount.getText())+value;
                lbltamount.setText(Format.ToString(value));
            }else{
                txtcgst.setText("");
            }
    }//GEN-LAST:event_txtcgstpFocusLost

    private void txtsgstpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsgstpFocusLost
        if (!txtsgstp.getText().equals("")){
            double p = Double.parseDouble(txtsgstp.getText());
            double d=0;
            if(!txtdiscount.getText().equals(""))
                d=Double.parseDouble(txtdiscount.getText());
            double value=((Double.parseDouble(lblamount.getText())-d)*p)/100;
            txtsgst.setText(Format.ToString(value));
            value=Double.parseDouble(lbltamount.getText())+value;
          //  String str = String.format("%.2f",value);
           lbltamount.setText(Format.ToString(value));
        }
        else{
            txtsgst.setText("");
        }
    }//GEN-LAST:event_txtsgstpFocusLost

    private void txtgstpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtgstpFocusLost
        if (!txtgstp.getText().equals("")){
            double p = Double.parseDouble(txtgstp.getText());
            double d=0;
            if(!txtdiscount.getText().equals(""))
                d=Double.parseDouble(txtdiscount.getText());
            double value=((Double.parseDouble(lblamount.getText())-d)*p)/100;
            txtgst.setText(Format.ToString(value));
            value=Double.parseDouble(lbltamount.getText())+value;
            //String str = String.format("%.2f",value);
           lbltamount.setText(Format.ToString(value));
        }else{
            txtgst.setText("");
        }
    }//GEN-LAST:event_txtgstpFocusLost

    private void txtdiscountpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdiscountpFocusLost
       if (!txtdiscountp.getText().equals("")){
            double p = Double.parseDouble(txtdiscountp.getText());
            double value=(Double.parseDouble(lblamount.getText())*p)/100;
            txtdiscount.setText(Format.ToString(value));
            value=Double.parseDouble(lbltamount.getText())-value;
            lbltamount.setText(Format.ToString(value));
            
            txtcgstpFocusGained(evt);
            txtsgstpFocusGained(evt);
            txtgstpFocusGained(evt);
            txtcesspFocusGained(evt);
            
            txtcgstpFocusLost(evt);
            txtsgstpFocusLost(evt);
            txtgstpFocusLost(evt);
            txtcesspFocusLost(evt);
       }
       else{
           txtdiscount.setText("");
       }
    }//GEN-LAST:event_txtdiscountpFocusLost

    private void txtcgstpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcgstpFocusGained
        if (!txtcgst.getText().equals("")){
            double value=Double.parseDouble(txtcgst.getText());
            value=Double.parseDouble(lbltamount.getText())-value;
           lbltamount.setText(Format.ToString(value));
        }
    }//GEN-LAST:event_txtcgstpFocusGained

    private void txtsgstpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsgstpFocusGained
        if (!txtsgst.getText().equals("")){
            double value=Double.parseDouble(txtsgst.getText());
            value=Double.parseDouble(lbltamount.getText())-value;
            //String str = String.format("%.2f",value);
           lbltamount.setText(Format.ToString(value));
        }
    }//GEN-LAST:event_txtsgstpFocusGained

    private void txtdiscountpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdiscountpFocusGained
       if (!txtdiscount.getText().equals("")){
           double value=Double.parseDouble(txtdiscount.getText());
           value+=Double.parseDouble(lbltamount.getText());
           lbltamount.setText(Format.ToString(value));
       }
    }//GEN-LAST:event_txtdiscountpFocusGained

    private void txtgstpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtgstpFocusGained
        if (!txtgst.getText().equals("")){
            double value=Double.parseDouble(txtgst.getText());
            value=Double.parseDouble(lbltamount.getText())-value;
//            String str = String.format("%.2f",value);
           lbltamount.setText(Format.ToString(value));
        }
    }//GEN-LAST:event_txtgstpFocusGained

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void txtpriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpriceFocusLost
        if(!txtqty.getText().equals(""))
        txtamount.setText(Format.ToString(Double.parseDouble(txtqty.getText())*Double.parseDouble(txtprice.getText())));
    }//GEN-LAST:event_txtpriceFocusLost

    private void txtpriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpriceKeyReleased
        if(!txtqty.getText().equals("") && !txtprice.getText().equals(""))
        txtamount.setText(Format.ToString(Double.parseDouble(txtqty.getText())*Double.parseDouble(txtprice.getText())));
    }//GEN-LAST:event_txtpriceKeyReleased

    private void txtamountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtamountKeyReleased
        if(!txtqty.getText().equals("") && !txtamount.getText().equals("") )
        txtprice.setText(Format.ToString(Double.parseDouble(txtamount.getText())/Double.parseDouble(txtqty.getText())));
    }//GEN-LAST:event_txtamountKeyReleased

    private void txtamountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtamountFocusLost
       if(!txtqty.getText().equals("") && !txtamount.getText().equals(""))
        txtprice.setText(Format.ToString(Double.parseDouble(txtamount.getText())/Double.parseDouble(txtqty.getText())));
    }//GEN-LAST:event_txtamountFocusLost

    private void btnupdateitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateitemActionPerformed
        int row=tblitm.getSelectedRow();
            if(row<0){
               JOptionPane.showMessageDialog(this,"Select Row...","Select...",1);
            } 
            else if(row>=tblitm.getRowCount()-10){
                JOptionPane.showMessageDialog(this,"This Row will not Update","Update row",1);
            }
            else{
                int n=JOptionPane.showConfirmDialog(this,"Do you want to Update this?", "Update?", JOptionPane.YES_NO_OPTION,3);
                if(n==JOptionPane.YES_OPTION){
                    jitemlist.setSelectedItem(tblitm.getValueAt(row,1));
                    txtqty.setText((String) tblitm.getValueAt(row,2));
                    txtunit.setText((String) tblitm.getValueAt(row,3));
                    txthsn.setText((String) tblitm.getValueAt(row,4));
                    txtprice.setText((String) tblitm.getValueAt(row,5));
                    txtamount.setText((String) tblitm.getValueAt(row,6));
                    gstp[0]=(String) tblitm.getValueAt(row,7);
                    gstp[1]=(String) tblitm.getValueAt(row,9);
                    gstp[2]=(String) tblitm.getValueAt(row,11);
                    
                    removeRow(row);
                    
                }
            }
    }//GEN-LAST:event_btnupdateitemActionPerformed

    private void tblitmMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblitmMousePressed
        if(evt.getClickCount()==2 && !evt.isConsumed()){
            evt.consume();
            ActionEvent e=null;
            btnupdateitemActionPerformed(e);
        }
    }//GEN-LAST:event_tblitmMousePressed

    private void tblitmMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblitmMouseReleased
      
    }//GEN-LAST:event_tblitmMouseReleased

    private void jitemlistFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jitemlistFocusLost
            cntrl.fetchitemdetail(jitemlist.getSelectedItem().toString(), txtunit, txtprice,txthsn,lblStock);
    }//GEN-LAST:event_jitemlistFocusLost

    private void txtqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtyActionPerformed

    private void jnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jnameFocusLost
        cntrl.fetchaccountdetail(jname.getSelectedItem().toString(), txtgstno, lblBalance);
    }//GEN-LAST:event_jnameFocusLost

    private void jnamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jnamePropertyChange
        
    }//GEN-LAST:event_jnamePropertyChange

    private void txtdiscountpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscountpKeyTyped
        char c=evt.getKeyChar();
        if( !(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtdiscountpKeyTyped

    private void txtqtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtqtyKeyTyped
        char c=evt.getKeyChar();
        if( !(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtqtyKeyTyped

    private void txtpriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpriceKeyTyped
        char c=evt.getKeyChar();
        if( !(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtpriceKeyTyped

    private void txtamountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtamountKeyTyped
        char c=evt.getKeyChar();
        if( !(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtamountKeyTyped

    private void txtdiscountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscountKeyTyped
        char c=evt.getKeyChar();
        if( !(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtdiscountKeyTyped

    private void txtcgstpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcgstpKeyTyped
        char c=evt.getKeyChar();
        if( !(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtcgstpKeyTyped

    private void txtsgstpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsgstpKeyTyped
        char c=evt.getKeyChar();
        if( !(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtsgstpKeyTyped

    private void txtgstpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgstpKeyTyped
        char c=evt.getKeyChar();
        if( !(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtgstpKeyTyped

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jitemlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jitemlistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jitemlistActionPerformed

    private void saleTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_saleTypeItemStateChanged
        if(saleType.getSelectedItem()=="None"){
            txtcgstp.setEditable(false);
            txtsgstp.setEditable(false);
            txtgstp.setEditable(false);
            
            gstPanel.setVisible(false);
            gstPanel.setEnabled(false);
            itemColumn();
            int arr[]={7,8,9,10,11,12,13};
            hideColumn(arr);
            cess(false);
        }else if(saleType.getSelectedItem()=="Regular"){
            txtcgstp.setEditable(true);
            txtsgstp.setEditable(true);
            txtgstp.setEditable(true);
            
            gstPanel.setVisible(true);
            gstPanel.setEnabled(true);
            itemColumn();
            int arr[]={7,8,9,10,11,12,13};
            hideColumn(arr);
            cess(false);
        }else if(saleType.getSelectedItem()=="ItemWise - cgst/sgst"){
            txtcgstp.setEditable(false);
            txtsgstp.setEditable(false);
            txtgstp.setEditable(false);
            
            gstPanel.setVisible(false);
            gstPanel.setEnabled(false);
            itemWiseColumn();
            int arr[]={11,12};
            hideColumn(arr);
            cess(false);
        }else if(saleType.getSelectedItem()=="ItemWise -Igst"){
            txtcgstp.setEditable(false);
            txtsgstp.setEditable(false);
            txtgstp.setEditable(false);
            
            gstPanel.setVisible(false);
            gstPanel.setEnabled(false);
            itemWiseIgstColumn();
            int arr[]={7,8,9,10};
            hideColumn(arr);
            cess(false);
        }else if(saleType.getSelectedItem()=="CESS"){
            txtcgstp.setEditable(true);
            txtsgstp.setEditable(true);
            txtgstp.setEditable(true);
            
            gstPanel.setVisible(true);
            gstPanel.setEnabled(true);
            itemColumn();
            int arr[]={7,8,9,10,11,12,13};
            hideColumn(arr);
            cess(true);
        }
        
        if(saleType.getSelectedItem()=="None" || saleType.getSelectedItem()=="Regular" || saleType.getSelectedItem()=="CESS"){
            lblamount.setText("00.00");
            for(int i=0;i<tblitm.getRowCount()-10;i++)
              lblamount.setText(Format.ToString(Double.parseDouble(lblamount.getText())+Double.parseDouble((String)tblitm.getValueAt(i,6))));
            lbltamount.setText(lblamount.getText()); 
            reset();
        }
        else if(saleType.getSelectedItem()=="ItemWise - cgst/sgst"){
            lblamount.setText("00.00");
            for(int i=0;i<tblitm.getRowCount()-10;i++){
              tblitm.setValueAt(Format.ToString(Double.parseDouble((String)tblitm.getValueAt(i,6))+Double.parseDouble((String)tblitm.getValueAt(i,8))+Double.parseDouble((String)tblitm.getValueAt(i,10))), i, 13);
              lblamount.setText(Format.ToString(Double.parseDouble(lblamount.getText())+Double.parseDouble((String)tblitm.getValueAt(i,13))));
            }
            lbltamount.setText(lblamount.getText());
            FocusEvent ev = null;
            txtroundoffFocusLost(ev);
            txtotherchargesFocusLost(ev);
        }
        else if(saleType.getSelectedItem()=="ItemWise -Igst"){
            lblamount.setText("00.00");
            for(int i=0;i<tblitm.getRowCount()-10;i++){
              tblitm.setValueAt(Format.ToString(Double.parseDouble((String)tblitm.getValueAt(i,6))+Double.parseDouble((String)tblitm.getValueAt(i,12))), i, 13);
              lblamount.setText(Format.ToString(Double.parseDouble(lblamount.getText())+Double.parseDouble((String)tblitm.getValueAt(i,13))));
            }
            lbltamount.setText(lblamount.getText());
            FocusEvent ev = null;
            txtroundoffFocusLost(ev);
            txtotherchargesFocusLost(ev);
        }
        
    }//GEN-LAST:event_saleTypeItemStateChanged

    private void jnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnameActionPerformed

    private void txtnoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnoteActionPerformed

    private void txtnoteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnoteFocusLost
        Color c=new Color(209,237,225);
        txtnote.setBackground(c);
        txtnote.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtnoteFocusLost

    private void txtnoteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnoteFocusGained
        Color c=new Color(38,115,103);
        txtnote.setBackground(c);
        txtnote.setForeground(Color.WHITE);
    }//GEN-LAST:event_txtnoteFocusGained

    private void txthsnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthsnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthsnActionPerformed

    private void txtamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtamountActionPerformed

    private void txtvehicalnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvehicalnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvehicalnoActionPerformed

    private void txtotherchargesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtotherchargesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtotherchargesActionPerformed

    private void txtcgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcgstActionPerformed

    private void txtgstpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgstpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgstpActionPerformed

    private void txtroundoffFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtroundoffFocusGained
        if(!txtroundoff.getText().equals("")){
            double value=Double.parseDouble(txtroundoff.getText());
            if(roundOff.getSelectedItem().equals("-"))
                lbltamount.setText(Format.ToString(Double.parseDouble(lbltamount.getText())+value));
            else if(roundOff.getSelectedItem().equals("+"))
                lbltamount.setText(Format.ToString(Double.parseDouble(lbltamount.getText())-value));
        }
    }//GEN-LAST:event_txtroundoffFocusGained

    private void txtroundoffKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtroundoffKeyTyped
        char c=evt.getKeyChar();
        if( !(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtroundoffKeyTyped

    private void txtotherchargesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtotherchargesKeyTyped
        char c=evt.getKeyChar();
        if( !(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtotherchargesKeyTyped

    private void txtroundoffFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtroundoffFocusLost
        if(!txtroundoff.getText().equals("")){
            double value=Double.parseDouble(txtroundoff.getText());
            if(roundOff.getSelectedItem().equals("-"))
                lbltamount.setText(Format.ToString(Double.parseDouble(lbltamount.getText())-value));
            else if(roundOff.getSelectedItem().equals("+"))
                lbltamount.setText(Format.ToString(Double.parseDouble(lbltamount.getText())+value));
        }
    }//GEN-LAST:event_txtroundoffFocusLost

    private void txtotherchargesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtotherchargesFocusGained
        if(!txtothercharges.getText().equals("")){
            double value=Double.parseDouble(txtothercharges.getText());
            lbltamount.setText(Format.ToString(Double.parseDouble(lbltamount.getText())-value));
        }
    }//GEN-LAST:event_txtotherchargesFocusGained

    private void txtotherchargesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtotherchargesFocusLost
        if(!txtothercharges.getText().equals("")){
            double value=Double.parseDouble(txtothercharges.getText());
            lbltamount.setText(Format.ToString(Double.parseDouble(lbltamount.getText())+value));
        }
    }//GEN-LAST:event_txtotherchargesFocusLost

    private void roundOffFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roundOffFocusGained
        txtroundoffFocusGained(evt);
    }//GEN-LAST:event_roundOffFocusGained

    private void roundOffFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roundOffFocusLost
        txtroundoffFocusLost(evt);
    }//GEN-LAST:event_roundOffFocusLost

    private void jnameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jnameItemStateChanged
        
    }//GEN-LAST:event_jnameItemStateChanged

    private void txtcesspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcesspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcesspActionPerformed

    private void txtcesspKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcesspKeyTyped
        char c=evt.getKeyChar();
        if( !(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtcesspKeyTyped

    private void txtcesspFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcesspFocusGained
        if (!txtcessvalue.getText().equals("")){
            double value=Double.parseDouble(txtcessvalue.getText());
            value=Double.parseDouble(lbltamount.getText())-value;
           lbltamount.setText(Format.ToString(value));
        }
    }//GEN-LAST:event_txtcesspFocusGained

    private void txtcesspFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcesspFocusLost
        if (!txtcessp.getText().equals("") ){
                double p = Double.parseDouble(txtcessp.getText());
                double d=0;
                if(!txtdiscount.getText().equals(""))
                    d=Double.parseDouble(txtdiscount.getText());
                double value=((Double.parseDouble(lblamount.getText())-d)*p)/100;
                txtcessvalue.setText(Format.ToString(value));
                value=Double.parseDouble(lbltamount.getText())+value;
                lbltamount.setText(Format.ToString(value));
            }else{
                txtcessp.setText("");
            }
    }//GEN-LAST:event_txtcesspFocusLost

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setForeground(Color.BLUE);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        String s=(String) jname.getSelectedItem();
        jitemlist.removeAllItems();
        jname.removeAllItems();
        cntrl.fetchItems(jitemlist);
        cntrl.fetchaccounts(jname);
        jname.setSelectedItem(s);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void billdateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_billdateFocusLost
        
    }//GEN-LAST:event_billdateFocusLost

    private void billdatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_billdatePropertyChange
       
    }//GEN-LAST:event_billdatePropertyChange

    private void btndeletebillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletebillActionPerformed
        int n=JOptionPane.showConfirmDialog(this,"Do you want to delete this?", "Delete?", JOptionPane.YES_NO_CANCEL_OPTION,3);
                if(n==JOptionPane.YES_OPTION){
                    cntrl.dltBill(oldbillno,itemname,itemqty);
                    JOptionPane.showMessageDialog(null,"Bill is Deleted","Deleted",2);
                    this.dispose();
                }
    }//GEN-LAST:event_btndeletebillActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException{
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
//             UIManager.setLookAndFeel(new FlatIntelliJLaf());
            }
           // }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(modpurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modpurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modpurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modpurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              modpurchase dialog = new modpurchase(new javax.swing.JFrame(),true,rr,d1,billno,db);
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
    private com.toedter.calendar.JDateChooser billdate;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnaccdetail;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnaddaccount;
    private javax.swing.JButton btnadditem;
    private javax.swing.JButton btndeletebill;
    private javax.swing.JButton btndltitm;
    private javax.swing.JButton btnhelp;
    private javax.swing.JButton btnpayment;
    private javax.swing.JButton btnpurchase;
    private javax.swing.JButton btnreceipt;
    private javax.swing.JButton btnsales;
    private javax.swing.JButton btnstocksts;
    private javax.swing.JButton btnupdateitem;
    private javax.swing.JPanel gstPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jitemlist;
    private javax.swing.JComboBox<String> jname;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblamount;
    private javax.swing.JLabel lblcess;
    private javax.swing.JLabel lblcess1;
    private javax.swing.JLabel lblcess2;
    private javax.swing.JLabel lblqty2;
    private javax.swing.JLabel lblqty3;
    private javax.swing.JLabel lblqty4;
    private javax.swing.JLabel lbltamount;
    private javax.swing.JLabel lbltqty;
    private javax.swing.JComboBox<String> roundOff;
    private javax.swing.JComboBox<String> saleType;
    private javax.swing.JTable tblitm;
    private javax.swing.JTextField txtamount;
    private javax.swing.JTextField txtbillno;
    private javax.swing.JTextField txtcessp;
    private javax.swing.JTextField txtcessvalue;
    private javax.swing.JTextField txtcgst;
    private javax.swing.JTextField txtcgstp;
    private javax.swing.JTextField txtdiscount;
    private javax.swing.JTextField txtdiscountp;
    private javax.swing.JTextField txtgst;
    private javax.swing.JTextField txtgstno;
    private javax.swing.JTextField txtgstp;
    private javax.swing.JTextField txthsn;
    private javax.swing.JTextField txtnote;
    private javax.swing.JTextField txtothercharges;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtroundoff;
    private javax.swing.JTextField txtsgst;
    private javax.swing.JTextField txtsgstp;
    private javax.swing.JTextField txtunit;
    private javax.swing.JTextField txtvehicalno;
    // End of variables declaration//GEN-END:variables
}
