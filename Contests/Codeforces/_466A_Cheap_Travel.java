import java.util.*;

public class _466A_Cheap_Travel {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();

		if (a * m <= b)
			System.out.println(n * a);
		else
			System.out.println((n / m) * b + Math.min((n % m) * a, b));
	}
}
