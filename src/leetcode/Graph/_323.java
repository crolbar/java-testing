package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public
class _323
{
    void dfs(HashMap<Integer, List<Integer>> map,
             HashSet<Integer> visited,
             int curr)
    {
        visited.add(curr);

        for (int nei : map.get(curr)) {
            if (!visited.contains(nei))
                dfs(map, visited, nei);
        }
    }

  public
    int countComponents(int n, int[][] edges)
    {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());

            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        int c = 0;
        for (int i = 0; i < n; i++) {
            if (visited.contains(i))
                continue;

            c++;

            if (!map.containsKey(i))
                continue;

            dfs(map, visited, i);
        }

        return c;
    }
}
