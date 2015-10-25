import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _118A_String_Task {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String s = in.next().toLowerCase();
	List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');
	for (int i = 0; i < s.length(); i++)
	    if (!vowels.contains(s.charAt(i)))
		System.out.print("." + s.charAt(i));
    }
}
