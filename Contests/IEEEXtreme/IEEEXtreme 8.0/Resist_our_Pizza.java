public class Resist_our_Pizza {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long r = 0;
    HashMap<String, Long> mp = new HashMap<String, Long>();
    mp.put("Anchovies", 50L);
    mp.put("Artichoke", 60L);
    mp.put("Bacon", 92L);
    mp.put("Broccoli", 24L);
    mp.put("Cheese", 80L);
    mp.put("Chicken", 30L);
    mp.put("Feta", 99L);
    mp.put("Garlic", 8L);
    mp.put("Ham", 46L);
    mp.put("Jalapeno", 5L);
    mp.put("Meatballs", 120L);
    mp.put("Mushrooms", 11L);
    mp.put("Olives", 25L);
    mp.put("Onions", 11L);
    mp.put("Pepperoni", 80L);
    mp.put("Peppers", 6L);
    mp.put("Pineapple", 21L);
    mp.put("Ricotta", 108L);
    mp.put("Sausage", 115L);
    mp.put("Spinach", 18L);
    mp.put("Tomatoes", 14L);
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      long pr = 270;
      Scanner d = new Scanner(in.next());
      d.useDelimiter(",");
      while (d.hasNext()) {
        pr += mp.get(d.next());
      }
      r += x * pr;
    }
    System.out.println("The total calorie intake is " + r);
  }
}
