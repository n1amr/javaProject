import java.util.Scanner;

public class _131A_cAPS_lOCK {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String s = in.next();
	boolean b = true;
	for (int i = 1; i < s.length(); i++) {
	    char c = s.charAt(i);
	    b = b & Character.isUpperCase(c);
	}
	if (b)
	    for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		if (Character.isLowerCase(c))
		    System.out.print(Character.toUpperCase(c));
		else
		    System.out.print(Character.toLowerCase(c));
	    }
	else
	    System.out.println(s);
    }
}
