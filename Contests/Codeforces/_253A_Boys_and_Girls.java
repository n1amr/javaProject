import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class _253A_Boys_and_Girls {
    public static void main(String[] args) throws FileNotFoundException {
	Scanner in = new Scanner(new File("input.txt"));
	int b = in.nextInt();
	int g = in.nextInt();
	in.close();
	StringBuilder ans = new StringBuilder();
	String s = b > g ? "BG" : "GB";
	int n = Math.min(g, b);
	for (int i = 0; i < n; i++)
	    ans.append(s);
	s = b > g ? "B" : "G";
	n = Math.max(g, b) - n;
	for (int i = 0; i < n; i++)
	    ans.append(s);
	PrintWriter printWriter = new PrintWriter("output.txt");
	printWriter.println(ans);
	printWriter.close();
    }
}
