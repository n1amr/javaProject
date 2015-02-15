import java.io.*;
import java.util.*;

public class _514C_Watto_and_Mechanism {
    public static Scanner in = new Scanner(new BufferedReader(
	    new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(
	    new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws Exception {
	int n = in.nextInt();
	int m = in.nextInt();

	Trie mTrie = new Trie(2450000);

	for (int i = 0; i < n; i++)
	    mTrie.add(in.next().toCharArray());

	for (int i = 0; i < m; i++)
	    out.println(mTrie.find(in.next().toCharArray()) ? "YES" : "NO");

	out.close();
    }
}

class Trie {
    int[] n;
    int free = 4;

    public Trie(int size) {
	n = new int[size];
    }

    public void add(char[] c) {
	int p = 1;
	for (int i = 0; i < c.length; i++) {
	    int ind = p + c[i] - 97;
	    if (n[ind] == 0) {
		n[ind] = free;
		p = free;
		free += 4;
	    } else
		p = n[ind];
	}
	n[p + 3] = 1;
    }

    public boolean find(char[] c) {
	if (findrec(c, 0, 1, 0))
	    return true;
	return false;
    }

    private boolean findrec(char[] c, int cp, int np, int changed) {
	if (cp == c.length)
	    if (n[np + 3] == 1 && changed == 1)
		return true;
	    else
		return false;
	if (np == 0)
	    return false;
	for (int i = 97; i < 100; i++)
	    if (i == c[cp]) {
		if (findrec(c, cp + 1, n[np + i - 97], changed))
		    return true;
	    } else if (changed == 0)
		if (findrec(c, cp + 1, n[np + i - 97], 1))
		    return true;
	return false;
    }
}

// public class _514C_Watto_and_Mechanism {
// public static Scanner in = new Scanner(new BufferedReader(
// new InputStreamReader(System.in)));
// public static PrintWriter out = new PrintWriter(new BufferedWriter(
// new OutputStreamWriter(System.out)));
//
// static long p[] = new long[600001];
// static long mod = (long) (1e16 + 7);
//
// static long Hash(char[] s) {
// long ans = 0;
// for (int i = 0; i < s.length; i++)
// ans += (s[i] - 'a' + 1) * p[i] % mod;
// return ans;
// }
//
// public static void main(String[] args) throws Exception {
// int n = in.nextInt();
// int m = in.nextInt();
//
// p[0] = 1;
// for (int i = 1; i < p.length; i++)
// p[i] = p[i - 1] * 4 % mod;
// HashSet<Long> hashVals = new HashSet<Long>();
//
// for (int i = 0; i < n; i++) {
// hashVals.add(Hash(in.nextLine().toCharArray()));
// }
// for (int i = 0; i < m; i++) {
// char[] query = in.nextLine().toCharArray();
// long val = Hash(query);
// boolean found = false;
// loop: for (int j = 0; j < query.length; j++) {
// long tempVal = val - (query[j] - 'a' + 1) * p[j] % mod;
// for (int k = 0; k < 3; k++)
// if (query[j] - 'a' != k)
// if (hashVals.contains(tempVal + (k + 1) * p[j] % mod)) {
// found = true;
// break loop;
// }
// }
// out.println(found ? "YES" : "NO");
// }
// out.close();
// }
// }