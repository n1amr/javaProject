import java.util.*;

public class _472A_Design_Tutorial_Learn_from_Math {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	System.err.println("Welcome");
	int n = in.nextInt();
	if (n % 2 == 0)
	    System.out.println(4 + " " + (n - 4));
	else
	    System.out.println(9 + " " + (n - 9));
    }
}
