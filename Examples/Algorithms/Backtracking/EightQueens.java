public class EightQueens {
	public static void main(String[] args) {
		search();
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < queens[i]; j++) {
				System.out.print(".");
			}
			System.out.print("*");
			for (int j = 0; j < 7-queens[i]; j++) {
				System.out.print(".");
			}
			System.out.println();
		}
	}

	private static int[] queens = { -1, -1, -1, -1, -1, -1, -1, -1 };

	private static boolean search() {
		// k - 1 indicates the number of queens placed so far
		// We are looking for a position in the kth row to place a queen
		int row = 0;
		while (row >= 0 && row <= 7) {
			// Find a position to place a queen in the kth row
			int j = findPosition(row);
			if (j < 0) {
				queens[row] = -1;
				row--; // back track to the previous row
			} else {
				queens[row] = j;
				row++;
			}
		}

		if (row == -1)
			return false; // No solution
		else
			return true; // A solution is found
	}

	public static int findPosition(int row) {
		int start = queens[row] + 1; // Search for a new placement

		for (int column = start; column < 8; column++) {
			if (isValid(row, column))
				return column; // (k, j) is the place to put the queen now
		}

		return -1;
	}

	/** Return true if a queen can be placed at (row, column) */
	public static boolean isValid(int row, int column) {
		for (int i = 1; i <= row; i++)
			if (queens[row - i] == column // Check column
					|| queens[row - i] == column - i // Check up-left diagonal
					|| queens[row - i] == column + i) // Check up-right diagonal
				return false; // There is a conflict
		return true; // No conflict
	}
}