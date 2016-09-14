public class Point implements Comparable<Point> {
  public final double x;
  public final double y;
  public final double r;
  public final double theta;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
    r = Math.hypot(x, y);
    theta = Math.atan2(y, x);
  }

  public Point(double r, double theta, int zero) {
    this.r = r;
    this.theta = theta;
    x = r * Math.cos(theta);
    y = r * Math.sin(theta);
  }

  public double length() {
    return r;
  }

  public double angle() {
    return theta;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  // Vectors
  public static Point vec(Point a, Point b) {
    return b.subtract(a);
  }

  public double dot(Point b) {
    return conjugate().multiply(b).x;
  }

  public double cross(Point b) {
    return conjugate().multiply(b).y;
  }

  public double lengthSqr() {
    return dot(this);
  }

  public Point rotate(double angle) {
    return this.multiply(Point.exp(new Point(0, angle)));
  }

  public Point rotateAbout(double angle, Point center) {
    return vec(center, this).rotate(angle).add(center);
  }

  public Point reflect(Point mirror) {
    return divide(mirror).conjugate().multiply(mirror);
  }

  public static double EPS = 0.000001;

  public boolean isOnLine(Point a, Point b) {
    return Math.abs(vec(a, b).cross(vec(a, this))) < EPS;
  }

  public boolean isOnRay(Point a, Point b) {
    return isOnLine(a, b) && vec(a, b).dot(vec(a, this)) > -EPS;
  }

  public boolean isOnSegment(Point a, Point b) {
    if (a.equals(b))
      return a.equals(this);
    return isOnRay(a, b) && isOnRay(b, a);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Point) {
      Point a = (Point) o;
      return Math.abs(x - a.x) < EPS && Math.abs(y - a.y) < EPS;
    }
    return super.equals(o);
  }

  public double distanceFromLine(Point a, Point b) {
    return vec(a, b).cross(vec(a, this)) / vec(a, b).length();
  }

  public Point intersection(Point a, Point b, Point p, Point q) {
    double d1 = vec(a, p).cross(vec(a, b));
    double d2 = vec(a, q).cross(vec(a, b));
    if (Math.abs(d1 - d2) < EPS)
      return null;
    return q.multiply(d1).subtract(p.multiply(d2)).multiply(1.0 / (d1 - d2));
  }

  public Point add(Point b) {
    return new Point(x + b.x, y + b.y);
  }

  public Point subtract(Point b) {
    return new Point(x - b.x, y - b.y);
  }

  public Point multiply(Point b) {
    return new Point(x * b.x - y * b.y, x * b.y + y * b.x);
  }

  public Point multiply(double alpha) {
    return new Point(alpha * x, alpha * y);
  }

  public Point conjugate() {
    return new Point(x, -y);
  }

  public Point reciprocal() {
    double scale = x * x + y * y;
    return new Point(x / scale, -y / scale);
  }

  public Point divide(Point b) {
    return this.multiply(b.reciprocal());
  }

  public static Point exp(Point a) {
    return new Point(Math.exp(a.x) * Math.cos(a.y), Math.exp(a.x) * Math.sin(a.y));
  }

  public static Point sin(Point a) {
    return new Point(Math.sin(a.x) * Math.cosh(a.y), Math.cos(a.x) * Math.sinh(a.y));
  }

  public static Point cos(Point a) {
    return new Point(Math.cos(a.x) * Math.cosh(a.y), -Math.sin(a.x) * Math.sinh(a.y));
  }

  public static Point tan(Point a) {
    return sin(a).divide(cos(a));
  }

  // sample client for testing
  public static void main(String[] args) {
    Point a = new Point(5.0, 6.0);
    Point b = new Point(-3.0, 4.0);
    Point c = new Point(4, 0);
    System.out.println(c.equals(b));
    System.out.println(c.rotateAbout(Math.PI / 2, new Point(1, 0)));
    System.out.println("a            = " + a);
    System.out.println("b            = " + b);
    System.out.println("b + a        = " + b.add(a));
    System.out.println("a - b        = " + a.subtract(b));
    System.out.println("a * b        = " + a.multiply(b));
    System.out.println("b * a        = " + b.multiply(a));
    System.out.println("a / b        = " + a.divide(b));
    System.out.println("(a / b) * b  = " + a.divide(b).multiply(b));
    System.out.println("conj(a)      = " + a.conjugate());
    System.out.println("|a|          = " + a.length());
    System.out.println("tan(a)       = " + tan(a));
  }

  @Override
  public int compareTo(Point o) {
    if (Math.abs(x - o.x) < EPS)
      return (int) (y - o.y);
    return (int) (x - o.x);
  }

}