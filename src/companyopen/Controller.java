package companyopen;


import dbconnection.DbConnection;
import home.home;
import java.awt.Dimension;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    
    //save button in Chkuser
    public void checkuser(JTextField txtuname,JTextField txtpass,JDialog Chkuser,String cmpname,Point rv,Dimension d,JMenu jm1,JMenu jm2,JMenu jm3,JMenu jm4,JMenu jm5,JMenu jm6,JLabel jl2,JLabel jl3,JPanel jp5,JButton b1,JButton b2,JButton b3,JButton b4,JButton b5,JButton b6,JButton b7,JButton b8,JButton b9,JDialog Opncmp){
        home hm=new home(1);
        try {
//            int i=0;
              rs=  st.executeQuery("select * from user_detail where cmpname='"+cmpname+"'");
              rs.first();
            if(  rs.getString(1).equals(txtuname.getText())){
                if(  rs.getString(2).equals(txtpass.getText())){
                    JOptionPane.showMessageDialog(Chkuser,"Succesfully Loged in....");
                    //j++;
                    new Chkuser(new javax.swing.JFrame(), true,cmpname,rv,d,jm1,jm2,jm3,jm4,jm5,jm6,jl2,jl3,jp5,b1,b2,b3,b4,b5,b6,b7,b8,b9,Opncmp,db).unvisible();
                    Chkuser.dispose();
                    Opncmp.dispose();
                }
                else
                JOptionPane.showMessageDialog(Chkuser,"Password incorrect....");
            }
            else
            JOptionPane.showMessageDialog(Chkuser,"Username Invalid....");
            /* if(rs.getString(1).equals(txtuname.getText())){
                JOptionPane.showMessageDialog(this,"uname correct.......");
            }*/
        } catch (SQLException ex) {
            System.out.println(""+ex);
        }
    }

    //for fetching data in Opncmp
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
    
    //main function
    public static void main(String[] args){

    }
}
