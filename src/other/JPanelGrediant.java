/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author asadj
 */
public class JPanelGrediant extends JPanel{
    Color c1;
    Color c2;
    //new other.JPanelGrediant(new Color(0,0,0),new Color(244,244,244));
    public JPanelGrediant(Color c1,Color c2){
        this.c1=c1;
        this.c2=c2;
    }
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)  g;
        int width= getWidth();
        int height= getHeight();
        
        GradientPaint gp=new GradientPaint(0,0, c1, 200, height, c2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
}
