import java.util.Scanner;

public class Problem_B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String s = in.nextLine();
			int p = s.indexOf('R');
			String F = s.substring(1, p);

			int R_n = Integer.valueOf(s.substring(p + 1, s.length()));
			String ans = toLetters(R_n) + F;
			if (!ans.equals("0"))
				System.out.println(ans);
		}
	}

	private static String toLetters(long n) {
		StringBuilder builder = new StringBuilder();
		while (n > 0) {
			builder.insert(0, (char) ((n - 1) % 26 + 'A'));
			n = (n - 1) / 26;
		}
		return builder.toString();
	}
}
