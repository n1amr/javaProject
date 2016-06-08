import java.io.*;
import java.util.*;

public class CodeJam {
	public static Scanner in;
	public static PrintWriter out;

	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new BufferedInputStream(new FileInputStream(new File("input.txt"))));
		out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File("output.txt"))));
		int nCases = in.nextInt();
		in.nextLine();
		for (int CASE = 1; CASE <= nCases; CASE++) {
			out.print("Case #" + CASE + ": ");
			solve();
		}
		out.close();
		System.err.println("Done");
	}

	static void solve() {
		out.println(in.nextLine());
	}
}
