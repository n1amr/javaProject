import java.io.*;
import java.util.StringTokenizer;

public class _474_D_Flowers {
	public static void main(String[] args) throws Exception {
		InputStream inputStream =
			(args.length <= 0) ?
				System.in : new FileInputStream(args[0]);
		OutputStream outputStream =
			(args.length <= 1) ?
				System.out : new FileOutputStream(args[1]);
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Solver solver = new Solver();
		if (args.length == 0)
			solver.solve(1, in, out);
		else {
			int T = in.nextInt();
			for (int t = 1; t <= T; t++) {
				out.println("Case " + t + ":");
				solver.solve(t, in, out);
			}
		}

		out.close();
	}

	static class Scanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public Scanner(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}

	static class Solver {
		static final int MAX = 100005;
		static final int MOD = 1000000007;

		void solve(int testNumber, Scanner in, PrintWriter out) {
			int n = in.nextInt();
			int k = in.nextInt();

			int[] ways = new int[MAX];
			for (int i = 0; i < k; i++)
				ways[i] = 1;
			for (int i = k; i < MAX; i++)
				ways[i] = add(ways[i - 1], ways[i - k]);

			int[] waysUp = new int[MAX];
			waysUp[0] = ways[0];
			for (int i = 1; i < MAX; i++)
				waysUp[i] = add(waysUp[i - 1], ways[i]);

			for (int i = 0; i < n; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				out.println(add(sub(waysUp[b], waysUp[a]), ways[a]));
			}
		}

		static int add(int a, int b) {
			return (int) (((long) a + (long) b) % MOD);
		}

		static int sub(int a, int b) {
			return fix(a - b);
		}

		static int fix(int a) {
			return (int) (((long) a % MOD + MOD) % MOD);
		}
	}
}
