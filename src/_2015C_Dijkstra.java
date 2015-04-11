import java.io.*;
import java.util.*;

public class _2015C_Dijkstra {
    public static Scanner in;
    public static PrintWriter out;

    public static void main(String[] args) throws FileNotFoundException {
	in = new Scanner(new BufferedInputStream(new FileInputStream(new File(
		"input.txt"))));
	out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(
		new File("output.txt"))));
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
	in.nextLong();
	long X = in.nextLong();
	in.nextLine();
	String s = in.nextLine().trim();
	boolean negative = false;
	char last = '1';
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    negative = negative ^ sign(last, c);
	    last = multiply(last, c);
	}

	if (X % 2 == 0)
	    negative = false;
	int res = (int) (X % 4);
	switch (res) {
	    case 0:
		last = '1';
		break;
	    case 2:
		last = '1';
		negative = !negative;
		break;
	    case 3:
		negative = !negative;
		break;
	}
	if (negative && last == '1')
	    out.println("YES");
	else
	    out.println("NO");
    }

    static char multiply(char a, char b) {
	if (a == '1')
	    return b;
	if (b == '1')
	    return a;
	if (a == b)
	    return '1';
	switch (a) {
	    case 'i':
		if (b == 'j')
		    return 'k';
		if (b == 'k')
		    return 'j';
	    case 'j':
		if (b == 'i')
		    return 'k';
		if (b == 'k')
		    return 'i';
	    case 'k':
		if (b == 'i')
		    return 'j';
		if (b == 'j')
		    return 'i';
	}
	return '0';
    }

    static boolean sign(char a, char b) {
	if (a == 1 || b == 1)
	    return false;
	if (a == b)
	    return true;
	if (a == 'i' && b == 'k' || a == 'j' && b == 'i' || a == 'k'
		&& b == 'j')
	    return true;
	return false;
    }
}