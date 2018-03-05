import java.util.*;
import java.lang.*;

public abstract class Player
{
    public static boolean quit = false;
    public static Scanner input;
    public static int choice;
    public Player()
    {}
    
    abstract  char getMarkP1();
    abstract  char getMarkP2();
    abstract  char getMarkC1();
    abstract  char getMarkC2();
    
    abstract void runGame();
    abstract void runGameC1();
    abstract void runGameC2();
    abstract void fillSquareP1(int c, char [][] board);
    abstract void fillSquareP2(int c, char [][] board);
    abstract void fillSquareC(int c, char [][] board);
    abstract void fillSquareC2(int c, char [][] board);
}