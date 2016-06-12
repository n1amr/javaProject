public class Vector3 {
	public final double x;
	public final double y;
	public final double z;

	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}

	public double length() {
		return Math.hypot(Math.hypot(x, y), z);
	}

	public double angle() {
		return Math.atan2(y, x);
	}

	public Vector3 add(Vector3 b) {
		return new Vector3(x + b.x, y + b.y, z + b.z);
	}

	public Vector3 subtract(Vector3 b) {
		return new Vector3(x - b.x, y - b.y, z - b.z);
	}

	public double dot(Vector3 b) {
		return x * b.x + y * b.y + z * b.z;
	}

	public Vector3 cross(Vector3 b) {
		return new Vector3(y * b.z - z * b.y, z * b.x - x * b.z, x * b.y - y * b.x);
	}

	public static void main(String[] args) {
		Vector3 a = new Vector3(5.0, 6.0, 0);
		Vector3 b = new Vector3(-3.0, 4.0, 0);
		System.out.println(a.cross(b));
		System.out.println("a            = " + a);
		System.out.println("b            = " + b);
		System.out.println("|a|          = " + a.length());
	}

}