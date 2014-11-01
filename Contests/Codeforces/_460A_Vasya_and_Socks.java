import java.util.Scanner;

public class _460A_Vasya_and_Socks {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nSocks = scanner.nextInt();
		int m = scanner.nextInt();
		int day=0;
		while(nSocks>0){
			day++;
			nSocks--;
			if(day%m==0)
				nSocks++;
		}
		System.out.println(day);
		scanner.close();
	}
}
