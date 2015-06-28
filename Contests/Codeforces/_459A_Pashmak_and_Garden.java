import java.util.Scanner;

public class _459A_Pashmak_and_Garden {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int x1 = in.nextInt();
	int y1 = in.nextInt();
	int x2 = in.nextInt();
	int y2 = in.nextInt();

	int x3 = 0;
	int y3 = 0;
	int x4 = 0;
	int y4 = 0;

	boolean solFound = false;
	int length;
	if (x1 == x2) {
	    length = y2 - y1;
	    x3 = x1 + length;
	    y3 = y1;
	    x4 = x2 + length;
	    y4 = y2;
	    if (x3 > 1000) {
		x3 -= 2 * length;
		x4 -= 2 * length;
	    }
	    if (x3 >= -1000)
		solFound = true;
	} else if (y1 == y2) {
	    length = x2 - x1;
	    x3 = x1;
	    y3 = y1 + length;
	    x4 = x2;
	    y4 = y2 + length;
	    if (y3 > 1000) {
		y3 -= 2 * length;
		y4 -= 2 * length;
	    }
	    if (y3 >= -1000)
		solFound = true;
	} else if (Math.abs(x2 - x1) == Math.abs(y2 - y1)) {
	    length = x2 - x1;
	    x3 = x1;
	    y3 = y2;
	    x4 = x2;
	    y4 = y1;
	    solFound = true;
	}

	if (!solFound)
	    System.out.println(-1);
	else
	    System.out.println(x3 + " " + y3 + " " + x4 + " " + y4);
    }
}
