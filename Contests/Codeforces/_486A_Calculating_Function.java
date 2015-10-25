import java.util.Scanner;

public class _486A_Calculating_Function {
    public static void main(String[] args) {
	long n = new Scanner(System.in).nextLong();
	System.out.println((n + 1) / 2 * (n % 2 == 1 ? -1 : 1));
    }
}
