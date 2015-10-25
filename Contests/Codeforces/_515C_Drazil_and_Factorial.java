import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class _515C_Drazil_and_Factorial {
    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
	in.nextInt();
	String a = new String(in.next());

	boolean changed = true;
	while (changed)
	    changed = a != (a = a.replace("4", "322")) || a != (a = a.replace("6", "53"))
		    || a != (a = a.replace("8", "7222")) || a != (a = a.replace("9", "7332"));
	char[] c = a.toCharArray();
	Arrays.sort(c);
	a = new StringBuilder(new String(c)).reverse().toString();
	int end = a.length();
	if (a.contains("1"))
	    end = a.indexOf("1");
	else if (a.contains("0"))
	    end = a.indexOf("0");

	a = a.substring(0, end);
	out.println(a);
	out.close();
    }
}
