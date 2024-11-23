package leetcode.Graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public
class _778
{
    int[][] dirs = new int[][]{
        { -1, 0 }, // up
        { 0, 1 },  // right
        { 1, 0 },  // dow
        { 0, -1 }, // left
    };

  public
    int swimInWater(int[][] grid)
    {
        PriorityQueue<int[]> pq =
          new PriorityQueue<>(Comparator.comparingInt(l->l[0]));

        boolean[][] visited = new boolean[grid.length][grid.length];

        pq.add(new int[]{ grid[0][0], 0, 0 });
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == grid.length - 1 && c == grid.length - 1)
                return time;

            for (int i = 0; i < dirs.length; i++) {
                int[] dir = dirs[i];
                int nR = r + dir[0];
                int nC = c + dir[1];

                if (nR < 0 || nR >= grid.length)
                    continue;

                if (nC < 0 || nC >= grid.length)
                    continue;

                if (visited[nR][nC])
                    continue;

                visited[nR][nC] = true;
                pq.add(new int[]{ Math.max(time, grid[nR][nC]), nR, nC });
            }
        }

        return 0;
    }
}
