import java.util.*;

public class _476A_Dreamoon_and_Stairs {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int m = in.nextInt();
	int l = (n + 1) / 2;
	int ans = 0;
	while (ans < l)
	    ans += m;
	System.out.println(ans <= n ? ans : -1);
    }
}
