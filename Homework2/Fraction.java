/*-----------------------FRACTION CLASS----------------------------*/
public class Fraction
{
    private int numerator = 0;
    private int denominator = 1;
    private int n;
/*-----------------------DEFAULT CONSTRUCTOR------------------------*/
    public Fraction()
    {
    }
/*-----------------------CONSTRUCTOR W/ PARAMETERS------------------*/
    public Fraction(int n, int d)
    {
        if (set(n,d)==false)
            set(0,1);
    }
/*------------------SET FUNCTION------------------------------------*/
    public boolean set(int n, int d)
    {
        if (d > 0)
        {
            numerator = n;
            denominator = d;
            return true;
        }
        else
            return false;
    }
/*-------------------------TO STRING FUNCTION------------------------*/
    public String toString()
    {
        return (numerator + "/" + denominator);
    }
/*------------------ACCESSOR FUNCTIONS-------------------------------*/
    public int getNumerator()
    {
        return numerator;
    }
    public int getDenominator()
    {
        return denominator;
    }
/*-----------------DECIMAL FUNCTION---------------------------------*/
    public double decimal()
    {
        return (double)numerator / denominator;
    }
/*-------------------SIMPLIFY FUNCTION------------------------------*/
    public Fraction simplify()
    {
        Fraction f = new Fraction(numerator, denominator);
        int gcd = 0, greater = 0;
        if(f.numerator >  f.denominator)
        {
            greater =  f.numerator;
        }
        else
        {
            greater =  f.denominator;
        }
        for(int i = greater; i >= 2; i--)
        {
            if(f.numerator % i == 0 &&  f.denominator % i == 0)
            {
                gcd = i;
                break;
            }
            else
            {
                gcd = 0;
            }
        }
        if(gcd != 0)
        {
            f.numerator /= gcd;
            f.denominator /= gcd;
            if(denominator < 0)
            {
                f.denominator *= -1;
                f.numerator *= -1;
            }
        }
        if(gcd == 0)
        {
            f.numerator = f.numerator;
            f.denominator = f.denominator;
            if(denominator < 0)
            {
                 f.denominator *= -1;
                 f.numerator *= -1;
            }
        }
        return f;
    }
/*-----------------------ADD FUNCTION---------------------------------*/
    public Fraction add(Fraction f)
    {
        Fraction f2 = new Fraction(0, 1);
        f2.simplify();
        f2.numerator = (numerator * f.denominator) + (f.numerator * denominator);
        f2.denominator = denominator * f.denominator;
        if(denominator < 0)
        {
            denominator *= -1;
            numerator *= -1;
        }
        return f2.simplify();
    }
/*---------------------SUBTRACT FUNCTION--------------------------------*/
    public Fraction subtract(Fraction f)
    {
        Fraction f2 = new Fraction(0, 1);
        f2.numerator = (numerator * f.denominator) - (f.numerator * denominator);
        f2.denominator = denominator * f.denominator;
        if(f2.denominator < 0)
        {
            f2.denominator *= -1;
            f2.numerator *= -1;
        }
        return f2.simplify();
    }
/*--------------------MULTIPLY FUNCTION-------------------------------*/
    public Fraction multiply(Fraction f)
    {
        Fraction f2 = new Fraction(0, 1);
        f2.numerator = (numerator * f.numerator);
        f2.denominator = denominator * f.denominator;
        if(f2.denominator < 0)
        {
            f2.denominator *= -1;
            f2.numerator *= -1;
        }
        return f2.simplify();
    }
/*-----------------DIVIDE FUNCTION-------------------------------------*/
    public Fraction divide(Fraction f)
    {
        Fraction f2 = new Fraction(0, 1);
        f2.numerator = (numerator * f.denominator);
        f2.denominator = denominator * f.numerator;
        if(f2.denominator == 0)
        {
            f2.numerator = 0;
            f2.denominator = 1;
        }
        if(f2.denominator < 0)
        {
            f2.denominator *= -1;
            f2.numerator *= -1;
        }
        return f2.simplify();
    }

}
/*------------------------------------------------------------------*/




