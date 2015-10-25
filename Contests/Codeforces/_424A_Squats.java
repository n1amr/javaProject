import java.util.Scanner;

public class _424A_Squats {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	char[] c = in.next().toCharArray();
	int s = 0;
	for (int i = 0; i < n; i++)
	    if (c[i] == 'x')
		s++;

	int r = 0;
	int i = 0;
	while (s < n / 2) {
	    if (c[i] == 'X') {
		c[i] = 'x';
		r++;
		s++;
	    }
	    i++;
	}
	while (s > n / 2) {
	    if (c[i] == 'x') {
		c[i] = 'X';
		r++;
		s--;
	    }
	    i++;
	}
	System.out.println(r);
	System.out.println(new String(c));
    }
}
