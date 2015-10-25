import java.util.Scanner;

public class _509A_Maximum_in_Table {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	int n = in.nextInt();
	int[][] a = new int[n][n];
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < n; j++)
		if (i == 0 || j == 0)
		    a[i][j] = 1;
		else
		    a[i][j] = a[i - 1][j] + a[i][j - 1];
	System.out.println(a[n - 1][n - 1]);
    }
}
