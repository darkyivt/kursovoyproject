/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

/**
 *
 * @author Alex
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.*;
import java.util.Random;

class main extends JPanel {
JLabel view;
BufferedImage surface;
int rows=10, cols=10, width=50, height=50;
public main()
{
    emu cemu = new emu();
    surface = new BufferedImage(800,800, BufferedImage.TYPE_INT_RGB);
    view = new JLabel(new ImageIcon(surface));
    Graphics g = surface.getGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, 800, 800);
    int i1, i2, i3;
    cemu.init();
for (i3=0; i3<rows; i3++)
{
g.setColor(Color.BLACK);
g.drawLine(12, 12+(i3*50), 475, 12+(i3*50));
g.drawLine(12+(i3*50), 12, 12+(i3*50), 475);
}
for (i1=0; i1<rows; i1++)
{
    for (i2=0; i2<cols; i2++)
    {
        g.setColor(Color.BLACK);
        if(cemu.IsInfected[i1][i2]==true)
        {
        g.setColor(Color.RED);
        }
        g.fillRect(i1*50, i2*50, width/2, height/2);
    }
}
ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                cemu.emulate();
                redrawthisshit(cemu.IsInfected);
            }
        };
Timer timer = new Timer(2500, listener);
        timer.start();
}
public void redrawthisshit(boolean checker[][])
{
    Graphics g = surface.getGraphics();
    int i1, i2;
for (i1=0; i1<checker.length; i1++)
{
    for (i2=0; i2<checker[i1].length; i2++)
    {
        if(checker[i1][i2]==false)
        {
        g.setColor(Color.BLACK);
        //System.out.println("The cell #" + i1 + i2 + "is safe.");
        }
        if(checker[i1][i2]==true)
        {
        g.setColor(Color.RED);
        //System.out.println("The cell #" + i1 + i2 + "is aggressive!"); //A bit of testing code with an outdated meme in it. 
        }
        g.fillRect(i1*50, i2*50, width/2, height/2);
    }
    }
}
public static void main(String[] args)
    {
        
        main canvas = new main();
        JFrame frame = new JFrame();
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(canvas.view);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}

