import java.io.*;
import java.util.*;

public class _518A_Vitaly_and_Strings {
    public static Scanner in = new Scanner(new BufferedReader(
	    new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(
	    new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
	String s = in.next();
	String t = in.next();

	int p = s.length() - 1;
	char[] c = s.toCharArray();
	while (p < s.length() && c[p] == 'z') {
	    c[p] = 'a';
	    p--;
	}
	c[p] += 1;
	String ans = new String(c);
	if (ans.compareTo(t) < 0)
	    out.println(ans);
	else
	    out.println("No such string");
	out.close();
    }
}
