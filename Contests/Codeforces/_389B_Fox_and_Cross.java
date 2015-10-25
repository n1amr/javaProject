import java.util.Scanner;

public class _389B_Fox_and_Cross {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int c = 0;
	boolean[][] g = new boolean[n][n];
	for (int i = 0; i < n; i++) {
	    String l = in.next();
	    for (int j = 0; j < l.length(); j++)
		if (l.charAt(j) == '#') {
		    g[i][j] = true;
		    c++;
		}
	}
	if (g[0][0] || g[n - 1][0] || g[0][n - 1] || g[n - 1][n - 1])
	    System.out.println("NO");
	else {
	    for (int i = 1; i < g.length - 1; i++)
		for (int j = 1; j < g.length - 1; j++)
		    if (g[i][j] && g[i - 1][j] && g[i + 1][j] && g[i][j - 1] && g[i][j + 1]) {
			g[i][j] = g[i - 1][j] = g[i + 1][j] = g[i][j - 1] = g[i][j + 1] = false;
			c -= 5;
		    }
	    if (c != 0)
		System.out.println("NO");
	    else
		System.out.println("YES");
	}
    }
}
