import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MatchingSets {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 0; i < n; i++)
			a.add(in.nextInt());

		ArrayList<Integer> b = new ArrayList<>();
		for (int i = 0; i < n; i++)
			b.add(in.nextInt());

		Collections.sort(a);
		Collections.sort(b);

		int pos = 0;
		int neg = 0;

		for (int i = 0; i < n; i++) {
			int diff = a.get(i) - b.get(i);
			if (diff < 0)
				neg += diff;
			else
				pos += diff;
		}

		if (pos + neg == 0)
			System.out.println(pos);
		else
			System.out.println(-1);
	}
}