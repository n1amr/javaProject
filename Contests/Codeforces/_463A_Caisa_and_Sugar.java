import java.util.Scanner;

public class _463A_Caisa_and_Sugar {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int s = in.nextInt();
	int max = -1;
	for (int i = 0; i < n; i++) {
	    int d = in.nextInt();
	    int c = in.nextInt();
	    if (s * 100 >= 100 * d + c) {
		int change = s * 100 - (100 * d + c);
		int candies = change % 100;
		max = Math.max(max, candies);
	    }
	}
	System.out.println(max);
    }
}
