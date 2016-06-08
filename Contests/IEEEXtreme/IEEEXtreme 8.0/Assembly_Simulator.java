import java.util.Scanner;

public class Assembly_Simulator {
	static int[] mem;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine(), 16) + 1;
		mem = new int[n];
		while (in.hasNext()) {
			String cmd = in.next();
			String[] params = in.nextLine().trim().split(",");
			if (cmd.equals("PRINT")) {
				if (params.length == 1) {
					print(params[0]);
				} else if (params.length == 2) {
					print(params[0], params[1]);
				}
			} else if (cmd.equals("MOVE")) {
				if (params.length == 1) {
					print(params[0]);
				} else if (params.length == 2) {
					print(params[0], params[1]);
				}
			}

		}
	}

	static void print(String pos) {
		print(pos, pos);
	}

	static void print(String start, String end) {
		int l = Integer.valueOf(start, 16);
		int r = Integer.valueOf(end, 16);

		for (int i = l; i <= r; i++) {
			System.out.printf("%02X ", mem[i]);
		}
		System.out.println();
	}
}
