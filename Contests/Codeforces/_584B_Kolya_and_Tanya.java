import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class _584B_Kolya_and_Tanya {
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static void main(String[] args) {
		int n = in.nextInt();
		long ans;
		long tmp1 = 1;
		long tmp2 = 1;
		long mod = 1000000007;
		for (int i = 0; i < n; i++) {
			tmp1 = tmp1 * 27 % mod;
			tmp2 = tmp2 * 7 % mod;
		}
		ans = tmp1 - tmp2;
		out.println((mod + ans) % mod);
		out.close();
	}
}
