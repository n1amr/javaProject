public class Console {
  static HashMap<String, Mat> vars = new HashMap<String, Mat>();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    vars.put("ans", null);

    while (in.hasNextLine())
      run(in.nextLine());
  }

  static void run(String s) {
    int i = 0;
    String name = "";
    Mat value;
    if ((i = s.indexOf('=')) != -1) {
      name = s.substring(0, i).trim();
      value = evaluate(s.substring(i + 1).trim());

    } else
      value = evaluate(s.trim());
    if (name.length() == 0)
      name = "ans";
    value.setName(name);

    vars.put(value.getName(), value);
    vars.put("ans", value);
    System.out.println(value);
  }

  private static boolean isPartOfName(char c) {
    return Character.isDigit(c) || Character.isAlphabetic(c) || c == '_';
  }

  private static Mat evaluate(String s) {
    if (s.contains("*")) {
      String name1 = "", name2 = "";
      for (int i = 0; i < s.length(); i++) {
        while (i < s.length() && isPartOfName(s.charAt(i)))
          i++;
        name1 = s.substring(0, i).trim();
        while (i < s.length() && !isPartOfName(s.charAt(i)))
          i++;
        int start2 = i;
        while (i < s.length() && isPartOfName(s.charAt(i)))
          i++;
        name2 = s.substring(start2, i).trim();

        Mat A = vars.get(name1);
        Mat B = vars.get(name2);

        return Mat.multiply(A, B);
      }
    }
    return new Mat(s);
  }
}