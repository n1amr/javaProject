import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _707_A_Brains_Photos {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		List<Character> colors = Arrays.asList(new Character[]{'C', 'M', 'Y'});
		boolean colored = false;

		for (int i = 0; i < n * m; i++)
			if (colors.contains(in.next().charAt(0)))
				colored = true;

		System.out.println(colored ? "#Color" : "#Black&White");
	}
}