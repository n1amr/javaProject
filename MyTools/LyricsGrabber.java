import org.json.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LyricsGrabber {
  public static void main(String[] args) throws Exception {
    File propertiesFile = new File("settings.txt");
    if (!propertiesFile.exists())
      propertiesFile.createNewFile();
    Properties properties = new Properties();
    properties.load(new FileInputStream(propertiesFile));
    String browser = "";
    if ((browser = properties.getProperty("browser")) == null)
      reselectBrowser(propertiesFile);

    // Get song name from clipboard
    String songName = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    System.out.println("Searching for lyrics of: " + songName);

    // Open google for JSON result
    String google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
    String searchingFor = songName + " - lyrics";
    String charset = "UTF-8";

    URL url = new URL(google + URLEncoder.encode(searchingFor, charset));
    Scanner in = new Scanner(new InputStreamReader(url.openStream(), charset));

    String resultFromGoogle = "";
    while (in.hasNextLine())
      resultFromGoogle += in.nextLine();

    // Parsing JSON
    JSONObject mainObject = new JSONObject(resultFromGoogle);
    JSONObject responseData = mainObject.getJSONObject("responseData");
    JSONArray results = responseData.getJSONArray("results");
    JSONObject arrayElement = (JSONObject) results.get(0);
    String urltext = arrayElement.getString("url");
    System.out.println(urltext);

    // Open first result in firefox
    try {
      URL firstResultURL = new URL(urltext);
      String cmd = browser + " " + firstResultURL.toString();
      Runtime.getRuntime().exec(cmd);
      System.out.println(">>" + cmd);
    } catch (Exception err) {
      reselectBrowser(propertiesFile);
    }
    in.close();
  }

  static void reselectBrowser(File propertiesFile) throws Exception, IOException {
    System.out.println("Select your browser");
    JFileChooser chooser = new JFileChooser();
    FileFilter exeFilter = new FileNameExtensionFilter("Applications", new String[]{"exe"});
    chooser.setFileFilter(exeFilter);
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      Properties p = new Properties();
      p.put("browser", chooser.getSelectedFile().getAbsolutePath());
      p.store(new FileOutputStream(propertiesFile), null);
    }
    System.out.println("Press enter to search again...");
    Scanner console = new Scanner(System.in);
    console.nextLine();
    main(null);
    console.close();
  }
}