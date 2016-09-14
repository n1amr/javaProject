import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
  static <E> ArrayList<E[]> permutations(E[] arr) {
    final ArrayList<E[]> resultList = new ArrayList<E[]>();
    final int l = arr.length;
    if (l == 0)
      return resultList;
    if (l == 1) {
      resultList.add(arr);
      return resultList;
    }

    E[] subClone = Arrays.copyOf(arr, l - 1);
    System.arraycopy(arr, 1, subClone, 0, l - 1);

    for (int i = 0; i < l; ++i) {
      E e = arr[i];
      if (i > 0)
        subClone[i - 1] = arr[0];
      final ArrayList<E[]> subPermutations = permutations(subClone);
      for (E[] sc : subPermutations) {
        E[] clone = Arrays.copyOf(arr, l);
        clone[0] = e;
        System.arraycopy(sc, 0, clone, 1, l - 1);
        resultList.add(clone);
      }
      if (i > 0)
        subClone[i - 1] = e;
    }
    return resultList;
  }

  static ArrayList<String> permutations(String arr) {
    final Character[] c = new Character[arr.length()];
    for (int i = 0; i < arr.length(); ++i)
      c[i] = arr.charAt(i);

    final ArrayList<Character[]> perms = permutations(c);
    final ArrayList<String> resultList = new ArrayList<String>(perms.size());

    for (Character[] p : perms)
      resultList.add(Arrays.toString(p));
    return resultList;
  }

  public static void main(String[] args) {
    ArrayList<String> str_perms = permutations("abc");
    for (String p : str_perms)
      System.out.println(p);

    ArrayList<Integer[]> int_perms = permutations(new Integer[]{1, 2, 3, 4});
    for (Integer[] p : int_perms)
      System.out.println(Arrays.toString(p));

  }
}
