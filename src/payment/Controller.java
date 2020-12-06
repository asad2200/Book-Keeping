package payment;

import dbconnection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
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
    
    //----------------------------------- Payment -----------------------------------//
    
    //to set bill no in Payment
    public int setbillno(){
        int no = 1;
        try {
            rs=st.executeQuery("select vchno from payment");
            if(rs.last()){
                no=rs.getInt(1)+1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
         return no;
    }
    
    //fetch accounts in combobox in Payment
    public void fetchaccountsford(JComboBox jname){
        try {
                rs=st.executeQuery("select accountname from account_detail where not type='cash-in-hand'");
                jname.addItem("");
                while(rs.next()){
                    jname.addItem(rs.getString(1));
                }
                rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //fetch accounts in combobox in Payment
    public void fetchaccountsforc(JComboBox jname){
        try {
                rs=st.executeQuery("select accountname from account_detail where type='cash-in-hand'");
                while(rs.next()){
                    jname.addItem(rs.getString(1));
                }
                rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //save the payment detail in Payment
    public void savePayment(String vchno,String billdate,JTable tblAccount,DefaultTableModel modeltbl){
        double value = 0.0;
        try{
           for(int i=0;i<tblAccount.getRowCount()-16;i++){
               if("D".equals(tblAccount.getValueAt(i, 1).toString())){
                   st.executeUpdate("Insert into payment(vchno,date,accountname,amount,detail) values('"+vchno+"','"+billdate+"','"+tblAccount.getValueAt(i, 2)+"',"+Double.parseDouble(tblAccount.getValueAt(i, 3).toString())+",'"+tblAccount.getValueAt(i, 5)+"')");
                   value=Double.parseDouble(tblAccount.getValueAt(i, 3).toString());
               }
                if(tblAccount.getValueAt(i, 1).toString().equals("C")){
                    st.executeUpdate("Insert into payment(vchno,date,accountname,amount,detail) values('"+vchno+"','"+billdate+"','"+tblAccount.getValueAt(i, 2)+"',"+Double.parseDouble(tblAccount.getValueAt(i, 4).toString())+",'"+tblAccount.getValueAt(i, 5)+"')");
                    value=Double.parseDouble(tblAccount.getValueAt(i, 4).toString());
                }
                rs=st.executeQuery("select balance from account_detail where accountname='"+tblAccount.getValueAt(i, 2)+"'");
                if(rs.first()){
                  value=Double.parseDouble(rs.getString(1))-value; 
                }
                st.executeUpdate("update account_detail set balance="+value+" where accountname='"+tblAccount.getValueAt(i, 2)+"'");
           } 
           
           modeltbl.setRowCount(0);
           modeltbl.setRowCount(16);
        }catch(Exception e){
            System.out.print("savePayment"+e);
        }
    }

    
    //----------------------------------- LmodPayment -----------------------------------//
    
    //to fetch payments in lmodpayment
    public void fetchpayments(JTable jTable1){
        try{
            Object[] col={"Vch No","Accounts","Date","Amount"};
            DefaultTableModel model=new  DefaultTableModel();//(DefaultTableModel)jTable1.getModel();
            model.setColumnIdentifiers(col);
            jTable1.setModel(model);
            jTable1.setDefaultEditor(Object.class,null);
            rs=st.executeQuery("select vchno,accountname,date,amount from payment");
            Object[] name =new Object[4];
            while(rs.next()){
                name[0]=rs.getString(1);
                name[1]=rs.getString(2);
                name[2]=rs.getString(3);
                name[3]=rs.getString(4);
                model.addRow(name);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //to fetch payments with date in LmodPayment
    public void fetchpaymentswithdate(JTable jTable1,String sdate,String edate){
        try{
            Object[] col={"Vch No","Accounts","Date","Amount"};
            DefaultTableModel model=new  DefaultTableModel();//(DefaultTableModel)jTable1.getModel();
            model.setColumnIdentifiers(col);
            jTable1.setModel(model);
            jTable1.setDefaultEditor(Object.class,null);
            rs=st.executeQuery("select vchno,accountname,date,amount from payment where date>='"+sdate+"' and date<='"+edate+"'");
            Object[] name =new Object[4];
            while(rs.next()){
                name[0]=rs.getString(1);
                name[1]=rs.getString(2);
                name[2]=rs.getString(3);
                name[3]=rs.getString(4);
                model.addRow(name);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    //----------------------------------- ModPayment -----------------------------------//
    
    public void setData(String vchno,JLabel lbldebit,JLabel lblcredit,List<String> accountname1,List<Double> amount1,List<String> accountname2,List<Double> amount2,DefaultTableModel modeltbl){
        try{ 
            
            Object[] obj = new Object[6];
            double paymentAmount=0.0;
            int i=1;
            rs=st.executeQuery("select accountname,amount,detail from PAYMENT_DETAIL where vchno='"+vchno+"'");
            modeltbl.setRowCount(0);
            while(rs.next()){
                obj[0]=Integer.toString(i);
                obj[1]="D";
                obj[2]=rs.getString(1);
                accountname1.add(rs.getString(1));
                obj[3]=rs.getString(2);
                amount1.add(rs.getDouble(2));
                paymentAmount+=rs.getDouble(2);
                obj[4]="";
                obj[5]=rs.getString(3);
                i++;
                modeltbl.addRow(obj);
            }
            lbldebit.setText(Format.ToString(paymentAmount));
            
            rs=st.executeQuery("select accountname,amount,detail from PAYMENT where vchno='"+vchno+"'");
            paymentAmount=0.0;
            i=modeltbl.getRowCount()+1;
            while(rs.next()){
                obj[0]=Integer.toString(i);
                obj[1]="C";
                obj[2]=rs.getString(1);
                accountname2.add(rs.getString(1));
                obj[3]="";
                obj[4]=rs.getString(2);
                amount2.add(rs.getDouble(2));
                paymentAmount+=rs.getDouble(2);
                obj[5]=rs.getString(3);
                i++;
                modeltbl.addRow(obj);
            }
            lblcredit.setText(Format.ToString(paymentAmount));
            
            modeltbl.setRowCount(modeltbl.getRowCount()+16);
            
        }catch(Exception e){
            System.out.println("setData modpayment -"+e);
        }
    }
    
    
    //update the payment detail in ModPayment
    public void updatePayment(String vchno,String billdate,JTable tblAccount,DefaultTableModel modeltbl,List<String> accountname1,List<Double> amount1,List<String> accountname2,List<Double> amount2){
        double value = 0.0;
        try{
            double amount = 0.0;
            String name;
            Iterator it1=accountname1.iterator();
            Iterator it2=amount1.iterator();
            while(it1.hasNext()){
                name=(String)it1.next();
                rs=st.executeQuery("select balance from account_detail where accountname='"+name+"'");
                if(rs.first()){
                  value=Double.parseDouble(rs.getString(1))+(double)it2.next(); 
                }
                st.executeUpdate("update account_detail set balance="+value+" where accountname='"+name+"'");
            }
            it1=accountname2.iterator();
            it2=amount2.iterator();
            while(it1.hasNext()){
                name=(String)it1.next();
                rs=st.executeQuery("select balance from account_detail where accountname='"+name+"'");
                if(rs.first()){
                  value=Double.parseDouble(rs.getString(1))+(double)it2.next(); 
                }
                st.executeUpdate("update account_detail set balance="+value+" where accountname='"+name+"'");
            }
            st.executeUpdate("delete from payment where vchno='"+vchno+"'");
            st.executeUpdate("delete from payment where vchno='"+vchno+"'");
            for(int i=0;i<tblAccount.getRowCount()-16;i++){
               if(tblAccount.getValueAt(i, 1).toString().equals("D")){
                   st.executeUpdate("Insert into payment(vchno,date,accountname,amount,detail) values('"+vchno+"','"+billdate+"','"+tblAccount.getValueAt(i, 2)+"',"+Double.parseDouble(tblAccount.getValueAt(i, 3).toString())+",'"+tblAccount.getValueAt(i, 5)+"')");
                   value=Double.parseDouble(tblAccount.getValueAt(i, 3).toString());
               }
                if(tblAccount.getValueAt(i, 1).toString().equals("C")){
                    st.executeUpdate("Insert into payment(vchno,date,accountname,amount,detail) values('"+vchno+"','"+billdate+"','"+tblAccount.getValueAt(i, 2)+"',"+Double.parseDouble(tblAccount.getValueAt(i, 4).toString())+",'"+tblAccount.getValueAt(i, 5)+"')");
                    value=Double.parseDouble(tblAccount.getValueAt(i, 4).toString());
                }
                rs=st.executeQuery("select balance from account_detail where accountname='"+tblAccount.getValueAt(i, 2)+"'");
                if(rs.first()){
                  value=Double.parseDouble(rs.getString(1))-value; 
                }
                st.executeUpdate("update account_detail set balance="+value+" where accountname='"+tblAccount.getValueAt(i, 2)+"'");
           } 
           modeltbl.setRowCount(0);
           modeltbl.setRowCount(16);
        }catch(Exception e){
            System.out.print("updatePayment-"+e);
        }
    }
    
    //delete payment in ModPayment
    public void dltVch(String vchno,List<String> accountname1,List<Double> amount1,List<String> accountname2,List<Double> amount2){
        try{
            double amount = 0.0,value = 0.0;
            String name;
            Iterator it1=accountname1.iterator();
            Iterator it2=amount1.iterator();
            while(it1.hasNext()){
                name=(String)it1.next();
                rs=st.executeQuery("select balance from account_detail where accountname='"+name+"'");
                if(rs.first()){
                  value=Double.parseDouble(rs.getString(1))+(double)it2.next(); 
                }
                st.executeUpdate("update account_detail set balance="+value+" where accountname='"+name+"'");
            }
            it1=accountname2.iterator();
            it2=amount2.iterator();
            while(it1.hasNext()){
                name=(String)it1.next();
                rs=st.executeQuery("select balance from account_detail where accountname='"+name+"'");
                if(rs.first()){
                  value=Double.parseDouble(rs.getString(1))+(double)it2.next(); 
                }
                st.executeUpdate("update account_detail set balance="+value+" where accountname='"+name+"'");
            }
            st.executeUpdate("delete from payment where vchno='"+vchno+"'");
            st.executeUpdate("delete from payment where vchno='"+vchno+"'");
        }catch(Exception e){
            System.out.print("dltVch-"+e);
        }
    }
    
    //----------------------------------- end -----------------------------------//
    
    //main function
    public static void main(String[] args){
     
    }
}
