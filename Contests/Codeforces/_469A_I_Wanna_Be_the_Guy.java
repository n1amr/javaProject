import java.util.Scanner;

public class _469A_I_Wanna_Be_the_Guy {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	boolean[] b = new boolean[n];
	for (int j = 0; j < 2; j++)
	    for (int i = 0, p = in.nextInt(); i < p; i++)
		b[in.nextInt() - 1] = true;
	String ans = "I become the guy.";
	for (int i = 0; i < n; i++)
	    if (!b[i])
		ans = "Oh, my keyboard!";
	System.out.println(ans);
    }
}
