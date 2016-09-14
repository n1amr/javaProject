public class BisectionMethod {
  interface Function {
    double apply(double x);
  }

  private static double solve(Function f, double a, double b) {
    double c = 0;
    for (int i = 0; i < 100; i++) {
      c = (a + b) / 2;
      System.err.println("Iteration " + i + ": " + c);
      if (f.apply(a) * f.apply(c) < 0)
        b = c;
      else if (f.apply(c) * f.apply(b) < 0)
        a = c;
      else {
        break;
      }
    }
    return c;
  }

  public static void main(String[] args) throws Exception {
    double a = 4, b = 50;
    double c = solve(
        (x) -> (Math.exp(x) - 0.17 * Math.pow(x, 4.2)),
        a, b);
    System.out.println(c);
  }
}