import java.util.Scanner;

public class _291B_Command_Line_Arguments {
    public static void main(String[] args) {
	String s = " " + new Scanner(System.in).nextLine() + " ";
	int r;
	for (int l = 0; l < s.length(); l++)
	    if (s.charAt(l) == '"') {
		r = s.indexOf('"', l + 1);
		System.out.printf("<%s>\n", s.substring(l + 1, r));
		l = r;
	    } else if (s.charAt(l) != ' ') {
		r = s.indexOf(' ', l);
		System.out.printf("<%s>\n", s.substring(l, r));
		l = r;
	    }
    }
}