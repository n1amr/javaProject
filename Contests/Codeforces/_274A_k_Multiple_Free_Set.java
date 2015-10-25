import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _274A_k_Multiple_Free_Set {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int k = in.nextInt();
	List<Integer> a = new ArrayList<>();
	for (int i = 0; i < n; i++)
	    a.add(in.nextInt());
	Set<Integer> b = new TreeSet<>();
	Collections.sort(a);
	for (int x : a)
	    if (x % k != 0 || !b.contains(x / k))
		b.add(x);
	System.out.println(b.size());
    }
}
