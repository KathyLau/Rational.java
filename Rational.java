//Kathy Lau, Anton Goretsky
//APCS1 pd5
//HW #33: Do You Even Add, Bro?
//2015-11-18

public class Rational{
    // Instance Variables
    private int _n;
    private int _d;

    // Constructors
    public Rational()
    {_n = 0;
      _d = 1;    }

    public Rational(int n, int d)
    {
        this();
        if (d != 0)
        {   _n = n;
            _d = d;  }
        else
            System.out.println("Invalid. Fraction set to 0 / 1");}

    // Accessor Methods
    public int getN()
    { return _n; }

    public int getD()
    {  return _d; }

    // Override toString() Method
    public String toString()
    {
        return ( "Fraction: " + _n + " / " + _d + "\n");
    }

    // Float Value Method
    public double floatValue()
    {return (1.0*_n / _d);
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
            System.out.println("Divide by Zero error.");
    }

    public void add(Rational fraction)
    {     _n = ( ( _n * fraction.getD() ) + ( fraction.getN() * _d ) );
          _d = ( _d * fraction.getD() );
        reduce();}


    public void subtract(Rational fraction)
    { Rational newR = new Rational(-1*fraction.getN(), fraction.getD());
      this.add(newR); }

    // Reduce Method
    public void reduce()
    {   int gcd = gcd();
        if ( gcd != 1 )
        {    _n /= gcd;
            _d /= gcd;  }
    }

    // Static GCD Function
    public static int gcd(int n, int d)
    { if (d==0){return n;}
    return gcd(d,n%d); }

    // GCD Method
    public int gcd()
    {return gcd(_n,_d); }

    public int compareTo(Rational fraction){
      return _n * fraction.getD() -  _d* fraction.getN();
    }
    public static void main(String[] args){
      Rational r = new Rational(1,3);
Rational s = new Rational(6,10);
r.add(s);
System.out.println(r);
r.subtract(s);
System.out.println(r);
System.out.println(r.compareTo(s));

    }
}
