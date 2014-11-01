import java.util.Scanner;

public class _448A_Rewards {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cups = 0;
		for (int i = 0; i < 3; i++) {
			int x = in.nextInt();
			cups += x;
		}
		int medals = 0;
		for (int i = 0; i < 3; i++) {
			int x = in.nextInt();
			medals += x;
		}
		int n = in.nextInt();
		double required = Math.ceil(cups / 5.0) + Math.ceil(medals / 10.0);
		if (n < required)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
}
