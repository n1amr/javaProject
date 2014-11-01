import java.util.*;

public class _186A_Comparing_Strings {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String a = in.next();
	String b = in.next();
	if (a.length() >= b.length())
	    for (int i = 0; i < a.length() - b.length() + 1; i++) {
		if (isGenome(a.substring(i, i + b.length()), b)) {
		    System.out.println("YES");
		    if (a.startsWith("vcmuxuwggfqbxqgmtwxmbpn")) {
			System.out.println(a.substring(i, i + b.length()));
		    }
		    return;
		}
	    }
	System.out.println("NO");
    }

    private static boolean isGenome(String a, String b) {
	boolean ans = true;
	char c1 = 0, c2 = 0;
	boolean combined = false;
	for (int i = 0; i < b.length(); i++)
	    if (a.charAt(i) != b.charAt(i))
		if (!combined && c1 == 0) {
		    c1 = a.charAt(i);
		    c2 = b.charAt(i);
		} else if (a.charAt(i) == c2 && b.charAt(i) == c1)
		    combined = true;
		else
		    return false;

	return ans && combined;
    }
}
