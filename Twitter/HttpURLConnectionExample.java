import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionExample {
  private final String USER_AGENT = "Mozilla/5.0";

  /**
   * HTTP GET request
   *
   * @throws Exception
   * @param url
   */
  private void sendGet(String url) throws Exception {
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    // optional default is GET
    con.setRequestMethod("GET");

    // add request header
    con.setRequestProperty("User-Agent", USER_AGENT);

    System.out.println("Sending 'GET' request to URL : " + url);
    int responseCode = con.getResponseCode();
    System.out.println("Response Code : " + responseCode);

    // print result
    System.out.println(getHTTPResponse(con));
  }

  /**
   * HTTP POST request
   *
   * @throws Exception
   * @param url
   */
  private void sendPost(String url) throws Exception {
    URL obj = new URL(url);
    HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

    // add reuqest header
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

    String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

    // Send post request
    con.setDoOutput(true);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    wr.writeBytes(urlParameters);
    wr.flush();
    wr.close();


    System.out.println("Sending 'POST' request to URL : " + url);
    System.out.println("Post parameters : " + urlParameters);
    int responseCode = con.getResponseCode();
    System.out.println("Response Code : " + responseCode);

    // print result
    System.out.println(getHTTPResponse(con));
  }

  private static String getHTTPResponse(HttpURLConnection con) {
    StringBuffer response = new StringBuffer();
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null)
        response.append(inputLine);
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return response.toString();
  }

  public static void main(String[] args) throws Exception {
    HttpURLConnectionExample http = new HttpURLConnectionExample();

    System.out.println("Testing 1 - Send Http GET request");
    http.sendGet("http://www.google.com/search?q=mkyong");

    System.out.println();

    System.out.println("Testing 2 - Send Http POST request");
    http.sendPost("https://selfsolve.apple.com/wcResults.do");
  }
}