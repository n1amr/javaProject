import java.util.*;

public class Console {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	while (in.hasNextLine())
	    run(in.nextLine());
    }

    private static void run(String s) {
	int i = 0;
	String name = "";
	String value;
	if ((i = s.indexOf('=')) != -1) {
	    name = s.substring(0, i).trim();
	    value = evaluate(s.substring(i + 1).trim());

	} else {
	    value = evaluate(s.trim());
	}
	Mat X = new Mat(value);
	if (name.length() == 0)
	    name = "ans";
	X.setName(name);
	System.out.println(X);

    }

    private static String evaluate(String s) {
	return s;
    }
}
