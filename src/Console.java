import java.util.*;

public class Console {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	run(in.nextLine());
    }

    private static void run(String line) {
	Mat X = new Mat(line);
	System.out.println(Mat.add(X, X));
    }
}
