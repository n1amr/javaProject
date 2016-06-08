import java.util.ArrayList;
import java.util.Scanner;

public class _94A_Restoring_Password {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		ArrayList<String> p = new ArrayList<>(10);
		for (int i = 0; i < 10; i++)
			p.add(in.next());
		String ans = "";
		for (int i = 0; i < 8; i++)
			ans += "" + p.indexOf(s.substring(i * 10, (i + 1) * 10));
		System.out.println(ans);
	}
}
