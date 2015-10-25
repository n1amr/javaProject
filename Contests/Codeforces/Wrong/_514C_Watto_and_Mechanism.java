import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class _514C_Watto_and_Mechanism {
    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
	HashMap<Integer, String> inputs = new HashMap<Integer, String>();
	HashMap<String, ArrayList<String>> firstHalves = new HashMap<String, ArrayList<String>>();
	HashMap<String, ArrayList<String>> lastHalves = new HashMap<String, ArrayList<String>>();

	int n = in.nextInt();
	int m = in.nextInt();

	for (int i = 0; i < n; i++) {
	    String input = in.next();
	    int len = input.length();
	    String s1 = input.substring(0, len / 2);
	    String s2 = input.substring(len / 2, len);

	    inputs.put(i, input);

	    if (firstHalves.containsKey(s1))
		firstHalves.get(s1).add(input);
	    else
		firstHalves.put(s1, new ArrayList<String>(Collections.singletonList(input)));

	    if (lastHalves.containsKey(s2))
		lastHalves.get(s2).add(input);
	    else
		lastHalves.put(s2, new ArrayList<String>(Collections.singletonList(input)));
	}

	for (int i = 0; i < m; i++) {
	    String query = in.next();
	    calc(query, inputs, firstHalves, lastHalves);
	}
	out.close();
    }

    private static void calc(String query, HashMap<Integer, String> inputs,
	    HashMap<String, ArrayList<String>> firstHalves, HashMap<String, ArrayList<String>> lastHalves) {
	int len = query.length();
	String q1 = query.substring(0, len / 2);
	String q2 = query.substring(len / 2, len);

	if (firstHalves.containsKey(q1)) {
	    ArrayList<String> origins = firstHalves.get(q1);
	    for (String o : origins)
		if (equalButOne(query, o)) {
		    out.println("YES");
		    return;
		}
	}

	if (lastHalves.containsKey(q2)) {
	    ArrayList<String> origins = lastHalves.get(q2);
	    for (String o : origins)
		if (equalButOne(query, o)) {
		    out.println("YES");
		    return;
		}
	}
	out.println("NO");
	return;
    }

    static boolean equalButOne(String s1, String s2) {
	if (s1.length() != s2.length())
	    return false;
	char[] c1 = s1.toCharArray();
	char[] c2 = s2.toCharArray();
	boolean foundLetter = false;
	for (int i = 0; i < c1.length; i++)
	    if (c1[i] != c2[i])
		if (!foundLetter)
		    foundLetter = true;
		else
		    return false;
	return foundLetter;
    }

}