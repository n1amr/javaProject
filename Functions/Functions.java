import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.util.*;
import java.util.List;

public class Functions {
    public String getHTTPResponse(HttpURLConnection con) {
	StringBuffer response = new StringBuffer();
	try {
	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    String inputLine;
	    while ((inputLine = in.readLine()) != null)
		response.append(inputLine);
	    in.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return response.toString();
    }

    static boolean[] isPrime;

    static void flagPrimes(int n) {
	isPrime = new boolean[n + 1];
	Arrays.fill(isPrime, 2, n, true);
	for (int i = 2; i <= n; i++)
	    if (isPrime[i])
		for (int j = 2 * i; j <= n; j += i)
		    isPrime[j] = false;
    }

    static long pow(long i, long n) {
	if (n == 1)
	    return i;
	long g = pow(i, n / 2);
	if (n % 2 == 0)
	    return g * g;
	return g * g * i;
    }

    static boolean isLess(Comparable v, Comparable w) {
	return v.compareTo(w) < 0;
    }

    static void swapInArray(Comparable[] a, int i, int j) {
	Comparable t = a[i];
	a[i] = a[j];
	a[j] = t;
    }

    static boolean isSorted(Comparable[] a) { // .GetSearchResultsFromGoogle
					      // whether the array
					      // entries are in order.
	for (int i = 1; i < a.length; i++)
	    if (isLess(a[i], a[i - 1]))
		return false;
	return true;
    }

    static double[][] matrixMultiply(int a[][], int b[][]) {
	int N = a.length;
	double[][] c = new double[N][N];
	for (int i = 0; i < N; i++)
	    for (int j = 0; j < N; j++)
		// column j.
		for (int k = 0; k < N; k++)
		    c[i][j] += a[i][k] * b[k][j];
	return c;
    }

    static void insertionSort(int[] list) {
	for (int i = 1; i < list.length; i++) {
	    int currentElement = list[i];
	    int k;
	    for (k = i; k > 0 && list[k - 1] > currentElement; k--)
		list[k] = list[k - 1];
	    list[k] = currentElement;
	}
    }

    static <T extends Comparable<T>> void insertionSort(T[] list) {
	for (int i = 1; i < list.length; i++) {
	    T currentElement = list[i];
	    int k;
	    for (k = i; k > 0 && list[k - 1].compareTo(currentElement) > 0; k--)
		list[k] = list[k - 1];
	    list[k] = currentElement;
	}
    }

    static void selectionSort(int[] list) {
	for (int i = 0; i < list.length; i++) {
	    int min = list[i], minIndex = i;
	    for (int j = i + 1; j < list.length; j++)
		if (min > list[j]) {
		    min = list[j];
		    minIndex = j;
		}

	    if (minIndex != i) {
		list[minIndex] = list[i];
		list[i] = min;
	    }
	}

    }

    static void shellSort(int[] a) {
	int N = a.length;

	// 3x+1 increment sequence: 1, 4, 13, 40, 121, 364, 1093, ...
	int h = 1;
	while (h < N / 3)
	    h = 3 * h + 1;
	h = 1;
	while (h >= 1) {
	    // h-sort the array (insertion)
	    for (int i = h; i < a.length; i++) {
		int currentElement = a[i];
		int j;
		for (j = i; j >= h && a[j - h] > currentElement; j -= h)
		    a[j] = a[j - h];
		a[j] = currentElement;
	    }
	    h /= 3;
	}
    }

    static class MergeSort {
	// stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
	private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
	    // copy to aux[]
	    for (int k = lo; k <= hi; k++)
		aux[k] = a[k];

	    // merge back to a[]
	    int i = lo, j = mid + 1;
	    for (int k = lo; k <= hi; k++)
		if (i > mid)
		    a[k] = aux[j++]; // this copying is unnecessary
		else if (j > hi)
		    a[k] = aux[i++];
		else if (aux[j] < aux[i])
		    a[k] = aux[j++];
		else
		    a[k] = aux[i++];
	}

	// mergesort a[lo..hi] using auxiliary array aux[lo..hi]
	private static void sort(int[] a, int[] aux, int lo, int hi) {
	    if (hi <= lo)
		return;
	    int mid = lo + (hi - lo) / 2;
	    sort(a, aux, lo, mid);
	    sort(a, aux, mid + 1, hi);
	    merge(a, aux, lo, mid, hi);
	}

	// Sort All
	public static void sort(int[] a) {
	    int[] aux = new int[a.length];
	    sort(a, aux, 0, a.length - 1);
	}
    }

    static class GenericMergeSort {
	// stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
	private static <T extends Comparable<T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
	    // copy to aux[]
	    for (int k = lo; k <= hi; k++)
		aux[k] = a[k];

	    // merge back to a[]
	    int i = lo, j = mid + 1;
	    for (int k = lo; k <= hi; k++)
		if (i > mid)
		    a[k] = aux[j++]; // this copying is unnecessary
		else if (j > hi)
		    a[k] = aux[i++];
		else if (aux[j].compareTo(aux[i]) < 0)
		    a[k] = aux[j++];
		else
		    a[k] = aux[i++];
	}

	// mergesort a[lo..hi] using auxiliary array aux[lo..hi]
	private static <T extends Comparable<T>> void sort(T[] a, T[] aux, int lo, int hi) {
	    if (hi <= lo)
		return;
	    int mid = lo + (hi - lo) / 2;
	    sort(a, aux, lo, mid);
	    sort(a, aux, mid + 1, hi);
	    merge(a, aux, lo, mid, hi);
	}

	// Sort All
	public static <T extends Comparable<T>> void sort(T[] a) {
	    T[] aux = a.clone();
	    sort(a, aux, 0, a.length - 1);
	}
    }

    public static class QuickSort {
	static Random random = new Random();

	public static void shuffle(Object[] a) {
	    int N = a.length;
	    for (int i = 0; i < N; i++) {
		int r = i + random.nextInt(N - i); // between i and N-1
		exch(a, i, r);
	    }
	}

	public static long sort(Comparable[] a) {
	    shuffle(a);
	    long t = System.currentTimeMillis();
	    sort(a, 0, a.length - 1);
	    return System.currentTimeMillis() - t;

	}

	// quicksort the subarray from a[lo] to a[hi]
	private static void sort(Comparable[] a, int lo, int hi) {
	    if (hi <= lo)
		return;
	    int j = partition(a, lo, hi);
	    sort(a, lo, j - 1);
	    sort(a, j + 1, hi);
	}

	// partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <=
	// a[j+1..hi]
	// and return the index j.
	private static int partition(Comparable[] a, int lo, int hi) {
	    int i = lo;
	    int j = hi + 1;
	    Comparable v = a[lo];
	    while (true) {
		// find item on lo to swap
		while (a[++i].compareTo(v) < 0)
		    if (i == hi)
			break;

		// find item on hi to swap
		while (v.compareTo(a[--j]) < 0)
		    if (j == lo)
			break; // redundant since a[lo] acts as sentinel

		// check if pointers cross
		if (i >= j)
		    break;

		exch(a, i, j);
	    }

	    // put partitioning item v at a[j]
	    exch(a, lo, j);

	    // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
	    return j;
	}

	private static void exch(Object[] a, int i, int j) {
	    Object swap = a[i];
	    a[i] = a[j];
	    a[j] = swap;
	}
    }

    public static class HeapSort {
	public static void sort(Comparable[] pq) {
	    int N = pq.length;
	    for (int k = N / 2; k >= 1; k--)
		sink(pq, k, N);
	    while (N > 1) {
		exch(pq, 1, N--);
		sink(pq, 1, N);
	    }
	}

	private static void sink(Comparable[] pq, int k, int N) {
	    while (2 * k <= N) {
		int j = 2 * k;
		if (j < N && less(pq, j, j + 1))
		    j++;
		if (!less(pq, k, j))
		    break;
		exch(pq, k, j);
		k = j;
	    }
	}

	private static boolean less(Comparable[] pq, int i, int j) {
	    return pq[i - 1].compareTo(pq[j - 1]) < 0;
	}

	private static void exch(Object[] pq, int i, int j) {
	    Object swap = pq[i - 1];
	    pq[i - 1] = pq[j - 1];
	    pq[j - 1] = swap;
	}

    }

    static void shuffleArray(int[] list) {
	Random rnd = new Random(System.nanoTime());
	for (int i = 0; i < list.length; i++) {
	    int j = rnd.nextInt(list.length - i);
	    int temp = list[i];
	    list[i] = list[i + j];
	    list[i + j] = temp;
	}
    }

    static int binarySearch(int[] list, int key) {
	int low = 0, high = list.length - 1;

	while (high >= low) {
	    int mid = (low + high) / 2;
	    if (key < list[mid])
		high = mid - 1;
	    else if (key == list[mid])
		return mid;
	    else
		low = mid + 1;
	}
	return -low - 1;
    }

    static int[] countLetters(String s) {
	int[] c = new int[26];
	s = s.toLowerCase();
	for (int i = 0; i < s.length(); i++)
	    c[s.charAt(i) - 'a']++;
	return c;
    }

    static int randomIntInRange(int a, int b) {
	return (int) (a + Math.random() * (b - a + 1));
    }

    static int digitalRoot(int n) {
	while (n > 9)
	    n -= 9;
	return n;
    }

    static int gcd(int a, int b) {
	if (b == 0)
	    return a;
	return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
	int temp = gcd(a, b);
	return temp != 0 ? a * b / temp : 0;
    }

    static int sumOfDigits(int num) {
	int sum = 0;
	String n = Integer.toString(num);
	for (int i = 0; i < n.length(); i++)
	    sum += n.charAt(i) - '0';
	return sum;
    }

    static long factorial(long n) {
	if (n < 2)
	    return 1;
	return n * factorial(n - 1);
    }

    static long fib(long n) {
	long f0 = 0;
	long f1 = 1;
	long f2 = 1;
	if (n == 0)
	    return f0;
	else if (n == 1)
	    return f1;
	else if (n == 2)
	    return f2;

	for (int i = 3; i <= n; i++) {
	    f0 = f1;
	    f1 = f2;
	    f2 = f0 + f1;
	}
	return f2;
    }

    static List<Long> fibsave = new LinkedList<Long>(Arrays.asList(0L, 1L, 1L));

    static long fibsave(int n) {
	if (n < fibsave.size())
	    return fibsave.get(n);
	for (int i = fibsave.size(); i <= n; i++)
	    fibsave.add(fibsave.get(i - 1) + fibsave.get(i - 2));
	return fibsave.get(n);
    }

    static List<BigInteger> bigFibSave = new LinkedList<BigInteger>(
	    Arrays.asList(BigInteger.ZERO, BigInteger.ONE, BigInteger.ONE));

    static BigInteger bigFibSave(int n) {
	if (n < bigFibSave.size())
	    return bigFibSave.get(n);
	for (int i = bigFibSave.size(); i <= n; i++)
	    bigFibSave.add(bigFibSave.get(i - 1).add(bigFibSave.get(i - 2)));
	return bigFibSave.get(n);
    }

    static boolean isLeapYear(int year) {
	return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    static boolean isItInt(double num) {
	return num == (long) num;
    }

    static ArrayList<Boolean> primeFlags = new ArrayList<>(Arrays.asList(false, false));

    /*
     * Invoke isPrime() for the largest number before testing smaller numbers to
     * be fast
     */
    static boolean isPrime(int n) {
	int initSize = primeFlags.size();
	for (int i = 0; i < n + 1 - initSize; i++)
	    primeFlags.add(true);
	if (n >= initSize)
	    for (int i = 2; i <= n; i++)
		if (primeFlags.get(i) == true)
		    for (int j = 2 * i; j <= n; j += i)
			primeFlags.set(j, false);
	return primeFlags.get(n);
    }

    static boolean isPalindrome(long n) {
	return isPalindrome(String.valueOf(n));
    }

    static boolean isPalindrome(String string) {
	StringBuilder sb = new StringBuilder(string);
	return sb.toString().equals(sb.reverse().toString());
    }

    static void permute(java.util.List<Integer> list, int n) {
	for (int i = n; i < list.size(); i++) {
	    java.util.Collections.swap(list, i, n);
	    permute(list, n + 1);
	    java.util.Collections.swap(list, n, i);
	}
	if (n == list.size() - 1)
	    System.out.println(java.util.Arrays.toString(list.toArray()));
    }

    static <E> ArrayList<E[]> permutations(E[] arr) {
	final ArrayList<E[]> resultList = new ArrayList<E[]>();
	final int l = arr.length;
	if (l == 0)
	    return resultList;
	if (l == 1) {
	    resultList.add(arr);
	    return resultList;
	}

	E[] subClone = Arrays.copyOf(arr, l - 1);
	System.arraycopy(arr, 1, subClone, 0, l - 1);

	for (int i = 0; i < l; ++i) {
	    E e = arr[i];
	    if (i > 0)
		subClone[i - 1] = arr[0];
	    final ArrayList<E[]> subPermutations = permutations(subClone);
	    for (E[] sc : subPermutations) {
		E[] clone = Arrays.copyOf(arr, l);
		clone[0] = e;
		System.arraycopy(sc, 0, clone, 1, l - 1);
		resultList.add(clone);
	    }
	    if (i > 0)
		subClone[i - 1] = e;
	}
	return resultList;
    }

    static ArrayList<String> permutations(String arr) {
	final Character[] c = new Character[arr.length()];
	for (int i = 0; i < arr.length(); ++i)
	    c[i] = arr.charAt(i);

	final ArrayList<Character[]> perms = permutations(c);
	final ArrayList<String> resultList = new ArrayList<String>(perms.size());

	for (Character[] p : perms)
	    resultList.add(Arrays.toString(p));
	return resultList;
    }

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String ans = "";
	// Start here
	System.out.println(sumOfDigits(12345));
	System.out.println(ans);
	in.close();
    }

}