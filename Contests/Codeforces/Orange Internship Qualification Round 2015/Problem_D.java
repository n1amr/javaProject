import java.util.Scanner;

public class Problem_D {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int T = in.nextInt();
	for (int test = 0; test < T; test++) {
	    int n = in.nextInt();
	    boolean[] a = new boolean[n];
	    for (int i = 1; i < n + 1; i++) {
		for (int j = 0; j < a.length; j++) {
		    if ((j + 1) % i == 0) {
			a[j] ^= true;
		    }
		}
	    }

	    int s = 0;
	    for (int i = 0; i < a.length; i++) {
		if (a[i])
		    s++;
	    }
	    System.out.println(s);

	}

    }
}
