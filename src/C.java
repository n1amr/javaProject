import java.io.*;
import java.util.*;

public class C {
    public static Scanner in = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(
            new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();

        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        for (int i = 0; i < n * n; i++) {
            int a = in.nextInt();

            if (!mp.containsKey(a))
                mp.put(a, 0);

            mp.put(a, mp.get(a) + 1);
        }

        Map<Integer, Integer> mp2 = new HashMap<Integer, Integer>();

        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> allnumbers = new ArrayList<Integer>();
        for (Integer i : mp.keySet()) {
            allnumbers.add(i);
            if (mp.get(i) % 2 != 0) {
                arr.add(i);
                mp.put(i, mp.get(i) - 1);
            }
        }

        Collections.sort(allnumbers);
        Collections.reverse(allnumbers);

        System.out.println(allnumbers);

        while (arr.size() < n) {
            for (int i = 0; i < arr.size(); i++) {
                for (int j = i + 1; j < arr.size(); j++) {
                    int g = gcd(arr.get(i), arr.get(j));
                    mp.put(g, mp.get(g) - 2);
                }
            }

            for (Integer i : allnumbers) {
                int c = mp.get(i);

                int cn = n;
                while (cn * cn > c) {
                    cn--;
                }

                for (int k = 0; k < cn; k++)
                    arr.add(i);
                mp.put(i, c - cn * cn);

                break;
            }
        }
        System.out.println(mp);
        for (Integer i : arr)
            out.print(i + " ");
        out.println();
        out.close();
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
