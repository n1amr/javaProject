public class LambdaExample {
  // Function is a functional interface because it defines only one method
  // So, it can be substituted by a lambda
  interface Function {
    double apply(double x);
  }

  private static double solve(Function f, double a) {
    return f.apply(a);
  }

  private static double f(double x) {
    return x + 2;
  }

  public static void main(String[] args) throws Exception {
    System.out.println(solve(
        (x) -> (x * 2),
        4));

    System.out.println(solve(
        LambdaExample::f,
        4));
  }
}