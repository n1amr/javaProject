import java.util.Scanner;

public class _456B_Fedya_and_Maths {
    public static void main(String[] args) {
	String s = new Scanner(System.in).next();
	if (s.length() > 1)
	    s = s.substring(s.length() - 2);
	int x = Integer.valueOf(s);
	System.out.println((x % 4 == 0) ? 4 : 0);
    }
}
