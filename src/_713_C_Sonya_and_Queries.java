import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _713_C_Sonya_and_Queries {
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
		solver.solve(1, in, out);
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
			TreeMap<Long, Integer> d = new TreeMap<>();

			for (int i = 0; i < n; i++) {
				String op = in.next();
				Long v = in.nextLong();
				Long p = 0L;
				while (v > 0) {
					p <<= 1;
					p += v % 2;
					v /= 10;
				}
				while (p > 0) {
					v <<= 1;
					v += p % 2;
					p >>= 1;
				}
				p = v;

				if (op.equals("?")) {
					out.println(d.get(p));
				} else {
					int c = op.equals("+") ? 1 : -1;
					if (d.containsKey(p))
						c += d.get(p);
					d.put(p, c);
				}
			}
		}
	}
}