import java.util.Arrays;
import java.util.Scanner;

public class _451B_Sort_the_Array {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int[] a = new int[n];
	for (int i = 0; i < n; i++)
	    a[i] = in.nextInt();
	int low = 0, high = 0;
	for (int i = 1; i < a.length; i++)
	    if (a[i - 1] > a[i]) {
		low = i - 1;
		while (i < a.length && a[i - 1] > a[i])
		    i++;
		high = i - 1;
	    }
	if (isSortedExcept(a, low, high)) {
	    System.out.println("yes");
	    System.out.println(low + 1 + " " + (high + 1));
	} else
	    System.out.println("no");

    }

    private static boolean isSortedExcept(int[] a, int low, int high) {
	boolean ans = isSorted(Arrays.copyOfRange(a, 0, low)) && isSorted(Arrays.copyOfRange(a, high + 1, a.length));
	if (low > 0)
	    ans = ans && a[high] >= a[low - 1];
	if (high + 1 < a.length)
	    ans = ans && a[low] <= a[high + 1];
	return ans;
    }

    private static boolean isSorted(int[] a) {
	for (int i = 1; i < a.length; i++)
	    if (a[i] < a[i - 1])
		return false;
	return true;
    }

}
