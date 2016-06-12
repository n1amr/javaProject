import java.util.Scanner;

public class Right_Angled_Triangle {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			solve(in.nextInt(), in.nextInt());
		}
	}

	static void solve(int a, int b) {
		for (int i = 1; i < a; i++) {
			int d1 = i;
			int d2 = (int) Math.sqrt(a * a - i * i);
			if (d1 * d1 + d2 * d2 == a * a) {
				double cosAlpha = 1.0 * d2 / a;
				// double sinBeta = cosAlpha;
				if (Math.ceil(b * cosAlpha) - Math.floor(b * cosAlpha) < 0.000000001) {
					System.out.println("TRUE");
					return;
				}
			}
		}
		System.out.println("FALSE");

	}
}
