import java.util.*;

public class _460B_Little_Dima_and_Equation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		ArrayList<Long> v = new ArrayList<Long>();
		for (int i = 1; i < 9 * 9 + 1; i++) {
			Long RHS = 1L;
			for (int j = 0; j < a; j++) {
				RHS *= i;
			}
			RHS = b * RHS + c;
			if (i == sumDigits(RHS) && RHS < 1E9) {
				v.add(RHS);
			}
		}
		Collections.sort(v);
		System.out.println(v.size());
		for (int i = 0; i < v.size(); i++) {
			System.out.print(v.get(i) + " ");
		}
	}

	private static int sumDigits(Long n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
}
