package leetcode.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public
class _417
{
    int[][] dirs = new int[][]{
        { -1, 0 }, // up
        { 0, 1 },  // right
        { 1, 0 },  // dow
        { 0, -1 }, // left
    };

  private
    void bfs(int[][] heights, Queue<int[]> q, boolean[][] seen) 
    {
        while (!q.isEmpty()) {
            int[] currPoint = q.poll();
            int r = currPoint[0];
            int c = currPoint[1];

            seen[r][c] = true;

            for (int i = 0; i < dirs.length; i++) {
                int[] dir = dirs[i];
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= heights.length)
                    continue;

                if (nc < 0 || nc >= heights[0].length)
                    continue;

                if (seen[nr][nc])
                    continue;

                if (heights[r][c] > heights[nr][nc])
                    continue;

                q.add(new int[]{nr, nc});
            }
        }
    }

  public
    List<List<Integer>> pacificAtlantic(int[][] heights)
    {
        List<List<Integer>> res = new ArrayList<>();

        boolean[][] pacSeen = new boolean[heights.length][heights[0].length];
        boolean[][] atlSeen = new boolean[heights.length][heights[0].length];

        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        for (int c = 0; c < heights[0].length; c++) {
            pacQ.add(new int[]{0, c});
            atlQ.add(new int[]{heights.length - 1, c});
        }

        for (int r = 0; r < heights.length; r++) {
            pacQ.add(new int[]{r, 0});
            atlQ.add(new int[]{r, heights[0].length - 1});
        }

        bfs(heights, pacQ, pacSeen);
        bfs(heights, atlQ, atlSeen);

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                if (pacSeen[r][c] && atlSeen[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }
}
