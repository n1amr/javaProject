import java.util.Scanner;

public class _466B_Wonder_Room {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	long n = in.nextLong();
	long a = in.nextLong();
	long b = in.nextLong();

	boolean swapped = false;
	if (a > b) {
	    swapped = true;
	    long swap_temp = a;
	    a = b;
	    b = swap_temp;
	}

	long a0 = a, b0 = b;
	long na = 0, nb = 0;
	for (long i = a0 * b0; (a0 + na) * (b0 + nb) < 6 * n; i++) {
	    long diff = i - (a0 + na) * (b0 + nb);
	    if (diff > 0 && diff < a0 + na)
		nb++;
	    else if (diff > b0 + nb)
		na++;
	    System.out.println(i + ": " + (a0 + na) + " " + (b0 + nb));
	}
	a = a0 + na;
	b = b0 + nb;
	if (swapped) {
	    long swap_temp = a;
	    a = b;
	    b = swap_temp;
	}
	System.out.println(a * b);
	System.out.println(a + " " + b);

	// if (a * b < 6 * n) {
	// long diff = (6 * n) - (a * b);
	// if (diff % a == 0) {
	// b += diff / a;
	// } else if (diff % b == 0) {
	// a += diff / b;
	// } else {
	// s = a * b;
	// for (long i = 6 * n; i <= 1E9; i++) {
	// if (i % a == 0)
	// ;
	// }
	// }
	// }
	//
	// s = a * b;
	// System.out.println(s);
	// System.out.println(a + " " + b);
    }
}
