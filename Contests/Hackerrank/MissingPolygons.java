import java.util.Scanner;

public class MissingPolygons {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] sides = new int[n];
		int sum = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			sides[i] = in.nextInt();
			sum += sides[i];
			if (sides[i] > max)
				max = sides[i];
		}

		System.out.println(n == 1 ? 2 : n == 2 ? sides[0] == sides[1] ? 2 : 1 : 2 * max >= sum ? 1 : 0);
	}
}