public class _2015A_Standing_Ovation {
  public static Scanner in;
  public static PrintWriter out;

  public static void main(String[] args) throws FileNotFoundException {
    in = new Scanner(new BufferedInputStream(new FileInputStream(new File(
        "input.txt"))));
    out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(
        new File("output.txt"))));
    int nCases = in.nextInt();
    in.nextLine();
    for (int CASE = 1; CASE <= nCases; CASE++) {
      out.print("Case #" + CASE + ": ");
      solve();
    }
    out.close();
    System.err.println("Done");
  }

  static void solve() {
    int m = in.nextInt();
    String s = in.next();
    int stoodCount = 0, requiredFriends = 0;
    for (int requiredStood = 0; requiredStood < s.length(); requiredStood++) {
      int peopleHasThisShyness = s.charAt(requiredStood) - '0';
      if (peopleHasThisShyness == 0)
        continue;
      if (requiredStood != 0 && requiredStood > stoodCount) {
        requiredFriends += (requiredStood - stoodCount);
        stoodCount = requiredStood;
      }
      stoodCount += peopleHasThisShyness;
    }
    out.println(requiredFriends);
  }
}
