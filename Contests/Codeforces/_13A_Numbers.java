import java.util.Scanner;

public class _13A_Numbers {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int sum = 0;
	for (int i = 2; i < n; i++)
	    sum += sumOfDigits(n, i);
	n -= 2;
	int g = gcd(sum, n);
	System.out.println(sum / g + "/" + n / g);
    }

    static int sumOfDigits(int n, int radix) {
	int sum = 0;
	while (n > 0) {
	    sum += n % radix;
	    n /= radix;
	}
	return sum;
    }

    static int gcd(int a, int b) {
	if (b == 0)
	    return a;
	return gcd(b, a % b);
    }
}
