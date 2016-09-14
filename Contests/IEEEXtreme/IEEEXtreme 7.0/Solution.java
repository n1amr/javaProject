import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Solution {

  static boolean valid = true;

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ArrayDeque<String> operations = new ArrayDeque<String>();
    Scanner input = new Scanner(System.in);
    String[] arrHEX = input.nextLine().split(" ");
    String[] arr = new String[arrHEX.length];
    int count = 0;
    for (String i : arrHEX) {
      if (i.equals("+") || i.equals("-") || i.equals("&")
          || i.equals("|") || i.equals("X"))
        arr[count] = i;
      else
        arr[count] = Integer.toString(Integer.parseInt(i, 16));
      count++;
    }
    for (String i : arr)
      if (i.equals("+") || i.equals("-") || i.equals("&")
          || i.equals("|") || i.equals("X")) {
        f(operations, i);
        if (!valid)
          break;
      } else
        operations.push(i);
    if (valid) {
      if (operations.size() == 1) {
        int intrslt = Integer.parseInt(operations.pop());
        if (intrslt >= 0 && intrslt <= 65535) {
          String rslt = Integer.toHexString(intrslt);
          rslt = rslt.toUpperCase();
          if (rslt.length() < 4)
            while (rslt.length() != 4)
              rslt = "0" + rslt;
          System.out.println(rslt);
        } else
          System.out.println("0000");
      } else
        System.out.println("ERROR");
    } else
      System.out.println("ERROR");
  }

  private static void f(ArrayDeque<String> s, String op) {
    try {
      int num1, num2;
      if (op.equals("+")) {
        num1 = Integer.parseInt(s.getLast());
        s.removeLast();
        num2 = Integer.parseInt(s.getLast());
        s.removeLast();
        s.push(Integer.toString(num1 + num2));
      } else if (op.equals("-")) {
        num1 = Integer.parseInt(s.getLast());
        s.removeLast();
        num2 = Integer.parseInt(s.getLast());
        s.removeLast();
        s.push(Integer.toString(num1 - num2));
      } else if (op.equals("&")) {
        num1 = Integer.parseInt(s.getLast());
        s.removeLast();
        num2 = Integer.parseInt(s.getLast());
        s.removeLast();
        s.push(Integer.toString(num1 & num2));
      } else if (op.equals("|")) {
        num1 = Integer.parseInt(s.getLast());
        s.removeLast();
        num2 = Integer.parseInt(s.getLast());
        s.removeLast();
        s.push(Integer.toString(num1 | num2));
      } else if (op.equals("^")) {
        num1 = Integer.parseInt(s.getLast());
        s.removeLast();
        num2 = Integer.parseInt(s.getLast());
        s.removeLast();
        s.push(Integer.toString(num1 ^ num2));
      } else if (op.equals("~")) {
        num1 = Integer.parseInt(s.getLast());
        s.removeLast();
        s.push(Integer.toString(~num1));
      }
    } catch (EmptyStackException e) {
      valid = false;
    } catch (NoSuchElementException e2) {
      valid = false;
    } catch (NumberFormatException e3) {
      valid = false;
    }
  }

}
