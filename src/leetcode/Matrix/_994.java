package leetcode.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public
class _994
{
    int[][] dirs = new int[][]{
        { -1, 0 },
        { 0, 1 },
        { 1, 0 },
        { 0, -1 },
    };

    void bfs(int[][] grid, Queue<int[]> q, int[] time, int[] fresh)
    {
        while (!q.isEmpty()) {
            for (int qi = 0, size = q.size(); qi < size; qi++) {
                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                for (int i = 0; i < dirs.length; i++) {
                    int[] dir = dirs[i];

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= grid.length || nr < 0)
                        continue;

                    if (nc >= grid[0].length || nc < 0)
                        continue;

                    if (grid[nr][nc] == 0 || grid[nr][nc] == 2)
                        continue;

                    grid[nr][nc] = 2;
                    fresh[0]--;

                    q.add(new int[]{ nr, nc });
                }

                if (q.isEmpty())
                    return;
            }

            time[0]++;
        }
    }

  public
    int orangesRotting(int[][] grid)
    {
        int[] time = new int[]{ 0 };
        Queue<int[]> q = new LinkedList<>();
        int[] fresh = new int[]{0};

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    fresh[0]++;
                }

                if (grid[r][c] == 2) {
                    q.add(new int[]{ r, c });
                }
            }
        }

        bfs(grid, q, time, fresh);

        if (fresh[0] > 0)
            return -1;

        return time[0];
    }
}
