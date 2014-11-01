import java.io.*;
import java.util.*;

public class _350C_Bombs {
    public static void main(String[] args) throws IOException {
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
		System.in)));
	PrintWriter out = new PrintWriter(new BufferedWriter(
		new OutputStreamWriter(System.out)));
	int n = in.nextInt();
	Point[] a = new Point[n];
	int r = 0;
	for (int i = 0; i < n; i++) {
	    a[i] = new Point(in.nextInt(), in.nextInt());
	    r += 2 * (2 + (a[i].x != 0 && a[i].y != 0 ? 1 : 0));
	}
	out.println(r);
	Arrays.sort(a);
	for (int i = 0; i < a.length; i++) {
	    int x = a[i].x;
	    int y = a[i].y;
	    if (x > 0)
		out.println("1 " + x + " R");
	    else if (x < 0)
		out.println("1 " + -x + " L");

	    if (y > 0)
		out.println("1 " + y + " U");
	    else if (y < 0)
		out.println("1 " + -y + " D");
	    out.println(2);

	    if (y > 0)
		out.println("1 " + y + " D");
	    else if (y < 0)
		out.println("1 " + -y + " U");

	    if (x > 0)
		out.println("1 " + x + " L");
	    else if (x < 0)
		out.println("1 " + -x + " R");

	    out.println(3);
	}
	out.close();
    }
}

class Point implements Comparable<Point> {
    public int x, y, d;

    public Point(int X, int Y) {
	x = X;
	y = Y;
	d = Math.abs(x) + Math.abs(y);
    }

    public int compareTo(Point o) {
	return d - o.d;
    }
}