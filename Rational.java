public class Rational 
{
    // Instance Variables
    private int _n;
    private int _d;

    // Constructors
    public Rational()
    {
        _n = 0;
        _d = 1;
    }

    public Rational(int n, int d)
    {
        this();
        //d cannot be 0
        if (d != 0)
        {
            _n = n;
            _d = d;
        }
        else
            System.out.println("Invalid denominator. Fraction set to 0 / 1");
    }

    // Accessor Methods
    public int getN()
    {
        return _n;
    }

    public int getD()
    {
        return _d;
    }

    // Override toString() Method
    public String toString()
    {
        return ( "Fraction: " + _n + " / " + _d + "\n");
    }

    // Float Value Method
    public double floatValue()
    {
        return ( _n / (_d * 1.0) ); //multiply by 1.0 to make it a double
    }

    // Multiply Method
    public void multiply(Rational fraction)
    {
        _n *= fraction.getN();
        _d *= fraction.getD();
    }

    // Divide Method
    public void divide(Rational fraction)
    {
        if ( fraction.getN() != 0 )
        {
            _n *= fraction.getD();
            _d *= fraction.getN();
        }
        else
            System.out.println("This cannot be done. Numerator is 0.");
    }
    public static void main(String[] args){
      Rational r = new Rational(2,3); //Stores the rational number 2/3
Rational s = new Rational(1,2); //Stores the rational number 1/2
r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains ½
System.out.println(r);
r.divide(s);
System.out.println(r);
Rational z = new Rational(0,3);
Rational k = new Rational(1/2);
z.multiply(k);
System.out.println(z);
z.divide(k);
System.out.println(z);

    }
}
