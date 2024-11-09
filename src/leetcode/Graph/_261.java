package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public
class _261
{
    boolean dfs(List<List<Integer>> adj,
                Set<Integer> visit,
                int i,
                int p)
    {
        if (visit.contains(i))
            return false;

        visit.add(i);
        for (Integer nei : adj.get(i)) {
            if (nei == p)
                continue;

            if (!dfs(adj, visit, nei, i)) {
                return false;
            }
        }

        return true;
    }

  public
    boolean validTree(int n, int[][] edges)
    {
        if (edges.length > n - 1)
            return false;

        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : edges) {
            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        }

        if (!dfs(adj, visit, 0, -1))
            return false;

        return visit.size() == n;
    }
}
