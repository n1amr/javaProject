import java.util.Scanner;

public class _144C_Anagram_Search {
	static int ns;
	static int np;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String p = in.nextLine();
		ns = s.length();
		np = p.length();
		int[] cp = countLetters(p);
		int[] cs = countLetters(s);
		int r = 0;

		for (int i = 0; i < ns - np + 1; i++) {
			if (isGood(cs, cp))
				r++;
			// System.out.println(s.substring(i, i + np));
			removeChar(cs, s.charAt(i));
			if (i + np < ns)
				addChar(cs, s.charAt(i + np));
		}
		System.out.println(r);
	}

	private static void removeChar(int[] cs, char c) {
		if (c != '?')
			cs[c - 'a']--;
		else
			cs[26]--;
	}

	private static void addChar(int[] cs, char c) {
		if (c != '?')
			cs[c - 'a']++;
		else
			cs[26]++;
	}

	private static boolean isGood(int[] cs, int[] cp) {
		boolean ans = true;
		int q = cs[26];
		for (int i = 0; i < 27; i++)
			if (cs[i] < cp[i])
				if (q >= cp[i] - cs[i])
					q -= cp[i] - cs[i];
				else {
					ans = false;
					break;
				}
		return ans;
	}

	static int[] countLetters(String str) {
		char[] s = str.toCharArray();
		int[] c = new int[27];

		for (int i = 0; i < np && i < ns; i++)
			if (s[i] == '?')
				c[26]++;
			else
				c[s[i] - 'a']++;
		return c;
	}
}
