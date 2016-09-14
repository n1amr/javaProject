public class GenerateCodeJamTemplate {
  public static void main(String[] args) throws Exception {
    String projectPath = "D:\\Lab\\Eclipse\\WorkSpace\\javaProject\\";

    String problemCompleteName = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
        .getData(DataFlavor.stringFlavor);
    System.out.println(problemCompleteName);

    String newName = problemCompleteName.trim().replaceAll("^|([^a-zA-Z0-9]+)", "_");
    File newFile = new File(projectPath + "src/" + newName + ".java");
    newFile.createNewFile();
    System.out.println("New path: " + newFile.getPath());

    String templateName = "CodeJam";
    File templateFile = new File(projectPath + "Contests/Templates/" + templateName + ".java");

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
