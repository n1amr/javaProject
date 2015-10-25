import java.util.Scanner;

public class _404A_Valera_and_X {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	char[][] a = new char[n][n];
	for (int i = 0; i < n; i++)
	    a[i] = in.next().toCharArray();

	if (ans(a))
	    System.out.println("YES");
	else
	    System.out.println("NO");
    }

    static boolean ans(char[][] a) {
	int n = a.length;
	char c1 = a[0][0], c2 = a[1][0];
	if (c1 == c2)
	    return false;
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < n; j++)
		if (i == j || i == n - 1 - j) {
		    if (a[i][j] != c1)
			return false;
		} else if (a[i][j] != c2)
		    return false;
	return true;
    }
}
