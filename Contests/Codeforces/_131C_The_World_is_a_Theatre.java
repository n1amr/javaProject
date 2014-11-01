import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.PortableInterceptor.INACTIVE;

public class _131C_The_World_is_a_Theatre {
	static BigInteger TWO = new BigInteger("2");

	static BigInteger factorial(BigInteger n) {
		if (n.compareTo(TWO) < 0)
			return BigInteger.ONE;
		return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}

	static BigInteger cmb(BigInteger n, BigInteger r) {
		return factorial(n).divide(
				factorial(n.subtract(r)).multiply(factorial(r)));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger nBoys = new BigInteger(in.next());
		BigInteger nGirls = new BigInteger(in.next());
		BigInteger nActors = new BigInteger(in.next());
		BigInteger r = BigInteger.ZERO;
		for (BigInteger girls = nGirls; girls.compareTo(BigInteger.ZERO) > 0; girls = girls
				.subtract(BigInteger.ONE)) {
			BigInteger boys = nActors.subtract(girls);
			if (boys.compareTo(new BigInteger("4")) < 0)
				continue;
			r = r.add(cmb(nGirls, girls).multiply(cmb(nBoys, boys)));
			System.err.println(r);
		}
		System.out.println(r);
	}
}
