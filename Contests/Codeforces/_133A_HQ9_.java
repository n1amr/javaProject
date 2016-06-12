import java.util.Scanner;

public class _133A_HQ9_ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		if (s.contains("H") || s.contains("Q") || s.contains("9"))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
