import java.util.HashMap;
import java.util.Scanner;

public class _4C_Registration_System {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    HashMap<String, Integer> a = new HashMap<>(n + 5);
    for (int i = 0; i < n; i++) {
      String entry = in.next();
      if (a.containsKey(entry)) {
        Integer oldValue = a.get(entry);
        a.put(entry, oldValue + 1);
        System.out.println(entry + oldValue);
      } else {
        a.put(entry, 1);
        System.out.println("OK");
      }
    }
  }
}
