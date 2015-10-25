import java.util.Scanner;

public class Secure_Password_System {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int T = in.nextInt();

	for (int i = 0; i < T; i++) {
	    int l = in.nextInt();
	    int r = in.nextInt();
	    long a = 0;
	    for (int j = l; j <= r; j++)
		a += Math.pow(10, j);
	    if (a > 1e6)
		System.out.println("YES");
	    else
		System.out.println("NO");
	}

    }
}
