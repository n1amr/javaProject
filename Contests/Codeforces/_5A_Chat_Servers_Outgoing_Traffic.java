import java.util.Scanner;

public class _5A_Chat_Servers_Outgoing_Traffic {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int online = 0;
		int r = 0;
		while (in.hasNext()) {
			String s = in.nextLine();
			if (s.startsWith("+"))
				online++;
			else if (s.startsWith("-"))
				online--;
			else
				r += (s.length() - s.indexOf(":") - 1) * online;
		}
		System.out.println(r);
	}
}
