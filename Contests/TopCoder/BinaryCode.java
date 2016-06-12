import java.util.Arrays;

public class BinaryCode {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(decode("111")));
	}

	static String[] decode(String message) {
		int n = message.length();
		String[] ret = new String[2];
		char[][] sol = new char[2][];
		int[] s = new int[n + 2];
		for (int i = 0; i < n; i++)
			s[i + 1] = message.charAt(i) - '0';
		for (int j = 0; j < 2; j++) {
			int[] possibleSeq = new int[n + 2];
			possibleSeq[1] = j;

			for (int i = 1; i < n + 1; i++)
				possibleSeq[i + 1] = s[i] - possibleSeq[i - 1] - possibleSeq[i];
			boolean valid = possibleSeq[possibleSeq.length - 1] == 0;
			ret[j] = null;
			sol[j] = new char[n];
			for (int i = 0; valid && i < n; i++)
				if (possibleSeq[i + 1] >= 0)
					sol[j][i] = (char) (possibleSeq[i + 1] + '0');
				else
					valid = false;

			if (valid)
				ret[j] = new String(sol[j]);
		}
		return ret;

	}
}
