import java.util.Scanner;

public class BisectionMethod {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		double a = 4, b = 50;
		double c;
		for (int i = 0; i < 100; i++) {
			c = (a + b) / 2;
			System.out.println("Iteration " + i + ": " + c);
			if (f(a) * f(c) < 0)
				b = c;
			else if (f(c) * f(b) < 0)
				a = c;
			else
				// System.out.println("Error");
				break;
		}

	}

	static double f(double x) {
		return Math.exp(x) - 0.17 * Math.pow(x, 4.2);
	}
}