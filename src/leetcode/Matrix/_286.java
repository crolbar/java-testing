package leetcode.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public
class _286
{
    int[][] dirs = new int[][]{
        { -1, 0 }, // up
        { 0, 1 },  // right
        { 1, 0 },  // dow
        { 0, -1 }, // left
    };

    void bfs(int[][] grid,
             Queue<int[]> q,
             int[] tresure,
             int dist,
             boolean[][] visited)
    {
        while (!q.isEmpty()) {
            int size = q.size();

            // loop through all of the groud at this level/distance
            for (int qi = 0; qi < size; qi++) {
                int[] currPoint = q.poll();
                int r = currPoint[0];
                int c = currPoint[1];

                visited[r][c] = true;
                grid[r][c] = Math.min(grid[r][c], dist);

                for (int i = 0; i < dirs.length; i++) {
                    int[] dir = dirs[i];

                    int nextR = r + dir[0];
                    int nextC = c + dir[1];

                    // out of grid (bottom/top)
                    if (nextR >= grid.length || nextR < 0)
                        continue;

                    // out of grid (right/left)
                    if (nextC >= grid[0].length || nextC < 0)
                        continue;

                    // have already visited
                    if (visited[nextR][nextC])
                        continue;

                    // can't traverse
                    if (grid[nextR][nextC] == -1)
                        continue;

                    // another gate that we will visit later in the first loop
                    if (grid[nextR][nextC] == 0 && nextR != tresure[0] &&
                        nextC != tresure[1])
                        continue;

                    q.add(new int[]{ nextR, nextC });
                }
            }

            dist++;
        }
    }

  public
    void islandsAndTreasure(int[][] grid)
    {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{ r, c });
                    bfs(grid,
                        q,
                        new int[]{ r, c },
                        0,
                        new boolean[grid.length][grid[0].length]);
                }
            }
        }
    }
}
