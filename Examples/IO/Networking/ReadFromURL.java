import java.net.URL;
import java.util.Scanner;

public class ReadFromURL {
  public static void main(String[] args) {
    try {
      URL url = new URL("http://www.google.com/index.html");
      Scanner scanner = new Scanner(url.openStream());
      while (scanner.hasNext())
        System.out.println(scanner.nextLine());
      System.out.println("------------------------------");
    } catch (Exception e) {
    }
  }
}
