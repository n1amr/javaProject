import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PrintSystemProperties {
  private static void main(String[] args) {
    printSystemProperties();
  }

  public static void printSystemProperties() {
    Properties properties = System.getProperties();
    Set set = properties.keySet();
    System.out.println();
    for (Iterator i = set.iterator(); i.hasNext(); ) {
      String s = i.next().toString();
      System.out.println(s + "=" + properties.getProperty(s));
    }
  }
}
