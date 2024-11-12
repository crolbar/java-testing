package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public
class _684
{
    boolean dfs(HashMap<Integer, ArrayList<Integer>> ed,
                HashSet<Integer> seen,
                int i,
                int p,
                int start)
    {
        if (i == start && p != 0)
            return true;

        if (seen.contains(i))
            return false;

        seen.add(i);

        for (Integer nei : ed.get(i)) {
            if (p == nei)
                continue;

            if (dfs(ed, seen, nei, i, start)) {
                return true;
            }
        }

        return false;
    }

  public
    int[] findRedundantConnection(int[][] edges)
    {
        HashMap<Integer, ArrayList<Integer>> ed = new HashMap<>();
        for (int[] edge : edges) {
            ed.putIfAbsent(edge[0], new ArrayList<>());
            ed.putIfAbsent(edge[1], new ArrayList<>());

            ed.get(edge[0]).add(edge[1]);
            ed.get(edge[1]).add(edge[0]);
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            int[] edge = edges[i];

            if (dfs(ed, new HashSet<>(), edge[0], 0, edge[0]) &&
                dfs(ed, new HashSet<>(), edge[1], 0, edge[1])) {
                return edge;
            }
        }

        return new int[]{ 0 };
    }
}
