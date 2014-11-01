import java.util.Arrays;
import java.util.Scanner;

public class No_to_Palindromes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		int maxChar = in.nextInt();
		String s = in.next();
		int intValue = getIntValue(s, maxChar);
		boolean isChanged = false;
		do {
			intValue++;
			isChanged = true;
			s = getString(intValue, length, maxChar);
		} while (!isValid(s) && intValue < (Math.pow(maxChar, length) - 1));
		if (isValid(s) && isChanged && intValue < (Math.pow(maxChar, length))) {
			System.out.println(s);
		} else
			System.out.println("NO");
		
		while (true) {
			s = in.next();
			System.out.println(getIntValue(s, maxChar));
		}
	}

	private static String getString(int intValue, int length, int maxChar) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char c = (char) (intValue % maxChar + 'a');
			intValue /= maxChar;
			s.insert(0, c);
		}
		return s.toString();
	}

	private static int getIntValue(String s, int maxChar) {
		int stringValue = 0;
		for (int i = 0; i < s.length(); i++) {
			stringValue = stringValue * maxChar + (int) (s.charAt(i) - 'a');
		}
		return stringValue;
	}

	private static boolean isValid(String x) {
		if (x.length() > 2) {
			for (int i = 0; i + 2 < x.length(); i++) {
				if (x.charAt(i) == x.charAt(i + 1)
						|| x.charAt(i) == x.charAt(i + 2))
					return false;
			}
		}
		if (x.length() > 1)
			if (x.charAt(x.length() - 2) == x.charAt(x.length() - 1))
				return false;

		return true;
	}

}
