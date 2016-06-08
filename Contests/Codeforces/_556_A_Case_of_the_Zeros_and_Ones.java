import java.io.*;
import java.util.*;

public class _556_A_Case_of_the_Zeros_and_Ones {
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static void main(String[] args) {
		int c = 0, n = in.nextInt();
		String s = in.next();
		for (int i = 0; i < n; i++)
			c += s.charAt(i) == '1' ? 1 : -1;
		out.println(c < 0 ? -c : c);
		out.close();
	}
}
