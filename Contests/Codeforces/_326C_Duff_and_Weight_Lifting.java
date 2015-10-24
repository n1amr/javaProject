import java.util.*;

public class _326C_Duff_and_Weight_Lifting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] count = new int[1000000 + 50];

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            count[in.nextInt()]++;
        }
        in.close();

        int x = 0;
        int TO = count.length - 1;
        for (int i = 0; i < TO; i++) {
            count[i + 1] += count[i] >> 1;
            x += count[i] & 1;
        }
        System.out.println(x);
    }
}
