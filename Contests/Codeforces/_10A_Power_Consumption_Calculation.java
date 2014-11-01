import java.io.FileNotFoundException;
import java.util.*;

public class _10A_Power_Consumption_Calculation {
    public static void main(String[] args) throws FileNotFoundException {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int P1 = in.nextInt();
	int P2 = in.nextInt();
	int P3 = in.nextInt();
	int T1 = in.nextInt();
	int T2 = in.nextInt();
	int r = 0;

	int start, end, lastEnd = -1;
	for (int i = 0; i < n; i++) {
	    start = in.nextInt();
	    end = in.nextInt();

	    r += (end - start) * P1;
	    if (lastEnd == -1) {
		lastEnd = end;
		continue;
	    }
	    int d = start - lastEnd;
	    r += P1 * (d > T1 ? T1 : d);
	    d -= T1;
	    r += P2 * (d > T2 ? T2 : d) * (d > 0 ? 1 : 0);
	    d -= T2;
	    r += P3 * (d > 0 ? d : 0) * (d > 0 ? 1 : 0);

	    lastEnd = end;
	}
	System.out.println(r);
    }
}
