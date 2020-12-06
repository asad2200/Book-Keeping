/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


/**
 *
 * @author asadj
 */
public class shortcutKey{
    public shortcutKey(JDialog dlg){
        ActionListener exit=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n=JOptionPane.showConfirmDialog(dlg,"Do you want to close this?", "Close?", JOptionPane.YES_NO_OPTION,3);
                if(n==JOptionPane.YES_OPTION){
                    dlg.dispose();
                }
            }
        };
        dlg.getRootPane().registerKeyboardAction(exit,KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0),JComponent.WHEN_IN_FOCUSED_WINDOW);
    }
}

