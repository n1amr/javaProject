import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileNotFoundExceptionDemo {
	public static void main(String[] args) {
		Scanner inputFromConsole = new Scanner(System.in);
		// Prompt the user to enter a file name
		System.out.print("Enter a filename: ");
		String filename = inputFromConsole.nextLine();

		try {
			new Scanner(new File(filename));
			System.out.println("File " + filename + " exists ");
			// Processing file ...
		} catch (FileNotFoundException ex) {
			System.out.println("Exception: " + filename + " not found");
		}
	}
}
