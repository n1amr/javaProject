import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _78A_Haiku {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String ans = "YES";
		Set v = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		for (int j = 0; j < 3; j++) {
			String s = in.nextLine();
			int n = 0;
			for (int i = 0; i < s.length(); i++)
				if (v.contains(s.charAt(i)))
					n++;
			if (j != 1 && n != 5 || j == 1 && n != 7)
				ans = "NO";
		}
		System.out.println(ans);
	}
}
