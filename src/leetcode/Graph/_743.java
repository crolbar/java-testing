package leetcode.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public
class _743
{

    int dij(HashMap<Integer, List<int[]>> adj,
                 PriorityQueue<int[]> pq,
                 HashSet<Integer> visited,
                 int n)
    {
        int c = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int v = curr[0];
            int w = curr[1];

            if (visited.contains(v))
                continue;

            visited.add(v);

            c = w;

            if (visited.size() == n)
                break;


            if (!adj.containsKey(v))
                continue;

            for (int[] nei : adj.get(v)) {
                if (visited.contains(nei[0]))
                    continue;

                pq.add(new int[]{ nei[0], nei[1] + w });
            }
        }

        if (visited.size() != n)
            return -1;

        return c;
    }

  public
    int networkDelayTime(int[][] times, int n, int k)
    {

        HashMap<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] time : times) {
            adj.computeIfAbsent(time[0], v->new ArrayList<>())
              .add(new int[]{ time[1], time[2] });
        }

        PriorityQueue<int[]> minHeap =
          new PriorityQueue<>(Comparator.comparingInt(l->l[1]));
        minHeap.add(new int[]{ k, 0 });

        return dij(adj, minHeap, new HashSet<>(), n);
    }
}
