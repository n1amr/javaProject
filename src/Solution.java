import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] argh) {
	Scanner in = new Scanner(System.in);
	StringBuilder builder = new StringBuilder();

	String s = in.nextLine();

	Pattern pattern = Pattern.compile("\\w+");
	Matcher matcher = pattern.matcher(s);

	boolean sd = true;
	int c = 0;
	while (matcher.find()) {
	    c++;
	    String w = matcher.group();
	    builder.append(w + "\r\n");
	}
	System.out.println(c + "\r\n" + builder.toString());
    }
}
