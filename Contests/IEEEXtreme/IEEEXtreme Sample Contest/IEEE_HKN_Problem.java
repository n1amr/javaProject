import java.util.*;

public class IEEE_HKN_Problem {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String input = in.nextLine();
	input = input.replace(',', ' ');
	in = new Scanner(input);
	long a = in.nextLong();
	long b = in.nextLong();
	long r = indexOf(b) - indexOf(a);
	if (isPalindrome(a))
	    r++;
	System.out.println(r);
	// System.err.println(indexOf(a));
	// System.err.println(indexOf(b));
    }

    static int indexOf(long n) {
	if (n > 8) {
	    int r = 2;

	    String num = Long.toBinaryString(n);
	    String half = num.substring(0, num.length() / 2);
	    String reversedHalf = new StringBuilder(half).reverse().toString();

	    long editedNumber;

	    if (num.length() % 2 == 0)
		editedNumber = Long.valueOf(half + reversedHalf, 2);
	    else
		editedNumber = Long.valueOf(half + num.charAt(num.length() / 2)
			+ reversedHalf, 2);

	    // smaller number
	    if (n < editedNumber)
		r--;

	    long len = half.length();
	    // number of elements in a sector = 3 * (2 ^ (half.length - 1));
	    long elementsInLastSector = 1 << len - 1;

	    // add previous sectors
	    for (long i = 1; i < len; i++)
		r += 3 * (1 << i - 1);

	    // get index in current section
	    if (num.length() % 2 == 0)
		r += Long.valueOf(half.substring(1), 2) + 1;
	    else if (num.length() % 2 == 1
		    && num.charAt(num.length() / 2) == '0') {
		r += elementsInLastSector;
		r += Long.valueOf(half.substring(1), 2) * 2 + 1;
	    } else if (num.length() % 2 == 1
		    && num.charAt(num.length() / 2) == '1') {
		r += elementsInLastSector;
		r += Long.valueOf(half.substring(1), 2) * 2 + 1 + 1;
	    }
	    return r;
	} else {
	    int[] ans = new int[] { 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 };
	    return ans[(int) n];
	}
    }

    static boolean isPalindrome(long num) {
	if (num == 0)
	    return false;
	char[] c = Long.toBinaryString(num).toCharArray();
	int n = c.length / 2;
	for (int i = 0, j = c.length - 1; i < n && j >= 0; i++) {
	    if (c[i] != c[j])
		return false;
	    j--;
	}
	return true;
    }
}