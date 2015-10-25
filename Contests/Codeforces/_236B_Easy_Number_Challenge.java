import java.util.Scanner;

public class _236B_Easy_Number_Challenge {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int a = in.nextInt();
	int b = in.nextInt();
	int c = in.nextInt();

	int MAX = 1000001;
	int d[] = new int[MAX];

	for (int i = 1; i < MAX; i++)
	    for (int j = i; j < MAX; j += i)
		d[j]++;

	long r = 0;
	for (int i = 1; i <= a; i++)
	    for (int j = 1; j <= b; j++)
		for (int k = 1; k <= c; k++)
		    r += d[i * j * k];
	System.out.println(r % 1073741824);
    }
}
