import java.util.Scanner;
import java.util.Stack;

public class _448B_Suffix_Structures {
	static int[] countS;
	static int[] countT;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String t = in.next();
		countS = countLetters(s);
		countT = countLetters(t);

		if (needTree())
			System.out.println("need tree");
		else if (solvedByAutomaton(s, t))
			System.out.println("automaton");
		else if (solvedByArray())
			System.out.println("array");
		else
			System.out.println("both");
	}

	private static boolean needTree() {
		for (int i = 0; i < countT.length; i++)
			if (countS[i] < countT[i])
				return true;
		return false;
	}

	private static boolean solvedByArray() {
		for (int i = 0; i < countT.length; i++)
			if (countS[i] != countT[i])
				return false;
		return true;
	}

	private static boolean solvedByAutomaton(String s, String t) {
		Stack<Character> stack = new Stack<>();
		for (int k = t.length() - 1; k >= 0; k--)
			stack.push(t.charAt(k));

		for (int k = 0; k < s.length() && !stack.isEmpty(); k++)
			if (s.charAt(k) == stack.peek())
				stack.pop();

		return stack.isEmpty();
	}

	private static int[] countLetters(String s) {
		int[] cnt = new int[26];
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++)
			cnt[s.charAt(i) - 'a']++;
		return cnt;
	}
}
