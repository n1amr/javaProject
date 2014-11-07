import java.util.*;

public class _482A_Diverse_Permutation {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int k = in.nextInt();
	int l = 1;
	System.out.print(1 + " ");
	for (int i = 0; i < k; i++)
	    System.out.print((l += i % 2 == 0 ? k - i : -(k - i)) + " ");
	for (int i = k + 2; i <= n; i++)
	    System.out.print(i + " ");
    }
}