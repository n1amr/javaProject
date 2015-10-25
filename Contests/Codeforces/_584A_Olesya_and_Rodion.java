import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class _584A_Olesya_and_Rodion {
    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
	int n = in.nextInt();
	String t = Integer.toString(in.nextInt());

	if (t.length() > n)
	    out.println(-1);
	else {
	    out.print(t);
	    for (int i = t.length(); i < n; i++)
		out.print('0');
	    out.println();
	}
	out.close();
    }
}
