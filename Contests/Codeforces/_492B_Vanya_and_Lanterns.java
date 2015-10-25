import java.util.Arrays;
import java.util.Scanner;

public class _492B_Vanya_and_Lanterns {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int l = in.nextInt();
	int[] a = new int[n];
	for (int i = 0; i < n; i++)
	    a[i] = in.nextInt();
	Arrays.sort(a);
	double max = Math.max(a[0], l - a[n - 1]);
	for (int i = 1; i < a.length; i++)
	    max = Math.max(max, (a[i] - a[i - 1]) / 2.0);
	System.out.println(max);
    }
}
