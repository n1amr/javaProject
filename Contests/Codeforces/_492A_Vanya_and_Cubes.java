import java.util.Scanner;

public class _492A_Vanya_and_Cubes {
    public static void main(String[] args) {
	int n = new Scanner(System.in).nextInt();
	int l = 0;
	while (n >= 0) {
	    l++;
	    n -= l * (l + 1) / 2;
	}
	System.out.println(l - 1);
    }
}