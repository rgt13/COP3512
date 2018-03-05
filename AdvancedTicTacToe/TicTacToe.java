import java.util.*;
import java.lang.*;

/*==================================================================================================================================*/
public class TicTacToe
{
    private static char [][] GameBoard;
    private static final int dimension = 3, options = 9;
    public static boolean winp1, winp2, winC, winC2, draw;
    public static int choice, choice2, choiceC1, choiceC2;
    public static int min, max;
    public static TicTacToe t = new TicTacToe();
    public static Player p = new HumanPlayer();
    public static Player c = new ComputerPlayer();
    public static Random r = new Random();
    public static Scanner in;
    public static int [] availableChoices;
    
/*==================================================================================================================================*/
    public TicTacToe()
    {
        GameBoard = new char[dimension][dimension];
        availableChoices = new int[9];
        for(int i = 0; i < options; i++)
        {
            availableChoices[i] = i+1;
        }
        in = new Scanner(System.in);
        min = 1;
        max = 9;
        winp1 = false;
        winp2 = false;
        winC = false;
        draw = false;
        for(int i = 0; i < dimension; i++)
        {
            for(int j = 0; j < dimension; j++)
            {
                GameBoard[i][j] = ' ';
            }
        }
    }
/*==================================================================================================================================*/
    public static void startGame()
    {
        drawBoard();
    }
/*==================================================================================================================================*/
    public static void drawBoard()
    {
        System.out.println("Game Board: \t\t Positions: \n");
        System.out.print(" " + GameBoard[0][0] + " | " + GameBoard[0][1] + " | " + GameBoard[0][2]);
        System.out.println("\t\t 1 | 2 | 3");
        System.out.println("-----------\t\t-----------");
        System.out.print(" " + GameBoard[1][0] + " | " + GameBoard[1][1] + " | " + GameBoard[1][2]);
        System.out.println("\t\t 4 | 5 | 6");
        System.out.println("-----------\t\t-----------");
        System.out.print(" " + GameBoard[2][0] + " | " + GameBoard[2][1] + " | " + GameBoard[2][2]);
        System.out.println("\t\t 7 | 8 | 9");
        System.out.println("\n");
    }
/*==================================================================================================================================*/
    public static void runGameC1(Player x, Player y)
    {
        do
        {
            winningMoveC1();
            
            while(!contains(availableChoices, choiceC1))
            {
                System.out.print("");
                checkBlockC1();
            }
            System.out.println("Player 1 (Computer) chooses position " + choiceC1 + "\n\n");
            x.fillSquareC(choiceC1, GameBoard);
            drawBoard();
            checkWinC();
            if(winC == true)
            {
                break;
            }
            checkDraw();
            if(draw == true)
            {
                break;
            }
            availableChoices = remove(availableChoices, choiceC1 - 1);
            
            System.out.print("Player 2, please enter a move (1-9): ");
            try
            {
                choice2 = in.nextInt();
            }
            catch(Exception e)
            {
                System.out.println("THAT AINT A NUMBER");
                System.exit(0);
            }
            
            System.out.println("\n");
            while(choice2 > 9 || choice2 < 1)
            {
                System.out.println("STOP! That's an illegal move! Please enter a move (1-9): ");
                choice2 = in.nextInt();
            }
            
            while(!contains(availableChoices, choice2))
            {
                System.out.print("That position has already been used. Please choose another: ");
                choice2 = in.nextInt();
            }
            y.fillSquareP2(choice2, GameBoard);
            drawBoard();
            checkWin();
            if(winp2 == true)
            {
                break;
            }
            checkDraw();
            if(draw == true)
            {
                break;
            }
            availableChoices = remove(availableChoices, choice2 - 1);
            
        }while(winC == false && winp2 == false && draw == false);
    }
/*==================================================================================================================================*/
    public static void runGameC2(Player x, Player y)
    {
        do
        {
            System.out.print("Player 1, please enter a move (1-9): ");
            try
            {
                choice = in.nextInt();
            }
            catch(Exception e)
            {
                System.out.println("THAT AINT A NUMBER");
                System.exit(0);
            }
            System.out.println("");
            
            while(choice > 9 || choice < 1)
            {
                System.out.println("STOP! That's an illegal move! Please enter a move (1-9): ");
                choice = in.nextInt();
            }
            
            while(!contains(availableChoices, choice))
            {
                System.out.print("That position has already been used. Please choose another: ");
                choice = in.nextInt();
            }
            System.out.println("Player 1 chooses position " + choice + "\n\n");
            y.fillSquareP1(choice, GameBoard);
            drawBoard();
            checkWin();
            if(winp1 == true)
            {
                break;
            }
            checkDraw();
            if(draw == true)
            {
                break;
            }
            availableChoices = remove(availableChoices, choice - 1);
            
            winningMoveC2();
            while(!contains(availableChoices, choiceC2))
            {
                System.out.print("");
                checkBlockC2();
            }
            System.out.println("Player 2 (Computer) chooses position " + choiceC2 + "\n\n");
            x.fillSquareC2(choiceC2, GameBoard);
            drawBoard();
            checkWinC();
            if(winC2 == true)
            {
                break;
            }
            checkDraw();
            if(draw == true)
            {
                break;
            }
            availableChoices = remove(availableChoices, choiceC2 - 1);
            
        }while(winp1 == false && winC2 == false && draw == false);
    }
/*==================================================================================================================================*/
    public static void runGameCC(Player x)
    {
        do
        {
            winningMoveC1();
            
            while(!contains(availableChoices, choiceC1))
            {
                System.out.print("");
                checkBlockC1();
            }
            System.out.println("Player 1 (Computer) chooses position " + choiceC1 + "\n\n");
            x.fillSquareC(choiceC1, GameBoard);
            drawBoard();
            checkWinC();
            if(winC == true)
            {
                break;
            }
            checkDraw();
            if(draw == true)
            {
                break;
            }
            availableChoices = remove(availableChoices, choiceC1 - 1);
            
            
            winningMoveC2();
            while(!contains(availableChoices, choiceC2))
            {
                System.out.print("");
                checkBlockC2();
            }
            System.out.println("Player 2 (Computer) chooses position " + choiceC2 + "\n\n");
            x.fillSquareC2(choiceC2, GameBoard);
            drawBoard();
            checkWinC();
            if(winC2 == true)
            {
                break;
            }
            checkDraw();
            if(draw == true)
            {
                break;
            }
            availableChoices = remove(availableChoices, choiceC2 - 1);
            
        }while(winC == false && winC2 == false && draw == false);
    }
/*==================================================================================================================================*/
    public static void runGameP(Player x)
    {
        do
        {
            System.out.print("Player 1, please enter a move (1-9): ");
            try
            {
                choice = in.nextInt();
            }
            catch(Exception e)
            {
                System.out.println("THAT AINT A NUMBER");
                System.exit(0);
            }
            
            while(choice > 9 || choice < 1)
            {
                System.out.println("STOP! That's an illegal move! Please enter a move (1-9): ");
                choice = in.nextInt();
            }
            
            while(!contains(availableChoices, choice))
            {
                System.out.print("That position has already been used. Please choose another: ");
                choice = in.nextInt();
            }
            System.out.println("Player 1 chooses position " + choice + "\n\n");
            x.fillSquareP1(choice, GameBoard);
            drawBoard();
            checkWin();
            if(winp1 == true)
            {
                break;
            }
            checkDraw();
            if(draw == true)
            {
                break;
            }
            
            
            availableChoices = remove(availableChoices, choice - 1);
            
            System.out.print("Player 2, please enter a move (1-9): ");
            try
            {
                choice2 = in.nextInt();
            }
            catch(Exception e)
            {
                System.out.println("THAT AINT A NUMBER");
                System.exit(0);
            }
            
            while(choice2 > 9 || choice2 < 1)
            {
                System.out.println("STOP! That's an illegal move! Please enter a move (1-9): ");
                choice2 = in.nextInt();
            }
            
            while(!contains(availableChoices, choice2))
            {
                System.out.print("That position has already been used. Please choose another: ");
                choice2 = in.nextInt();
            }
            System.out.println("Player 2 chooses position " + choice2 + "\n\n");
            x.fillSquareP2(choice2, GameBoard);
            drawBoard();
            checkWin();
            if(winp2 == true)
            {
                break;
            }
            checkDraw();
            if(draw == true)
            {
                break;
            }
            availableChoices = remove(availableChoices, choice2 - 1);
            
        }while(winp1 == false && winC2 == false && draw == false);
    }
/*==================================================================================================================================*/
    public static boolean contains(int [] array, int number)
    {
        for (int i : array)
        {
            if (number == i)
            {
                return true;
            }
        }
        return false;
    }
/*==================================================================================================================================*/
    public static int[] remove(int[] array, int number)
    {
        array[number] = 0;
        return array;
        
    }
/*==================================================================================================================================*/
    public static void winningMoveC1()
    {
        if(((GameBoard[0][1] == c.getMarkC1() && GameBoard[0][2] == c.getMarkC1()) ||
           (GameBoard[1][0] == c.getMarkC1() && GameBoard[2][0] == c.getMarkC1()) ||
           (GameBoard[2][2] == c.getMarkC1() && GameBoard[1][1] == c.getMarkC1())) && GameBoard[0][0] == ' ')
        {
            choiceC1 = 1;
        }
        
        else if(((GameBoard[0][0] == c.getMarkC1() && GameBoard[0][2] == c.getMarkC1()) ||
                (GameBoard[1][1] == c.getMarkC1() && GameBoard[2][1] == c.getMarkC1())) && GameBoard[0][1] == ' ')
        {
            choiceC1 = 2;
        }
        
        else if(((GameBoard[0][0] == c.getMarkC1() && GameBoard[0][1] == c.getMarkC1()) ||
                (GameBoard[1][2] == c.getMarkC1() && GameBoard[2][2] == c.getMarkC1()) ||
                (GameBoard[2][0] == c.getMarkC1() && GameBoard[1][1] == c.getMarkC1())) && GameBoard[0][2] == ' ')
        {
            choiceC1 = 3;
        }
        
        else if(((GameBoard[1][1] == c.getMarkC1() && GameBoard[1][2] == c.getMarkC1()) ||
                (GameBoard[0][0] == c.getMarkC1() && GameBoard[2][0] == c.getMarkC1())) && GameBoard[1][0] == ' ')
        {
            choiceC1 = 4;
        }
        
        else if(((GameBoard[1][1] == ' ') ||
                (GameBoard[1][0] == c.getMarkC1() && GameBoard[1][2] == c.getMarkC1()) ||
                (GameBoard[0][1] == c.getMarkC1() && GameBoard[2][1] == c.getMarkC1()) ||
                (GameBoard[0][0] == c.getMarkC1() && GameBoard[2][2] == c.getMarkC1()) ||
                (GameBoard[0][2] == c.getMarkC1() && GameBoard[2][0] == c.getMarkC1())) && GameBoard[1][1] == ' ')
        {
            choiceC1 = 5;
        }
        
        else if(((GameBoard[1][0] == c.getMarkC1() && GameBoard[1][1] == c.getMarkC1()) ||
                (GameBoard[0][2] == c.getMarkC1() && GameBoard[2][2] == c.getMarkC1())) && GameBoard[1][2] == ' ')
        {
            choiceC1 = 6;
        }
        
        else if(((GameBoard[2][1] == c.getMarkC1() && GameBoard[2][2] == c.getMarkC1()) ||
                (GameBoard[0][0] == c.getMarkC1() && GameBoard[1][0] == c.getMarkC1()) ||
                (GameBoard[0][2] == c.getMarkC1() && GameBoard[1][1] == c.getMarkC1())) && GameBoard[2][0] == ' ')
        {
            choiceC1 = 7;
        }
        
        else if(((GameBoard[2][0] == c.getMarkC1() && GameBoard[2][2] == c.getMarkC1()) ||
                (GameBoard[0][1] == c.getMarkC1() && GameBoard[1][1] == c.getMarkC1())) && GameBoard[2][1] == ' ')
        {
            choiceC1 = 8;
        }
        
        else if(((GameBoard[2][0] == c.getMarkC1() && GameBoard[2][1] == c.getMarkC1()) ||
                (GameBoard[0][2] == c.getMarkC1() && GameBoard[1][2] == c.getMarkC1()) ||
                (GameBoard[0][0] == c.getMarkC1() && GameBoard[1][1] == c.getMarkC1())) && GameBoard[2][2] == ' ')
        {
            choiceC1 = 9;
        }
        
        else
        {
            checkBlockC1();
        }
    }
/*==================================================================================================================================*/
    public static void winningMoveC2()
    {
        if(((GameBoard[0][1] == c.getMarkC2() && GameBoard[0][2] == c.getMarkC2()) ||
                (GameBoard[1][0] == c.getMarkC2() && GameBoard[2][0] == c.getMarkC2()) ||
                (GameBoard[2][2] == c.getMarkC2() && GameBoard[1][1] == c.getMarkC2())) && GameBoard[0][0] == ' ')
        {
            choiceC2 = 1;
        }
        
        else if(((GameBoard[0][0] == c.getMarkC2() && GameBoard[0][2] == c.getMarkC2()) ||
                (GameBoard[1][1] == c.getMarkC2() && GameBoard[2][1] == c.getMarkC2())) && GameBoard[0][1] == ' ')
        {
            choiceC2 = 2;
        }
        
        else if(((GameBoard[0][0] == c.getMarkC2() && GameBoard[0][1] == c.getMarkC2()) ||
                (GameBoard[1][2] == c.getMarkC2() && GameBoard[2][2] == c.getMarkC2()) ||
                (GameBoard[2][0] == c.getMarkC2() && GameBoard[1][1] == c.getMarkC2())) && GameBoard[0][2] == ' ')
        {
            choiceC2 = 3;
        }
        
        else if(((GameBoard[1][1] == c.getMarkC2() && GameBoard[1][2] == c.getMarkC2()) ||
                (GameBoard[0][0] == c.getMarkC2() && GameBoard[2][0] == c.getMarkC2())) && GameBoard[1][0] == ' ')
        {
            choiceC2 = 4;
        }
        
        else if(((GameBoard[1][1] == ' ') ||
                (GameBoard[1][0] == c.getMarkC2() && GameBoard[1][2] == c.getMarkC2()) ||
                (GameBoard[0][1] == c.getMarkC2() && GameBoard[2][1] == c.getMarkC2()) ||
                (GameBoard[0][0] == c.getMarkC2() && GameBoard[2][2] == c.getMarkC2()) ||
                (GameBoard[0][2] == c.getMarkC2() && GameBoard[2][0] == c.getMarkC2())) && GameBoard[1][1] == ' ')
        {
            choiceC2 = 5;
        }
        
        else if(((GameBoard[1][0] == c.getMarkC2() && GameBoard[1][1] == c.getMarkC2()) ||
                (GameBoard[0][2] == c.getMarkC2() && GameBoard[2][2] == c.getMarkC2())) && GameBoard[1][2] == ' ')
        {
            choiceC2 = 6;
        }
        
        else if(((GameBoard[2][1] == c.getMarkC2() && GameBoard[2][2] == c.getMarkC2()) ||
                (GameBoard[0][0] == c.getMarkC2() && GameBoard[1][0] == c.getMarkC2()) ||
                (GameBoard[0][2] == c.getMarkC2() && GameBoard[1][1] == c.getMarkC2())) && GameBoard[2][0] == ' ')
        {
            choiceC2 = 7;
        }
        
        else if(((GameBoard[2][0] == c.getMarkC2() && GameBoard[2][2] == c.getMarkC2()) ||
                (GameBoard[0][1] == c.getMarkC2() && GameBoard[1][1] == c.getMarkC2())) && GameBoard[2][1] == ' ')
        {
            choiceC2 = 8;
        }
    
        else if(((GameBoard[2][0] == c.getMarkC2() && GameBoard[2][1] == c.getMarkC2()) ||
                (GameBoard[0][2] == c.getMarkC2() && GameBoard[1][2] == c.getMarkC2()) ||
                (GameBoard[0][0] == c.getMarkC2() && GameBoard[1][1] == c.getMarkC2())) && GameBoard[2][2] == ' ')
        {
            choiceC2 = 9;
        }
        
        else
        {
            checkBlockC2();
        }
    }
/*==================================================================================================================================*/
    public static void checkWin()
    {
        if((GameBoard[0][0] == p.getMarkP2() && GameBoard[0][1] == p.getMarkP2() && GameBoard[0][2] == p.getMarkP2()) ||
           (GameBoard[1][0] == p.getMarkP2() && GameBoard[1][1] == p.getMarkP2() && GameBoard[1][2] == p.getMarkP2()) ||
           (GameBoard[2][0] == p.getMarkP2() && GameBoard[2][1] == p.getMarkP2() && GameBoard[2][2] == p.getMarkP2()))
        {
            winp2 = true;
        }
        
        if((GameBoard[0][0] == p.getMarkP2() && GameBoard[1][0] == p.getMarkP2() && GameBoard[2][0] == p.getMarkP2()) ||
                (GameBoard[0][1] == p.getMarkP2() && GameBoard[1][1] == p.getMarkP2() && GameBoard[2][1] == p.getMarkP2()) ||
                (GameBoard[0][2] == p.getMarkP2() && GameBoard[1][2] == p.getMarkP2() && GameBoard[2][2] == p.getMarkP2()))
        {
            winp2 = true;
        }
        
        if((GameBoard[0][0] == p.getMarkP2() && GameBoard[1][1] == p.getMarkP2() && GameBoard[2][2] == p.getMarkP2()) ||
                (GameBoard[0][2] == p.getMarkP2() && GameBoard[1][1] == p.getMarkP2() && GameBoard[2][0] == p.getMarkP2()))
        {
            winp2 = true;
        }
        
        if((GameBoard[0][0] == p.getMarkP1() && GameBoard[0][1] == p.getMarkP1() && GameBoard[0][2] == p.getMarkP1()) ||
                (GameBoard[1][0] == p.getMarkP1() && GameBoard[1][1] == p.getMarkP1() && GameBoard[1][2] == p.getMarkP1()) ||
                (GameBoard[2][0] == p.getMarkP1() && GameBoard[2][1] == p.getMarkP1() && GameBoard[2][2] == p.getMarkP1()))
        {
            winp1 = true;
        }
        
        if((GameBoard[0][0] == p.getMarkP1() && GameBoard[1][0] == p.getMarkP1() && GameBoard[2][0] == p.getMarkP1()) ||
                (GameBoard[0][1] == p.getMarkP1() && GameBoard[1][1] == p.getMarkP1() && GameBoard[2][1] == p.getMarkP1()) ||
                (GameBoard[0][2] == p.getMarkP1() && GameBoard[1][2] == p.getMarkP1() && GameBoard[2][2] == p.getMarkP1()))
        {
            winp1 = true;
        }
        
        if((GameBoard[0][0] == p.getMarkP1() && GameBoard[1][1] == p.getMarkP1() && GameBoard[2][2] == p.getMarkP1()) ||
                (GameBoard[0][2] == p.getMarkP1() && GameBoard[1][1] == p.getMarkP1() && GameBoard[2][0] == p.getMarkP1()))
        {
            winp1 = true;
        }
    }
/*==================================================================================================================================*/
    public static void checkWinC()
    {
        /*============================================================================================================================*/
        
        if((GameBoard[0][0] == c.getMarkC2() && GameBoard[0][1] == c.getMarkC2() && GameBoard[0][2] == c.getMarkC2()) ||
           (GameBoard[1][0] == c.getMarkC2() && GameBoard[1][1] == c.getMarkC2() && GameBoard[1][2] == c.getMarkC2()) ||
           (GameBoard[2][0] == c.getMarkC2() && GameBoard[2][1] == c.getMarkC2() && GameBoard[2][2] == c.getMarkC2()))
        {
            winC2 = true;
        }
        
        if((GameBoard[0][0] == c.getMarkC2() && GameBoard[1][0] == c.getMarkC2() && GameBoard[2][0] == c.getMarkC2()) ||
           (GameBoard[0][1] == c.getMarkC2() && GameBoard[1][1] == c.getMarkC2() && GameBoard[2][1] == c.getMarkC2()) ||
           (GameBoard[0][2] == c.getMarkC2() && GameBoard[1][2] == c.getMarkC2() && GameBoard[2][2] == c.getMarkC2()))
        {
            winC2 = true;
        }
        
        if((GameBoard[0][0] == c.getMarkC2() && GameBoard[1][1] == c.getMarkC2() && GameBoard[2][2] == c.getMarkC2()) ||
           (GameBoard[0][2] == c.getMarkC2() && GameBoard[1][1] == c.getMarkC2() && GameBoard[2][0] == c.getMarkC2()))
        {
            winC2 = true;
        }
        
        if((GameBoard[0][0] == c.getMarkC1() && GameBoard[0][1] == c.getMarkC1() && GameBoard[0][2] == c.getMarkC1()) ||
           (GameBoard[1][0] == c.getMarkC1() && GameBoard[1][1] == c.getMarkC1() && GameBoard[1][2] == c.getMarkC1()) ||
           (GameBoard[2][0] == c.getMarkC1() && GameBoard[2][1] == c.getMarkC1() && GameBoard[2][2] == c.getMarkC1()))
        {
            winC = true;
        }
        
        if((GameBoard[0][0] == c.getMarkC1() && GameBoard[1][0] == c.getMarkC1() && GameBoard[2][0] == c.getMarkC1()) ||
           (GameBoard[0][1] == c.getMarkC1() && GameBoard[1][1] == c.getMarkC1() && GameBoard[2][1] == c.getMarkC1()) ||
           (GameBoard[0][2] == c.getMarkC1() && GameBoard[1][2] == c.getMarkC1() && GameBoard[2][2] == c.getMarkC1()))
        {
            winC = true;
        }
        
        if((GameBoard[0][0] == c.getMarkC1() && GameBoard[1][1] == c.getMarkC1() && GameBoard[2][2] == c.getMarkC1()) ||
           (GameBoard[0][2] == c.getMarkC1() && GameBoard[1][1] == c.getMarkC1() && GameBoard[2][0] == c.getMarkC1()))
        {
            winC = true;
        }
    }
/*==================================================================================================================================*/
    public static void checkDraw()
    {
        if((GameBoard[0][0]==p.getMarkP1()||(GameBoard[0][0]==p.getMarkP2()||(GameBoard[0][0]==c.getMarkC1()||(GameBoard[0][0]==c.getMarkC2())))) &&
           (GameBoard[0][1]==p.getMarkP1()||(GameBoard[0][1]==p.getMarkP2()||(GameBoard[0][1]==c.getMarkC1()||(GameBoard[0][1]==c.getMarkC2())))) &&
           (GameBoard[0][2]==p.getMarkP1()||(GameBoard[0][2]==p.getMarkP2()||(GameBoard[0][2]==c.getMarkC1()||(GameBoard[0][2]==c.getMarkC2())))) &&
           (GameBoard[1][0]==p.getMarkP1()||(GameBoard[1][0]==p.getMarkP2()||(GameBoard[1][0]==c.getMarkC1()||(GameBoard[1][0]==c.getMarkC2())))) &&
           (GameBoard[1][1]==p.getMarkP1()||(GameBoard[1][1]==p.getMarkP2()||(GameBoard[1][1]==c.getMarkC1()||(GameBoard[1][1]==c.getMarkC2())))) &&
           (GameBoard[1][2]==p.getMarkP1()||(GameBoard[1][2]==p.getMarkP2()||(GameBoard[1][2]==c.getMarkC1()||(GameBoard[1][2]==c.getMarkC2())))) &&
           (GameBoard[2][0]==p.getMarkP1()||(GameBoard[2][0]==p.getMarkP2()||(GameBoard[2][0]==c.getMarkC1()||(GameBoard[2][0]==c.getMarkC2())))) &&
           (GameBoard[2][1]==p.getMarkP1()||(GameBoard[2][1]==p.getMarkP2()||(GameBoard[2][1]==c.getMarkC1()||(GameBoard[2][1]==c.getMarkC2())))) &&
           (GameBoard[2][2]==p.getMarkP1()||(GameBoard[2][2]==p.getMarkP2()||(GameBoard[2][2]==c.getMarkC1()||(GameBoard[2][2]==c.getMarkC2())))))
        {
            draw = true;
        }
    }
/*==================================================================================================================================*/
    public static void checkBlockC1()
    {

        if(((GameBoard[0][1] == p.getMarkP2() && GameBoard[0][2] == p.getMarkP2()) && GameBoard[0][0] == ' ') ||
           ((GameBoard[1][0] == p.getMarkP2() && GameBoard[2][0] == p.getMarkP2()) && GameBoard[0][0] == ' ') ||
           ((GameBoard[1][1] == p.getMarkP2() && GameBoard[2][2] == p.getMarkP2()) && GameBoard[0][0] == ' '))
        {
            choiceC1 = 1;
             
        }
        
        else if(((GameBoard[0][0] == p.getMarkP2() && GameBoard[0][2] == p.getMarkP2()) && GameBoard[0][1] == ' ')||
                ((GameBoard[1][1] == p.getMarkP2() && GameBoard[2][1] == p.getMarkP2()) && GameBoard[0][1] == ' '))
        {
            choiceC1 = 2;
             
        }
        
        else if(((GameBoard[0][0] == p.getMarkP2() && GameBoard[0][1] == p.getMarkP2()) && GameBoard[0][2] == ' ') ||
                ((GameBoard[1][2] == p.getMarkP2() && GameBoard[2][2] == p.getMarkP2()) && GameBoard[0][2] == ' ') ||
                ((GameBoard[2][0] == p.getMarkP2() && GameBoard[1][1] == p.getMarkP2()) && GameBoard[0][2] == ' '))
        {
            choiceC1 = 3;
             
        }
        
        else if(((GameBoard[1][1] == p.getMarkP2() && GameBoard[1][2] == p.getMarkP2()) && GameBoard[1][0] == ' ') ||
                ((GameBoard[0][0] == p.getMarkP2() && GameBoard[2][0] == p.getMarkP2()) && GameBoard[1][0] == ' '))
        {
            choiceC1 = 4;
             
        }
        
        else if(((GameBoard[1][0] == p.getMarkP2() && GameBoard[1][2] == p.getMarkP2()) && GameBoard[1][1] == ' ') ||
                ((GameBoard[0][1] == p.getMarkP2() && GameBoard[2][1] == p.getMarkP2()) && GameBoard[1][1] == ' ') ||
                ((GameBoard[0][0] == p.getMarkP2() && GameBoard[2][2] == p.getMarkP2()) && GameBoard[1][1] == ' '))
        {
            choiceC1 = 5;
             
        }
        
        else if(((GameBoard[1][0] == p.getMarkP2() && GameBoard[1][1] == p.getMarkP2()) && GameBoard[1][2] == ' ') ||
                ((GameBoard[0][2] == p.getMarkP2() && GameBoard[2][2] == p.getMarkP2()) && GameBoard[1][2] == ' '))
        {
            choiceC1 = 6;
             
        }
        
        else if(((GameBoard[2][1] == p.getMarkP2() && GameBoard[2][2] == p.getMarkP2()) && GameBoard[2][0] == ' ') ||
                ((GameBoard[0][0] == p.getMarkP2() && GameBoard[1][0] == p.getMarkP2()) && GameBoard[2][0] == ' ') ||
                ((GameBoard[0][2] == p.getMarkP2() && GameBoard[1][1] == p.getMarkP2()) && GameBoard[2][0] == ' '))
        {
            choiceC1 = 7;
             
        }
        
        else if(((GameBoard[2][0] == p.getMarkP2() && GameBoard[2][2] == p.getMarkP2()) && GameBoard[2][1] == ' ') ||
                ((GameBoard[0][1] == p.getMarkP2() && GameBoard[1][1] == p.getMarkP2()) && GameBoard[2][1] == ' '))
        {
            choiceC1 = 8;
             
        }
        
        else if(((GameBoard[2][0] == p.getMarkP2() && GameBoard[2][1] == p.getMarkP2()) && GameBoard[2][2] == ' ') ||
                ((GameBoard[0][2] == p.getMarkP2() && GameBoard[1][2] == p.getMarkP2()) && GameBoard[2][2] == ' ') ||
                ((GameBoard[0][0] == p.getMarkP2() && GameBoard[1][1] == p.getMarkP2()) && GameBoard[2][2] == ' '))
        {
            choiceC1 = 9;
             
        }
        
        else
        {
            choiceC1 = r.nextInt(max-min+1) + min;
        }
    }
/*==================================================================================================================================*/
    public static void checkBlockC2()
    {
        if(((GameBoard[0][1] == p.getMarkP1() && GameBoard[0][2] == p.getMarkP1()) && GameBoard[0][0] == ' ') ||
           ((GameBoard[1][0] == p.getMarkP1() && GameBoard[2][0] == p.getMarkP1()) && GameBoard[0][0] == ' ') ||
           ((GameBoard[1][1] == p.getMarkP1() && GameBoard[2][2] == p.getMarkP1()) && GameBoard[0][0] == ' '))
        {
            choiceC2 = 1;
              
        }
        
        else if(((GameBoard[0][0] == p.getMarkP1() && GameBoard[0][2] == p.getMarkP1()) && GameBoard[0][1] == ' ')||
                ((GameBoard[1][1] == p.getMarkP1() && GameBoard[2][1] == p.getMarkP1()) && GameBoard[0][1] == ' '))
        {
            choiceC2 = 2;
              
        }
        
        else if(((GameBoard[0][0] == p.getMarkP1() && GameBoard[0][1] == p.getMarkP1()) && GameBoard[0][2] == ' ') ||
                ((GameBoard[1][2] == p.getMarkP1() && GameBoard[2][2] == p.getMarkP1()) && GameBoard[0][2] == ' ') ||
                ((GameBoard[2][0] == p.getMarkP1() && GameBoard[1][1] == p.getMarkP1()) && GameBoard[0][2] == ' '))
        {
            choiceC2 = 3;
              
        }
        
        else if(((GameBoard[1][1] == p.getMarkP1() && GameBoard[1][2] == p.getMarkP1()) && GameBoard[1][0] == ' ') ||
                ((GameBoard[0][0] == p.getMarkP1() && GameBoard[2][0] == p.getMarkP1()) && GameBoard[1][0] == ' '))
        {
            choiceC2 = 4;
              
        }
        
        else if(((GameBoard[1][0] == p.getMarkP1() && GameBoard[1][2] == p.getMarkP1()) && GameBoard[1][1] == ' ') ||
                ((GameBoard[0][1] == p.getMarkP1() && GameBoard[2][1] == p.getMarkP1()) && GameBoard[1][1] == ' ') ||
                ((GameBoard[0][0] == p.getMarkP1() && GameBoard[2][2] == p.getMarkP1()) && GameBoard[1][1] == ' '))
        {
            choiceC2 = 5;
              
        }
        
        else if(((GameBoard[1][0] == p.getMarkP1() && GameBoard[1][1] == p.getMarkP1()) && GameBoard[1][2] == ' ') ||
                ((GameBoard[0][2] == p.getMarkP1() && GameBoard[2][2] == p.getMarkP1()) && GameBoard[1][2] == ' '))
        {
            choiceC2 = 6;
              
        }
        
        else if(((GameBoard[2][1] == p.getMarkP1() && GameBoard[2][2] == p.getMarkP1()) && GameBoard[2][0] == ' ') ||
                ((GameBoard[0][0] == p.getMarkP1() && GameBoard[1][0] == p.getMarkP1()) && GameBoard[2][0] == ' ') ||
                ((GameBoard[0][2] == p.getMarkP1() && GameBoard[1][1] == p.getMarkP1()) && GameBoard[2][0] == ' '))
        {
            choiceC2 = 7;
        }
        
        else if(((GameBoard[2][0] == p.getMarkP1() && GameBoard[2][2] == p.getMarkP1()) && GameBoard[2][1] == ' ') ||
                ((GameBoard[0][1] == p.getMarkP1() && GameBoard[1][1] == p.getMarkP1()) && GameBoard[2][1] == ' '))
        {
            choiceC2 = 8;
              
        }
        
        else if(((GameBoard[2][0] == p.getMarkP1() && GameBoard[2][1] == p.getMarkP1()) && GameBoard[2][2] == ' ') ||
                ((GameBoard[0][2] == p.getMarkP1() && GameBoard[1][2] == p.getMarkP1()) && GameBoard[2][2] == ' ') ||
                ((GameBoard[0][0] == p.getMarkP1() && GameBoard[1][1] == p.getMarkP1()) && GameBoard[2][2] == ' '))
        {
            choiceC2 = 9;
              
        }
        
        else
        {
            choiceC2 = r.nextInt(max-min+1) + min;
        }
    }
/*==================================================================================================================================*/
    public static void main(String [] args)
    {
        try
        {
            if(args.length == 0)
            {
                t.startGame();
                runGameP(p);
            }
            else if("-c".equals(args[0]))
            {
                if(args.length == 1)
                {
                    t.startGame();
                    runGameCC(c);
                }
                else if("1".equals(args[1]))
                {
                    System.out.println("\n\n" + args[0] + " & " + args[1] + " are now initialized, my dude.");
                    t.startGame();
                    runGameC1(c, p);
                }
                else if("2".equals(args[1]))
                {
                    System.out.println("\n\n" + args[0] + " & " + args[1] + " are now initialized, my dude.");
                    t.startGame();
                    runGameC2(c, p);
                }
                
                else if(args.length == 3 && ("1".equals(args[1]) && "-a".equals(args[2])))
                {
                    System.out.println("\n\n" + args[0] + " & " + args[1] + " are now initialized, my dude.");
                    t.startGame();
                    runGameC1(c, p);
                }
                
                else if(args.length == 3 && ("2".equals(args[1]) && "-a".equals(args[2])))
                {
                    System.out.println("\n\n" + args[0] + " & " + args[1] + " are now initialized, my dude.");
                    t.startGame();
                    runGameC2(c, p);
                }
            }
            
            else
            {
                System.out.println("Usage: java TicTacToe [-c [1|2]] [-a]");
            }

        }
        
        catch(NullPointerException n)
        {
            n.printStackTrace();
            
            System.out.println("Lol what're you doing man");
        }
        
        catch(ArrayIndexOutOfBoundsException a)
        {
            System.out.println("Usage: java TicTacToe [-c [1|2]]");
        }
        
        
        
        if(winp1 == true)
        {
            System.out.println("Congratulations, Player 1! You've won the game!");
        }
        
        else if(winp2 == true)
        {
            System.out.println("Congratulations, Player 2! You've won the game!");
        }
        
        else if(winC == true || winC2 == true)
        {
            System.out.println("The computer has won. Better luck next time!");
        }
    
        else if(draw == true)
        {
            System.out.println("It's a draw!\n");
        }

        
    }
}
