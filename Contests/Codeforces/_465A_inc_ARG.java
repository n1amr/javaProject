import java.util.Scanner;

public class inc_ARG {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	String s = in.next();
	int r = 0;
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) == '1') {
		r++;
	    } else
		break;
	}
	if (r < s.length())
	    r++;
	System.out.println(r);
    }
}
