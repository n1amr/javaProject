import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
	Scanner in = new Scanner(System.in);
	String c = "RGOEJN";// in.next();
	// String s = in.next();
	int[] a = new int[] { 2, 2, 1, 2, 1, 2 };
	for (int i = 0; i < c.length(); i++) {
	    System.out.print((char) (c.charAt(i) - a[i]));
	}

    }
}