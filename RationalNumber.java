public class RationalNumber extends RealNumber{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno) {
    super(0); //this value is ignored!
    numerator = nume;
    denominator = deno;
    if (deno == 0) {
      denominator = 1;
    }
    reduce();
  }

  public double getValue() {
    return (double)numerator / denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator() {
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator() {
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal() {
    return new RationalNumber(this.getDenominator(), this.getNumerator());
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other) {
    return((this.getNumerator() == other.getNumerator()) && (this.getDenominator() == other.getDenominator()));
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString() {
    if (numerator == 0) return ""+0;
    if (denominator == 1) {
      return ""+numerator;
    } else if (denominator < 0) {
      numerator *= -1;
      denominator *= -1;
    }
    return numerator+"/"+denominator;
  }



  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b, boolean firstTime) {
    int hi,lo;
    if (firstTime) {
      hi = Math.max(a,b);
      lo = Math.min(a,b);
    } else {
      hi = a;
      lo = b;
    }
    if (hi == 0) {
      return lo;
    }
    if (lo == 0) {
      return hi;
    }
    a = gcd(lo,(hi % lo), false);
    return(a);
  }



  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce() {
    int nume = (numerator / gcd(numerator, denominator, true));
    int deno = (denominator / gcd(numerator, denominator, true));
    numerator = nume;
    denominator = deno;
  }



  /******************Operations Return a new RationalNumber!!!!****************/
    /**
    *Return a new RationalNumber that is the product of this and the other
    */

  public RationalNumber multiply(RationalNumber other) {
    int nume = (this.getNumerator() * other.getNumerator());
    int deno = (this.getDenominator() * other.getDenominator());
    RationalNumber ans = new RationalNumber(nume, deno);
    return(ans);
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other) {
    return this.multiply(other.reciprocal());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other) {
    int nume = ((this.getNumerator() * other.getDenominator()) + (this.getDenominator() * other.getNumerator()));
    int deno = (this.getDenominator() * other.getDenominator());
    RationalNumber ans = new RationalNumber(nume, deno);
    return(ans);
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other) {
    // int nume = ((this.getNumerator() * other.getDenominator()) + (this.getDenominator() * other.getNumerator()));
    // int deno = (this.getDenominator() * other.getDenominator());
    // RationalNumber ans = new RationalNumber(nume, deno);
    // return(ans);

    RationalNumber neg = new RationalNumber(-1,1);
    return(this.add(other.multiply(neg)));
  }
}

