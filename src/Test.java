public class Test {
    public static void main(String[] args) {

	for (int a = 1; a < 10; a++)
	    for (int b = 0; b < 10; b++)
		for (int c = 0; c < 10; c++)
		    for (int d = 0; d < 10; d++) {
			int n = d + 10 * (c + 10 * (b + 10 * a));
			int x = (int) (Math.pow(a, b) * Math.pow(c, d));
			if (n == x)
			    System.out.println(x);
		    }

    }
}
