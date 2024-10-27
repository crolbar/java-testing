package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
           List<String> l,
           HashSet<int[]> queenColumns,
           int x,
           int y)
    {
        if (y >= n) {
            res.add(new ArrayList<>(l));
            return true;
        }

        Iterator<int[]> iter = queenColumns.iterator();

        while (iter.hasNext()) {
            int[] curr = iter.next();

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

        queenColumns.add(curr);
        l.add(constructRow(x, n));

        for (int i = 0; i < n; i++) {
            if (r(n, res, l, queenColumns, i, y + 1)) {
                break;
            }
        }

        l.removeLast();
        queenColumns.remove(curr);

        return false;
    }

  public
    List<List<String>> solveNQueens(int n)
    {
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            r(n, res, new ArrayList<>(), new HashSet<>(), i, 0);
        }

        return res;
    }
}
