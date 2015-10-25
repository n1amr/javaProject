import java.util.Scanner;

public class _478B_Random_Teams {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	long n = in.nextLong();
	long m = in.nextLong();
	long max = (n - m + 1) * (n - m) / 2;
	long o = n / m;
	long b = n % m;
	long a = m - b;
	long min = a * (o * (o - 1) / 2) + b * ((o + 1) * o / 2);
	System.out.println(min + " " + max);
    }
}
