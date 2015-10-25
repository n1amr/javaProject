import java.io.*;
import java.util.*;

public class CodeEdit {
    public static void main(String[] args) {
	try {
	    File file = new File("res/code_edit/code.txt");
	    file.getParentFile().mkdirs();
	    file.createNewFile();

	    ArrayList<String> fileLines = new ArrayList<String>();
	    Scanner scanner = new Scanner(file);
	    while (scanner.hasNextInt()) {
		scanner.nextInt();
		fileLines.add(scanner.nextLine());
	    }
	    scanner.close();

	    file = new File("res/code_edit/code_output.txt");
	    file.createNewFile();

	    PrintWriter printWriter = new PrintWriter(file);
	    for (int i = 0; i < fileLines.size(); i++) {
		printWriter.println(fileLines.get(i));
		System.out.println(fileLines.get(i));
	    }
	    printWriter.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}