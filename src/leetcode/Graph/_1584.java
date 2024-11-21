package leetcode.Graph;

import java.util.PriorityQueue;
import java.util.Comparator;

public
class _1584
{
    int find(int[] par, int v)
    {
        if (v != par[v])
            par[v] = find(par, par[v]);
        return par[v];
    }

    boolean unite(int[] par, int[] rank, int v, int u) {
        int pV = find(par, v);
        int pU = find(par, u);

        if (pV == pU)
            return false;

        if (rank[pV] > rank[pU]) {
            par[pU] = pV;
        } else if (rank[pV] < rank[pU]) {
            par[pV] = pU;
        } else {
            par[pV] = pU;
            rank[pU]++;
        }

        return true;
    }

  public
    int minCostConnectPoints(int[][] points)
    {
        PriorityQueue<int[]> minHeap =
          new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];

            for (int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];

                int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);

                minHeap.add(new int[]{ dist, j, i });
            }
        }

        int[] par = new int[points.length + 1];
        int[] rank = new int[points.length + 1];

        for (int i = 0; i <= points.length; i++) {
            rank[i] = 1;
            par[i] = i;
        }


        int cost = 0;
        while (!minHeap.isEmpty()) {
            int[] p = minHeap.poll();

            if (!unite(par, rank, p[1], p[2])) {
                continue;
            }

            cost += p[0];
        }

        return cost;
    }
}
