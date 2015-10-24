import java.util.*;

public class _326B_Duff_in_Love {
    public static void main(String[] args) {
        long n = (new Scanner(System.in)).nextLong();
        long i = 1;
        while (i * i++ < n)
            while (n % (i * i) == 0)
                n /= i;
        System.out.println(n);
    }
}