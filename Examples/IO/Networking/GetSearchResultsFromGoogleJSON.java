import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Scanner;

public class GetSearchResultsFromGoogleJSON {
  public static void main(String[] args) throws Exception {
    String google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
    String search = "amr";
    String charset = "UTF-8";

    URL url = new URL(google + URLEncoder.encode(search, charset));
    Scanner in = new Scanner(new InputStreamReader(url.openStream(), charset));

    String r = "";
    while (in.hasNextLine())
      r += in.nextLine() + "\n";
    System.err.println(r);

    JSONObject mainObject = new JSONObject(r);
    System.err.println(Arrays.toString(JSONObject.getNames(mainObject)));

    JSONObject responseData = mainObject.getJSONObject("responseData");
    JSONArray results = responseData.getJSONArray("results");
    JSONObject arrayElement = (JSONObject) results.get(0);
    String urltext = arrayElement.getString("url");
    System.out.println(urltext);
    in.close();
  }
}