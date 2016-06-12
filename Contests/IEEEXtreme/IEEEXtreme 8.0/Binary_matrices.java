import java.util.*;

public class BinaryMatrices {

	public static int check(int T[][], boolean isPrinting, int N, int M) {
		int errors = 0;
		for (int i_1 = 1; i_1 < N; i_1++) {
			boolean badRow = true;
			for (int j = 0; j < M; j++)
				if (T[i_1][j] != T[i_1 + 1][j] && T[i_1 + 1][j] == T[N][j]) {
					badRow = false;
					break;
				}
			if (badRow) {
				errors++;
				if (isPrinting)
					System.out.println("i1=" + i_1);
			}

		}
		for (int i_1 = 1; i_1 < N - 1; i_1++)
			for (int i_2 = i_1 + 1; i_2 < N; i_2++) {
				boolean badRow = true;

				for (int j = 0; j < M; j++)
					if (T[i_1][j] != T[i_1 + 1][j]
									&& T[i_1 + 1][j] == T[i_2][j]
									&& T[i_2][j] == T[i_2 + 1][j]) {
						badRow = false;
						break;
					}
				if (badRow) {
					errors++;
					if (isPrinting)
						System.out.println("i1=" + i_1 + " i2=" + i_2);
				}

			}

		return errors;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int T[][] = new int[N + 1][M];
		for (int line = 1; line <= N; line++)
			for (int bit = 0; bit < M; bit++)
				T[line][bit] = in.nextInt();
		int errors = check(T, false, N, M);
		System.out.println(errors);
		if (errors != 0)
			check(T, true, N, M);
	}
}
