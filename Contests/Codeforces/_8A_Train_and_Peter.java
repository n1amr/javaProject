import java.util.Scanner;

public class _8A_Train_and_Peter {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String s = in.nextLine();
	String a = in.nextLine();
	String b = in.nextLine();
	boolean[] r = new boolean[2];
	for (int i = 0; i < 2; i++) {
	    int A = s.indexOf(a);
	    int B = s.indexOf(b, A + a.length());
	    if (A != -1 && B != -1)
		r[i] = true;
	    s = new StringBuffer(s).reverse().toString();
	}
	String ans = "fantasy";
	if (r[0]) {
	    if (r[1])
		ans = "both";
	    else
		ans = "forward";
	} else if (r[1])
	    ans = "backward";
	System.out.println(ans);
    }
}
