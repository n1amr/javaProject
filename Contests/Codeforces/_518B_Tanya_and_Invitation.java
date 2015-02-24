import java.io.*;
import java.util.*;

public class _518B_Tanya_and_Invitation {
    public static Scanner in = new Scanner(new BufferedReader(
	    new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(
	    new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
	String s = in.next();
	String t = in.next();
	boolean[] ss = new boolean[s.length()];
	int[] a = new int[26];
	int[] A = new int[26];
	for (int i = 0; i < t.length(); i++) {
	    char c = t.charAt(i);
	    if (c < 0x60)
		A[c - 'A']++;
	    else
		a[c - 'a']++;
	}
	int n1 = 0, n2 = 0;
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (c > 0x60 && a[c - 'a'] > 0) {
		a[c - 'a']--;
		n1++;
		ss[i] = true;
	    } else if (c < 0x60 && A[c - 'A'] > 0) {
		A[c - 'A']--;
		n1++;
		ss[i] = true;
	    }

	}

	s = s.toLowerCase();
	for (int i = 0; i < 26; i++)
	    a[i] += A[i];

	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (ss[i])
		continue;
	    if (a[c - 'a'] > 0) {
		a[c - 'a']--;
		n2++;
	    }
	}

	out.println("" + n1 + " " + n2);
	out.close();
    }
}
