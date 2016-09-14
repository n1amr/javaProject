import java.io.*;

public class _688_B_Lovely_Palindromes {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 32768);
    PrintWriter out = new PrintWriter(System.out);
    StringBuilder sb = new StringBuilder(reader.readLine());
    out.print(sb.toString());
    out.println(sb.reverse().toString());
    out.close();
  }
}
