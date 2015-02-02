import java.io.*;
import java.util.*;

public class _507A_Amr_and_Music {
    public static void main(String[] args) throws IOException {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int k = in.nextInt();
	Node[] a = new Node[n];
	for (int i = 0; i < n; i++)
	    a[i] = new Node(in.nextInt(), i + 1);
	String ans = "";
	int c = 0;
	Arrays.sort(a);
	for (int i = 0; i < n; i++)
	    if (k >= a[i].a) {
		ans = a[i].i + " " + ans;
		c++;
		k -= a[i].a;
	    }
	System.out.println(c);
	if (c != 0)
	    System.out.println(ans);
    }
}

class Node implements Comparable<Node> {
    public int a, i;

    public Node(int a, int i) {
	this.a = a;
	this.i = i;
    }

    public int compareTo(Node o) {
	return Integer.compare(a, o.a);
    }
}
