import java.util.Scanner;

public class _437C_The_Child_and_Toy {
    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int m = in.nextInt();
	int[] v = new int[n];
	for (int i = 0; i < n; i++)
	    v[i] = in.nextInt();
	int r = 0;
	for (int i = 0; i < m; i++) {
	    int a = in.nextInt() - 1;
	    int b = in.nextInt() - 1;
	    r += Math.min(v[a], v[b]);
	}
	System.out.println(r);
    }
}