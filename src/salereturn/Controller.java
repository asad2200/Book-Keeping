package salereturn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.toedter.calendar.JDateChooser;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import other.Format;


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
    
    //fetch items in combobox in saleReturn
    public void fetchItems(JComboBox jitemlist){
        try {
            rs=st.executeQuery("select itemname from items_detail");
            rs.first();
            jitemlist.addItem("");
            for(double i=0;i<rs.getRow();i++){
                jitemlist.addItem(rs.getString(1));
                rs.next();
            }
            rs.close();
        } catch (Exception ex) {
           ex.getMessage();
        }
    }
    public void fetchitemdetail(String s,JTextField txtunit,JTextField txtprice,JTextField txthsn,JLabel lblstock){
        try {
            rs.close();
                rs=st.executeQuery("select  UNIT,saleprice,hsn,status from items_detail where itemname='"+s+"'");
                if(rs.first()){
                    txtunit.setText(rs.getString(1));
                    txtprice.setText(rs.getString(2));
                    txthsn.setText(rs.getString(3));
                    lblstock.setText(rs.getString(4));
                }
                rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(saleReturn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //fetch accounts in combobox in saleReturn
    public void fetchaccounts(JComboBox jname){
        try {
                rs=st.executeQuery("select accountname from account_detail");
                jname.addItem("");
                while(rs.next()){
                    jname.addItem(rs.getString(1));
                }
                rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(saleReturn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fetchaccountdetail(String s,JTextField txtgstno,JLabel balance){
        try {
                rs=st.executeQuery("select  gstno,balance from account_detail where accountname='"+s+"'");
                if(rs.first()){
                    txtgstno.setText(rs.getString(1));
                    balance.setText(Format.ToString(rs.getDouble(2)));
                }
                rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(saleReturn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    //to set bill no in saleReturn
    public int setbillno(){
        int no = 1;
        try {
            rs=st.executeQuery("select billno from saleReturn_detail");
            if(rs.last()){
                no=rs.getInt(1)+1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(saleReturn.class.getName()).log(Level.SEVERE, null, ex);
        }
         return no;
    }
    
    //to save bill 
    public void savebill(String billtype,String billno,String billdate,String txtname,String gstno,String vehicalno,double tqty,double amount,double discountp,double discount,double cgstp,double cgst,double sgstp,double sgst,double gstp,double gst,double cessp,double cess,double roundoff,double other,double tamount){
        try{
            st.executeUpdate("Insert into saleReturn_detail(billtype,billno,billdate,accountname,gstno,vehicalno,tqty,amount,discountp,discount,cgstp,cgst,sgstp,sgst,gstp,gst,cessp,cess,roundoff,other,tamount) values('"+billtype+"','"+billno+"','"+billdate+"','"+txtname+"','"+gstno+"','"+vehicalno+"',"+tqty+","+amount+","+discountp+","+discount+","+cgstp+","+cgst+","+sgstp+","+sgst+","+gstp+","+gst+","+cessp+","+cess+","+roundoff+","+other+","+tamount+")");
            rs=st.executeQuery("select balance from account_detail where accountname='"+txtname+"'");
            if(rs.first()){
                tamount=Double.parseDouble(rs.getString(1))+tamount;
            }
            st.executeUpdate("update account_detail set balance="+tamount+" where accountname='"+txtname+"'");
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    //to save bill item
    public void savebillitems(String billno,String itemname,double qty,String unit,String hsn,double saleReturnprice,double amount,double cgstp,double cgst,double sgstp,double sgst,double gstp,double gst,double totalamount){
        try{
            st.executeUpdate("Insert into saleReturn_bill_items(BILLNO,ITEMNAME,QTY,UNIT,hsn,saleReturnPRICE,AMOUNT,cgstp,cgst,sgstp,sgst,gstp,gst,tamount) values('"+billno+"','"+itemname+"',"+qty+",'"+unit+"','"+hsn+"',"+saleReturnprice+","+amount+","+cgstp+","+cgst+","+sgstp+","+sgst+","+gstp+","+gst+","+totalamount+")");
            rs=st.executeQuery("select status from items_detail where ITEMNAME='"+itemname+"'");
            if(rs.first()){
                qty=Double.parseDouble(rs.getString(1))+qty;
            }
            st.executeUpdate("update items_detail set status="+qty+" where ITEMNAME='"+itemname+"'");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //-------------------------------------------------------------------------------lmodsaleReturn------------------------------------------------
    
    //fetch bills using searchbar in lmodsaleReturn
    public void fetbillforSearchbar(JTable jTable1,String text){
        try{
             Object[] col={"Bill No","Account Name","BillDate","Total Qty","Amount"};
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(col);
            jTable1.setModel(model);
            jTable1.setDefaultEditor(Object.class,null);
            rs=st.executeQuery("select billno,accountname,billdate,tqty,tamount from saleReturn_detail where accountname like '%"+text+"%'");
            rs.first();
            Object[] name =new Object[5];
            for(int i=0;i<rs.getRow();i++){
                name[0]=rs.getString(1);
                name[1]=rs.getString(2);
                name[2]=rs.getString(3);
                name[3]=rs.getString(4);
                name[4]=rs.getString(5);
                model.addRow(name);
                rs.next();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //to fetch bills in lmodsaleReturn
    public void fetchbills(JTable jTable1){
        try{
           Object[] col={"Bill No","Account Name","BillDate","Total Qty","Amount"};
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(col);
            jTable1.setModel(model);
            jTable1.setDefaultEditor(Object.class,null);
            rs=st.executeQuery("select billno,accountname,billdate,tqty,tamount from saleReturn_detail");
            rs.first();
            Object[] name =new Object[5];
            for(int i=0;i<rs.getRow();i++){
                name[0]=rs.getString(1);
                name[1]=rs.getString(2);
                name[2]=rs.getString(3);
                name[3]=rs.getString(4);
                name[4]=rs.getString(5);
                model.addRow(name);
                rs.next();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //to fetch bills with date in lmodsaleReturn
    public void fetchbillswithdate(JTable jTable1,String sdate,String edate){
        try{
           Object[] col={"Bill No","Account Name","BillDate","Total Qty","Amount"};
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(col);
            jTable1.setModel(model);
            jTable1.setDefaultEditor(Object.class,null);
            rs=st.executeQuery("select billno,accountname,billdate,tqty,tamount from saleReturn_detail where billdate>='"+sdate+"' and billdate<='"+edate+"'");
            rs.first();
            Object[] name =new Object[5];
            for(int i=0;i<rs.getRow();i++){
                name[0]=rs.getString(1);
                name[1]=rs.getString(2);
                name[2]=rs.getString(3);
                name[3]=rs.getString(4);
                name[4]=rs.getString(5);
                model.addRow(name);
                rs.next();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //to delete bill in lmodsaleReturn
    public void dltBill(String billno,List<String> itemname,List<Double> itemqty){
        try{
            double oldamount=0.0;
            String accountname="";
            rs=st.executeQuery("select tamount,accountname from saleReturn_detail where billno='"+billno+"'");
            if(rs.first()){
                oldamount=Double.parseDouble(rs.getString(1));
                accountname=rs.getString(2);
            }
            rs=st.executeQuery("select balance from account_detail where accountname='"+accountname+"'");
            if(rs.first()){
                oldamount=Double.parseDouble(rs.getString(1))-oldamount;
            }
            st.executeUpdate("update account_detail set balance="+oldamount+" where accountname='"+accountname+"'");
            st.executeUpdate("delete from saleReturn_detail where billno= '"+billno+"'");
            dltItems(billno,itemname,itemqty);  
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //to delete blankrow
    public void dltbrow(int start,DefaultTableModel modeltbl){
        for(int i=start-1;i>=start-10;i--)
            modeltbl.removeRow(i);
    }
    
    //to add blankrow 
    public void addbrow(int start,DefaultTableModel modeltbl){
        Object[] obj={" "," "," "," "," "," "};
        for(int i=start;i<start+10;i++)
            modeltbl.addRow(obj);
    }
    
    
    //set bill Data in modsaleReturn
    public void setBillData(List<String> itemname,List<Double> itemqty,String billno,JComboBox billtype,JTextField txtbillno,JDateChooser billdate,JComboBox jname,JTextField txtgstno,JTextField txtvehicalno,JComboBox jitemlist,JTextField txtqty,JTextField txtunit,JTextField txtprice,JTextField txtamount,JTable tblitm,DefaultTableModel modeltbl,JLabel lbltqty,JLabel lblamount,JTextField txtcgstp,JTextField txtcgst,JTextField txtsgstp,JTextField txtsgst,JTextField txtgstp,JTextField txtgst,JTextField txtdiscountp,JTextField txtdiscount,JTextField txtcessp,JTextField txtcess,JComboBox roundoff,JTextField txtroundoff,JTextField txtotherchages,JLabel lbltamount){
        try {
            
            //set Sata from the saleReturn_detail
            rs=st.executeQuery("select billtype,billno,billdate,accountname,gstno,vehicalno,tqty,amount,discountp,discount,cgstp,cgst,sgstp,sgst,gstp,gst,cessp,cess,roundoff,other,tamount from saleReturn_detail where billno='"+billno+"'");
            if(rs.first()){
                billtype.setSelectedItem(rs.getString(1));
                txtbillno.setText(rs.getString(2));
                ((JTextField)billdate.getDateEditor().getUiComponent()).setText(rs.getString(3));
                jname.setSelectedItem(rs.getString(4));
                txtgstno.setText(rs.getString(5));
                txtvehicalno.setText(rs.getString(6));
                lbltqty.setText(rs.getString(7));
                lblamount.setText(rs.getString(8));
                txtdiscountp.setText(rs.getString(9));
                txtdiscount.setText(rs.getString(10));
                txtcgstp.setText(rs.getString(11));
                txtcgst.setText(rs.getString(12));
                txtsgstp.setText(rs.getString(13));
                txtsgst.setText(rs.getString(14));
                txtgstp.setText(rs.getString(15));
                txtgst.setText(rs.getString(16));
                txtcessp.setText(rs.getString(17));
                txtcess.setText(rs.getString(18));
                if(rs.getDouble(19)<0){
                    roundoff.setSelectedIndex(0);
                    txtroundoff.setText(rs.getString(19).substring(1));
                }else{
                    roundoff.setSelectedIndex(1);
                    txtroundoff.setText(rs.getString(19));
                }
                txtotherchages.setText(rs.getString(20));
                lbltamount.setText(rs.getString(21));
                
                
                
            }
            
            //-------------------------------------------------------------------------------------
            //set Sata from the saleReturn_bill_items
            rs=st.executeQuery("select * from saleReturn_bill_items where billno='"+billno+"'");
            Object[] obj = new Object[14];
            int i=1;
            dltbrow(modeltbl.getRowCount(), modeltbl);
            while(rs.next()){
                obj[0]=Integer.toString(i);
                obj[1]=rs.getString(2);
                itemname.add(rs.getString(2));
                obj[2]=rs.getString(3);
                itemqty.add(rs.getDouble(3));
                obj[3]=rs.getString(4);
                obj[4]=rs.getString(5);
                obj[5]=rs.getString(6);
                obj[6]=rs.getString(7);
                obj[7]=rs.getString(8);
                obj[8]=rs.getString(9);
                obj[9]=rs.getString(10);
                obj[10]=rs.getString(11);
                obj[11]=rs.getString(12);
                obj[12]=rs.getString(13);
                obj[13]=rs.getString(14);
                i++;
                modeltbl.addRow(obj);
            }
            addbrow(modeltbl.getRowCount()-1, modeltbl);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //to update bill modsaleReturn
    public void updateBill(double oldamount,String oldname,String billtype,String billno,String billdate,String txtname,String gstno,String vehicalno,double tqty,double amount,double discountp,double discount,double cgstp,double cgst,double sgstp,double sgst,double gstp,double gst,double cessp,double cess,double roundoff,double other,double tamount){
        try{
            st.executeUpdate("update saleReturn_detail set billtype='"+billtype+"',billdate='"+billdate+"',accountname='"+txtname+"',gstno='"+gstno+"',vehicalno='"+vehicalno+"',tqty="+tqty+",amount="+amount+",discountp="+discountp+",discount="+discount+",cgstp="+cgstp+",cgst="+cgst+",sgstp="+sgstp+",sgst="+sgst+",gstp="+gstp+",gst="+gst+",cessp="+cessp+",cess="+cess+",roundoff="+roundoff+",other="+other+",tamount="+tamount+" where billno='"+billno+"'");
            rs=st.executeQuery("select balance from account_detail where accountname='"+oldname+"'");
            if(rs.first()){
                oldamount=Double.parseDouble(rs.getString(1))-oldamount;
            }
            st.executeUpdate("update account_detail set balance="+oldamount+" where accountname='"+oldname+"'");
            rs=st.executeQuery("select balance from account_detail where accountname='"+txtname+"'");
            if(rs.first()){
                tamount=Double.parseDouble(rs.getString(1))+tamount;
            }
            st.executeUpdate("update account_detail set balance="+tamount+" where accountname='"+txtname+"'");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //to dltitem for modsaleReturn
    public void dltItems(String billno,List<String> itemname,List<Double> itemqty){
        try {
            double qty = 0;
            String name;
            Iterator it1=itemname.iterator();
            Iterator it2=itemqty.iterator();
            while(it1.hasNext()){
                name=(String)it1.next();
                rs=st.executeQuery("select status from items_detail where ITEMNAME='"+name+"'");
                if(rs.first())
                    qty=(double)it2.next()-Double.parseDouble(rs.getString(1));
                st.executeUpdate("update items_detail set status="+qty+" where ITEMNAME='"+name+"'");
            }
            st.executeUpdate("delete from saleReturn_bill_items where billno= '"+billno+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    //main function
    public static void main(String[] args){
       /* Billcontroller bcntrl=new Billcontroller();
        bcntrl.connection();
        for(int i=0;i<=1000000;i++)
        bcntrl.savebillitems(1,"asad",1,1,1);*/
    }
}

