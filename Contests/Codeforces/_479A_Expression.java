import java.io.*;
import java.util.*;

public class _479A_Expression {
    public static void main(String[] args) throws IOException {
	Scanner in = new Scanner(System.in);
	int a = in.nextInt();
	int b = in.nextInt();
	int c = in.nextInt();
	int[] s = { a + b + c, a + b * c, a * b + c, a * b * c, (a + b) * c,
		a * (b + c) };
	Arrays.sort(s);
	System.out.println(s[5]);
    }
}