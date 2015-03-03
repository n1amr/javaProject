import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	String n = in.next();
	int last = n.charAt(n.length() - 1) - 48, num = -1;
	for (int i = 0; i < n.length() - 1; i++) {
	    int k = n.charAt(i) - 48;
	    if (k % 2 == 0)
		num = i;
	    if (k % 2 == 0 && k < last)
		break;
	}
	if (num == -1)
	    System.out.println(-1);
	else
	    System.out.println(n.substring(0, num) + (char) (last + 48)
		    + n.substring(num + 1, n.length() - 1) + n.charAt(num));
    }
}