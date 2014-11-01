import java.util.*;

public class _122B_Lucky_Substring {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String s = in.nextLine();
	int n4 = 0, n7 = 0;
	for (int i = 0; i < s.length(); i++)
	    if (s.charAt(i) == '4')
		n4++;
	    else if (s.charAt(i) == '7')
		n7++;
	if (n4 == 0 && n7 == 0)
	    System.out.println(-1);
	else if (n7 > n4)
	    System.out.println(7);
	else if (n4 >= n7)
	    System.out.println(4);
    }
}
