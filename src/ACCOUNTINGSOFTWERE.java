

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASAD
 */
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.IntelliJTheme;
import home.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class ACCOUNTINGSOFTWERE {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, UnsupportedLookAndFeelException {
        
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                  if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                  }
              
        }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ACCOUNTINGSOFTWERE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // IntelliJTheme.install( ACCOUNTINGSOFTWERE.class.getResourceAsStream("/icons/white_sand.theme.json" ) );
        UIManager.setLookAndFeel(new FlatIntelliJLaf());
        welcome wel= new welcome();
          try{
            wel.show();
            for(int i=0;i<=100;i++){
            if(i<=40){
                Thread.sleep(30);
                wel.bar.setValue(i);
                wel.bartext.setText("Loading..."+i+"%");
            }
            else if(i>=40 && i<=70){
                Thread.sleep(100);
                wel.bar.setValue(i);
                wel.bartext.setText("Featching data..."+i+"%");
            }
            else if(i>=70 && i<=95){
                 Thread.sleep(150);
                 wel.bar.setValue(i);
                 wel.bartext.setText("Preparing data..."+i+"%");
            }
            else{
                Thread.sleep(200);
                wel.bar.setValue(i);
                wel.bartext.setText("Starting..."+i+"%");
            }
        }    
        wel.dispose();
        }catch(Exception e ){}
        new home(0).setVisible(true);   
    }
    
}
