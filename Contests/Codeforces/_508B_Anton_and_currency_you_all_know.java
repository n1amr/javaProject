import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class _508B_Anton_and_currency_you_all_know {
    public static void main(String[] args) {
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	char[] s = in.next().toCharArray();
	int n = s.length;
	for (int i = 0; i < n; i++)
	    if (s[i] % 2 == 0 && s[i] < s[n - 1]) {
		char t = s[i];
		s[i] = s[n - 1];
		s[n - 1] = t;
		System.out.println(s);
		return;
	    }
	for (int i = n - 1; i >= 0; i--)
	    if (s[i] % 2 == 0) {
		char t = s[i];
		s[i] = s[n - 1];
		s[n - 1] = t;
		System.out.println(s);
		return;
	    }
	System.out.println(-1);
    }
}