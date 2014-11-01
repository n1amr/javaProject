import java.util.Scanner;


public class IEEEUniversityPartnershipProgramProblem {

	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.next());
		String str = input.next();
		
	}
	public static void f(String str) {
		
	}
	public static boolean isPalindrome(String str) {
		if(str.equals(rev(str)))
			return true;
		return false;
	}
	public static String rev(String str) {
	    char[] s = str.toCharArray();
	    int n = s.length;
	    int halfLength = n / 2;
	    for (int i=0; i<halfLength; i++)
	    {
	        char temp = s[i];
	        s[i] = s[n-1-i];
	        s[n-1-i] = temp;
	    }
	    return new String(s);
	}
}
