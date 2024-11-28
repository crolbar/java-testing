package leetcode.Graph;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public
class _787
{
  public
    int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
    {
        @SuppressWarnings("unchecked") List<int[]>[] adj =
          (List<int[]>[]) new List[n];

        boolean hasDst = false;
        for (int[] flight : flights) {
            if (!hasDst && flight[1] == dst)
                hasDst = true;

            int[] dist = new int[]{ flight[1], flight[2] };

            if (adj[flight[0]] == null)
                adj[flight[0]] = new ArrayList<>();

            adj[flight[0]].add(dist);
        }

        if (!hasDst)
            return -1;

        PriorityQueue<int[]> pq =
          new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.add(new int[]{ src, 0, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (curr[0] == dst)
                return curr[1];

            if (curr[2] > k)
                continue;

            if (adj[curr[0]] == null)
                continue;

            List<int[]> neis = adj[curr[0]];
            for (int[] nei : neis) {
                if (nei[0] != dst && curr[2] + 1 > k)
                    continue;

                pq.offer(new int[]{ nei[0], curr[1] + nei[1], curr[2] + 1 });
            }
        }

        return -1;
    }
}
