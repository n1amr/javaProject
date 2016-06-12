import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class _591A_Wizards_Duel {
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static void main(String[] args) {
		int l = in.nextInt();
		int p = in.nextInt();
		int q = in.nextInt();

		double t1 = (float) l * p / (p + q);

		out.println(t1);
		out.close();
	}
}
