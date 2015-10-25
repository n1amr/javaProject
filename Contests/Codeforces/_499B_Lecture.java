import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class _499B_Lecture {

    public static void main(String[] args) {
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	int m = in.nextInt();
	int n = in.nextInt();
	HashMap<String, String> c = new HashMap<String, String>(n);
	for (int i = 0; i < n; i++) {
	    String f = in.next();
	    String l = in.next();
	    if (l.length() >= f.length())
		l = f;
	    c.put(f, l);
	}
	for (int i = 0; i < m; i++) {
	    out.print(c.get(in.next()));
	    if (i < m - 1)
		out.print(" ");
	}
	out.close();
    }
}
