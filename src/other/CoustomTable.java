/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author asadj
 */
public class CoustomTable {
    
    
    //    int bg[]={38,115,103};
    //    int fg[]={255,255,255};
    //    CoustomTable.theader(jTable1,bg,fg);
    public static void theader(JTable table,int background[],int forground[]) {
        JTableHeader hd = table.getTableHeader();
        hd.setOpaque(false);
        hd.setBackground(new Color(background[0],background[1],background[2]));
        hd.setForeground(new Color(forground[0],forground[1],forground[2]));
          
    }

}
