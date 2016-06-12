import java.util.Scanner;

public class _332A_Down_the_Hatch_ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		char[] a = in.next().toCharArray();
		int r = 0;
		for (int i = 0; i < a.length; i += n)
			if (i - 3 >= 0 && a[i - 1] == a[i - 2] && a[i - 2] == a[i - 3])
				r++;
		System.out.println(r);
	}
}
