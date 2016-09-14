public class URLConnectionDemo {
  public static void main(String[] args) {
    try {
      //Connecting
      URL url = new URL("http://www.amrood.com");
      URLConnection urlConnection = url.openConnection();
      HttpURLConnection httpURLConnection = null;
      if (urlConnection instanceof HttpURLConnection) {
        httpURLConnection = (HttpURLConnection) urlConnection;
      } else {
        System.out.println("Please enter an HTTP URL.");
        return;
      }

      //Reading
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
          httpURLConnection.getInputStream()));
      String urlString = "";
      String current;
      while ((current = bufferedReader.readLine()) != null) {
        System.out.println(current);
      }
      System.out.println(urlString);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}