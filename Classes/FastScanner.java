import java.io.*;
import java.util.*;

public class FastScanner {
	BufferedReader bf;
	StringTokenizer st;

	FastScanner(BufferedReader bf) {
		this.bf = bf;
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(bf.readLine(), " :");
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	int[] readIntArray(int n) throws IOException {
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	long[] readLongArray(int n) throws IOException {
		long a[] = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nextLong();
		return a;
	}
}
