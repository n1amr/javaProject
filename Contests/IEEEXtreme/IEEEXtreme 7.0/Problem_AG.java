import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem_AG {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		ArrayList<Long> rslts = new ArrayList<Long>();
		while (n != 0 && k != 0) {
			n = input.nextInt();
			k = input.nextInt();

		}
		for (long i : rslts)
			System.out.println(i);
	}

	static String PATH = "";

	private static ArrayList findNumOfPaths(int x, int y, int testx, int testy, int n, int k, ArrayList<Integer> paths) {
		if (testx == n && testy == n) {
			//R
			if (x < n && y > n) {
				return findNumOfPaths(x + 1, y, x, y, n, k, paths);
			}
			//D
			if (x < n && y > k)
				return findNumOfPaths(x + 1, y, x, y, n, k, paths);
		}
	}
}