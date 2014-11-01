import java.util.*;

public class _6A_Triangle {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] a = new int[4];
		for (int i = 0; i < 4; i++)
			a[i] = in.nextInt();
		int b = 0;
		Arrays.sort(a);
		if ((a[3] < a[2] + a[1]) || (a[2] < a[1] + a[0])) {
			b = 2;
		} else {
			for (int i = 0; i < 4; i++) { // Exclude
				for (int j = 0; j < 4; j++) { // Select
					if (i != j) {
						int s = 0;
						for (int k = 0; k < 4; k++)
							if (k != i && k != j)
								s += a[k];

						if (s == a[j])
							b = 1;
					}
				}
			}
		}
		System.out
				.println(new String[] { "IMPOSSIBLE", "SEGMENT", "TRIANGLE" }[b]);
	}
}
