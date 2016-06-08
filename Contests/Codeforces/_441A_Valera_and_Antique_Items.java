import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _441A_Valera_and_Antique_Items {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int v = in.nextInt();

		Set<Integer> sellers = new TreeSet<Integer>();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			for (int j = 0; j < a[i]; j++) {
				int item = in.nextInt();
				if (v > item)
					sellers.add(i + 1);
			}

		}
		System.out.println(sellers.size());
		for (Integer s : sellers)
			System.out.print(s + " ");
		System.out.println();
	}
}
