import java.util.Scanner;

public class _510B_Fox_And_Two_Dots {
  static int n, m;
  static boolean isVisisted[][];

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    m = in.nextInt();
    char[][] grid = new char[n][m];
    isVisisted = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      String s = in.next();
      grid[i] = s.toCharArray();
    }
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (findPath(grid, i, j, i, j, 1)) {
          System.out.println("Yes");
          return;
        }
    System.out.println("No");
  }

  private static boolean findPath(char[][] grid, int i, int j, int x, int y, int l) {
    isVisisted[i][j] = true;
    if (i >= n || j >= m || i < 0 || j < 0)
      return false;
    if (l > 3 && (i == x && j == y || i == x && (j + 1 == y || j - 1 == y) || j == y && (i + 1 == x || i - 1 == x)))
      return true;

    if (i + 1 < n && grid[i][j] == grid[i + 1][j] && !isVisisted[i + 1][j]) {
      if (findPath(grid, i + 1, j, x, y, l + 1))
        return true;
      isVisisted[i + 1][j] = false;
    }
    if (i - 1 >= 0 && grid[i][j] == grid[i - 1][j] && !isVisisted[i - 1][j]) {
      if (findPath(grid, i - 1, j, x, y, l + 1))
        return true;
      isVisisted[i - 1][j] = false;
    }

    if (j + 1 < m && grid[i][j] == grid[i][j + 1] && !isVisisted[i][j + 1]) {
      if (findPath(grid, i, j + 1, x, y, l + 1))
        return true;
      isVisisted[i][j + 1] = false;
    }

    if (j - 1 >= 0 && grid[i][j] == grid[i][j - 1] && !isVisisted[i][j - 1]) {
      if (findPath(grid, i, j - 1, x, y, l + 1))
        return true;
      isVisisted[i][j - 1] = false;
    }

    return false;
  }
}
