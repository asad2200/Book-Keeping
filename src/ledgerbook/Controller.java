package ledgerbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dbconnection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sale.sale;


public class Controller {
    
    Statement st;
    ResultSet rs,rs2;
    
    DbConnection db;
    public Controller(DbConnection db){
        this.db=db;
        rs= db.rs;
        st= db.st;
        rs2=db.rs;
    }
    
    //fetch accounts in combobox in lb_sale
    public void fetchaccounts(JComboBox jname){
        try {
                rs=st.executeQuery("select accountname from account_detail where type ='Sundry Debtors'");
                jname.addItem("");
                while(rs.next()){
                    jname.addItem(rs.getString(1));
                }
                rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(sale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //fetch bills for lb_coustmer
    public void fetchbills(JTable jTable1,String text,String sdate,String edate){
        try{
            //System.out.println(""+sdate+edate);
            Object[] col={"Bill No","BillDate","Total Qty","Amount"};
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(col);
            jTable1.setModel(model);
            jTable1.setDefaultEditor(Object.class,null);
            rs=st.executeQuery("select billno,billdate,tqty,tamount from sale_detail where accountname ='"+text+"' and billdate >= '"+sdate+"' and billdate <= '"+edate+"'");
            rs.first();
            Object[] name =new Object[4];
            for(int i=0;i<rs.getRow();i++){
                name[0]=rs.getString(1);
                name[1]=rs.getString(2);
                name[2]=rs.getString(3);
                name[3]=rs.getString(4);
                model.addRow(name);
                rs.next();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //fetch salereturnbills for lb_coustmer
    public void fetchreturnreceipt(JTable jTable1,String text,String sdate,String edate){
        try{
            //System.out.println(""+sdate+edate);
            Object[] col={"Vch No","Date","Amount"};
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(col);
            jTable1.setModel(model);
            jTable1.setDefaultEditor(Object.class,null);
            rs=st.executeQuery("select billno,billdate,tamount from salereturn_detail where accountname ='"+text+"' and billdate >= '"+sdate+"' and billdate <= '"+edate+"'");
            rs.first();
            Object[] name =new Object[3];
            for(int i=0;i<rs.getRow();i++){
                name[0]=rs.getString(1);
                name[1]=rs.getString(2);
                name[2]=rs.getString(3);
                model.addRow(name);
                rs.next();
            }
            rs=st.executeQuery("select vchno,date,amount from receipt where accountname ='"+text+"' and date >='"+sdate+"' and date <= '"+edate+"'");
            while(rs.next()){
                name[0]=rs.getString(1);
                name[1]=rs.getString(2);
                name[2]=rs.getString(3);
                model.addRow(name);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
 //------------------------------------------ lB_suppliar -----------------------------------------------------------  
    
    //fetch accounts in combobox in lb_suppliar
    public void fetchaccountsforsuppliar(JComboBox jname){
        try {
                rs=st.executeQuery("select accountname from account_detail where type ='sundry creditiors'");
                jname.addItem("");
                while(rs.next()){
                    jname.addItem(rs.getString(1));
                }
                rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(sale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //fetch bills using searchbar in lmodsale
    public void fetchpurchasebills(JTable jTable1,String text,String sdate,String edate){
        try{
            //System.out.println(""+sdate+edate);
            Object[] col={"Bill No","BillDate","Total Qty","Amount"};
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(col);
            jTable1.setModel(model);
            jTable1.setDefaultEditor(Object.class,null);
            rs=st.executeQuery("select billno,billdate,tqty,tamount from purchase_detail where accountname ='"+text+"' and billdate >= '"+sdate+"' and billdate <= '"+edate+"'");
            rs.first();
            Object[] name =new Object[4];
            for(int i=0;i<rs.getRow();i++){
                name[0]=rs.getString(1);
                name[1]=rs.getString(2);
                name[2]=rs.getString(3);
                name[3]=rs.getString(4);
                model.addRow(name);
                rs.next();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //fetch salereturnbills for lb_coustmer
    public void fetchreturnpayments(JTable jTable1,String text,String sdate,String edate){
        try{
            //System.out.println(""+sdate+edate);
            Object[] col={"Vch No","Date","Amount"};
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(col);
            jTable1.setModel(model);
            jTable1.setDefaultEditor(Object.class,null);
            rs=st.executeQuery("select billno,billdate,tamount from PURCHASERETURN_DETAIL where accountname ='"+text+"' and billdate >= '"+sdate+"' and billdate <= '"+edate+"'");
            rs.first();
            Object[] name =new Object[3];
            for(int i=0;i<rs.getRow();i++){
                name[0]=rs.getString(1);
                name[1]=rs.getString(2);
                name[2]=rs.getString(3);
                model.addRow(name);
                rs.next();
            }
            rs=st.executeQuery("select vchno,date,amount from payment where accountname ='"+text+"' and date >='"+sdate+"' and date <= '"+edate+"'");
            while(rs.next()){
                name[0]=rs.getString(1);
                name[1]=rs.getString(2);
                name[2]=rs.getString(3);
                model.addRow(name);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //main function
    public static void main(String[] args){

    }
}

