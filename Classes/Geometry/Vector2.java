
public class Vector2 {
    public final double x;
    public final double y;

    public Vector2(double x, double y) {
	this.x = x;
	this.y = y;
    }

    @Override
    public String toString() {
	return "(" + x + ", " + y + ")";
    }

    public double length() {
	return Math.hypot(x, y);
    }

    public double angle() {
	return Math.atan2(y, x);
    }

    public Vector2 add(Vector2 b) {
	return new Vector2(x + b.x, y + b.y);
    }

    public Vector2 subtract(Vector2 b) {
	return new Vector2(x - b.x, y - b.y);
    }

    public double dot(Vector2 b) {
	return x * b.x + y * b.y;
    }

    public double cross(Vector2 b) {
	return x * b.y - y * b.x;
    }

    public static void main(String[] args) {
	Vector2 a = new Vector2(5.0, 6.0);
	Vector2 b = new Vector2(-3.0, 4.0);

	System.out.println("a            = " + a);
	System.out.println("b            = " + b);
	System.out.println("|a|          = " + a.length());
    }

}