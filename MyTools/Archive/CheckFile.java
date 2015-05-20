import java.io.*;
import java.util.*;

public class CheckFile {
    public static void main(String[] args) throws Exception {
	Scanner f1 = new Scanner(new BufferedInputStream(new FileInputStream(
		new File("output.txt"))));
	Scanner f2 = new Scanner(new BufferedInputStream(new FileInputStream(
		new File("output2.txt"))));
	int i = 1;
	while (f2.hasNextLine()) {
	    String s1;
	    String s2 = f2.nextLine();
	    if (!f1.hasNextLine()) {
		System.out.println("Line " + i + ": \n" + s2 + "\n" + ""
			+ "\n*****************\n\n");
	    } else {
		s1 = f1.nextLine();
		if (!s1.equals(s2)) {
		    System.out.println("Line " + i + ": \n" + s2 + "\n" + s1
			    + "\n*****************\n\n");
		}
	    }
	    i++;
	}
	System.out.println("Finished");
    }
}
