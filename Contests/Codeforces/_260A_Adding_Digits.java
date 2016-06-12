import java.util.Scanner;

public class _260A_Adding_Digits {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int n = in.nextInt();
		int d = 0;
		for (; d < 10; d++)
			if ((a * 10 + d) % b == 0)
				break;
		if (d < 10) {
			System.out.print(a + "" + d);
			for (int i = 0; i < n - 1; i++)
				System.out.print('0');
		} else
			System.out.println(-1);
	}

}
