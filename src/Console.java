import java.util.*;

public class Console {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	while (in.hasNextLine())
	    run(in.nextLine());
    }

    private static void run(String s) {
	int i = 0;
	if ((i = s.indexOf('=')) != -1) {
	    String name = s.substring(0, i).trim();
	    String value = s.substring(i + 1).trim();
	    System.err.println(name);
	    System.err.println(value);
	    Mat X = new Mat(value);
	    X.setName(name);
	    System.out.println(X);
	}
    }
}
