public class SegmentTree {
	final static int MAX = 5;
	int[] interval = new int[(int) Math.pow(2,
					Math.ceil(Math.log(MAX) / Math.log(2)) + 1)];
	int S = 0;
	int E = MAX;

	// initialzie all cells to val = 1
	public int build() {
		return build(S, E, 1);
	}

	public int build(int s, int e, int p) { // O(nlogn)
		if (s == e)
			return interval[p] = 1;
		return interval[p] = build(s, (s + e) / 2, 2 * p)
						+ build((s + e) / 2 + 1, e, 2 * p + 1);
	}

	// insert num and return its order (kth in order)
	public int insert(int num) { // O(logn)
		return insert(num, S, E, 1);
	}

	public int insert(int num, int s, int e, int p) { // O(logn)
		interval[p]++;
		if (s == e)
			return interval[p]; // control here for repeated nums
		if (num <= (s + e) / 2)
			return insert(num, s, (s + e) / 2, 2 * p);
		return interval[2 * p] + insert(num, (s + e) / 2 + 1, e, 2 * p + 1);
	}

	public int remove(int num) {
		return remove(num, S, E, 1);
	}

	public int remove(int num, int s, int e, int p) { // return position of
		// deleted val
		// in O(logn)
		interval[p]--;
		if (s == e)
			return interval[p] + 1;

		if ((s + e) / 2 >= num)
			return remove(num, s, (s + e) / 2, 2 * p);
		return interval[2 * p] + remove(num, (s + e) / 2 + 1, e, 2 * p + 1);
	}

	// delete kth element, and return its value
	public int delete(int index) {
		return delete(index, S, E, 1);
	}

	public int delete(int index, int s, int e, int p) {
		interval[p]--;
		if (s == e)
			return s;
		if (interval[2 * p] >= index)
			return delete(index, s, (s + e) / 2, 2 * p);
		return delete(index - interval[2 * p], (s + e) / 2 + 1, e, 2 * p + 1);
	}

	// get value of kth element
	public int get(int index) {
		return get(index, S, E, 1);
	}

	public int get(int index, int s, int e, int p) {
		if (s == e)
			return s;
		if (interval[2 * p] >= index)
			return get(index, s, (s + e) / 2, 2 * p);
		return get(index - interval[2 * p], (s + e) / 2 + 1, e, 2 * p + 1);
	}

	public void displayElements() {
		displayElements(S, E, 1);
	}

	public void displayElements(int s, int e, int p) {
		if (s == e) {
			int cnt = interval[p];
			while (cnt-- != 0)
				System.out.print(s + " ");
			return;
		}
		displayElements(s, (s + e) / 2, 2 * p);
		displayElements((s + e) / 2 + 1, e, 2 * p + 1);
	}

	public static void main(String[] args) {
		SegmentTree segmentTree = new SegmentTree();
		int[] a = new int[segmentTree.interval.length];

		System.out.println(segmentTree.insert(2));
		System.out.println(segmentTree.insert(2));

		segmentTree.displayElements();
	}
}
