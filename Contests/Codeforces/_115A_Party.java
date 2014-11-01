import java.util.*;

public class _115A_Party {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Employee[] a = new Employee[n];
		for (int i = 0; i < n; i++)
			a[i] = new Employee();
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			if (x != -1)
				a[i].parent=a[x - 1];
			else
				a[i].height = 1;
		}
		int maxHeight = 0;
		for (int i = 0; i < a.length; i++)
			maxHeight = Math.max(maxHeight, a[i].getHeight());
		System.out.println(maxHeight);
	}

	static class Employee {
		public int height = -1;
		public Employee parent = null;

		public int getHeight() {
			if (height != -1)
				return height;
			return 1 + parent.getHeight();
		}
	}
}
