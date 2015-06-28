import java.util.*;

public class _431B_Shower_Line {
    static int[][] g;

    static <lnteger> ArrayList<lnteger[]> permutations(lnteger[] arr) {
	final ArrayList<lnteger[]> resultList = new ArrayList<lnteger[]>();
	final int len = arr.length;
	if (len == 0)
	    return resultList;
	if (len == 1) {
	    resultList.add(arr);
	    return resultList;
	}

	lnteger[] subClone = Arrays.copyOf(arr, len - 1);
	System.arraycopy(arr, 1, subClone, 0, len - 1);

	for (int i = 0; i < len; ++i) {
	    lnteger e = arr[i];
	    if (i > 0)
		subClone[i - 1] = arr[0];
	    final ArrayList<lnteger[]> subPermutations = permutations(subClone);
	    for (lnteger[] sc : subPermutations) {
		lnteger[] clone = Arrays.copyOf(arr, len);
		clone[0] = e;
		System.arraycopy(sc, 0, clone, 1, len - 1);
		resultList.add(clone);
	    }
	    if (i > 0)
		subClone[i - 1] = e;
	}
	return resultList;
    }

    public static void main(String[] args) {

	Scanner in = new Scanner(System.in);
	g = new int[5][5];
	for (int i = 0; i < 5; i++)
	    for (int j = 0; j < 5; j++)
		g[i][j] = in.nextInt();
	in.close();

	int max = 0;
	Integer[] a = new Integer[] { 0, 1, 2, 3, 4 };
	ArrayList<Integer[]> ss = permutations(a);
	for (Integer[] v : ss) {
	    max = Math.max(max, calcG(v));
	}
	System.out.println(max);
    }

    private static int calcG(Integer[] a) {
	int r = 0;

	// 01234
	r = g[a[0]][a[1]] + g[a[1]][a[0]];
	r += g[a[2]][a[3]] + g[a[3]][a[2]];
	// 1234
	r += g[a[1]][a[2]] + g[a[2]][a[1]];
	r += g[a[3]][a[4]] + g[a[4]][a[3]];
	// 234
	r += g[a[2]][a[3]] + g[a[3]][a[2]];
	// 34
	r += g[a[3]][a[4]] + g[a[4]][a[3]];

	return r;
    }
}
