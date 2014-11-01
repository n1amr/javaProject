import java.util.*;

public class _478A_Initial_Bet {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int s = 0;
	for (int i = 0; i < 5; i++)
	    s += in.nextInt();
	if (s % 5 == 0 && s != 0)
	    System.out.println(s / 5);
	else
	    System.out.println(-1);
    }
}
