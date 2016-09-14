public class Regex {
  public static void main(String[] args) {
    String source = "Welcome to RegExr v2.0 by gskinner.com!\n\nEdit the Expression & Text to see matches. Roll over matches or the expression for details. Undo mistakes with ctrl-z. Save & Share expressions with friends or the Community. A full Reference & Help is available in the Library, or watch the video Tutorial.\n\nSample text for testing:\nabcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ\n0123456789 +-.,!@#$%^&*();\\/|<>\"\'\n12345 -98.7 3.141 .6180 9,000 +42\n555.123.4567	+1-(800)-555-2468\nfoo@demo.net	bar.ba@test.co.uk\nwww.demo.com	http://foo.co.uk/\nhttp://regexr.com/foo.html?q=bar\nhahaha haa hah!\n 255.255.255.255 ";
    Scanner scanner = new Scanner(System.in);
    // String pattern = scanner.nextLine();
    String pattern = "\\btest\\b";
    String replacement = "&";

    Matcher m = Pattern.compile(pattern).matcher(source);
    while (m.find())
      System.out.println(">>" + m.group() + "\n-----------------");

    System.out.println();
  }
}
