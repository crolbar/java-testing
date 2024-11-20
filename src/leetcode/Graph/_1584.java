package leetcode.Graph;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public
class _1584
{
    int bfs(HashSet<Integer> visited,
            PriorityQueue<int[]> mh,
            HashMap<Integer, List<int[]>> adj,
            int n)
    {
        int cost = 0;

        while (visited.size() < n) {
            int[] curr = mh.poll();

            int dist = curr[0];
            int i = curr[1];

            if (visited.contains(i))
                continue;

            cost += dist;
            visited.add(i);

            if (!adj.containsKey(i))
                continue;

            for (int[] nei : adj.get(i)) {
                if (!visited.contains(nei[1])) {
                    mh.offer(new int[]{ nei[0], nei[1] });
                }
            }
        }

        return cost;
    }
  public
    int minCostConnectPoints(int[][] points)
    {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];

            for (int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];

                int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);

                adj.putIfAbsent(i, new ArrayList<>());
                adj.putIfAbsent(j, new ArrayList<>());

                adj.get(i).add(new int[]{ dist, j });
                adj.get(j).add(new int[]{ dist, i });
            }
        }

        HashSet<Integer> visited = new HashSet<>();

        PriorityQueue<int[]> minHeap =
          new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        minHeap.offer(new int[]{ 0, 0 });

        return bfs(visited, minHeap, adj, points.length);
    }
}
