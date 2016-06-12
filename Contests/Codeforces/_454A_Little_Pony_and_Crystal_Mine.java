import java.util.Scanner;

public class _454A_Little_Pony_and_Crystal_Mine {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int stars = n / 2;
		int diamonds = 1;

		while (stars > 0) {
			printRow(stars, diamonds);
			stars--;
			diamonds += 2;
		}
		while (diamonds > 0) {
			printRow(stars, diamonds);
			stars++;
			diamonds -= 2;
		}
	}

	private static void printRow(int stars, int diamonds) {
		for (int i = 0; i < stars; i++)
			System.out.print('*');
		for (int i = 0; i < diamonds; i++)
			System.out.print('D');
		for (int i = 0; i < stars; i++)
			System.out.print('*');
		System.out.println();
	}
}
