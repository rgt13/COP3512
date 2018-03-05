import java.util.*;
import java.lang.*;

public class ComputerPlayer extends Player
{
    public char getMarkP1()
    {
        return ' ';
    }
    
    public char getMarkP2()
    {
      return ' ';
    }
    
    public char getMarkC1()
    {
        return 'X';
    }
    
    public char getMarkC2()
    {
        return 'O';
    }
    
    
    public void runGame()
    {
        
    }
    public void runGameC1()
    {
        
    }
    
    public void runGameC2()
    {
        
    }
    
    public void fillSquareC(int c, char [][] board)
    {
        if(c == 1)
        {
            board[0][0] =  getMarkC1();
        }
        
        if(c == 2)
        {
            board[0][1] =  getMarkC1();
        }
        
        if(c == 3)
        {
            board[0][2] =  getMarkC1();
        }
        
        if(c == 4)
        {
            board[1][0] =  getMarkC1();
        }
        
        if(c == 5)
        {
            board[1][1] =  getMarkC1();
        }
        
        if(c == 6)
        {
            board[1][2] =  getMarkC1();
        }
        
        if(c == 7)
        {
            board[2][0] =  getMarkC1();
        }
        
        if(c == 8)
        {
            board[2][1] =  getMarkC1();
        }
        
        if(c == 9)
        {
            board[2][2] =  getMarkC1();
        }

    }
    
    public void fillSquareP1(int c, char [][] board)
    {
        
    }
    
    
    public void fillSquareP2(int c, char [][] board)
    {
        
    }
    
    public void fillSquareC2(int c, char [][] board)
    {
        if(c == 1)
        {
            board[0][0] =  getMarkC2();
        }
        
        if(c == 2)
        {
            board[0][1] =  getMarkC2();
        }
        
        if(c == 3)
        {
            board[0][2] =  getMarkC2();
        }
        
        if(c == 4)
        {
            board[1][0] =  getMarkC2();
        }
        
        if(c == 5)
        {
            board[1][1] =  getMarkC2();
        }
        
        if(c == 6)
        {
            board[1][2] =  getMarkC2();
        }
        
        if(c == 7)
        {
            board[2][0] =  getMarkC2();
        }
        
        if(c == 8)
        {
            board[2][1] =  getMarkC2();
        }
        
        if(c == 9)
        {
            board[2][2] =  getMarkC2();
        }
        
    }

}
