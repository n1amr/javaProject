import java.io.*;
import java.util.*;

public class _599_A_Patrick_and_Shopping {
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static void main(String[] args) {
		int max = 0;
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			int x = in.nextInt();
			sum += x;
			max = Math.max(max, x);
		}
		out.println(Math.min((sum - max) * 2, sum));
		out.close();
	}
}
