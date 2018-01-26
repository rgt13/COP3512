import java.util.Scanner;

public class Reverse
{
    
    public static long reverseDigits(long s)
    {
        long result = 0;
        
        while(s != 0)
        {
            long div = 10;
            long lastDigit = s % div;
            result = (result*div) + lastDigit;
            s = s / div;
        }
        return result;
    }

  public static void main(String[] args)
  {
      Scanner input = new Scanner(System.in);
      long s = 1, result = 0;
      
      while(s != 0)
      {
          System.out.print("Please enter a long integer (0 to quit): ");
          s = input.nextLong();
        
          result = reverseDigits(s);
          
          if(result == 0)
          {
              System.out.println("\nGoodbye!");
              break;
          }
          
          System.out.println("\nThe number reversed is: " + result + "\n");
      }
  }
    
}
