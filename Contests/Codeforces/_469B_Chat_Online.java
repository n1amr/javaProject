import java.util.*;

public class _469B_Chat_Online {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int p = in.nextInt();
	int q = in.nextInt();
	int l = in.nextInt();
	int r = in.nextInt();
	int[] X = new int[1001];
	int[] Z = new int[1001];
	for (int i = 0; i < p; i++) {
	    int a = in.nextInt();
	    int b = in.nextInt();
	    for (int j = a; j <= b; j++)
		Z[j] = 1;
	}
	for (int i = 0; i < q; i++) {
	    int c = in.nextInt();
	    int d = in.nextInt();
	    for (int j = c; j <= d; j++)
		X[j] = 1;
	}
	int s = 0;
	for (int i = l; i <= r; i++)
	    for (int j = 0; i + j < Z.length; j++)
		if (Z[i + j] == 1 && X[j] == 1) {
		    s++;
		    break;
		}
	System.out.println(s);
    }
}
