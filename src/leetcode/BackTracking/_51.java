package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public
class _51
{
    String constructRow(int c, int n)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i == c) {
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }

        return sb.toString();
    }

    boolean r(int n,
           List<List<String>> res,
           int[][] queenColumns,
           int x,
           int y)
    {
        if (y >= n) {
            List<String> l = new ArrayList<>();
            for (int i = 0; i < y; i++) {
                l.add(constructRow(queenColumns[i][1], n));
            }
            res.add(l);
            return true;
        }

        // we check if we are at the same column as some of the 
        // above queens or if some of the queens above will hit
        // our row at the x that we are at
        for (int i = 0; i < y; i++) {
            int[] curr = queenColumns[i];

            if (x == curr[1])
                return false;

            int xHitBack = curr[1] - (y - curr[0]);
            int xHitFront = curr[1] + (y - curr[0]);

            if (x == xHitBack)
                return false;

            if (x == xHitFront)
                return false;
        }

        int[] curr = new int[]{y, x};;

        queenColumns[y] = curr;

        for (int i = 0; i < n; i++) {
            if (r(n, res, queenColumns, i, y + 1)) {
                break;
            }
        }

        return false;
    }

  public
    List<List<String>> solveNQueens(int n)
    {
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            r(n, res, new int[n][2], i, 0);
        }

        return res;
    }
}
