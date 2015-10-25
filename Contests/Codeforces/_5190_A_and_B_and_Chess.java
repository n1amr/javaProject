import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class _5190_A_and_B_and_Chess {
    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
	int White = 0, Black = 0;

	char[][] g = new char[8][8];
	for (int i = 0; i < 8; i++)
	    g[i] = in.next().toCharArray();
	int[] weights = new int[256];
	weights['q'] = 9;
	weights['r'] = 5;
	weights['b'] = 3;
	weights['n'] = 3;
	weights['p'] = 1;
	weights['k'] = 0;
	weights['.'] = 0;
	for (int i = 0; i < 8; i++)
	    for (int j = 0; j < 8; j++) {
		char c = g[i][j];
		if (c >= 'A' && c <= 'Z')
		    White += weights[c - 'A' + 'a'];
		else
		    Black += weights[c];
	    }

	if (White > Black)
	    System.out.println("White");
	else if (White == Black)
	    System.out.println("Draw");
	else
	    System.out.println("Black");
	out.close();
    }
}
