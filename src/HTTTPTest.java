public class HTTTPTest {
    public String getHTML(String urlToRead) {
	URL url;
	HttpURLConnection conn;
	BufferedReader rd;
	String line;
	String result = "";
	try {
	    url = new URL(urlToRead);
	    conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    rd = new BufferedReader(
		    new InputStreamReader(conn.getInputStream()));
	    while ((line = rd.readLine()) != null) {
		result += line;
	    }
	    rd.close();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return result;
    }

    public static void main(String args[]) {
	c c = new c();
	System.out.println(c.getHTML(args[0]));
    }
}
