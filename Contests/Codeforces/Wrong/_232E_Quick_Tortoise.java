import java.util.HashSet;
import java.util.Scanner;

public class _232E_Quick_Tortoise {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] grid = new int[n][m];
    for (int i = 0; i < n; i++) {
      String line = in.next();
      for (int j = 0; j < line.length(); j++)
        if (line.charAt(j) == '.')
          grid[i][j] = 1;
    }
    // for (int i = 0; i < n; i++) {
    // System.err.println();
    // for (int j = 0; j < m; j++)
    // if (grid[i][j] == 1)
    // System.err.printf("%4d", i * m + j);
    // else
    // System.err.print(" ");
    // System.err.println();
    // }
    HashSet[][] fillGrid = new HashSet[n][m];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        fillGrid[i][j] = new HashSet<>();
    for (int i = n - 1; i >= 0; i--)
      for (int j = m - 1; j >= 0; j--)
        fill(grid, fillGrid, i, j);

    int q = in.nextInt();
    int x1, y1, x2, y2;
    for (int i = 0; i < q; i++) {
      x1 = in.nextInt() - 1;
      y1 = in.nextInt() - 1;
      x2 = in.nextInt() - 1;
      y2 = in.nextInt() - 1;
      if (fillGrid[x1][y1].contains(x2 * grid[0].length + y2))
        System.out.println("Yes");
      else
        System.out.println("No");
    }

  }

  private static void fill(int[][] grid, HashSet[][] fillGrid, int i, int j) {
    if (i >= fillGrid.length || j >= fillGrid[0].length || grid[i][j] != 1)
      return;
    if (i + 1 < fillGrid.length && grid[i + 1][j] == 1)
      fillGrid[i][j].add((i + 1) * grid[0].length + j);
    if (j + 1 < fillGrid[0].length && grid[i][j + 1] == 1)
      fillGrid[i][j].add(i * grid[0].length + j + 1);
    fill(grid, fillGrid, i, j, i, j);
  }

  private static void fill(int[][] grid, HashSet[][] fillGrid, int x, int y, int i, int j) {
    if (i >= fillGrid.length || j >= fillGrid[0].length || grid[i][j] != 1)
      return;
    fill(grid, fillGrid, x, y, i, j + 1);
    fill(grid, fillGrid, x, y, i + 1, j);

    if (j + 1 < fillGrid[0].length && grid[i][j + 1] == 1) {
      fillGrid[x][y].add(i * grid[0].length + j + 1);
      if (fillGrid[i][j + 1].size() != 0)
        fillGrid[x][y].addAll(fillGrid[i][j + 1]);
      j++;
    }
    if (i + 1 < fillGrid.length && grid[i + 1][j] == 1) {
      fillGrid[x][y].add((i + 1) * grid[0].length + j);
      if (fillGrid[i + 1][j].size() != 0)
        fillGrid[x][y].addAll(fillGrid[i + 1][j]);
      i++;
    }
  }
}