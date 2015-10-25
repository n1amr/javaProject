public class TestCircleWithException {
    public static void main(String[] args) {
	try {
	    new CircleWithException(5);
	    new CircleWithException(-5);
	    new CircleWithException(0);
	} catch (IllegalArgumentException ex) {
	    System.out.println(ex);
	}

	System.out.println("Number of objects created: " + CircleWithException.getNumberOfObjects());
    }
}
