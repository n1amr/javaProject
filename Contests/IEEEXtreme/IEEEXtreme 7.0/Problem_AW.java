import java.util.Scanner;
import java.util.TreeMap;


public class Problem_AW {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TreeMap<String, String> reslt = new TreeMap<String, String>();
		int n = Integer.parseInt(input.next());
		String[] a1 = new String[n];
		String[] a2 = new String[n];

		for (int i = 0; i < n; i++)
			a1[i] = input.next();
		for (int i = 0; i < n; i++)
			a2[i] = input.next();

		for (int i = 0; i < n; i++)
			if (hasOneOnly(a2, a1[i].length()))
				reslt.put(a2[index], a1[i]);

		for (String i : a2)
			System.out.print(reslt.get(i) + " ");
	}

	static int index;

	private static boolean hasOneOnly(String[] arr, int len) {
		int count = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i].length() == len) {
				index = i;
				count++;
			}
		if (count == 1)
			return true;
		index = -1;
		return false;
	}
}
