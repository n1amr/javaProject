import java.io.*;
import java.util.*;

public class _570_A_Elections {
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static void main(String[] args) {
		int nCandidates = in.nextInt();
		int nCities = in.nextInt();
		int[] a = new int[nCandidates];
		for (int j = 0; j < nCities; j++) {
			int winner = 0;
			int votes = in.nextInt();
			for (int i = 1; i < nCandidates; i++) {
				int t = in.nextInt();
				if (t > votes) {
					votes = t;
					winner = i;
				}
			}
			a[winner]++;
		}
		int winner = 0;
		for (int i = 1; i < nCandidates; i++)
			if (a[i] > a[winner])
				winner = i;

		out.println(winner + 1);
		out.close();
	}
}
