import java.util.*;

public class _145A_Lucky_Conversion {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String a = in.next();
	String b = in.next();
	int n47 = 0, n74 = 0;
	for (int i = 0; i < a.length(); i++) {
	    if (a.charAt(i) != b.charAt(i)) {
		if (a.charAt(i) == '4')
		    n47++;
		else
		    n74++;
	    }
	}
	System.out.println(Math.min(n47, n74) + Math.abs(n74 - n47));
    }
}
