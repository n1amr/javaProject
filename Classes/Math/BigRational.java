import java.math.BigInteger;

public class BigRational extends Number implements Comparable<BigRational> {
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private BigInteger numerator;
  private BigInteger denominator;

  static BigInteger gcd(BigInteger a, BigInteger b) {
    if (b.equals(BigInteger.ZERO))
      return a;
    return gcd(b, a.remainder(b));
  }

  public BigRational() {
    this(BigInteger.ZERO, BigInteger.ONE);
  }

  public BigRational(BigInteger numerator, BigInteger denominator) {
    BigInteger gcd = gcd(numerator.abs(), denominator.abs());
    this.numerator = numerator.abs().divide(gcd).multiply(
        numerator.signum() == -1 ^ denominator.signum() == -1 ? BigInteger.ONE.negate() : BigInteger.ONE);
    this.denominator = denominator.abs().divide(gcd);
  }

  public BigInteger getNumerator() {
    return numerator;
  }

  public BigInteger getDenominator() {
    return denominator;
  }

  public BigRational add(BigRational r2) {
    return new BigRational(numerator.multiply(r2.denominator).add(r2.numerator.multiply(denominator)),
        denominator.multiply(r2.numerator));
  }

  public BigRational subtract(BigRational r2) {
    return new BigRational(numerator.multiply(r2.denominator).subtract(r2.numerator.multiply(denominator)),
        denominator.multiply(r2.numerator));
  }

  public BigRational multiply(BigRational r2) {
    return new BigRational(numerator.multiply(r2.numerator), denominator.multiply(r2.denominator));
  }

  public BigRational divide(BigRational r2) {
    return new BigRational(numerator.multiply(r2.denominator), denominator.multiply(r2.numerator));
  }

  @Override
  public int compareTo(BigRational o) {
    return subtract(o).getNumerator().signum();
  }

  @Override
  public String toString() {
    if (denominator == BigInteger.ONE)
      return numerator + "/" + denominator;
    else
      return numerator.toString();
  }

  @Override
  public boolean equals(Object obj) {
    return subtract((BigRational) obj).getNumerator() == BigInteger.ZERO;
  }

  @Override
  public int intValue() {
    return (int) doubleValue();
  }

  @Override
  public long longValue() {
    return (long) doubleValue();
  }

  @Override
  public float floatValue() {
    return (float) doubleValue();
  }

  @Override
  public double doubleValue() {
    return numerator.divide(denominator).doubleValue();
  }

}
