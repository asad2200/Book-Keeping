package home;




import comapnycreate.Crtcmp;
import dbconnection.DbConnection;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Controller {
    
    Statement st;
    ResultSet rs;
    
    DbConnection db;
    public Controller(DbConnection db){
        this.db=db;
        rs= db.rs;
        st= db.st;
        
    }
    
    //for chrcking companies in home in createcomapny button
    public void checkcompany(JButton btncrtcmp,Point rr,Dimension d1,JFrame home) {
        try {
             rs= st.executeQuery("select * from cmp_detail");
             rs.last();
            if( rs.getRow()>=1){
                btncrtcmp.disable();
                JOptionPane.showMessageDialog(home,"You can Create One company at the time...:))\nIf you want to add another company than Delete previous one..");
            }
            else{
                new Crtcmp(home,true,rr,d1,db).show();
            }
         } catch (HeadlessException | SQLException ex) {
             System.out.println(""+ex);
        }
    }
    
    //main function
    public static void main(String[] args){
//       Controller cntrl=new Controller();
//       cntrl.connection();
    }
    
    
    
}

