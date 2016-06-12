
public class Complex {
	private final double re;
	private final double im;

	public Complex(double real, double imag) {
		re = real;
		im = imag;
	}

	@Override
	public String toString() {
		if (im == 0)
			return re + "";
		if (re == 0)
			return im + "i";
		if (im < 0)
			return re + " - " + -im + "i";
		return re + " + " + im + "i";
	}

	public double abs() {
		return Math.hypot(re, im);
	}

	public double angle() {
		return Math.atan2(im, re);
	}

	public Complex add(Complex b) {
		return new Complex(re + b.re, im + b.im);
	}

	public Complex subtract(Complex b) {
		return new Complex(re - b.re, im - b.im);
	}

	public Complex multiply(Complex b) {
		return new Complex(re * b.re - im * b.im, re * b.im + im * b.re);
	}

	public Complex multiply(double alpha) {
		return new Complex(alpha * re, alpha * im);
	}

	public Complex conjugate() {
		return new Complex(re, -im);
	}

	public Complex reciprocal() {
		double scale = re * re + im * im;
		return new Complex(re / scale, -im / scale);
	}

	// return the real or imaginary part
	public double re() {
		return re;
	}

	public double im() {
		return im;
	}

	public Complex divide(Complex b) {
		return this.multiply(b.reciprocal());
	}

	// return a new Complex object whose value is the complex exponential of
	public Complex exp() {
		return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
	}

	// return a new Complex object whose value is the complex sine of this
	public Complex sin() {
		return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
	}

	public Complex cos() {
		return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
	}

	public Complex tan() {
		return sin().divide(cos());
	}

	// sample client for testing
	public static void main(String[] args) {
		Complex a = new Complex(5.0, 6.0);
		Complex b = new Complex(-3.0, 4.0);

		System.out.println("a            = " + a);
		System.out.println("b            = " + b);
		System.out.println("Re(a)        = " + a.re());
		System.out.println("Im(a)        = " + a.im());
		System.out.println("b + a        = " + b.add(a));
		System.out.println("a - b        = " + a.subtract(b));
		System.out.println("a * b        = " + a.multiply(b));
		System.out.println("b * a        = " + b.multiply(a));
		System.out.println("a / b        = " + a.divide(b));
		System.out.println("(a / b) * b  = " + a.divide(b).multiply(b));
		System.out.println("conj(a)      = " + a.conjugate());
		System.out.println("|a|          = " + a.abs());
		System.out.println("tan(a)       = " + a.tan());
	}

}