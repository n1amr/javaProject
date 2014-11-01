import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import org.json.*;

public class JSONParseTest {
    public static void main(String[] args) throws Exception {
	Scanner in = new Scanner(new File("g.JSON"));

	String text = "";
	while (in.hasNextLine())
	    text += in.nextLine();
	JSONObject obj = new JSONObject(text);
	System.out.println(Arrays.toString(JSONObject.getNames(obj)));

	JSONObject responseData = obj.getJSONObject("responseData");
	JSONArray results = responseData.getJSONArray("results");
	for (int i = 0; i < results.length(); i++) {
	    JSONObject arrayElement = (JSONObject) results.get(i);
	    String url = arrayElement.getString("url");
	    System.out.println(url);

	}
	in.close();
    }
}

// g.JSON

// {
// "responseData":{
// "results":[
// {
// "GsearchResultClass":"GwebSearch",
// "unescapedUrl":"http://stackoverflow.com/",
// "url":"http://stackoverflow.com/",
// "visibleUrl":"stackoverflow.com",
// "cacheUrl":"http://www.google.com/search?q\u003dcache:U1GC2GYOToIJ:stackoverflow.com",
// "title":"Stack Overflow",
// "titleNoFormatting":"Stack Overflow",
// "content":"A language-independent collaboratively edited question and answer site for \nprogrammers."
// },
// {
// "GsearchResultClass":"GwebSearch",
// "unescapedUrl":"http://careers.stackoverflow.com/",
// "url":"http://careers.stackoverflow.com/",
// "visibleUrl":"careers.stackoverflow.com",
// "cacheUrl":"http://www.google.com/search?q\u003dcache:HdL8laOgt04J:careers.stackoverflow.com",
// "title":"Stack Overflow Careers",
// "titleNoFormatting":"Stack Overflow Careers",
// "content":"keywords: C# - Node.js - Java - iPhone - Ruby - Python - ASP."
// },
// {
// "GsearchResultClass":"GwebSearch",
// "unescapedUrl":"http://stackoverflow.com/questions",
// "url":"http://stackoverflow.com/questions",
// "visibleUrl":"stackoverflow.com",
// "cacheUrl":"http://www.google.com/search?q\u003dcache:6S_0sErDKfQJ:stackoverflow.com",
// "title":"Newest Questions - Stack Overflow",
// "titleNoFormatting":"Newest Questions - Stack Overflow",
// "content":"I tried to resist myself not to seek help for this apparently simple ..."
// },
// {
// "GsearchResultClass":"GwebSearch",
// "unescapedUrl":"http://michael.richter.name/blogs/why-i-no-longer-contribute-to-stackoverflow",
// "url":"http://michael.richter.name/blogs/why-i-no-longer-contribute-to-stackoverflow",
// "visibleUrl":"michael.richter.name",
// "cacheUrl":"http://www.google.com/search?q\u003dcache:6TtXvyGddR4J:michael.richter.name",
// "title":"Why I no longer contribute to \u003cb\u003eStackOverflow\u003c/b\u003e — Michael T. Richter",
// "titleNoFormatting":"Why I no longer contribute to StackOverflow — Michael T. Richter",
// "content":"I was active in the \u003cb\u003eStackOverflow\u003c/b\u003e (and the broader Stack Exchange) community \nfor a while. I no longer am. Here\u0026#39;s why."
// }
// ],
// "cursor":{
// "resultCount":"4,140,000",
// "pages":[
// {
// "start":"0",
// "label":1
// },
// {
// "start":"4",
// "label":2
// },
// {
// "start":"8",
// "label":3
// },
// {
// "start":"12",
// "label":4
// },
// {
// "start":"16",
// "label":5
// },
// {
// "start":"20",
// "label":6
// },
// {
// "start":"24",
// "label":7
// },
// {
// "start":"28",
// "label":8
// }
// ],
// "estimatedResultCount":"4140000",
// "currentPageIndex":0,
// "moreResultsUrl":"http://www.google.com/search?oe\u003dutf8\u0026ie\u003dutf8\u0026source\u003duds\u0026start\u003d0\u0026hl\u003den\u0026q\u003dstackoverflow",
// "searchResultTime":"0.12"
// }
// },
// "responseDetails":null,
// "responseStatus":200
// }