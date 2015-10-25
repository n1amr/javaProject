import java.util.Scanner;

public class _282A_Bit_ {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int a = 0;
	for (int i = 0; i < n; i++)
	    if (in.next().charAt(1) == '+')
		a++;
	    else
		a--;
	System.out.println(a);
    }
}
