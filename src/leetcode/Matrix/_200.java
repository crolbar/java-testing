package leetcode.Matrix;

public
class _200
{
    int[][] dirs = new int[][]{
        { -1, 0 }, // up
        { 0, 1 },  // right
        { 1, 0 },  // dow
        { 0, -1 }, // left
    };

    void dfs(char[][] grid, int r, int c)
    {
        for (int i = 0; i < dirs.length; i++) {
            int[] dir = dirs[i];

            int nextR = r + dir[0];
            int nextC = c + dir[1];

            if (nextR >= grid.length || nextR < 0)
                continue;

            if (nextC >= grid[0].length || nextC < 0)
                continue;

            if (grid[nextR][nextC] == '0')
                continue;

            grid[nextR][nextC] = '0';
            dfs(grid, nextR, nextC);
        }
    }

  public
    int numIslands(char[][] grid)
    {
        int c = 0;

        for (int ri = 0; ri < grid.length; ri++) {
            for (int ci = 0; ci < grid[0].length; ci++) {
                if (grid[ri][ci] == '1') {
                    grid[ri][ci] = '0';
                    dfs(grid, ri, ci);
                    c++;
                }
            }
        }

        return c;
    }
}