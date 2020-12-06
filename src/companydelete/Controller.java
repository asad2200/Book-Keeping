package companydelete;


import dbconnection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Controller {
    
    Statement st;
    ResultSet rs;
    
    DbConnection db;
    public Controller(DbConnection db){
        this.db=db;
        rs= db.rs;
        st= db.st;
        
    }
    
    //verify user in Chkuser4dlt
    public void checkuser4delete(JTextField txtuname,JTextField txtpass,JDialog Chkuser4dlt,String cmpname,JTable tbl1,JTable tbl2){
         try {
              rs=  st.executeQuery("select * from user_detail where cmpname='"+cmpname+"'");
              rs.first();
           if(  rs.getString(1).equals(txtuname.getText())){
                if(  rs.getString(2).equals(txtpass.getText())){
                   //new Dltcom(null,true,rv,d).check(cmpname,tbl1,tbl2);
                   check(cmpname,tbl1,tbl2);
                   JOptionPane.showMessageDialog(Chkuser4dlt,"Cmp deleted....");
                  // new Dltcom(null,true,rv,d).fetchcmpdetail(model1, model2);
                    Chkuser4dlt.dispose();
                }
                else
                     JOptionPane.showMessageDialog(Chkuser4dlt,"Password incorrect....");
            }
            else
                 JOptionPane.showMessageDialog(Chkuser4dlt,"Username Invalid....");
           /* if(rs.getString(1).equals(txtuname.getText())){
                 JOptionPane.showMessageDialog(this,"uname correct.......");
            }*/
       } catch (SQLException ex) {
           System.out.println(""+ex);
        }
       //JOptionPane.showMessageDialog(this,"Username Invalid....");
     }

    //for fetching data in Dltcom
    public void fetchcmpdetail(JTable tbl1,JTable tbl2) {
       Object[] col1={"No"};
       DefaultTableModel model1=new DefaultTableModel();
       Object[] col2={"Company Name"};           
       model1.setColumnIdentifiers(col1);
       DefaultTableModel model2=new DefaultTableModel();
       model2.setColumnIdentifiers(col2);
        tbl1.setModel(model1);
        tbl2.setModel(model2);
        tbl1.setDefaultEditor(Object.class,null);
        tbl2.setDefaultEditor(Object.class,null);
        try {
              rs=  st.executeQuery("select cmpname from cmp_detail");
              rs.first();
            Object[] no =new Object[1];
            Object[] name =new Object[1];
            for(int i=0;i<  rs.getRow();i++){
                no[0]=""+(i+1);
                name[0]=  rs.getString(1);
                model1.addRow(no);
                model2.addRow(name);
                  rs.next();
            }
              rs.close();
            // System.out.println("deta fatched...");
         } catch (Exception ex) {System.out.println(""+ex);} 
    }
    
    //Verify user for delete company in Dltcom
    public void check(String s,JTable tbl1,JTable tbl2){
        try{
         //String s=(String) tblcmpname.getValueAt(tblcmpname.getSelectedRow(),0);
           st.executeUpdate("delete from cmp_detail where cmpname='"+s+"'");
           st.executeUpdate("delete from user_detail where cmpname='"+s+"'");
           //JOptionPane.showMessageDialog(this,"cmp deleted");
         fetchcmpdetail(tbl1,tbl2);
        }catch(Exception ex) {System.out.println(""+ex);} 
         // JOptionPane.showMessageDialog(this,"check");
     }
    
    //main function
    public static void main(String[] args){
      
    }
}
