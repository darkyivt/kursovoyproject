/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;
import java.util.Random.*;
import java.util.concurrent.TimeUnit;
import java.util.Timer;
/**
 *
 * @author Alex
 */
public class emu {
    int totalinfectees=0;
    boolean [][] IsInfected = new boolean [10][10];//Массив
    boolean stillruns=true;
    void init(){
            for (int i1=0; i1<IsInfected.length; i1++)
        {
            for (int i2=0; i2<IsInfected[i1].length; i2++)
            {
               IsInfected[i1][i2]=false; //Все изначальные значения - false
            }
        }
    IsInfected[0][0]=true;//Задаём нулевого пациента. 
                }
    void emulate(int basetimer){
        int infectioncoefficient=0;
        java.util.Random rand=new java.util.Random();
        double infectchance = 0.2;
        double infecttotal = 0;
        double curechance = 0.4;
        for (int it=0; it<basetimer; it++)//Всё происходит в течение одной минуты
        {
            if (it%5<=0)//Срабатывание каждые 5 секунд
            {
               for (int i1=0; i1<IsInfected.length; i1++)
        {
            for (int i2=0; i2<IsInfected[i1].length; i2++)
            {
            //System.out.print("The cell's current infection state: ");
            //System.out.println(IsInfected[i1][i2]);
               if(IsInfected[i1][i2]=false); //Далее - проверка соседних ячеек и соответствующая аддитивная модификация вероятности заражения
               {
                   int left=i1-1;
                   int right=i1+1;
                   int up=i2-1;
                   int down=i2+1;
                   if(left>=0)//Проверка на наличие соседней ячейки
                   {
                       //System.out.println("There is a cell to the left of the current one.");
                   if(IsInfected[left][i2]=true)
                   {
                       //System.out.println("The adjacent cell is infected.");
                       infectioncoefficient++;
                   }
                   }
                   if(right<IsInfected.length)//Проверка на наличие соседней ячейки
                   {
                       //System.out.println("There is a cell to the right of the current one.");
                   if(IsInfected[right][i2]=true)
                   {
                       //System.out.println("The adjacent cell is infected.");
                       infectioncoefficient++;
                   }
                   }
                   if(up>=0)//Проверка на наличие соседней ячейки
                   {
                       //System.out.println("There is a cell to the top of the current one.");
                   if(IsInfected[i1][up]=true)
                   {
                       //System.out.println("The adjacent cell is infected.");
                       infectioncoefficient++;
                   }
                   }
                   if(down<IsInfected[i1].length)//Проверка на наличие соседней ячейки
                   {
                       //System.out.println("There is a cell to the bottom of the current one.");
                   if(IsInfected[i1][down]=true)
                   {
                       //System.out.println("The adjacent cell is infected.");
                       infectioncoefficient++;
                   }
                   }
                   infecttotal=infectchance*infectioncoefficient;
                   //System.out.print("Current infection chance: "); //Testing infection chance
                   //System.out.println(infecttotal); // Don't mind it
                   double r1 = rand.nextDouble();//Пресвятой рандом
                   //System.out.print("RNG infection result: "); //Testing infection chance
                   //System.out.println(r1); // Don't mind it
                   if (r1<infecttotal)
                   {
                       IsInfected[i1][i2]=true;//Заражаем ячейку
                   }
                   infectioncoefficient=0;
                   infecttotal=0;//Сбрасываем шанс перед следующей итерацией
                   }
               if (IsInfected[i1][i2]=true)
               {
                   double r2 = rand.nextDouble();
                   //System.out.print("RNG cure result: "); //Testing infection chance
                   //System.out.println(r2); // Don't mind it
                   if (r2<curechance)
                   {
                       IsInfected[i1][i2]=false;
                   }
               }
               //System.out.print(("Is cell #") + (i1+i2) + (" infected: ")); //This code is for testing purposes
               //System.out.println(IsInfected[i1][i2]); //So don't mind it
               }
            }
               //System.out.println("Iteration over.");
        } 
            try{
            Thread.sleep(1000);
            }
            catch (InterruptedException exc){
            exc.printStackTrace();
            }
        }
        stillruns=false;
        }
    } 
