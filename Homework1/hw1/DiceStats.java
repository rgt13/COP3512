import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
import java.text.DecimalFormat;

public class DiceStats
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        int numDice = 0, numRolls = 0;
        DecimalFormat f = new DecimalFormat("0.00");
        DecimalFormat d = new DecimalFormat("0");
    
        System.out.print("How many dice will constitute one roll? ");
     	numDice = input.nextInt();
        int max = 6*numDice;
    
    	System.out.print("How many rolls? ");
        numRolls = input.nextInt();
        
        int x = 0;
        float[] numTimes = new float[max+1];
    
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
