import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class DoStuff
{
    public static void main(String [] args)
    {
        System.out.println("\n\n");
        File d = new File("./");
        File [] f = d.listFiles();
        Date date = new Date();
        String x = date.toString();
        String s = x.substring(4, 20);
        
        if(args.length == 0)
        {
            print(d, f);
        }
        
        else if(args.length == 1 && "-s".equals(args[0]))
        {
            Arrays.sort(f, new ByteCompare());
            print(d, f);
        }
        
        else if(args.length == 1 && "-l".equals(args[0]))
        {
            Arrays.sort(f, new DateCompare());
            print(d, f);
        }
        
        else if(args.length == 1 && "-a".equals(args[0]))
        {
            Arrays.sort(f, new AlphaCompare());
            print(d, f);
        }
        
        else if(args.length == 1)
        {
            d = new File(args[0]);
            if(d.isDirectory())
            {
                f = d.listFiles();
                print(d, f);
            }
            
            else
            {
                System.out.println("I hate to say it, man, but that ain't a directory. It could be a file, though.\n\n");
            }
        }
        
        else if(args.length == 2 && "-s".equals(args[1]))
        {
            d = new File(args[0]);
            if(d.isDirectory())
            {
                f = d.listFiles();
                Arrays.sort(f, new ByteCompare());
                print(d, f);
            }
            
            else
            {
                System.out.println("I hate to say it, man, but that ain't a directory. It could be a file, though.\n\n");
                print(d, f);
            }
        }
        
        else if(args.length == 2 && "-l".equals(args[1]))
        {
            d = new File(args[0]);
            if(d.isDirectory())
            {
                f = d.listFiles();
                Arrays.sort(f, new DateCompare());
                print(d, f);
            }
            
            else
            {
                System.out.println("I hate to say it, man, but that ain't a directory. It could be a file, though.\n\n");
                print(d, f);
            }
        }
        
        else if(args.length == 2 && "-a".equals(args[1]))
        {
            d = new File(args[0]);
            if(d.isDirectory())
            {
                f = d.listFiles();
                Arrays.sort(f, new AlphaCompare());
                print(d, f);
            }
            
            else
            {
                System.out.println("usage:  java -jar hw5.jar [directory] [-a | -l | -s]");
                System.out.println("current directory is default");
                System.out.println("-a alphabetical sorting");
                System.out.println("-l last time modified sorting");
            }
        }
        
        else if(args.length == 3)
        {
            System.out.println("usage:  java -jar hw5.jar [directory] [-a | -l | -s]");
            System.out.println("current directory is default");
            System.out.println("-a alphabetical sorting");
            System.out.println("-l last time modified sorting");
        }
        
        else if(args.length == 1 && (!args[0].equals("-a") || !args[0].equals("-s") || !args[0].equals("-l")))
        {
            System.out.println("usage:  java -jar hw5.jar [directory] [-a | -l | -s]");
            System.out.println("current directory is default");
            System.out.println("-a alphabetical sorting");
            System.out.println("-l last time modified sorting");
        }
        
        else if(args.length == 2 && (args[1].equals("-a") || args[1].equals("-s") || args[1].equals("-l")))
        {
            System.out.println("LOL NAH");
        }
        
        else
        {
            System.out.println("usage:  java -jar hw5.jar [directory] [-a | -l | -s]");
            System.out.println("current directory is default");
            System.out.println("-a alphabetical sorting");
            System.out.println("-l last time modified sorting");
        }
        System.out.println("\n\n");
    }
    
    public static void print(File f, File [] fn)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd HH:mm:ss");
        for(File file : fn)
        {
            if(file.isDirectory())
            {
                System.out.println(file.length() + "\t" + sdf.format(file.lastModified()) + "\t  " + file);
            }
            if(file.isFile())
            {
                System.out.println(file.length() + "\t" + sdf.format(file.lastModified()) + "\t  " + file);
            }
        }
    }
    
    private static class ByteCompare implements Comparator<File>
    {
        public int compare(File f1, File f2)
        {
            return ((int)(f1.length() - f2.length()));
        }
    }
    
    private static class DateCompare implements Comparator<File>
    {
        public int compare(File f1, File f2)
        {
            return((int)(f1.lastModified() - f2.lastModified()));
        }
    }
    
    
    private static class AlphaCompare implements Comparator<File>
    {
        public int compare(File f1, File f2)
        {
            return(f1.compareTo(f2));
        }
    }
}