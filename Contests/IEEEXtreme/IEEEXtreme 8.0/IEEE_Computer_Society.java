import static java.lang.Math.max;

import java.util.Arrays;
import java.util.Scanner;

public class IEEE_Computer_Society {
    public static void main(String[] args) {
	mem = new int[2222][2222];
	for (int i = 0; i < 1000; i++) {
	    Arrays.fill(mem[i], -1);
	}
	String s = new Scanner(System.in).next();
	System.out.println(LC(s, 0, s.length() - 1));
    }

    static int[][] mem;

    private static int LC(String s, int i, int j) {
	if (i < 0 || i >= s.length() || j < 0 || j >= s.length())
	    return 0;
	if (mem[i][j] != -1)
	    return mem[i][j];
	if (i == j)
	    return 1;
	if (i > j)
	    return 0;
	if (s.charAt(i) == s.charAt(j))
	    return mem[i][j] = 2 + LC(s, i + 1, j - 1);
	int c1 = LC(s, i + 1, j);
	int c2 = LC(s, i, j - 1);
	return mem[i][j] = max(c1, c2);
    }
}