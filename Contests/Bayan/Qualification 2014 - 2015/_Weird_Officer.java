import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class _Weird_Officer {
	static Scanner in;
	static PrintWriter out;

	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new BufferedInputStream(new FileInputStream(new File("input.txt"))));
		out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File("output.txt"))));
		int nCases = in.nextInt();
		in.nextLine();
		for (int CASE = 1; CASE <= nCases; CASE++)
			solve();
		out.close();
		System.out.println("Done");
	}

	static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

	static void solve() {
		String name = in.nextLine();
		int c = 0;

		for (int i = 0; i < name.length(); i++) {
			char l = name.charAt(i);
			for (int j = 0; j < vowels.length; j++)
				if (l == vowels[j]) {
					c++;
					break;
				}
		}

		if (c % 2 == 1)
			out.println("PESAR");
		else
			out.println("DOKHTAR");

	}
}
