public class Trie {
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
