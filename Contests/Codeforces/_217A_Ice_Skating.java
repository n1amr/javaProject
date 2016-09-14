import java.io.FileNotFoundException;

public class _217A_Ice_Skating {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Point[] a = new Point[n];
    for (int i = 0; i < n; i++)
      a[i] = new Point(i, in.nextInt(), in.nextInt());
    Graph<Point> g = new Graph<>(a);

    Arrays.sort(a, new Comparator<Point>() {
      @Override
      public int compare(Point o1, Point o2) {
        return o1.x != o2.x ? o1.x - o2.x : o1.y - o2.y;
      }
    });
    int i;
    int cur = a[0].x;
    for (i = 0; i < n; ) {
      while (i < n && a[i].x == cur) {
        if (i + 1 < n && a[i + 1].x == cur)
          g.addEdge(a[i].index, a[i + 1].index);
        i++;
      }
      if (i < n)
        cur = a[i].x;
    }

    Arrays.sort(a, new Comparator<Point>() {
      @Override
      public int compare(Point o1, Point o2) {
        return o1.y != o2.y ? o1.y - o2.y : o1.x - o2.x;
      }
    });
    cur = a[0].y;
    for (i = 0; i < n; ) {
      while (i < n && a[i].y == cur) {
        if (i + 1 < n && a[i + 1].y == cur)
          g.addEdge(a[i].index, a[i + 1].index);
        i++;
      }
      if (i < n)
        cur = a[i].y;
    }
    g.dfs(0);
    int r = n - 1;
    for (int j = 1; j < n; j++) {
      if (g.isVisited.get(j))
        r--;
      g.dfs(j);
    }
    System.out.println(r);
  }
}

class Point {
  int index, y, x;

  public Point(int i, int X, int Y) {
    index = i;
    x = X;
    y = Y;
  }
}

class Graph<V> {
  List<V> vertices = new ArrayList<V>();
  List<List<Integer>> neighbors = new ArrayList<List<Integer>>();
  ArrayList<Boolean> isVisited;

  Graph(V[] vertices) {
    isVisited = new ArrayList<Boolean>();
    for (V vertex : vertices) {
      this.vertices.add(vertex);
      neighbors.add(new ArrayList<Integer>());
      isVisited.add(false);
    }
  }

  void addVertex(V vertex) {
    vertices.add(vertex);
    neighbors.add(new ArrayList<Integer>());
  }

  void addEdge(int u, int v) {
    neighbors.get(u).add(v);
    neighbors.get(v).add(u);
  }

  void dfs(int v) {
    dfs(v, isVisited);
  }

  void dfs(int v, ArrayList<Boolean> isVisited) {
    isVisited.set(v, true);

    for (int i : neighbors.get(v))
      if (!isVisited.get(i))
        dfs(i, isVisited);
  }
}
