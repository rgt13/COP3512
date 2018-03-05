import java.util.*;
import java.lang.*;

public class HumanPlayer extends Player
{
    public char getMarkP1()
    {
        return 'X';
    }
    
    public char getMarkP2()
    {
        return 'O';
    }
    
    public char getMarkC1()
    {
        return ' ';
    }
    
    public char getMarkC2()
    {
        return ' ';
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
        
    }
    
    public void fillSquareC2(int c, char [][] board)
    {
        
    }
    
    public void fillSquareP1(int c, char [][] board)
    {
        if(c == 1)
        {
            board[0][0] =  getMarkP1();
        }
        
        if(c == 2)
        {
            board[0][1] =  getMarkP1();
        }
        
        if(c == 3)
        {
            board[0][2] =  getMarkP1();
        }
        
        if(c == 4)
        {
            board[1][0] =  getMarkP1();
        }
        
        if(c == 5)
        {
            board[1][1] =  getMarkP1();
        }
        
        if(c == 6)
        {
            board[1][2] =  getMarkP1();
        }
        
        if(c == 7)
        {
            board[2][0] =  getMarkP1();
        }
        
        if(c == 8)
        {
            board[2][1] =  getMarkP1();
        }
        
        if(c == 9)
        {
            board[2][2] =  getMarkP1();
        }
    }
    
    
    public void fillSquareP2(int c, char [][] board)
    {
        if(c == 1)
        {
            board[0][0] =  getMarkP2();
        }
        
        if(c == 2)
        {
            board[0][1] =  getMarkP2();
        }
        
        if(c == 3)
        {
            board[0][2] =  getMarkP2();
        }
        
        if(c == 4)
        {
            board[1][0] =  getMarkP2();
        }
        
        if(c == 5)
        {
            board[1][1] =  getMarkP2();
        }
        
        if(c == 6)
        {
            board[1][2] =  getMarkP2();
        }
        
        if(c == 7)
        {
            board[2][0] =  getMarkP2();
        }
        
        if(c == 8)
        {
            board[2][1] =  getMarkP2();
        }
        
        if(c == 9)
        {
            board[2][2] =  getMarkP2();
        }
    }
}