import java.util.*;
import javax.swing.*;

public class QuickGraphDisplay {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Graph<String> g = new Graph<>();
		Graph<Node> visualGraph = new Graph<>();

		int m = in.nextInt();
		for (int i = 0; i < m; i++) {
			String word = in.next().toLowerCase();
			g.addVertex(word);
			visualGraph.addVertex(new Node(word));
		}

		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String word = in.next().toLowerCase();
			String translation = in.next().toLowerCase();
			if (!g.vertices.contains(word)) {
				g.addVertex(word);
				visualGraph.addVertex(new Node(word));
			}
			if (!g.vertices.contains(translation)) {
				g.addVertex(translation);
				visualGraph.addVertex(new Node(translation));
			}
			g.addEdge(g.getIndex(word), g.getIndex(translation));
			visualGraph.addEdge(g.getIndex(word), g.getIndex(translation));
		}
		displayGraph(visualGraph);
	}

	private static void displayGraph(Graph<Node> visualGraph) {
		JFrame frame = new JFrame("Display Graph");
		JApplet applet = new JApplet();
		applet.add(new GraphView(visualGraph));
		frame.add(applet);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1300, 700);
		frame.setVisible(true);

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

		public int getSize() {
			return vertices.size();
		}

		public List<V> getVertices() {
			return vertices;
		}

		public List<Integer> getNeighbors(int index) {
			return neighbors.get(index);
		}
	}

	static class GraphView extends javax.swing.JPanel {

		private Graph<Node> graph;

		public GraphView(Graph<Node> graph) {
			this.graph = graph;
		}

		@Override
		protected void paintComponent(java.awt.Graphics g) {
			super.paintComponent(g);

			// Draw vertices
			java.util.List<Node> vertices = graph.getVertices();
			for (int i = 0; i < graph.getSize(); i++) {
				int x = vertices.get(i).X;
				int y = vertices.get(i).Y;
				String name = vertices.get(i).Name;

				g.fillOval(x - 8, y - 8, 16, 16);
				g.drawString(name, x - 12, y - 12);
			}

			for (int i = 0; i < graph.getSize(); i++) {
				java.util.List<Integer> neighbors = graph.getNeighbors(i);
				int x1 = graph.getVertex(i).X;
				int y1 = graph.getVertex(i).Y;
				for (int v : neighbors) {
					int x2 = graph.getVertex(v).X;
					int y2 = graph.getVertex(v).Y;

					g.drawLine(x1, y1, x2, y2); // Draw an edge for (i, v)
				}
			}
		}

	}

	static class Node {
		public int X, Y;
		public String Name;

		Node(String Name) {
			this.Name = Name;
			this.X = (int) (Math.random() * 1100 + 100);
			this.Y = (int) (Math.random() * 500 + 100);
		}
	}

}
