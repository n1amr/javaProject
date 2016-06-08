import java.io.*;
import java.util.Scanner;

public class CodeJam2016A {
	public static Scanner in;
	public static PrintWriter out;

	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new BufferedInputStream(new FileInputStream(new File("A-large.in"))));
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
		long N = in.nextLong();
		long taken = 0;
		long num = 0;
		long tmp;
		long timeout = (long) Math.pow(10, (double) Math.log(N + 1) * 2);
		while ((N != 0 || timeout != 0) && taken != 0x3FF) {
			num += N;
			tmp = num;
			while (tmp != 0) {
				taken |= 1 << (tmp % 10);
				tmp /= 10;
			}
			timeout--;
		}
		out.println(timeout == 0 ? "INSOMNIA" : num);
	}
}
