import java.util.*;

public class _277A_Learning_Languages {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Graph G = new Graph(100 + 100, 100);
		int i, k;
		int n = in.nextInt();
		int m = in.nextInt();
		G.clearTo(m + n);

		int allLangs = 0;
		for (i = 0; i < n; i++) {
			k = in.nextInt();
			allLangs += k;
			for (int j = 0; j < k; j++) {
				G.doubleAddEdge(i, in.nextInt() - 1 + n);
			}
		}

		if (allLangs > 0) {
			while (i > 0) {
				i--;
				if (G.F[i])
					n--;
				else
					G.DFS(i);
			}
			n--;
		}
		System.out.println(n);
	}
}

class Graph {
	final int N;
	boolean[] F;
	int n;
	ArrayList<Integer>[] G;

	public Graph(int n) {
		N = n;
		F = new boolean[N];
		G = new ArrayList[N];
		for (int i = 0; i < n; i++)
			G[i] = new ArrayList<>();
	}

	public Graph(int n, int m) {
		N = n;
		F = new boolean[N];
		G = new ArrayList[N];
		for (int i = 0; i < n; i++)
			G[i] = new ArrayList<>(m);
	}

	public void clearTo(int nn) {
		n = nn;
		for (int i = 0; i < nn; i++) {
			G[nn].clear();
			F[nn] = false;
		}
	}

	public void addEdge(int x, int y) {
		G[x].add(y);
	}

	public void doubleAddEdge(int x, int y) {
		addEdge(x, y);
		addEdge(y, x);
	}

	public void DFS(int x) {
		if (!F[x]) {
			F[x] = true;
			for (int y : G[x])
				DFS(y);
		}
	}
}