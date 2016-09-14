import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteToFile {
  public static void main(String[] args) throws IOException {
    File file = new File("res\\n1amr.txt");
    JFileChooser chooser = new JFileChooser();
    if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
      file = chooser.getSelectedFile();
    file.getParentFile().mkdirs();
    PrintWriter printWriter = new PrintWriter(file);
    printWriter.println("amr");
    printWriter.print("_______");
    printWriter.close();
    System.out.println(file.getAbsolutePath());
  }
}
