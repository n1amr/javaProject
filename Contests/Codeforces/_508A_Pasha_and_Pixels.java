import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _508A_Pasha_and_Pixels {

    public static void main(String[] args) {
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	int n = in.nextInt();
	int m = in.nextInt();
	int k = in.nextInt();
	boolean[][] a = new boolean[n + 2][m + 2];
	int ans = 0;
	for (int i = 0; i < k; i++) {
	    int x = in.nextInt();
	    int y = in.nextInt();
	    a[x][y] = true;
	    if (ans == 0 && (a[x + 1][y] && a[x][y + 1] && a[x + 1][y + 1]
		    || a[x - 1][y] && a[x][y + 1] && a[x - 1][y + 1] || a[x + 1][y] && a[x][y - 1] && a[x + 1][y - 1]
		    || a[x - 1][y] && a[x][y - 1] && a[x - 1][y - 1]))
		ans = i + 1;
	}
	System.out.println(ans);
    }

}
