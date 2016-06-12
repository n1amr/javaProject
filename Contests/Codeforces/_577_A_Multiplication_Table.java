import java.io.*;
import java.util.*;

public class _577_A_Multiplication_Table {
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static void main(String[] args) {
		int n = in.nextInt();
		int x = in.nextInt();

		int c = 0;

		for (int i = 1; i <= n; i++)
			if (x % i == 0 && (x / i) <= n)
				c++;

		out.println(c);
		out.close();
	}
}
