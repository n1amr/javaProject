import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class _500A_New_Year_Transportation {
    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
	int n = in.nextInt();
	int t = in.nextInt();
	int[] a = new int[n];
	for (int i = 1; i < n; i++)
	    a[i] = in.nextInt();
	int p = 1;
	while (p < n && p != t)
	    p += a[p];
	out.println(p == t ? "YES" : "NO");
	out.close();
    }
}
