import java.io.*;
import java.util.*;

public class _414A_Mashmokh_and_Numbers {
	static ArrayList<Boolean> primeFlags = new ArrayList<>(Arrays.asList(false,
			false));

	public static boolean isPrime(int n) {
		int initSize = primeFlags.size();
		for (int i = 0; i < n + 1 - initSize; i++)
			primeFlags.add(true);
		if (n >= initSize)
			for (int i = 2; i <= n; i++)
				if (primeFlags.get(i) == true)
					for (int j = 2 * i; j <= n; j += i)
						primeFlags.set(j, false);
		return primeFlags.get(n);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		isPrime(1300000);
		int n = in.nextInt();
		int k = in.nextInt();
		if (n == 1 && k == 0) {
			System.out.println(1);
		} else {
			k = k - n / 2 + 1;
			if (k > 0 && n > 1) {
				System.out.print(2 * k + " " + 3 * k + " ");
				for (int i = 5; i < primeFlags.size() && n > 2; i++) {
					if (primeFlags.get(i)) {
						n--;
						System.out.print(i + " ");
					}
				}
			} else {
				System.out.println(-1);
			}
		}
	}
}
