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
        {
            _n = n;
            _d = d;
        }
        else
            System.out.println("Invalid. Fraction set to 0 / 1");
    }

    // Accessor Methods
    public int getN()
    { return _n; }

    public int getD()
    {  return _d; }

    // Override toString() Method
    public String toString()
    {
        return (  _n + " / " + _d);
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
    {
        if ( _d == fraction.getD() )
            _n += fraction.getN();
        else{
          _n = ( ( _n * fraction.getD() ) + ( fraction.getN() * _d ) );
          _d = ( _d * fraction.getD() );
        }
    }

    public void subtract(Rational fraction)
    {
        if ( _d == fraction.getD() )
            _n -= fraction.getN();
        else {
            _n = ( ( _n * fraction.getD() ) - ( fraction.getN() * _d ) );
            _d = ( _d * fraction.getD() );
        }
    }

    // Reduce Method
    public void reduce()
    {
      int n = gcd();
        if ( n != 1 )
        {    _n /= n;
            _d /= n;  }
    }

    // GCD Function
    public int gcd()
    {
      int a = _n;
        int b = _d;
        while (b!=0){
          int temp = b;
          b=a%b;
          a=temp;  }
        return a;  }

    // Static GCD Method
    public static int gcd(int n, int d)
    {
        Rational ans = new Rational(n, d);
        return ans.gcd();
    }

    // Compare To Method
public boolean compareTo(Object other)
  {this.reduce();
    if (other instanceof Rational){
        ((Rational) other).reduce();}
    else
    {throw new ClassCastException("Requires an instance of the 'Rational' class.");}
    return this.toString().equals(other.toString());}

// Equals Method
public boolean equals(Object other)
{
    return ( (this == other) || compareTo(other));
}

    public static void main(String[] args){
      Rational r = new Rational(2,3);
    //  Tile s = new Tile("hi");
Rational s = new Rational(6,9);
System.out.println(r.equals(s));
    }
}
