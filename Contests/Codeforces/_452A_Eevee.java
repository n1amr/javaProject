import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _452A_Eevee {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	scanner.nextLine();
	Matcher matcher = Pattern.compile("\\b" + scanner.nextLine() + "\\b")
		.matcher("Vaporeon, Jolteon, Flareon, Espeon, Umbreon, Leafeon, Glaceon, Sylveon".toLowerCase());
	if (matcher.find())
	    System.out.println(matcher.group());

    }
}
