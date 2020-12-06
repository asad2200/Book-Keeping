package user;



import dbconnection.DbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Controller {
    
    Statement st;
    ResultSet rs;
    
    DbConnection db;
    public Controller(DbConnection db){
        this.db=db;
        rs= db.rs;
        st= db.st;
        
    }
    
    //Save Button in Crtuser 
    public void crtuser(JTextField txtname,JTextField txtpass1,String cmpname,JDialog crtuser){
        if(txtname.getText().equals("") || txtpass1.getText().equals("") || txtpass1.getText().equals("") ){
            JOptionPane.showMessageDialog(crtuser,"Please Fill All Detail...");
            txtname.requestFocus();
        }
        else if((txtname.getText().length()<5) && (txtname.getText().length()>11)){
            JOptionPane.showMessageDialog(crtuser,"User name within 4 to 10 character...");
            txtname.requestFocus();
        }
        else if((txtpass1.getText().length()<5) && (txtpass1.getText().length()>11)){
            JOptionPane.showMessageDialog(crtuser,"Password within 4 to 10 character...");
            txtpass1.requestFocus();
        }
        else if(!txtpass1.getText().equals(txtpass1.getText())){
            JOptionPane.showMessageDialog(crtuser,"Password and Confirm Password is not same...");
            txtpass1.requestFocus();
        }
        else{ 
            try{
                st.executeUpdate("insert into user_detail values('"+txtname.getText()+"','"+txtpass1.getText()+"','"+cmpname+"',NEXT VALUE FOR tbl_user_detail)");
                crtuser.dispose();
                //bar1.setVisible(true);
                //t.start();
            }catch(Exception e){ System.out.println(""+e);}
        }
    }

    //edit user in Moduser
    public void moduser(JTextField txtname,JTextField txtpass1,JDialog moduser,String cmpname){
        if(txtname.getText().equals("") || txtpass1.getText().equals("") || txtpass1.getText().equals("") ){
            JOptionPane.showMessageDialog(moduser,"Please Fill All Detail...");
            txtname.requestFocus();
        }
        else if((txtname.getText().length()<5) && (txtname.getText().length()>11)){
            JOptionPane.showMessageDialog(moduser,"User name within 4 to 10 character...");
            txtname.requestFocus();
        }
        else if((txtpass1.getText().length()<5) && (txtpass1.getText().length()>11)){
            JOptionPane.showMessageDialog(moduser,"Password within 4 to 10 character...");
            txtpass1.requestFocus();
        }
        else if(!txtpass1.getText().equals(txtpass1.getText())){
            JOptionPane.showMessageDialog(moduser,"Password and Confirm Password is not same...");
            txtpass1.requestFocus();
        }
        else{ 
            try{
                st.executeUpdate("update user_detail set uname='"+txtname.getText()+"',password='"+txtpass1.getText()+"' where cmpname='"+cmpname+"'");
                moduser.dispose();
                //bar1.setVisible(true);
                //t.start();
            }catch(Exception e){ System.out.println(""+e);}
        }
    }

    
    //main function
    public static void main(String[] args){
       
    }
}
