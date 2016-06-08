import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class _467D_Fedor_and_Essay {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int m = in.nextInt();
		Graph<String> g = new Graph<>();
		Vector<String> msg = new Vector<>(m + 5);
		int r = 0, s = 0;

		for (int i = 0; i < m; i++) {
			String word = in.next().toLowerCase();
			msg.add(word);
			if (!g.vertices.contains(word))
				g.addVertex(word);
			r += countR(word);
			s += word.length();
		}

		int n = in.nextInt();
		HashMap<String, Vector<String>> dic = new HashMap<>(n + 5);
		for (int i = 0; i < n; i++) {
			String word = in.next().toLowerCase();
			String translation = in.next().toLowerCase();
			if (!g.vertices.contains(word))
				g.addVertex(word);
			if (!g.vertices.contains(translation))
				g.addVertex(translation);
			g.addEdge(g.getIndex(word), g.getIndex(translation));
		}

		Graph<String>.Tree tree = g.bfs(0);
		for (int i = 0; i < msg.size(); i++) {
			String word = msg.get(i);
			List<Integer> path = tree.getSearchOrder();
			if (!path.contains(word)) {
				tree = g.bfs(g.getIndex(word));
				path = tree.getSearchOrder();
			}
			int s1 = word.length();
			int r1 = countR(word);
			String bestTranslation = g.getVertex(path.get(0));
			int sb = bestTranslation.length();
			int rb = countR(bestTranslation);

			for (Integer translationIndex : path) {
				String translation = g.getVertex(translationIndex);
				int s2 = translation.length();
				int r2 = countR(translation);
				if (r2 < rb || r2 == rb && s2 < sb) {
					bestTranslation = translation;
					rb = r2;
					sb = s2;
				}

			}
			if (rb < r1 || rb == r1 && sb < s1) {
				r += rb - r1;
				s += sb - s1;
				msg.set(i, bestTranslation);
				s1 = sb;
				r1 = rb;
				if (dic.containsKey(bestTranslation)) {
					i--;
					continue;
				}
			}
		}
		System.out.println(r + " " + s);
	}

	private static int countR(String string) {
		int c = 0;
		for (int i = 0; i < string.length(); i++)
			if (string.charAt(i) == 'r')
				c++;
		return c;
	}

	static class Graph<V> {
		public List<V> vertices = new ArrayList<V>();
		public List<List<Integer>> neighbors = new ArrayList<List<Integer>>(); // Adjacency

		public V getVertex(int index) {
			return vertices.get(index);
		}

		public int getIndex(V v) {
			return vertices.indexOf(v);
		}

		public void addVertex(V vertex) {
			vertices.add(vertex);
			neighbors.add(new ArrayList<Integer>());
		}

		public void addEdge(int u, int v) {
			neighbors.get(u).add(v);
		}

		public Tree bfs(int v) {
			List<Integer> searchOrder = new ArrayList<Integer>();
			int[] parent = new int[vertices.size()];
			for (int i = 0; i < parent.length; i++)
				parent[i] = -1;

			LinkedList<Integer> queue = new LinkedList<Integer>();

			boolean[] isVisited = new boolean[vertices.size()];
			queue.offer(v);
			isVisited[v] = true;

			while (!queue.isEmpty()) {
				int u = queue.poll();
				searchOrder.add(u);
				for (int w : neighbors.get(u))
					if (!isVisited[w]) {
						queue.offer(w);
						parent[w] = u;
						isVisited[w] = true;
					}
			}

			return new Tree(v, parent, searchOrder);
		}

		public class Tree {
			private int root;
			private int[] parent;
			private List<Integer> searchOrder;

			public Tree(int root, int[] parent, List<Integer> searchOrder) {
				this.root = root;
				this.parent = parent;
				this.searchOrder = searchOrder;
			}

			public List<Integer> getSearchOrder() {
				return searchOrder;
			}

			public List<V> getPath(int index) {
				ArrayList<V> path = new ArrayList<V>();

				do {
					path.add(vertices.get(index));
					index = parent[index];
				} while (index != -1);

				return path;
			}
		}
	}
}
