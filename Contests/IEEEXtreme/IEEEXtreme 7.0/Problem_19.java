import java.util.ArrayList;
import java.util.Scanner;

public class Problem_19 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] str = input.next().split(" ");

		ArrayList<Integer> rceipts = new ArrayList<Integer>();
		String test;
		int s, y, a1;
		for (int i = 0; i < str.length / 2; i += 2) {
			test = str.toString()[]
		}
		while (input.nextLine() != null) {
			s = 0;
			test = input.next();
			if (test.length() == 8)
				test = "0" + test;
			for (int i = 0; i < test.length(); i++)
				s += Integer.parseInt(test.charAt(i) + "") * Math.pow(2, i);
			y = s % 11;
			a1 = Integer.parseInt(test.charAt(0) + "");
			if ((y == 10 && a1 == 0) || (y == a1))
				rceipts.add(Integer.parseInt(input.next()));
			else
				test = input.next();
		}
		int sum = 0;
		for (int i : rceipts)
			sum += i;
		System.out.println(sum);
	}
}