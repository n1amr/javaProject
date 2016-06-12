import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;


public class Problem_AS {
	boolean[] taken = new boolean[21];

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		ArrayDeque<String> bfs = new ArrayDeque<String>();
		TreeMap<String, String> blocks = new TreeMap<String, String>();
		String distination = input.next();
		ArrayList<String> str = new ArrayList<String>();

		String s1 = "", s2 = "";
		ArrayList<String> parent = new ArrayList<String>();
		ArrayList<String> child = new ArrayList<String>();

		while (true) {
			s1 = input.next();
			s2 = input.next();
			if (s1.equals("A") && s2.equals("A"))
				break;
			parent.add(s1);
			child.add(s2);
			if (!blocks.containsKey(s1)) {
				str.add(s1);
				blocks.put(s1, s2);
			} else
				blocks.put(s1, s2 + blocks.get(s1));
		}
		for (String i : str)
			System.out.println(i + " " + blocks.get(i));
		String sb = distination;
		for (int i = 0; i < str.size(); i++) {
			if (blocks.get(str.get(i)) == distination) {
				sb += str.get(i);
				distination = str.get(i);
				i = 0;
			}
		}
		System.out.println(sb);
	}

	private static void bfs(String s1, String s2) {

	}


}
