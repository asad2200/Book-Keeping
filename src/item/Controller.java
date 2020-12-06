package item;


import dbconnection.DbConnection;
import java.awt.Dimension;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import other.Format;


public class Controller {
    
    Statement st;
    ResultSet rs;
    
    DbConnection db;
    public Controller(DbConnection db){
        this.db=db;
        rs= db.rs;
        st= db.st;
        
    }
    
    //save item detail in itmadd
    public void itmadd(JTextField txtname,JComboBox listgroup,JComboBox listunit,JTextField txthsn,JTextField txtsale,JTextField txtpurcahse,JDialog itmadd){
        int k=0;
        if(txtname.getText().equals("") || txtsale.getText().equals("") || txtpurcahse.getText().equals("")){
            JOptionPane.showMessageDialog(itmadd,"Please Fill All Detail...");
            txtname.requestFocusInWindow();
        }
        else if(txtname.getText().length()>21){
            JOptionPane.showMessageDialog(itmadd,"Item name must be lessthen 20");
            txtname.requestFocusInWindow();
        }
        else if(txtsale.getText().length()>11){
            JOptionPane.showMessageDialog(itmadd,"Saleprice must be lessthen 10");
            txtsale.requestFocusInWindow();
        }
       
        else if(txtpurcahse.getText().length() >11){
            JOptionPane.showMessageDialog(itmadd,"Purchaseprice must be lessthen 10");
            txtpurcahse.requestFocusInWindow();
        }
        else{
        try {
            String s=txtname.getText();
            char c[]=s.toCharArray();
            rs=st.executeQuery("select itemname from  items_detail where itemname like '"+c[0]+"%' ");
            rs.first();
            for(int i=0;i<rs.getRow();i++){
                 if(rs.getString(1).toLowerCase().equals(txtname.getText().toLowerCase())){
                    JOptionPane.showMessageDialog(itmadd,"Item already existed you have to change Item name..");
                    k=1;
                    break;
                    }
                rs.next();
            }
            if(k==0){
                    int response=JOptionPane.showConfirmDialog(itmadd, "Do you want to Save this information ?","Save ?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(response==JOptionPane.YES_OPTION){    
                        st.executeUpdate("insert into items_detail(ITEMNAME,STOCK,UNIT,hsn,SALEPRICE,PURCHASEPRICE,status,ID) values('"+txtname.getText().toLowerCase()+"','"+listgroup.getSelectedItem().toString().toLowerCase()
                            +"','"+listunit.getSelectedItem().toString().toLowerCase()+"','"+txthsn.getText()
                            +"',"+txtsale.getText()+","+txtpurcahse.getText()+",0,NEXT VALUE FOR tbl_items_detail)");
                        JOptionPane.showMessageDialog(itmadd,"Item is Created.....");
                        txtname.setText("");
                        txthsn.setText("");
                        txtsale.setText("");
                        txtpurcahse.setText("");
                    }
                    else{
                       txtname.requestFocusInWindow();
                    }
                } 
            } catch (Exception e) {
                System.out.println("="+e);
            }finally{
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(itmadd.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    //set ItemDetail in itmmod
    public String setitemdetail(String itmname,JTextField txtname,JComboBox listgroup,JComboBox listunit,JTextField txthsn,JTextField txtsale,JTextField txtpurchase){
        String seq="" ;
        try {
            rs=st.executeQuery("select * from items_detail where itemname='"+itmname+"'");
            if(rs.first()){
                txtname.setText(rs.getString(1));
                listgroup.setSelectedItem(rs.getString(2));
                listunit.setSelectedItem(rs.getString(3));
                txthsn.setText(rs.getString(8));
                txtsale.setText(rs.getString(4));
                txtpurchase.setText(rs.getString(5));
                seq=rs.getString(6);
            }
        } catch (SQLException ex) {
            Logger.getLogger(itmmod.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seq;
    }  
    
    //edit item detail in itmmod
    public void itmmod(JTextField txtname,JComboBox listgroup,JComboBox listunit,JTextField txthsn,JTextField txtsale,JTextField txtpurcahse,JDialog itmadd,String seq,JTable jTable1){
        int k=0;
        if(txtname.getText().equals("") || txtsale.getText().equals("") || txtpurcahse.getText().equals("")){
            JOptionPane.showMessageDialog(itmadd,"Please Fill All Detail...");
            txtname.requestFocusInWindow();
        }
        else if(txtname.getText().length()>21){
            JOptionPane.showMessageDialog(itmadd,"Item name must be lessthen 20");
            txtname.requestFocusInWindow();
        }
        else if(txtsale.getText().length()>11){
            JOptionPane.showMessageDialog(itmadd,"Saleprice must be lessthen 10");
            txtsale.requestFocusInWindow();
        }
       
        else if(txtpurcahse.getText().length() >11){
            JOptionPane.showMessageDialog(itmadd,"Purchaseprice must be lessthen 10");
            txtpurcahse.requestFocusInWindow();
        }
        else{
        try {
            String s=txtname.getText();
            char c[]=s.toCharArray();
            rs=st.executeQuery("select itemname from  items_detail where itemname like '"+c[0]+"%' ");
            rs.first();
            for(int i=0;i<rs.getRow();i++){
                 if(rs.getString(1).toLowerCase().equals(txtname.getText().toLowerCase()) && !rs.getString(1).toLowerCase().equals(txtname.getText().toLowerCase())){
                    JOptionPane.showMessageDialog(itmadd,"Item already existed you have to change Item name..");
                    k=1;
                    break;
                    }
                rs.next();
            }
            if(k==0){
                    int response=JOptionPane.showConfirmDialog(itmadd, "Do you want to Save this information ?","Save ?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(response==JOptionPane.YES_OPTION){    
                        st.executeUpdate("update items_detail set itemname='"+txtname.getText().toLowerCase()+"',STOCK='"+listgroup.getSelectedItem().toString().toLowerCase()
                            +"',unit='"+listunit.getSelectedItem().toString().toLowerCase()
                            +"',SALEPRICE="+txtsale.getText()+",PURCHASEPRICE="+txtpurcahse.getText()+",hsn='"+txthsn.getText()+"' where id="+seq+"");
                        JOptionPane.showMessageDialog(itmadd,"Item is Updated.....");
                        fetchitems(jTable1);
                        itmadd.dispose();
                    }
                    else{
                       txtname.requestFocusInWindow();
                    }
                } 
            } catch (Exception e) {
                System.out.println("="+e);
            }finally{
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(itmmod.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    //fetch accounts in lmodacc
    public void fetchitems(JTable jTable1){
        try{
            Object[] col={"Item Name"};
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(col);
            jTable1.setModel(model);
            jTable1.setDefaultEditor(Object.class,null);
            rs=st.executeQuery("select itemname from items_detail");
            rs.first();
            Object[] name =new Object[1];
            for(int i=0;i<rs.getRow();i++){
                name[0]=rs.getString(1);
                model.addRow(name);
                rs.next();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void fetchitemsforSearchbar(JTable jTable1,String text){
        try{
            Object[] col={"Item Name"};
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(col);
            jTable1.setModel(model);
            jTable1.setDefaultEditor(Object.class,null);
            rs=st.executeQuery("select ITEMNAME from items_detail where ITEMNAME like '%"+text+"%'");
            rs.first();
            Object[] name =new Object[1];
            for(int i=0;i<rs.getRow();i++){
                name[0]=rs.getString(1);
                model.addRow(name);
                rs.next();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //list of Items in listitm
    public void itmlist(JTable jTable1,boolean group,String type){
         try{
            Object[] col={"Item Name","Group","Unit","HSN Code","Sale Price","Purchase Price","Stock"};
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(col);
            jTable1.setModel(model);
            jTable1.setDefaultEditor(Object.class,null);
            if(group)
                rs=st.executeQuery("select itemname,stock,unit,saleprice,purchaseprice,status,hsn from Items_detail where stock='"+type+"'");
            else
                rs=st.executeQuery("select itemname,stock,unit,saleprice,purchaseprice,status,hsn from Items_detail");
            rs.first();
            Object[] name =new Object[7];
            for(int i=0;i<rs.getRow();i++){
                name[0]=rs.getString(1);
                name[1]=rs.getString(2);
                name[2]=rs.getString(3);
                name[3]=rs.getString(7);
                name[4]=Format.ToString(rs.getDouble(4));
                name[5]=Format.ToString(rs.getDouble(5));
                name[6]=Format.ToString(rs.getDouble(6));
                
                model.addRow(name);
                rs.next();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //delete item in lmoditm
    public void lmoditmdlt(JTable jTable1,JDialog lmoditm){
        try { 
            if(jTable1.getRowCount()==0){
                JOptionPane.showMessageDialog(lmoditm,"Item was not created");
            }
            else{
               String s=null;
                try{
                   s=(String) jTable1.getValueAt(jTable1.getSelectedRow(),0);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(lmoditm,"Please select Item");
                }
                if(!s.equals("")){
                    int response=JOptionPane.showConfirmDialog(lmoditm, "Do you want to Delete this information ?","Delete ?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(response==JOptionPane.YES_OPTION){
                        st.executeUpdate("delete from items_detail where itemname='"+s+"'");
                        fetchitems(jTable1);
                    } 
                      // JOptionPane.showMessageDialog(lmodacc,"Account is Deleted");
                       
                }
                else{
                    JOptionPane.showMessageDialog(lmoditm,"Please select Item");
                }
            }
        } catch (SQLException ex) {
                       Logger.getLogger(lmoditm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //select item for modification in lmoditm
    public void lmoditmmod(JTable jTable1,JDialog lmoditm,Point rr,Dimension d1){
        try { 
            if(jTable1.getRowCount()==0){
                JOptionPane.showMessageDialog(lmoditm,"Item was not created");
            }
            else{
               String s=null;
                try{
                   s=(String) jTable1.getValueAt(jTable1.getSelectedRow(),0);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(lmoditm,"Please select Item");
                }
                if(!s.equals("")){
                      new itmmod(new javax.swing.JFrame(),true,rr,d1,s,jTable1,db).show();
                }
                else{
                    JOptionPane.showMessageDialog(lmoditm,"Please select Item");
                }
            }
        } catch (Exception ex) {
                       Logger.getLogger(lmoditm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //main function
    public static void main(String[] args){
      
    }
}
