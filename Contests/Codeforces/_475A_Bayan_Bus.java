import java.util.*;

public class _475A_Bayan_Bus {

    public static void main(String[] args) {
	char[][] rows = { "|#.#.#.#.#.#.#.#.#.#.#.|D|)".toCharArray(),
		"|#.#.#.#.#.#.#.#.#.#.#.|.|".toCharArray(),
		"|#.......................|".toCharArray(),
		"|#.#.#.#.#.#.#.#.#.#.#.|.|)".toCharArray(),
		"+------------------------+".toCharArray() };
	int k = new Scanner(System.in).nextInt();
	for (int c = 1; c < 22; c += 2)
	    for (int r = 0; r < 4; r++)
		if (!(r == 2 && c != 1) && k-- > 0)
		    rows[r][c] = 'O';
	System.out.println(rows[4]);
	for (char[] row : rows)
	    System.out.println(row);
    }
}
