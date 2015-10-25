import java.util.Arrays;
import java.util.Scanner;

public class _461A_Appleman_and_Toastman {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	long[] arr = new long[n];
	for (int i = 0; i < n; i++)
	    arr[i] = in.nextInt();

	Arrays.sort(arr);

	long t = -arr[arr.length - 1];
	for (int i = 0; i < arr.length; i++)
	    t += arr[i] * (i + 2);
	System.out.println(t);
    }
}
