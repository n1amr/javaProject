import java.util.*;

public class _441B_Valera_and_Fruits {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int v = in.nextInt();

	int left = 0;
	int[] b = new int[3333];
	for (int i = 0; i < n; i++)
	    b[in.nextInt()] += in.nextInt();

	int r = 0;
	for (int i = 0; i < b.length; i++) {
	    int now = b[i];
	    if (now + left <= v) {
		r += now + left;
		left = 0;
	    } else {
		r += v;
		left = now - Math.max(0, v - left);
	    }
	}
	System.out.println(r);
    }
}
