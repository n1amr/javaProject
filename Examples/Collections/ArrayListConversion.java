public class ArrayListConversion {
  public static void main(String[] args) {
    Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    // To List
    List list = Arrays.asList(arr);
    System.out.println(list.get(5));

    // To Array
    Integer[] arr2 = (Integer[]) list.toArray();
    System.out.println(arr2[3]);
  }
}