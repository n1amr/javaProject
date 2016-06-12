import java.util.Scanner;

public class _318B_Strings_of_Power {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		long nHeavy = 0, c = 0;
		for (int i = 0; i < s.length() - 4; i++)
			if (s.substring(i, i + 5).equals("heavy"))
				nHeavy++;
			else if (s.substring(i, i + 5).equals("metal"))
				c += nHeavy;
		System.out.println(c);
	}
}