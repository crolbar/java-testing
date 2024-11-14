package leetcode.Graph;

public
class _323
{
    int find(int[] par, int v) {
        if (par[v] != v)
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
            par[parU] = parV;
            rank[parV]++;
        }

        return true;
    }

  public
    int countComponents(int n, int[][] edges)
    {

        int[] par   = new int[n];
        int[] rank  = new int[n];

        for (int i = 0; i < n; i++) {
            par[i]  = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (union(par, rank, edge[0], edge[1]))
                n--;
        }

        return n;
    }
}
