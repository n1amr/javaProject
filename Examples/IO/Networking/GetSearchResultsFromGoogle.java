public class GetSearchResultsFromGoogle {
  public static void main(String[] args) throws Exception, IOException {
    String url = "http://www.google.com/search?q=";
    String charset = "UTF-8";
    String key = "java";
    String query = String.format("%s", URLEncoder.encode(key, charset));
    URLConnection con = new URL(url + query).openConnection();
    con.setRequestProperty("User-Agent",
        "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    while ((inputLine = in.readLine()) != null)
      System.out.println(inputLine);
    in.close();
  }
}