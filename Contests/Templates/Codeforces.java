import java.util.Arrays;
import java.util.StringTokenizer;

public class Codeforces {
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
		void solve(int testNumber, Scanner in, PrintWriter out) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = in.nextInt();
			out.println(Arrays.toString(a));
		}
	}
}