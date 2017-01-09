public class CD {
  public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

  public static void main(String[] args) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = in.nextInt();

    LinkedList<Integer> indices = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (i >= k) {
        out.print(a[indices.getFirst()] + " ");

        while (!indices.isEmpty() && indices.getFirst() < i - k + 1)
          indices.removeFirst();
      }

      while (!indices.isEmpty() && a[i] >= a[indices.getLast()])
        indices.removeLast();

      indices.addLast(i);
    }

    out.print(a[indices.getFirst()]);
    out.close();
  }
}
