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
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Random;

class CoronaCanvas extends JPanel {
    //JLabel nope;
    //BufferedImage boom;
  int width, height;

  int rows;

  int cols;
  
  int i1, i2;
  
  String InfectState[][] = new String [10][10];
  
  JLabel Ilabel[][] = new JLabel[10][10];
  CoronaCanvas(int w, int h, int r, int c) {
    setSize(width = w, height = h);
    rows = r;
    cols = c;
  }//Ввод данных
@Override
public void paintComponent (Graphics g)
{
    g.setColor(Color.BLUE);
    g.fillRect(0,0,640,800);
int i1, i2, i3;
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
        g.setColor(Color.WHITE);
        g.fillRect(i1*50, i2*50, width/2, height/2);
    }
    }
}
}

public class main extends JFrame{
  public main() {
    CoronaCanvas xyz = new CoronaCanvas(50, 50, 10, 10);
    emu cemu = new emu();
    xyz.setLayout(null);
    for (int rei1=0; rei1<xyz.InfectState.length;rei1++)
    {
        for (int rei2=0; rei2<xyz.InfectState[rei1].length;rei2++){
        xyz.InfectState[rei1][rei2]="H";
        xyz.add(xyz.Ilabel[rei1][rei2]);
        xyz.Ilabel[rei1][rei2].setText(xyz.InfectState[rei1][rei2]);
        }
    }
    xyz.InfectState[0][0]="I";
    xyz.Ilabel[0][0].setText(xyz.InfectState[0][0]);
    cemu.init();    
    int time = 15;
    cemu.emulate(time);
    add(xyz);
    pack();
    while (cemu.stillruns==true)
    {
        for(int id1=0; id1<cemu.IsInfected.length;id1++){
        for(int id2=0; id2<cemu.IsInfected[id1].length; id2++)
        {
            if (cemu.IsInfected[id1][id2]==false)
            {
            xyz.InfectState[id1][id2]="H";
            }
            if (cemu.IsInfected[id1][id2]==true)
            {
            xyz.InfectState[id1][id2]="I";;
            }
            System.out.print("Node's current state: ");
            System.out.println(xyz.InfectState[id1][id2]);
        }
        }
        xyz.repaint();
    }
  }

  public static void main(String[] a) {
    new main().setVisible(true);
    
  } //Без этого Maven начисто отказался работать по неизвестным мне причинам. 
}