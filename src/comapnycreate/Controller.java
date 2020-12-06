package comapnycreate;



import dbconnection.DbConnection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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
    
    //for create comapny in Crtcmp in save button
    public void createcompany(JTextField txtname,JComboBox listcountry,JComboBox liststate,JTextArea taadd,JTextField txtemail,JTextField txtmno,JProgressBar bar1,Timer t,JDialog crtcmp,JTextField txtgstno){
        if(txtname.getText().equals("") || taadd.getText().equals("") ||txtemail.getText().equals("") || txtmno.getText().equals("")){
            JOptionPane.showMessageDialog(crtcmp,"Please Fill All Detail...");
            txtname.requestFocusInWindow();
        }
        else if(txtname.getText().length()>31){
            JOptionPane.showMessageDialog(crtcmp,"Company name must be lessthen 30");
            txtname.requestFocusInWindow();
        }
        else if(taadd.getText().length()>101){
            JOptionPane.showMessageDialog(crtcmp,"Address must be lessthen 100");
            taadd.requestFocusInWindow();
        }
        else if(txtemail.getText().length()>31){
            JOptionPane.showMessageDialog(crtcmp,"Email must be lessthen 30");
            txtemail.requestFocusInWindow();
        }
        else if(txtmno.getText().length()!=10){
            JOptionPane.showMessageDialog(crtcmp,"Mobile no. must be in 10 digit");
            txtmno.requestFocusInWindow();
        }
        else if(txtgstno.getText().length()>21){
            JOptionPane.showMessageDialog(crtcmp,"Gst no. must be lessthan 15");
            txtmno.requestFocusInWindow();
        }
        else{
           try {
                rs=st.executeQuery("select cmpname from cmp_detail");
                rs.last();
               /* if(rs.getRow()==0){
                    int response=JOptionPane.showConfirmDialog(crtcmp, "Do you want to save this information ?","Save ?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(response==JOptionPane.YES_OPTION){
                        st.executeUpdate("insert into cmp_detail values('"+txtname.getText()+"','"+listcountry.getSelectedItem()+"','"
                            +liststate.getSelectedItem()+"','"+taadd.getText()+"','"+txtemail.getText()+"',"
                            +Double.parseDouble(txtmno.getText())+",NEXT VALUE FOR tbl_cmp_detail)");
                        bar1.setVisible(true);
                        t.start();
                    }
                    else{
                        txtname.requestFocusInWindow();
                    }
                }*/
                if(rs.getRow()>0 && rs.getString(1).toLowerCase().equals(txtname.getText().toLowerCase())){
                    JOptionPane.showMessageDialog(crtcmp,"Company already existed you have to change company name..");
                }
                else{
                    int response=JOptionPane.showConfirmDialog(crtcmp, "Do you want to save this information ?","Save ?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(response==JOptionPane.YES_OPTION){
                        st.executeUpdate("insert into cmp_detail values('"+txtname.getText()+"','"+listcountry.getSelectedItem()+"','"
                            +liststate.getSelectedItem()+"','"+taadd.getText()+"','"+txtemail.getText()+"',"
                            +Double.parseDouble(txtmno.getText())+",'"+txtgstno.getText()+"',NEXT VALUE FOR tbl_cmp_detail)");
                        bar1.setVisible(true);
                        t.start();
                    }
                    else{
                        txtname.requestFocusInWindow();
                    }
                }
                //rs.close();
            } catch (SQLException e) {
                System.out.println("=="+e);
            }
        } 
    }

    
    //main function
    public static void main(String[] args){
    
    }
}
