import java.util.Arrays;
import java.util.Scanner;

public class _271B_Prime_Matrix {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt(), m = in.nextInt(), min = 50000000;
	int[][] a = new int[n][m];
	flagPrimes(999999);
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < m; j++)
		a[i][j] = diff(in.nextInt());

	for (int i = 0; i < n; i++) {
	    int c = 0;
	    for (int j = 0; j < m; j++)
		c += a[i][j];
	    min = Math.min(min, c);
	}
	for (int j = 0; j < m; j++) {
	    int c = 0;
	    for (int i = 0; i < n; i++)
		c += a[i][j];
	    min = Math.min(min, c);
	}
	System.out.println(min);
    }

    static boolean[] isPrime;

    static void flagPrimes(int n) {
	isPrime = new boolean[n + 1];
	Arrays.fill(isPrime, 2, n, true);
	for (int i = 2; i <= n; i++)
	    if (isPrime[i])
		for (int j = 2 * i; j <= n; j += i)
		    isPrime[j] = false;
    }

    static int diff(int n) {
	int r = 0;
	while (!isPrime[n++])
	    r++;
	return r;
    }
}