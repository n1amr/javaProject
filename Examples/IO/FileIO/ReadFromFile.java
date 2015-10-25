import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class ReadFromFile {
    public static void main(String[] args) throws IOException {
	File file = new File("res\\n1amr.txt");
	JFileChooser jFileChooser = new JFileChooser();
	if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
	    file = jFileChooser.getSelectedFile();
	// file.deleteOnExit();
	if (file.exists()) {
	    System.out.println(">>Reading from: " + file.getAbsolutePath());
	    System.out.println("-------------------------------");
	    Scanner scanner = new Scanner(file);
	    while (scanner.hasNext())
		System.out.println(scanner.nextLine());
	    scanner.close();
	} else
	    System.out.println(">>File " + file.getAbsolutePath() + " does not exist!");
    }
}
