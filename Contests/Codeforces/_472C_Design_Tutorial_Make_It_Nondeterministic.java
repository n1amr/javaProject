import java.util.Scanner;

public class _472C_Design_Tutorial_Make_It_Nondeterministic {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] f = new String[n];
		String[] s = new String[n];
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			f[i] = in.next();
			s[i] = in.next();
		}
		for (int i = 0; i < n; i++)
			p[i] = in.nextInt() - 1;
		String lastOne = "";
		for (int i = 0; i < n; i++) {
			String first = f[p[i]];
			String last = s[p[i]];
			String selected = first;
			if (selected.compareTo(lastOne) < 0 || last.compareTo(first) < 0 && last.compareTo(lastOne) > 0)
				selected = last;
			if (lastOne.compareTo(selected) > 0) {
				System.out.println("NO");
				return;
			}
			lastOne = selected;
		}
		System.out.println("YES");
	}
}
