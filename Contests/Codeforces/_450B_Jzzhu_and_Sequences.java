import java.util.Scanner;

public class _450B_Jzzhu_and_Sequences {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	long x = in.nextLong();
	long y = in.nextLong();
	long n = in.nextLong() - 1;

	long[] a = new long[6];
	a[0] = x;
	a[1] = y;
	for (int i = 2; i < 6; i++)
	    a[i] = a[i - 1] - a[i - 2];
	long MAX = 1000000007;
	long r = (a[(int) n % 6] % MAX + MAX) % MAX;
	System.out.println(r);
    }
}
