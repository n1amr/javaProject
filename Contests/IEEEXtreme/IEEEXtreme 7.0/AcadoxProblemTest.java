import java.util.ArrayList;
import java.util.Scanner;


public class AcadoxProblemTest {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String[] str = input.nextLine().split(" ");
    int opIndex = getFirstOpIndex(str);
    if (opIndex < 2 || str.length % 2 == 0 ||
        getFirstOpIndex(str) % str.length != 1)
      System.out.println("ERROR");
    else {
      int nextOP = getFirstOpIndex(str), lastNum = 0;
      for (int i = 0; i < str.length; i++) {
        nextOP = nextOpIndex(str, i);
        int tempI = i;
        while (nextOpIndex(str, i + 1) != -1) {
          nextOP = nextOpIndex(str, i);
          i++;
        }

      }
    }
  }

  //serach right
  private static int nextOpIndex(String[] arr, int start) {
    for (int i = start; i < arr.length; i++) {
      if (arr[i].equals("+") || arr[i].equals("-") ||
          arr[i].equals("&") || arr[i].equals("|") ||
          arr[i].equals("~") || arr[i].equals("X"))
        return i;
    }
    return -1;
  }

  //search left
  private static int beforOpIndex(String[] arr, int start) {
    for (int i = start; i >= 0; i--) {
      if (arr[i].equals("+") || arr[i].equals("-") ||
          arr[i].equals("&") || arr[i].equals("|") ||
          arr[i].equals("~") || arr[i].equals("X"))
        return i;
    }
    return -1;
  }

  private static int getFirstOpIndex(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals("+") || arr[i].equals("-") ||
          arr[i].equals("&") || arr[i].equals("|") ||
          arr[i].equals("~") || arr[i].equals("X"))
        return i;
    }
    return -1;
  }

  private static int numOfOp(String[] arr) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals("+") || arr[i].equals("-") ||
          arr[i].equals("&") || arr[i].equals("|") ||
          arr[i].equals("~") || arr[i].equals("X"))
        count++;
    }
    return count;
  }

  private static int getFirstOpIndexAL(ArrayList<String> arr) {
    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i).equals("+") || arr.get(i).equals("-") ||
          arr.get(i).equals("&") || arr.get(i).equals("|") ||
          arr.get(i).equals("~") || arr.get(i).equals("X"))
        return i;
    }
    return -1;
  }

  private static int equ(ArrayList<String> str) {
    if (getFirstOpIndexAL(str) == -1)
      return Integer.parseInt(str.get(0));
    if (str.get(1).equals("+")) {
      int tempNum = Integer.parseInt(str.get(0));
      str.remove(0);
      str.remove(0);
      return tempNum + equ(str);
    }
    if (str.get(1).equals("-")) {
      int tempNum = Integer.parseInt(str.get(0));
      str.remove(0);
      str.remove(0);
      return tempNum - equ(str);
    }
    if (str.get(1).equals("|")) {
      int tempNum = Integer.parseInt(str.get(0));
      str.remove(0);
      str.remove(0);
      return tempNum | equ(str);
    }
    return -1;
  }
}
