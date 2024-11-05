package leetcode.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    void dfs(int[][] heights, int r, int c, boolean[] reached, int prev)
    {
        // reached pacific
        if (r < 0 || c < 0) {
            reached[0] = true;
            return;
        }

        // reached atlantic
        if (r >= heights.length || c >= heights[0].length) {
            reached[1] = true;
            return;
        }

        if (prev < heights[r][c])
            return;

        int tmp = heights[r][c];
        heights[r][c] = Integer.MAX_VALUE;

        for (int i = 0; i < dirs.length; i++) {
            int[] dir = dirs[i];

            dfs(heights, r + dir[0], c + dir[1], reached, tmp);
            if (reached[0] && reached[1]) {
                break;
            }
        }

        heights[r][c] = tmp;
    }

  public
    List<List<Integer>> pacificAtlantic(int[][] heights)
    {
        List<List<Integer>> res = new ArrayList<>();

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                int[] currPoint = new int[]{ r, c };
                boolean[] reached = new boolean[2];

                dfs(heights, r, c, reached, Integer.MAX_VALUE);
                if (reached[0] && reached[1]) {
                    res.add(Arrays.stream(currPoint).boxed().collect(
                      Collectors.toList()));
                }
            }
        }

        return res;
    }
}
