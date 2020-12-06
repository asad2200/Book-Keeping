package account;




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
import javax.swing.JTextArea;
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
    
    public void accadd(int k,JTextField txtname,JTextArea taadd,JTextField txtmno,JDialog accadd,JComboBox listcountry,JComboBox listtype,JComboBox liststate,JTextField txtgstno){
        k=0;
        if(txtname.getText().equals("") || taadd.getText().equals("") || txtmno.getText().equals("")){
            JOptionPane.showMessageDialog(accadd,"Please Fill All Detail...");
            txtname.requestFocusInWindow();
        }
        else if(txtname.getText().length()>31){
            JOptionPane.showMessageDialog(accadd,"Account name must be lessthen 30");
            txtname.requestFocusInWindow();
        }
        else if(taadd.getText().length()>101){
            JOptionPane.showMessageDialog(accadd,"Address must be lessthen 100");
            taadd.requestFocusInWindow();
        }
       
        else if(txtmno.getText().length()!=10){
            JOptionPane.showMessageDialog(accadd,"Mobile no. must be in 10 digit");
            txtmno.requestFocusInWindow();
        }
        else{
        try {
            String s=txtname.getText();
            char c[]=s.toCharArray();
            rs=st.executeQuery("select accountname from account_detail where accountname like '"+c[0]+"%' ");
            rs.first();
            for(int i=0;i<rs.getRow();i++){
                 if(rs.getString(1).toLowerCase().equals(txtname.getText().toLowerCase())){
                    JOptionPane.showMessageDialog(accadd,"Account already existed you have to change Account name..");
                    k=1;
                    break;
                    }
                rs.next();
            }
            if(k==0){
                    int response=JOptionPane.showConfirmDialog(accadd, "Do you want to Save this information ?","Save ?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(response==JOptionPane.YES_OPTION){    
                        st.executeUpdate("insert into account_detail(accountname,type,country,state,address,mobile,gstno,balance,id) values('"+txtname.getText().toLowerCase()+"','"+listtype.getSelectedItem().toString().toLowerCase()
                            +"','"+listcountry.getSelectedItem().toString().toLowerCase()+"','"+liststate.getSelectedItem().toString().toLowerCase()
                            +"','"+taadd.getText().toLowerCase()+"',"+Double.parseDouble(txtmno.getText())+",'"+txtgstno.getText()+"',0,NEXT VALUE FOR tbl_account_detail)");
                        JOptionPane.showMessageDialog(accadd,"Account is Created.....");
                        txtname.setText(null);
                        taadd.setText(null);
                        txtmno.setText(null);
                        txtgstno.setText("");
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
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }
    
    //set accountDetail in accmod
    public String setaccountdetail(String accname,JTextField txtname,JTextArea taadd,JTextField txtmno,JDialog accadd,JComboBox listcountry,JComboBox listtype,JComboBox liststate,JTextField txtgstno){
        String seq="" ;
        try {
            rs=st.executeQuery("select * from account_detail where accountname='"+accname+"'");
            if(rs.first()){
                txtname.setText(rs.getString(1));
                listtype.setSelectedItem(rs.getString(2));
                listcountry.setSelectedItem(rs.getString(3));
                liststate.setSelectedItem(rs.getString(4));
                taadd.setText(rs.getString(5));
                txtmno.setText(Long.toString((long)rs.getDouble(6)));
                txtgstno.setText(rs.getString(7));
                seq=rs.getString(8);
            }
        } catch (SQLException ex) {
           Logger.getLogger(accmod.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seq;
    }  
    
    //edit account detail in accmod
    public void accmod(JTextField txtname,JTextArea taadd,JTextField txtmno,JDialog accadd,JComboBox listcountry,JComboBox listtype,JComboBox liststate,String seq,JTable jTable1,String aname,JTextField txtgstno){
        int k=0;
        if(txtname.getText().equals("") || taadd.getText().equals("") || txtmno.getText().equals("")){
            JOptionPane.showMessageDialog(accadd,"Please Fill All Detail...");
            txtname.requestFocusInWindow();
        }
        else if(txtname.getText().length()>31){
            JOptionPane.showMessageDialog(accadd,"Account name must be lessthen 30");
            txtname.requestFocusInWindow();
        }
        else if(taadd.getText().length()>101){
            JOptionPane.showMessageDialog(accadd,"Address must be lessthen 100");
            taadd.requestFocusInWindow();
        }
       
        else if(txtmno.getText().length()!=10){
            JOptionPane.showMessageDialog(accadd,"Mobile no. must be in 10 digit");
            txtmno.requestFocusInWindow();
        }
        else{
        try {
            String s=txtname.getText();
            char c[]=s.toCharArray();
            rs=st.executeQuery("select accountname from account_detail where accountname like '"+c[0]+"%' ");
            rs.first();
            for(int i=0;i<rs.getRow();i++){
                 if(rs.getString(1).toLowerCase().equals(txtname.getText().toLowerCase()) && !rs.getString(1).equals(aname)){
                    JOptionPane.showMessageDialog(accadd,"Account already existed you have to change Account name..");
                    k=1;
                    break;
                    }
                rs.next();
            }
            if(k==0){
                    int response=JOptionPane.showConfirmDialog(accadd, "Do you want to Save this information ?","Save ?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(response==JOptionPane.YES_OPTION){    
                        st.executeUpdate("update account_detail set accountname='"+txtname.getText().toLowerCase()+"',type='"+listtype.getSelectedItem().toString().toLowerCase()
                            +"',COUNTRY='"+listcountry.getSelectedItem().toString().toLowerCase()+"',state='"+liststate.getSelectedItem().toString().toLowerCase()
                            +"',ADDRESS='"+taadd.getText().toLowerCase()+"',mobile="+Double.parseDouble(txtmno.getText())+",gstno='"+txtgstno.getText()+"' where id="+seq+"");
                        JOptionPane.showMessageDialog(accadd,"Account is Updated.....");
                        fetchaccounts(jTable1);
                        accadd.dispose();
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
                Logger.getLogger(accmod.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }
    
    //fetch accounts in lmodacc
    public void fetchaccounts(JTable jTable1){
        try{
            Object[] col={"Account Name"};
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(col);
            jTable1.setModel(model);
            jTable1.setDefaultEditor(Object.class,null);
            rs=st.executeQuery("select accountname from account_detail");
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
  
    //fetch accounts in lmodacc
    public void fetchaccountsforSearchbar(JTable jTable1,String text){
        try{
            Object[] col={"Account Name"};
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(col);
            jTable1.setModel(model);
            jTable1.setDefaultEditor(Object.class,null);
            rs=st.executeQuery("select accountname from account_detail where accountname like '%"+text+"%'");
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
    
    //list of accounts in listacc
    public void acclist(JTable jTable1,boolean type,String group){
         try{
            Object[] col={"Account Name","Account Type","Country","State","Address","Mobile No.","Balance","Gst No."};
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(col);
            jTable1.setModel(model);
            jTable1.setDefaultEditor(Object.class,null);
            if(type)
                rs=st.executeQuery("select accountname,type,country,state,address,mobile,balance,gstno from account_detail where type='"+group+"'");
            else
                rs=st.executeQuery("select accountname,type,country,state,address,mobile,balance,gstno from account_detail");
            rs.first();
            Object[] name =new Object[8];
            for(int i=0;i<rs.getRow();i++){
                name[0]=rs.getString(1);
                name[1]=rs.getString(2);
                name[2]=rs.getString(3);
                name[3]=rs.getString(4);
                name[4]=rs.getString(5);
                name[5]=Format.ToString(rs.getDouble(6),0);
                name[6]=Format.ToString(rs.getDouble(7));
                name[7]=rs.getString(8);
                
                
                model.addRow(name);
                rs.next();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //delete account in lmodacc
    public void lmodacc(JTable jTable1,JDialog lmodacc){
        try { 
            if(jTable1.getRowCount()==0){
                JOptionPane.showMessageDialog(lmodacc,"account was not created");
            }
            else{
               String s=null;
                try{
                   s=(String) jTable1.getValueAt(jTable1.getSelectedRow(),0);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(lmodacc,"Please select Account");
                }
                if(!s.equals("")){
                    int response=JOptionPane.showConfirmDialog(lmodacc, "Do you want to Delete this Account ?","Delete ?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(response==JOptionPane.YES_OPTION){
                        st.executeUpdate("delete from account_detail where accountname='"+s+"'");
                        fetchaccounts(jTable1);
                    } 
                      // JOptionPane.showMessageDialog(lmodacc,"Account is Deleted");
                       
                }
                else{
                    JOptionPane.showMessageDialog(lmodacc,"Please select Account");
                }
            }
        } catch (SQLException ex) {
                       Logger.getLogger(lmodacc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //select account for modification in lmodacc
    public void modacc(JTable jTable1,JDialog lmodacc,Point rr,Dimension d1){
        try { 
            if(jTable1.getRowCount()==0){
                JOptionPane.showMessageDialog(lmodacc,"account was not created");
            }
            else{
               String s=null;
                try{
                   s=(String) jTable1.getValueAt(jTable1.getSelectedRow(),0);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(lmodacc,"Please select Account");
                }
                if(!s.equals("")){
                      new accmod(new javax.swing.JFrame(),true,rr,d1,s,jTable1,db).show();
                }
                else{
                    JOptionPane.showMessageDialog(lmodacc,"Please select Account");
                }
            }
        } catch (Exception ex) {
                       Logger.getLogger(lmodacc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //main function
    public static void main(String[] args){
       
    }
}
