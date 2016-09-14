public class IEEE_Electronic_Devices_Society {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[m];
    for (int i = 0; i < n; i++)
      a[i] = in.nextInt();
    long start = System.currentTimeMillis();
    for (int i = 0; i < m; i++) {
      b[i] = a[i];
    }
    Integer ans = Integer.MAX_VALUE;
    Arrays.sort(b);

    for (int i = 0; i < n; i++) {
      ans = Math.min(ans, b[k - 1]);
      int deletedIndex = Arrays.binarySearch(b, a[i]);
      b[deletedIndex] = a[(i + m) % n];
      while (deletedIndex + 1 < m
          && b[deletedIndex] > b[deletedIndex + 1]) {
        int swap_temp = b[deletedIndex];
        b[deletedIndex] = b[deletedIndex + 1];
        b[deletedIndex + 1] = swap_temp;
        deletedIndex++;
      }
      while (deletedIndex - 1 >= 0
          && b[deletedIndex] < b[deletedIndex - 1]) {
        int swap_temp = b[deletedIndex];
        b[deletedIndex] = b[deletedIndex - 1];
        b[deletedIndex - 1] = swap_temp;
        deletedIndex--;
      }
    }
    System.out.println(ans);
    long end = System.currentTimeMillis();
    System.err.println(end - start);
  }
}