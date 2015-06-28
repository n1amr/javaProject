import java.util.*;

public class _471A_MUH_and_Sticks {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = 6;
	int[] a = new int[9];
	for (int i = 0; i < n; i++)
	    a[in.nextInt() - 1]++;
	int[] c = new int[6];
	int p = 0;
	boolean have4 = false;
	boolean morethan4 = false;
	for (int i = 0; i < 9; i++) {
	    if (a[i] != 0) {
		c[p++] = a[i];
		if (a[i] == 4) {
		    have4 = true;
		}
		if (a[i] > 4) {
		    have4 = true;
		    morethan4 = true;
		}
	    }
	}
	if (p > 3 || !have4) {
	    System.out.println("Alien");
	} else if ((!morethan4 && c[2] == 0) || (c[1] == 0)) {
	    System.out.println("Elephant");
	} else {
	    System.out.println("Bear");
	}
    }
}
