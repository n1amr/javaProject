import java.io.*;
import java.util.*;

public class A {
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static void main(String[] args) {
		String[] a = new String[5];
		for (int i = 0; i < 5; i++)
			a[i] = in.next();
		int ans = 0;
		if (a[4].equals("x")) {
			ans = Integer.valueOf(a[0]) + Integer.valueOf(a[2]);
		} else {
			int number1 = Integer.valueOf(a[0].equals("x") ? a[2] : a[0]);
			ans = Integer.valueOf(a[4]) - number1;
		}
		out.println(ans);
		out.close();
	}
}
