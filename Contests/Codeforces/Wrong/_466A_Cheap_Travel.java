import java.util.*;

public class _466A_Cheap_Travel {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();

		int r = 0;
		while (n > 0) {
			if (m > n) {
				r += Math.min(b, n*a);
				n = 0;
			} else if (a <= ((double) b / m)) {
				r += a;
				n--;
			} else if (a > ((double) b / m) && m < n) {
				r += b;
				n -= m;
			}
		}
		System.out.println(r);
	}
}
