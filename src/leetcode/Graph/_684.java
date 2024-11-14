package leetcode.Graph;

public
class _684
{
    int find(int[] par, int v) {
        if (v != par[v])
            par[v] = find(par, par[v]);
        return par[v];
    }


    boolean union(int[] par, int[] rank, int u, int v) {
        int parU = find(par, u);
        int parV = find(par, v);

        if (parU == parV)
            return false;

        if (rank[parU] > rank[parV]) {
            par[parV] = parU;
        } else if (rank[parU] < rank[parV]) {
            par[parU] = parV;
        } else {
            par[parV] = parU;
            rank[parU]++;
        }

        return true;
    }

  public
    int[] findRedundantConnection(int[][] edges)
    {
        int[] par   = new int[edges.length + 1];
        int[] rank  = new int[edges.length + 1];

        for (int i = 1; i < par.length; i++) {
            par[i]  = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(par, rank, edge[0], edge[1]))
                return edge;
        }

        return new int[]{ 0 };
    }
}
