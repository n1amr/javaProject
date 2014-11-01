import java.io.*;
import java.util.*;

public class _255B_Code_Parsing {
    public static void main(String[] args) {
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
		System.in)));
	PrintWriter out = new PrintWriter(new BufferedWriter(
		new OutputStreamWriter(System.out)));
	String s = in.next();
	int nx = 0, ny = 0;
	for (int i = 0; i < s.length(); i++)
	    if (s.charAt(i) == 'x')
		nx++;
	    else
		ny++;
	char c = nx > ny ? 'x' : 'y';
	int n = Math.abs(nx - ny);
	for (int i = 0; i < n; i++)
	    out.print(c);
	out.println();
	out.close();
    }
}
