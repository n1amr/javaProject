import java.util.Scanner;

public class _312A_Whose_sentence_is_it_ {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    for (int i = 0; i < n; i++) {
      String s = in.nextLine();
      if (s.endsWith("lala.") ^ s.startsWith("miao.")) {
        if (s.endsWith("lala."))
          System.out.println("Freda's");
        else if (s.startsWith("miao."))
          System.out.println("Rainbow's");
      } else
        System.out.println("OMG>.< I don't know!");
    }
  }
}
