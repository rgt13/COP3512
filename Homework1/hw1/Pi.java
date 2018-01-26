import java.util.Scanner;

public class Pi
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        int s = 0;
        
        System.out.println("Exercise 5.20: 'Approximating Pi'");
        System.out.print("Compute to how many terms of the series? ");
        
        s = input.nextInt();
        
        System.out.println("\nTerms\tPI Approximation");
        
        double num = 4, denom = 1, series = 0;
        
        for(int i = 1; i <= s; i++)
        {
            if(i%2 == 0)
            {
                series -= num/denom;
            }
            
            else
            {
                series += num/denom;
            }
            
            denom++;
            denom++;
        
            System.out.println(i + "\t" + series);
        }
    }
}