import java.util.Scanner;
import java.util.TreeMap;

public class Problem_A {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int test = 0; test < T; test++) {
			int n = in.nextInt();

			TreeMap<Integer, Integer> inc = new TreeMap<Integer, Integer>();

			long max = 0;
			for (int i = 0; i < n; i++) {
				int up = in.nextInt();
				int down = in.nextInt();
				max = Math.max(max, down);

				if (inc.containsKey(up))
					inc.put(up, inc.get(up) + 1);
				else
					inc.put(up, 1);

				if (inc.containsKey(down))
					inc.put(down, inc.get(down) - 1);
				else
					inc.put(down, -1);
			}

			long c = 0;
			long cur = 0;

			Integer[] times = new Integer[inc.keySet().size()];
			times = inc.keySet().toArray(times);

			cur = inc.get(times[0]);
			for (int i = 1; i < times.length; i++) {
				if (cur > 0)
					c += times[i] - times[i - 1];
				cur += inc.get(times[i]);
			}

			System.out.println(c);

		}

	}
}
