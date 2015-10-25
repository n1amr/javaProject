import java.util.Arrays;
import java.util.Scanner;

public class _276C_Little_Girl_and_Maximum_Sum {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int q = in.nextInt();
	Integer[] a = new Integer[n];
	int[] b = new int[n];
	Integer[] c = new Integer[n];
	for (int i = 0; i < n; i++)
	    a[i] = in.nextInt();
	for (int i = 0; i < q; i++) {
	    int x = in.nextInt();
	    int y = in.nextInt();
	    b[x - 1] += 1;
	    if (y < b.length)
		b[y] -= 1;
	}
	int v = 0;
	for (int i = 0; i < n; i++) {
	    v += b[i];
	    c[i] = v;
	}
	Arrays.sort(a);
	Arrays.sort(c);
	long r = 0;
	for (int i = 0; i < n; i++)
	    r += (long) a[i] * c[i];

	System.out.println(r);
    }
}
