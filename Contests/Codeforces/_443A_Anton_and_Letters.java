import java.util.Scanner;

public class _443A_Anton_and_Letters {
    public static void main(String[] args) {
	String s = new Scanner(System.in).nextLine();
	int[] count = new int[26];
	for (int i = 0; i < s.length(); i++)
	    if (Character.isLetter(s.charAt(i)))
		count[s.charAt(i) - 'a']++;
	int r = 0;
	for (int i = 0; i < count.length; i++)
	    if (count[i] != 0)
		r++;
	System.out.println(r);
    }
}
