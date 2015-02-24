import java.io.*;
import java.util.*;

public class _515A_Drazil_and_Date {
    public static Scanner in = new Scanner(new BufferedReader(
	    new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(
	    new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
	int a = Math.abs(in.nextInt());
	int b = Math.abs(in.nextInt());
	int s = in.nextInt();
	out.println(((s - (a + b)) >= 0 && (s - (a + b)) % 2 == 0) ? "YES"
		: "NO");
	out.close();
    }
}
