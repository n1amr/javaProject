import java.util.Scanner;

public class _408A_Line_to_Cashier {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int min = 1000000;
	int[] a = new int[n];
	for (int i = 0; i < n; i++)
	    a[i] = in.nextInt();
	for (int i = 0; i < n; i++) {
	    int s = 0;
	    for (int j = 0; j < a[i]; j++)
		s += in.nextInt() + 3;
	    min = Math.min(min, s);
	}
	System.out.println(min * 5);
    }
}
