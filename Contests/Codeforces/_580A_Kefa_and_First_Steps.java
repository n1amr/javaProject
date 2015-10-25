import java.util.*;

public class _580A_Kefa_and_First_Steps {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int c = 0, max = 0;
	int last = 0;
	for (int i = 0; i < n; i++) {
	    int cur = in.nextInt();
	    if (cur < last) {
		max = Math.max(max, c);
		c = 0;
	    }
	    c++;
	    last = cur;
	}
	System.out.println(Math.max(max, c));
    }
}
