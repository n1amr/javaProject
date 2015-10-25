import java.util.Scanner;

public class _11A_Increasing_Sequence {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int d = in.nextInt();
	int[] a = new int[n];
	for (int i = 0; i < n; i++)
	    a[i] = in.nextInt();
	int r = 0;
	for (int i = 1; i < a.length; i++) {
	    if (a[i] < a[i - 1]) {
		r += (a[i - 1] - a[i] + d - 1) / d;
		a[i] += (a[i - 1] - a[i] + d - 1) / d * d;
	    }
	    if (a[i] == a[i - 1]) {
		r++;
		a[i] += d;
	    }
	}
	System.out.println(r);
    }
}
