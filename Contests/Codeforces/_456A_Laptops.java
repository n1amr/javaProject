import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _456A_Laptops {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Integer[][] a = new Integer[n][2];
		for (int i = 0; i < n; i++) {
			a[i][0] = in.nextInt();
			a[i][1] = in.nextInt();
		}
		Arrays.sort(a, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if (o1[0] == o2[0])
					return 0;
				return (o1[0] - o2[0]) / Math.abs(o1[0] - o2[0]);
			}
		});

		for (int i = 1; i < a.length; i++)
			if (a[i][1] < a[i - 1][1]) {
				System.out.println("Happy Alex");
				return;
			}
		System.out.println("Poor Alex");
	}
}
