import java.util.*;

public class _152A_Marks {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int m = in.nextInt();
	in.nextLine();
	char[][] g = new char[n][m];
	boolean[] s = new boolean[n];
	for (int i = 0; i < n; i++)
	    g[i] = in.nextLine().toCharArray();
	for (int j = 0; j < m; j++) {
	    int max = '0';
	    for (int i = 0; i < n; i++)
		if (max < g[i][j])
		    max = g[i][j];
	    for (int i = 0; i < n; i++)
		if (max == g[i][j])
		    s[i] = true;
	}
	int r = 0;
	for (int i = 0; i < n; i++)
	    if (s[i])
		r++;
	System.out.println(r);
    }
}
