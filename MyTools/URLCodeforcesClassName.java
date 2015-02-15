import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class URLCodeforcesClassName {
    public static void main(String[] args) throws Exception {
	String projectPath = "D:\\Lab\\Eclipse\\WorkSpace\\javaProject\\";

	String url = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
		.getData(DataFlavor.stringFlavor);
	String[] segments = url.split("/");
	String problemNumber = segments[segments.length - 2]
		+ segments[segments.length - 1];

	System.out.println("Connecting...");
	Document doc = Jsoup.connect(url).get();
	Elements element = doc.select(".header > div:nth-child(1)");
	String problemName = element.text();
	problemName = problemName.substring(problemName.indexOf(' ') + 1);
	String problemCompleteName = problemNumber + " - " + problemName;
	System.out.println(problemCompleteName);

	String newName = problemCompleteName.trim().replaceAll(
		"^|([^a-zA-Z0-9]+)", "_");
	System.out.println(newName);
	File newFile = new File(projectPath + "src/" + newName + ".java");
	newFile.createNewFile();
	System.out.println("New path: " + newFile.getPath());

	String templateName = "Codeforces";
	File templateFile = new File(projectPath + "Contests/Templates/"
		+ templateName + ".java");

	Scanner in = new Scanner(templateFile);
	PrintWriter out = new PrintWriter(newFile);
	while (in.hasNextLine()) {
	    String line = in.nextLine();
	    line = line.replace(templateName, newName);
	    out.println(line);
	}
	out.close();
	System.out.println("SUCCESSFUL");

	// //Copy to clipboard
	// StringSelection stringSelection = new StringSelection(s);
	// Toolkit.getDefaultToolkit().getSystemClipboard()
	// .setContents(stringSelection, null);
    }
}
