import java.util.ArrayList;
import java.util.Scanner;


public class Problem_AB {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<String>();
		String str = input.next();
		arr.add(str);
		while(!str.isEmpty()) {
			arr.add(str);
			if(arr.size() >= 31) {
				System.out.println("Too long");
				break;
			}
			str = "";
			str = input.next();
		}
	}
	
}
