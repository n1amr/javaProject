import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Graph<V> {
  public List<V> vertices = new ArrayList<V>(); // Store vertices
  public List<List<Integer>> neighbors = new ArrayList<List<Integer>>(); // Adjacency

  /**
   * Construct an empty graph
   */
  public Graph() {
  }

  /**
   * Construct a graph from edges and vertices stored in arrays
   */
  public Graph(int[][] edges, V[] vertices) {
    for (V vertex : vertices) {
      this.vertices.add(vertex);
    }

    createAdjacencyLists(edges, vertices.length);
  }

  /**
   * Construct a graph from integer vertices 0, 1, and edge array
   */
  public Graph(int[][] edges, int numberOfVertices) {
    for (int i = 0; i < numberOfVertices; i++) {
      vertices.add((V) new Integer(i)); // vertices is {0, 1, ...}
    }

    createAdjacencyLists(edges, numberOfVertices);
  }

  /**
   * Create adjacency lists for each vertex
   */
  public void createAdjacencyLists(int[][] edges, int numberOfVertices) {
    // Create a linked list
    for (int i = 0; i < numberOfVertices; i++) {
      neighbors.add(new ArrayList<Integer>());
    }

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      neighbors.get(u).add(v);
    }
  }

  /**
   * Return the number of vertices in the graph
   */
  public int getSize() {
    return vertices.size();
  }

  /**
   * Return the vertices in the graph
   */
  public List<V> getVertices() {
    return vertices;
  }

  /**
   * Return the object for the specified vertex
   */
  public V getVertex(int index) {
    return vertices.get(index);
  }

  /**
   * Return the index for the specified vertex object
   */
  public int getIndex(V v) {
    return vertices.indexOf(v);
  }

  /**
   * Return the neighbors of the specified vertex
   */
  public List<Integer> getNeighbors(int index) {
    return neighbors.get(index);
  }

  /**
   * Return the degree for a specified vertex
   */
  public int getDegree(int v) {
    return neighbors.get(v).size();
  }

  /**
   * Print a vertex
   */
  public void printVertex(int v) {
    System.out.printf("(%d)-%s", v, getVertex(v));
  }

  /**
   * Print the edges
   */
  public void printEdges() {
    for (int u = 0; u < vertices.size(); u++) {
      printVertex(u);
      System.out.print(" -> {");
      for (int v : getNeighbors(u)) {
        printVertex(v);
        System.out.print(", ");
      }
      System.out.println("}");
    }
  }

  /**
   * Clear graph
   */
  public void clear() {
    vertices.clear();
    neighbors.clear();
  }

  /**
   * Add a vertex to the graph
   */
  public void addVertex(V vertex) {
    vertices.add(vertex);
    neighbors.add(new ArrayList<Integer>());
  }

  /**
   * Add an edge to the graph
   */
  public void addDoubleEdge(int u, int v) {
    addEdge(u, v);
    addEdge(v, u);
  }

  /**
   * Add an edge from u to v to the graph
   */
  public void addEdge(int u, int v) {
    neighbors.get(u).add(v);
  }

  /** Obtain a DFS tree starting from vertex v */
  /**
   * To be discussed in Section 27.6
   */
  public Tree dfs(int v) {
    List<Integer> searchOrder = new ArrayList<Integer>();
    int[] parent = new int[vertices.size()];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = -1; // Initialize parent[i] to -1
    }

    // Mark visited vertices
    boolean[] isVisited = new boolean[vertices.size()];

    // Recursively search
    dfs(v, parent, searchOrder, isVisited);

    // Return a search tree
    return new Tree(v, parent, searchOrder);
  }

  /**
   * Recursive method for DFS search
   */
  private void dfs(int v, int[] parent, List<Integer> searchOrder,
                   boolean[] isVisited) {
    // Store the visited vertex
    searchOrder.add(v);
    isVisited[v] = true; // Vertex v visited

    for (int i : neighbors.get(v)) {
      if (!isVisited[i]) {
        parent[i] = v; // The parent of vertex i is v
        dfs(i, parent, searchOrder, isVisited); // Recursive search
      }
    }
  }

  /** Starting bfs search from vertex v */
  /**
   * To be discussed in Section 27.7
   */
  public Tree bfs(int v) {
    List<Integer> searchOrder = new ArrayList<Integer>();
    int[] parent = new int[vertices.size()];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = -1; // Initialize parent[i] to -1
    }

    LinkedList<Integer> queue = new LinkedList<Integer>(); // list
    // used
    // as
    // a
    // queue
    boolean[] isVisited = new boolean[vertices.size()];
    queue.offer(v); // Enqueue v
    isVisited[v] = true; // Mark it visited

    while (!queue.isEmpty()) {
      int u = queue.poll(); // Dequeue to u
      searchOrder.add(u); // u searched
      for (int w : neighbors.get(u)) {
        if (!isVisited[w]) {
          queue.offer(w); // Enqueue w
          parent[w] = u; // The parent of w is u
          isVisited[w] = true; // Mark it visited
        }
      }
    }

    return new Tree(v, parent, searchOrder);
  }

  /** Tree inner class inside the AbstractGraph class */
  /**
   * To be discussed in Section 27.5
   */
  public class Tree {
    private int root; // The root of the tree
    private int[] parent; // Store the parent of each vertex
    private List<Integer> searchOrder; // Store the search order

    /**
     * Construct a tree with root, parent, and searchOrder
     */
    public Tree(int root, int[] parent, List<Integer> searchOrder) {
      this.root = root;
      this.parent = parent;
      this.searchOrder = searchOrder;
    }

    /**
     * Return the root of the tree
     */
    public int getRoot() {
      return root;
    }

    /**
     * Return the parent of vertex v
     */
    public int getParent(int v) {
      return parent[v];
    }

    /**
     * Return an array representing search order
     */
    public List<Integer> getSearchOrder() {
      return searchOrder;
    }

    /**
     * Return number of vertices found
     */
    public int getNumberOfVertices() {
      return searchOrder.size();
    }

    /**
     * Return the path of vertices from a vertex to the root
     */
    public List<V> getPath(int index) {
      ArrayList<V> path = new ArrayList<V>();

      do {
        path.add(vertices.get(index));
        index = parent[index];
      } while (index != -1);

      return path;
    }

    /**
     * Print a path from the root to vertex v
     */
    public void printPath(int index) {
      List<V> path = getPath(index);
      Collections.reverse(path);
      System.out.println(path);
    }

    /**
     * Print the whole tree
     */
    public void printTree() {
      System.out.println("Root is: " + vertices.get(root));
      System.out.print("Edges: ");
      for (int i = 0; i < parent.length; i++) {
        if (parent[i] != -1) {
          // Display an edge
          System.out.print("(" + vertices.get(parent[i]) + ", "
              + vertices.get(i) + ") ");
        }
      }
      System.out.println();
    }
  }

  class PracticalGraph {
    final int N;
    boolean[] F;
    int n;
    ArrayList<Integer>[] G;

    public PracticalGraph(int n) {
      N = n;
      F = new boolean[N];
      G = new ArrayList[N];
      for (int i = 0; i < n; i++) {
        G[i] = new ArrayList<>();
      }
    }

    public PracticalGraph(int n, int m) {
      N = n;
      F = new boolean[N];
      G = new ArrayList[N];
      for (int i = 0; i < n; i++) {
        G[i] = new ArrayList<>(m);
      }
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
        for (int y : G[x]) {
          DFS(y);
        }
      }
    }
  }

  public static void main(String[] args) {
    String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
        "Denver", "Kansas City", "Chicago", "Boston", "New York",
        "Atlanta", "Miami", "Dallas", "Houston"};

    // Edge array for graph in Figure 27.1
    int[][] edges = {{0, 1}, {0, 3}, {0, 5}, {1, 0}, {1, 2},
        {1, 3}, {2, 1}, {2, 3}, {2, 4}, {2, 10}, {3, 0},
        {3, 1}, {3, 2}, {3, 4}, {3, 5}, {4, 2}, {4, 3},
        {4, 5}, {4, 7}, {4, 8}, {4, 10}, {5, 0}, {5, 3},
        {5, 4}, {5, 6}, {5, 7}, {6, 5}, {6, 7}, {7, 4},
        {7, 5}, {7, 6}, {7, 8}, {8, 4}, {8, 7}, {8, 9},
        {8, 10}, {8, 11}, {9, 8}, {9, 11}, {10, 2},
        {10, 4}, {10, 8}, {10, 11}, {11, 8}, {11, 9}};

    Graph<String> graph1 = new Graph<String>(edges, vertices);
    graph1.printEdges();

    graph1.bfs(11).printPath(2);
  }
}
