public class SegmentTreeApps extends SegmentTree {

	// Assume we build the tree to have the index of the maximum of an interval:
	int from, to; // initialize to given query interval
	int n = 20;
	int[] input = new int[n];

	int query() {
		return query(0, MAX, 1);
	}

	int query(int s, int e, int p) {
		if (from <= s && to >= e)
			return interval[p];

		int mid = (s + e) / 2;

		// Either we are in specific interval, or we are spanned over 2
		// intervals
		if (to <= mid)
			return query(s, (s + e) / 2, 2 * p);

		if (from > mid)
			return query((s + e) / 2 + 1, e, 2 * p + 1);

		int a = query(s, (s + e) / 2, 2 * p);
		int b = query((s + e) / 2 + 1, e, 2 * p + 1);

		return input[a] > input[b] ? a : b;
	}

	// O(n^2), length[i]: longest seq ENDING at i. This definition is better
	// than STARTing at i
	int solve(int[] height, int[] length, int n) {
		int mx = 0;
		for (int i = 0; i < n; i++) {
			length[i] = 1;
			for (int j = 0; j < i; j++) {
				if (height[i] > height[j])
					length[i] = Math.max(length[i], length[j] + 1);
				mx = Math.max(mx, length[i]);
			}
		}
		return mx;
	}

	int solve(int height[], int n) {
		int mx = 1;
		int val = 0, idx = 0;
		for (int i = 1; i < n; i++) {
			int bestPosLen = 1;

			if (height[i] != 0) // special handling for the smallest entry, 0 in
								// this case
			{
				from = 0;
				to = height[i] - 1;
				bestPosLen = query(0, n - 1, 1) + 1;
			}
			idx = height[i];
			val = bestPosLen;
			update(0, n - 1);

			mx = Math.max(mx, bestPosLen);
		}

		return mx;
	}

	private void update(int i, int j) {
		// TODO Auto-generated method stub

	}

	int minVal;

	int query2() {
		return query2(0, MAX, 1);
	}

	int query2(int s, int e, int p) {
		if (s == e)
			return interval[p];

		int mid = (s + e) / 2;

		if (to <= mid)
			return query2(s, (s + e) / 2, 2 * p);

		if (from > mid)
			return query2((s + e) / 2 + 1, e, 2 * p + 1);

		int idx1 = query2(s, (s + e) / 2, 2 * p);

		if (input[idx1] >= minVal)
			return idx1;

		return query2((s + e) / 2 + 1, e, 2 * p + 1);
	}

	static class NODE {
		int maxFreq, isMixed;
	}

	NODE[] tree = new NODE[MAX];

	int Enter, Exit; // given query
	int S = 0, E;

	void updateLazy() {
		updateLazy(S, E, 1);
	}

	void updateLazy(int s, int e, int p) {

		if (Enter > e || Exit < s)
			return; // no intersection
		// tree interval inside query interval. all its children has same value
		if (Enter <= s && e <= Exit && tree[p].isMixed == 0) {
			tree[p].maxFreq++;
			return;
		}

		int mid = (s + e) / 2;
		if (tree[p].isMixed == 0)
			tree[2 * p] = tree[2 * p + 1] = tree[p]; // propagate

		updateLazy(s, mid, 2 * p);
		updateLazy(mid + 1, e, 2 * p + 1);

		// Update the function
		tree[p].isMixed = (tree[2 * p].isMixed != 0
				|| tree[2 * p + 1].isMixed != 0 || tree[2 * p].maxFreq != tree[2 * p + 1].maxFreq) ? 1
				: 0;
		tree[p].maxFreq = Math
				.max(tree[2 * p].maxFreq, tree[2 * p + 1].maxFreq);
	}
}
