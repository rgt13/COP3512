import java.util.Scanner;
import java.io.FileWriter;
import java.util.Formatter;
import java.io.FileReader;
import java.io.*;

public class WebToPigLatin
{
    Scanner in;
    Writer out;
    int index;
/*=========================================================================================*/
    public WebToPigLatin(String input, String output)
    {
        try
        {
            in = new Scanner(new FileReader( input));
        }
        catch(FileNotFoundException f)
        {
            f.printStackTrace();
            System.out.println("\nUsage: java WebToPigLatin inputFile outputFile");
            System.out.println("Must have two command-line parameters");
        }
        catch(NullPointerException n)
        {
            n.printStackTrace();
            System.out.println("\nREADER: Testing for null pointer");
        }
        try
        {
            out = new BufferedWriter(new FileWriter( output));
        }
        catch(IOException i)
        {
            i.printStackTrace();
            System.out.println("\nWRITER: Testing for IO problems");
        }
        catch(NullPointerException a)
        {
            a.printStackTrace();
            System.out.println("\nWRITER: Testing for null pointer");
        }
    }
/*=========================================================================================*/
    public String MarkerFinder(String s)
    {
        String marker = "";
        int x = 1;
        if(s.charAt(0) == '&')
        {
            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i)==';')
                {
                    marker = (s.substring(0, (i + 1)) + translate(s.substring(i + 1)));
                    return marker;
                }
            }
        }
        return marker;
    }
/*=========================================================================================*/
    public String WordFinder(String s, int start)
    {
        String word = "";
        char mark = Punctuation(s);
        for(int end = start; end < s.length(); end++)
        {
            if (s.charAt(end) == ' ' || s.charAt(end) == '\n')
            {
                word = s.substring(start, end + 1);
                index = end - 1;
                break;
            }
        }
        return word;
    }
/*=========================================================================================*/
    public String TagFinder(String s, int start)
    {
        String tag = "";
        int x = 1;
        
        for(int end = start; x == 1; end++)
        {
            if (s.charAt(end)=='>')
            {
                tag = s.substring(start, end + 1);
                index = end + 1;
                break;
            }
        }
        return tag;
    }
/*=========================================================================================*/
    public int VowelLocation(String word)
    {
        int vowel = 0;
        String vowels = "AaEeIiOoUuYy";
        
        for (int i = 0; i < word.length(); i++)
        {
            for (int j = 0; j < vowels.length(); j++)
            {
                if(word.charAt(i) == vowels.charAt(j)){
                    vowel = i;
                    return vowel;
                }
            }
        }
        return vowel;
    }
/*=========================================================================================*/
    public String Capitalize (String s)
    {
        s = s.toLowerCase();
        s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
        return s;
    }
/*=========================================================================================*/
    public char Punctuation(String s)
    {
        char mark = ' ';
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) >= '!' && s.charAt(i) <= '@' && s.charAt(i) != '>' && s.charAt(i) != '<')
            {
                mark = s.charAt(i);
                return mark;
            }
        }
        return mark;
    }
/*=========================================================================================*/
    public String translate(String word) throws StringIndexOutOfBoundsException
    {
        String pig= "";
        if(word.length() == 0)
        {
            return pig;
        }
        char vowel =' ';
        int location = VowelLocation(word);
        vowel = word.charAt(location);
        char mark = Punctuation(word);
        if(vowel != 'Y' && vowel != 'y' && location == 0)
        {
            word = word.substring(0, word.length()-1);
            if(mark >= '!' && mark <= '@' && mark != '>' && mark != '<')
            {
                
                for(int i = 0; i < word.length(); i++)
                {
                    if(word.charAt(0) == mark)
                    {
                        
                        pig = word;
                        if(Character.isUpperCase(word.charAt(0)))
                        {
                            Capitalize(pig);
                        }
                    }
                    
                    else if(word.charAt(i) == mark)
                    {
                        word.trim();
                        pig = word + "way" + mark;
                        pig.trim();
                        if(Character.isUpperCase(word.charAt(0)))
                        {
                            Capitalize(pig);
                        }
                        }
                    else
                    {
                        pig = word;
                        if(Character.isUpperCase(word.charAt(0)))
                        {
                            Capitalize(pig);
                        }
                    }
                }
                
            }
            else
            {
                pig = word + "way";
                pig.trim();
            }
            
            if(Character.isUpperCase(word.charAt(0)))
            {
                Capitalize(pig);
            }
            MarkerFinder(pig);
            return pig;
        }
        
        else if ((vowel=='Y' || vowel=='y') && location == 0)
        {
            location = VowelLocation(word.substring(1));
            vowel= word.substring(1).charAt(location);
            word = word.substring(1);
            word = word.substring(location, (word.length()-1)) + 'y' + word.substring(0, location) + "ay";
            if(mark >= '!' && mark <= '@' && mark != '>' && mark != '<')
            {
                for(int i = 0; i < word.length(); i++)
                {
                    if(word.charAt(0) == mark)
                    {
                        pig = word;
                    }
                    
                    else if(word.charAt(i) == mark)
                    {
                        pig = word + mark;
                    }
                    else
                    {
                        pig = word;
                    }
                }
            }
            else
            {
                pig = word;
            }
            
            if(vowel == 'Y')
            {
                pig = Capitalize(pig);
            }
            MarkerFinder(pig);
            return pig;
        }
        else
        {
            word = word.substring(location, (word.length() - 1)) + word.substring(0, location) + "ay";
            if(mark >= '!' && mark <= '@' && mark != '>' && mark != '<')
            {
                pig = word + mark;
            }
            else
            {
                pig = word;
            }
            if(Character.isUpperCase(word.charAt(0)))
            {
                pig = Capitalize(pig);
            }
            MarkerFinder(pig);
            return pig;
        }
    }
/*=========================================================================================*/
    public String Construct()
    {
        String s = in.nextLine();
        String word = "", pig = "";

        for( index = 0; index < s.length(); index++)
        {
            if (s.charAt(index)=='<')
            {
                pig += TagFinder(s, index);
            }
            
            if(index < s.length() && s.charAt(index) != ' ')
            {
                word = WordFinder(s, index);
                pig += translate(word) + " ";
            }
            
        }
        return pig;
    }
/*=========================================================================================*/
    
    public static void main(String[] args) throws NullPointerException, IOException, StringIndexOutOfBoundsException
    {
        String s;
        
        WebToPigLatin p = new WebToPigLatin(args[0], args[1]);
        
        while (p.in.hasNext())
        {
            s = p.Construct();
            p.out.write(s);
        }
        p.out.close();
    }
    
}