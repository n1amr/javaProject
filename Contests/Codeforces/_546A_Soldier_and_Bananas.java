import java.util.Scanner;

public class _546A_Soldier_and_Bananas {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int k = in.nextInt();
		int n = in.nextInt();
		int w = in.nextInt();

		System.out.println(Math.max(0, k * w * (w + 1) / 2 - n));
	}
}
