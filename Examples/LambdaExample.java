public class LambdaExample {
  // Function is a functional interface because it defines only one method
  // So, it can be substituted by a lambda
  interface Function {
    double apply(double x);
  }

  private static double solve(Function f, double a) {
    return f.apply(a);
  }

  public static void main(String[] args) throws Exception {
    System.out.println(solve(
        (x) -> (x * 2),
        4));
  }
}