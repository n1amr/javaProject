import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class _519B_A_and_B_and_Compilation_Errors {
    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
	int n = in.nextInt();
	int[] a = new int[n];
	for (int i = 0; i < n; i++)
	    a[i] = in.nextInt();
	Arrays.sort(a);

	int[] b = new int[n - 1];
	for (int i = 0; i < n - 1; i++)
	    b[i] = in.nextInt();
	Arrays.sort(b);

	int[] c = new int[n - 2];
	for (int i = 0; i < n - 2; i++)
	    c[i] = in.nextInt();
	Arrays.sort(c);

	int n1 = a[n - 1], n2 = b[n - 2];
	for (int i = 0; i < n - 1; i++)
	    if (a[i] != b[i]) {
		n1 = a[i];
		break;
	    }
	for (int i = 0; i < n - 2; i++)
	    if (b[i] != c[i]) {
		n2 = b[i];
		break;
	    }
	out.println(n1);
	out.println(n2);
	out.close();
    }
}
