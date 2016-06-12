import java.util.Scanner;

public class _513A_Game {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] input = new int[4];
		for (int i = 0; i < 4; i++)
			input[i] = in.nextInt();
		if (input[0] > input[1])
			System.out.println("First");
		else
			System.out.println("Second");
	}
}
