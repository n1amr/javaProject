import java.io.*;
import java.net.*;

import javax.net.ssl.*;

import org.json.*;

public class TwitterAuthentication {
    private final static String USER_AGENT = "Mozilla/5.0";

    public static String CONSUMER_KEY = "P2f72jqoc3EUTIvtFH0W1rVDw";
    public static String CONSUMER_SECRET = "MivorGgxPcVdBhCevyFiwW3UPyGbGnW5edXMr92ehRCQXkjp1j";
    public static String ACCESS_TOKEN = "66505231-u0KqEbt4KmcHHFcVS7qR8psrifLPhXXfra4Rjg4Nc";
    public static String ACCESS_TOKEN_SECRET = "pA4YCFIOZZp1A8EDNml3dKzTLfzUGuAcQ2CEzgRDulqML";

    private static String encodeKeys(String consumerKey, String consumerSecret) {
	try {
	    String encodedConsumerKey = URLEncoder.encode(consumerKey, "UTF-8");
	    String encodedConsumerSecret = URLEncoder.encode(consumerSecret,
		    "UTF-8");
	    String fullKey = encodedConsumerKey + ":" + encodedConsumerSecret;

	    return Base64.encodeBase64(fullKey);
	} catch (UnsupportedEncodingException e) {
	    return new String();
	}
    }

    // Constructs the request for requesting a bearer token and returns that
    // token as a string
    private static String requestBearerToken(String endPointUrl)
	    throws IOException {
	HttpsURLConnection connection = null;
	String encodedCredentials = encodeKeys(CONSUMER_KEY, CONSUMER_SECRET);
	encodedCredentials = URLEncoder.encode(encodedCredentials, "UTF-8");

	try {
	    URL url = new URL(endPointUrl);
	    connection = (HttpsURLConnection) url.openConnection();
	    connection.setDoOutput(true);
	    connection.setDoInput(true);
	    connection.setRequestMethod("POST");
	    connection.setRequestProperty("Host", "api.twitter.com");
	    connection.setRequestProperty("User-Agent", "N1amr");
	    connection.setRequestProperty("Authorization", "Basic "
		    + encodedCredentials);
	    connection.setRequestProperty("Content-Type",
		    "application/x-www-form-urlencoded;charset=UTF-8");
	    connection.setRequestProperty("Content-Length", "29");
	    connection.setUseCaches(false);
	    writeRequest(connection, "grant_type=client_credentials");

	    // Parse the JSON response into a JSON mapped object to fetch fields
	    // from.
	    String response = readResponse(connection);
	    if (response != null) {
		System.out.println("response = " + response);
		JSONObject obj = new JSONObject(response);

		if (obj != null) {
		    String tokenType = (String) obj.get("token_type");
		    String token = (String) obj.get("access_token");

		    return tokenType.equals("bearer") && token != null ? token
			    : "";
		}
	    }
	    return new String();
	} catch (MalformedURLException e) {
	    throw new IOException("Invalid endpoint URL specified.", e);
	} finally {
	    if (connection != null)
		connection.disconnect();
	}
    }

    // Fetches the first tweet from a given user's timeline
    private static String fetchTimelineTweet(String endPointUrl)
	    throws IOException {
	HttpsURLConnection connection = null;

	try {
	    URL url = new URL(endPointUrl);
	    connection = (HttpsURLConnection) url.openConnection();
	    connection.setDoOutput(true);
	    connection.setDoInput(true);
	    connection.setRequestMethod("GET");
	    connection.setRequestProperty("Host", "api.twitter.com");
	    connection.setRequestProperty("User-Agent", "Your Program Name");
	    connection.setRequestProperty("Authorization", "Bearer "
		    + bearerToken);
	    connection.setUseCaches(false);

	    // Parse the JSON response into a JSON mapped object to fetch fields
	    // from.
	    JSONArray obj = new JSONArray(readResponse(connection));

	    if (obj != null) {
		String tweet = ((JSONObject) obj.get(0)).get("text").toString();

		return tweet != null ? tweet : "";
	    }
	    return new String();
	} catch (MalformedURLException e) {
	    throw new IOException("Invalid endpoint URL specified.", e);
	} finally {
	    if (connection != null)
		connection.disconnect();
	}
    }

    static String bearerToken = "";
    static String endPointUrl = "https://api.twitter.com/oauth2/token";

    public static void main(String[] args) throws IOException {
	bearerToken = requestBearerToken(endPointUrl);
	System.out.println(encodeKeys(CONSUMER_KEY, CONSUMER_SECRET));
    }

    // Writes a request to a connection
    private static boolean writeRequest(HttpsURLConnection connection,
	    String textBody) {
	try {
	    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(
		    connection.getOutputStream()));
	    wr.write(textBody);
	    wr.flush();
	    wr.close();

	    return true;
	} catch (IOException e) {
	    return false;
	}
    }

    // Reads a response for a given connection and returns it as a string.
    private static String readResponse(HttpsURLConnection connection) {
	try {
	    StringBuilder str = new StringBuilder();

	    BufferedReader br = new BufferedReader(new InputStreamReader(
		    connection.getInputStream()));
	    String line = "";
	    while ((line = br.readLine()) != null) {
		str.append(line + System.getProperty("line.separator"));
	    }
	    return str.toString();
	} catch (IOException e) {
	    return new String();
	}
    }

}
