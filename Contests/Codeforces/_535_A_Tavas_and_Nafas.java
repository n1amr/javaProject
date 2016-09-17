import java.util.Scanner;

public class _535_A_Tavas_and_Nafas {
  public static void main(String[] args) throws Exception {
    int n = new Scanner(System.in).nextInt();
    String[] ones = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    String[] teens = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    String[] tens = new String[]{"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    String ans;
    if (n < 10)
      ans = ones[n];
    else if (n < 20)
      ans = teens[n % 10];
    else
      ans = tens[n / 10] + ((n % 10 > 0) ? "-" + ones[n % 10] : "");
    System.out.println(ans);
  }
}
