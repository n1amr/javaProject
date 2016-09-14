import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.IOException;

public class TestJsoup {
  public static void main(String[] args) throws IOException {
    Document doc = Jsoup.connect("http://codeforces.com/problemset/problem/437/C").get();
    Elements newsHeadlines = doc.getElementsByAttributeValue("class", "title");
    System.out.println(newsHeadlines.text());
    System.out.println("END");
    // problemindexholder
  }
}
