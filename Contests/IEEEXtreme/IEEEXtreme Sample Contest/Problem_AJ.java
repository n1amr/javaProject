public class Problem_AJ {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = in.nextInt();
    long sum = 0;
    long max = 0;
    for (int i = a.length - 1; i >= 0; i--) {
      sum += a[i];
      if (sum > max)
        max = sum;
    }
    System.out.println(max);
  }
}
