import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class _468A_24_Game {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = in.nextInt();

		if (n % 2 == 0 && n > 3) {
			out.println("YES");
			out.println("2 * 3 = 6");
			out.println("4 * 6 = 24");
			out.println("24 * 1 = 24");
			for (int i = 5; i + 1 <= n; i += 2) {
				out.println(i + 1 + " - " + i + " = 1");
				out.println("24 * 1 = 24");
			}

		} else if (n % 2 != 0 && n > 4) {
			out.println("YES");
			out.println("4 * 5 = 20");
			out.println("20 + 3 = 23");
			out.println("23 + 2 = 25");
			out.println("25 - 1 = 24");
			for (int i = 6; i + 1 <= n; i += 2) {
				out.println(i + 1 + " - " + i + " = 1");
				out.println("24 * 1 = 24");
			}
		} else
			out.println("NO");
		out.close();
	}
}
