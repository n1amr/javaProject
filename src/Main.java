import java.lang.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		System.out.printf("%s\n", "Welcome");

		Scanner in = new Scanner(System.in);
		while (in.hasNextLine())
			System.out.println(in.nextLine());
	}
}