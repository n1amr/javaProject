import java.util.*;

public class _518D_Ilya_and_Escalator {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	double p = in.nextDouble();
	int t = in.nextInt();

	double[][] DP = new double[t + 2][n + 2];
	DP[0][0] = 1;

	for (int i = 0; i < t + 1; i++)
	    for (int j = 0; j < n + 1; j++) {
		if (j == n)
		    DP[i + 1][j] += DP[i][j];
		else {
		    DP[i + 1][j + 1] += DP[i][j] * p;
		    DP[i + 1][j] += DP[i][j] * (1 - p);
		}
	    }
	double sum = 0;
	for (int i = 0; i <= n; i++)
	    sum += DP[t][i] * i;
	System.out.println(sum);
    }
}

/*
 * To solve this problem let's use dynamic programming. We will store
 * two-dimensional array z[][] with type double. In z[i][j] will store the
 * likelihood that after i seconds j people are on escalator.
 * 
 * In dynamic will be following transitions. If j = n, i. e. all n people
 * already on escalator then we make transition z[i + 1][j] +  = z[i][j]. Else,
 * or person number j go to escalator in i + 1 second, i. e.
 * z[i + 1][j + 1] +  = z[i][j] * p, or person number j stays on his place, i.
 * e. z[i + 1][j] +  = z[i][j] * (1 – p).
 */
