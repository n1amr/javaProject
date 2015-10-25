import java.util.Scanner;

public class _92B_Binary_Number {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	char[] s = in.nextLine().toCharArray();
	int r = 0;
	int i = s.length - 1;
	boolean simple = s[0] == '1';
	for (int j = 1; j < s.length; j++)
	    if (s[j] != '0') {
		simple = false;
		break;
	    }
	if (!simple) {
	    while (i >= 0) {
		if (i >= 0 && s[i] == '1') {
		    while (i >= 0 && s[i] == '1') {
			s[i] = '0';
			i--;
		    }
		    r++;
		    if (i > 0)
			s[i] = '1';
		    i++;
		}
		i--;
	    }
	    r += s.length;
	    if (s.length == 1)
		r = 1;
	} else
	    r = s.length - 1;
	System.out.println(r);
    }
}
