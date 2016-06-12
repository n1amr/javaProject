import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class _515B_Drazil_and_His_Happy_Friends {
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static void main(String[] args) {
		int n = in.nextInt();
		int m = in.nextInt();

		int b = in.nextInt();
		boolean[] boys = new boolean[n];
		for (int i = 0; i < b; i++)
			boys[in.nextInt()] = true;

		int g = in.nextInt();
		boolean[] girls = new boolean[m];
		for (int i = 0; i < g; i++)
			girls[in.nextInt()] = true;

		for (int i = 0; i < n * n * m * m; i++)
			if (boys[i % n] || girls[i % m])
				boys[i % n] = girls[i % m] = true;

		String ans = "Yes";
		for (int i = 0; i < n; i++)
			if (!boys[i])
				ans = "No";
		for (int i = 0; i < m; i++)
			if (!girls[i])
				ans = "No";
		out.println(ans);
		out.close();
	}
}
