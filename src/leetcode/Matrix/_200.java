package leetcode.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public
class _200
{
    int[][] dirs = new int[][]{
        { -1, 0 }, // up
        { 0, 1 },  // right
        { 1, 0 },  // dow
        { 0, -1 }, // left
    };

    void r(char[][] grid, Queue<int[]> q)
    {
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

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
                q.add(new int[]{ nextR, nextC });
            }
        }
    }

  public
    int numIslands(char[][] grid)
    {
        Queue<int[]> q = new LinkedList<int[]>();
        int c = 0;

        for (int ri = 0; ri < grid.length; ri++) {
            for (int ci = 0; ci < grid[0].length; ci++) {
                if (grid[ri][ci] == '1') {
                    grid[ri][ci] = '0';
                    q.add(new int[]{ ri, ci });
                    r(grid, q);
                    c++;
                }
            }
        }

        return c;
    }
}
