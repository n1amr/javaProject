public class Rational extends Number implements Comparable<Rational> {
    /**
    * 
    */
    private static final long serialVersionUID = 1L;
    private long numerator = 0;
    private long denominator = 1;

    static long gcd(long a, long b) {
	if (b == 0)
	    return a;
	return gcd(b, a % b);
    }

    public Rational() {
	this(0, 1);
    }

    public Rational(long numerator, long denominator) {
	long gcd = gcd(Math.abs(numerator), Math.abs(denominator));
	this.numerator = Math.abs(numerator) * (numerator < 0 ^ denominator < 0 ? -1 : 1) / gcd;
	this.denominator = Math.abs(denominator) / gcd;
    }

    public long getNumerator() {
	return numerator;
    }

    public long getDenominator() {
	return denominator;
    }

    public Rational add(Rational r2) {
	return new Rational(numerator * r2.denominator + r2.numerator * denominator, denominator * r2.denominator);
    }

    public Rational subtract(Rational r2) {
	return new Rational(numerator * r2.denominator - r2.numerator * denominator, denominator * r2.denominator);
    }

    public Rational multiply(Rational r2) {
	return new Rational(numerator * r2.numerator, denominator * r2.denominator);
    }

    public Rational divide(Rational r2) {
	return new Rational(numerator * r2.denominator, denominator * r2.numerator);
    }

    @Override
    public int compareTo(Rational o) {
	int r = (int) subtract(o).getNumerator();
	if (r > 0)
	    return 1;
	else if (r < 0)
	    return -1;
	else
	    return 0;
    }

    @Override
    public String toString() {
	if (denominator != 1)
	    return numerator + "/" + denominator;
	else
	    return Long.toString(numerator);
    }

    @Override
    public boolean equals(Object obj) {
	return subtract((Rational) obj).getNumerator() == 0;
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
	return (double) numerator / denominator;
    }

}
