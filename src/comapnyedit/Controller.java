package comapnyedit;

import dbconnection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Controller {
    
    Statement st;
    ResultSet rs;
    
    DbConnection db;
    public Controller(DbConnection db){
        this.db=db;
        rs= db.rs;
        st= db.st;
        
    }
    
    //get and set company detail in Edtcmp
    public String seteditcmp(JTextField txtname,JComboBox listcountry,JComboBox liststate,JTextArea taadd,JTextField txtemail,JTextField txtmno,String seq,int k,String cname,JTextField txtgstno){
        try {
             rs=  st.executeQuery("select * from cmp_detail where cmpname='"+cname.toLowerCase()+"'");
            // seq=rs.getInt(7);
            if(  rs.first()){
                txtname.setText(  rs.getString(1));
                listcountry.setSelectedItem(  rs.getString(2));
                liststate.setSelectedItem(  rs.getString(3));
                taadd.setText(  rs.getString(4));
                txtemail.setText(  rs.getString(5));
                txtmno.setText(Long.toString((long)  rs.getDouble(6)));
                txtgstno.setText( rs.getString(7));
                seq=  rs.getString(8);
            }
            k=0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Edtcmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seq;
    }

    //Edit company detail in Edtcmp
    public void edtcmp(JTextField txtname,JComboBox listcountry,JComboBox liststate,JTextArea taadd,JTextField txtemail,JTextField txtmno,String seq,String cname,int k,JDialog edtcmp,JLabel jl,JProgressBar bar1,Timer t,JTextField txtgstno){
        k=0;
        if(txtname.getText().equals("") || taadd.getText().equals("") ||txtemail.getText().equals("") || txtmno.getText().equals("")){
            JOptionPane.showMessageDialog(edtcmp,"Please Fill All Detail...");
            txtname.requestFocusInWindow();
        }
        else if(txtname.getText().length()>31){
            JOptionPane.showMessageDialog(edtcmp,"Company name must be lessthen 30");
            txtname.requestFocusInWindow();
        }
        else if(taadd.getText().length()>101){
            JOptionPane.showMessageDialog(edtcmp,"Address must be lessthen 100");
            taadd.requestFocusInWindow();
        }
        else if(txtemail.getText().length()>31){
            JOptionPane.showMessageDialog(edtcmp,"Email must be lessthen 30");
            txtemail.requestFocusInWindow();
        }
        else if(txtmno.getText().length()!=10){
            JOptionPane.showMessageDialog(edtcmp,"Mobile no. must be in 10 digit");
            txtmno.requestFocusInWindow();
        }
        else if(txtgstno.getText().length()>21){
            JOptionPane.showMessageDialog(edtcmp,"Gst no. must be lessthan 15");
            txtmno.requestFocusInWindow();
        }
        /*else if(txtmno.getText().length()==10){
            char c[]=txtmno.getText().toCharArray();
            for(int i=0;i<10;i++){
                if(c[i]>=48 && c[i]<=57){
                    
                }
                else{
                    txtmno.requestFocusInWindow();
                     JOptionPane.showMessageDialog(this,"Mobile no. must be in digit");
                    break;
                }
            }
        }*/
        else{
            try {
                  rs.close();
                ResultSet rs2=  st.executeQuery("select cmpname from cmp_detail");
                while(rs2.next()){
                    if(rs2.getString(1).toLowerCase().equals(txtname.getText().toLowerCase()) && !rs2.getString(1).toLowerCase().equals(cname)){
                        JOptionPane.showMessageDialog(edtcmp,"Company already existed you have to change company name..");
                        k=1;
                        break;
                    }
                }
                    if(k==0){
                        int response=JOptionPane.showConfirmDialog(edtcmp, "Do you want to update this information ?","Update ?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                        if(response==JOptionPane.YES_OPTION){    
                          st.executeUpdate("update cmp_detail set cmpname='"+txtname.getText()+"',country='"+listcountry.getSelectedItem()+"',state='"
                                    +liststate.getSelectedItem()+"',address='"+taadd.getText()+"',e_mail='"+txtemail.getText()+"',mobile="+Double.parseDouble(txtmno.getText())+",gstno='"+txtgstno.getText()+"' where id= "+seq);
                        jl.setText(""+txtname.getText());
                          st.executeUpdate("update user_detail set cmpname='"+txtname.getText()+"' where cmpname='"+cname+"'");
                        bar1.setVisible(true);
                        t.start();
                        }
                        else{
                           txtname.requestFocusInWindow();
                        }
                    }            

            } catch (Exception e) {
                System.out.println("=="+e);
            }
        }
    }

    
    //main function
    public static void main(String[] args){
     
    }
}
