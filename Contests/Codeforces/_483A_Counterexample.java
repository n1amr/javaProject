import java.util.*;

public class _483A_Counterexample {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	long l = in.nextLong();
	long r = in.nextLong();
	if (l % 2 != 0)
	    l++;
	if (r - l > 1)
	    System.out.println(l++ + " " + l++ + " " + l);
	else
	    System.out.println(-1);
    }
}
