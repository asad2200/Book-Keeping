/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author asad
 */
public class DbConnection {
    public Statement st;
    public Connection con;
    public ResultSet rs;
    
    //connection Detabase
    public DbConnection() {
        try {
            String udir= System.getProperty("user.dir");
            String ddir=udir+"/bin";
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //con=DriverManager.getConnection("jdbc:derby://localhost:1527/bookkeeping","book","book");
            con=DriverManager.getConnection("jdbc:derby:"+ddir+"/bookkeeping","book","book");
            System.out.println("connection is ok...");
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            con=DriverManager.getConnection("jdbc:ucanaccess://"+curnt+"\\test.accdb");
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-7HVCAP9:1521:orcl","bookkeeping","bk");
//            System.out.println("--connection is ok...");
            st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
      } catch (ClassNotFoundException | SQLException ex) {System.out.println(""+ex);}
    }
    
    public static void main(String[] args){
        DbConnection dbConnection = new DbConnection();
    }
}
