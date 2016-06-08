import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class _519C_A_and_B_and_Team_Training {
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static void main(String[] args) {
		int n = in.nextInt();
		int m = in.nextInt();

		if (n < m) {
			int swap_temp = n;
			n = m;
			m = swap_temp;
		}
		int c = 0;

		int min = Math.min(m, n);
		int rn = n - min;
		int t = Math.min(rn, min);
		rn -= t;
		min -= t;
		c += t;
		int threecouples = min / 3;
		min -= threecouples * 3;
		c += 2 * threecouples;
		if (min > 1)
			c++;

		System.out.println(c);
	}
}
