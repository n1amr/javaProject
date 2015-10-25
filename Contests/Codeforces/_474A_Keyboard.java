import java.util.Scanner;

public class _474A_Keyboard {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextLine().equals("L") ? 1 : -1;
	String s = in.nextLine();
	for (String k : new String[] { "qwertyuiop", "asdfghjkl;", "zxcvbnm,./" })
	    for (int i = n == 1 ? 8 : 1; i >= 0 && i < 10; i -= n)
		s = s.replace(k.charAt(i), k.charAt(i + n));
	System.out.println(s);
    }
}
