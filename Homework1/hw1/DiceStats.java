/* Name: Ryan Thomas
   Project: 1
   Purpose: Calculate the percentage of each number rolled based
            on how many dice rolled, and how many times all dice 
            are rolled (based on input from user)
 */

import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
import java.text.DecimalFormat;

public class DiceStats
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);                         //Input for number of dice and rolls
        
        int numDice = 0, numRolls = 0;                                  //Initialize Dice and Rolls variables
        DecimalFormat f = new DecimalFormat("0.00");                    //Output percentage to two decimals
        
        DecimalFormat d = new DecimalFormat("0");                       //Output roll and number of times to no
                                                                        //decimal places
        
    
        System.out.print("How many dice will constitute one roll? ");
     	numDice = input.nextInt();                                      //Number of dice initiliazed from input
        int max = 6*numDice;                                            //Max value from roll is always the number of dice multiplied by 6
    
    	System.out.print("How many rolls? ");
        numRolls = input.nextInt();                                     //Number of rolls initiliazed from input
        
        int x = 0;
        float[] numTimes = new float[max+1];                            //Result of roll is stored in array of floats
        
        
        
        //These for loops serve to randomly pick a number between the minimum number of die
        //and max value one could receive from the rolled die. When it chooses a number, the
        //"number of times" is incremented, and the value is reset to continue the pattern.
        for(float i = 1; i <= numRolls; i++)
        {
            x = 0;
            for(int k = 0; k < numDice; k++)
            {
                x += (int)(1 + Math.random() * 6);
            }
             ++numTimes[x];
        }
    
        System.out.println("\nSum\t# of times\tPercentage\n");
        
        for(int j = numDice; j <= max; j++)
        {
            float percentage = 100*numTimes[j]/numRolls;
            
            System.out.print(j + "\t" + d.format(numTimes[j]) + "\t\t");
            System.out.print(f.format(percentage));
            System.out.println(" %");
        }
    
        
        
        
    }
}
