/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;
;
import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.awt.event.KeyEvent;

/**
 *
 * @author asadj
 */
public class acceptNoOnly {
    public acceptNoOnly(java.awt.event.KeyEvent evt){
        char c=evt.getKeyChar();
        if( !(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD)){
            //getToolkit().beep();
            evt.consume();
        }
    }
}
