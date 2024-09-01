package pkgs;

import pkgs.Graph.GraphList.GraphEdge;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    public static void main() {
        //     >(1)<--->(4) ---->(5)
        //    /          |       /|
        // (0)     ------|------- |
        //    \   v      v        v
        //     >(2) --> (3) <----(6)
        int[][] graphMatrix = {
            {0, 3, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0},
            {0, 0, 7, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 5, 0, 2, 0},
            {0, 0, 18, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0, 0},
        };

        assert Arrays.equals(BFSMatrix(graphMatrix, 0, 6), new int[] {0, 1, 4, 5, 6});
        assert null == BFSMatrix(graphMatrix, 6, 0);

        // System.out.println(Arrays.toString(BFSMatrix(graphMatrix, 0, 6)));

        GraphList graphList = new GraphList();
        assert Arrays.equals(DFSList(graphList.list, 0, 6), new int[] {0, 1, 4, 5, 6});
        assert DFSList(graphList.list, 6, 0) == null;

        // for (int i = 0; i < graphList.list.length; i++) {
        //    System.out.printf("\nvertex: %d\n", i);
        //    for (int j = 0; j < graphList.list[i].length; j++) {
        //        System.out.println(graphList.list[i][j].to + "w: " + graphList.list[i][j].weight);
        //    }
        // }
        //

        assert Arrays.equals(
                Dijkstra.dijkstra_list(graphList.list, 0, 6), new int[] {0, 1, 4, 5, 6});
        assert Arrays.equals(Dijkstra.dijkstra_list(graphList.list, 0, 7), new int[0]);
        assert Arrays.equals(Dijkstra.dijkstra_list(graphList.list, 0, 3), new int[] {0, 2, 3});

        System.out.println("test ran");
        // System.out.println(Arrays.toString(Dijkstra.dijkstra_list(graphList.list, 0, 6)));
    }

    static class GraphList {
        GraphEdge[][] list;

        GraphList() {
            //     >(1)<--->(4) ---->(5)
            //    /          |       /|
            // (0)     ------|------- |
            //    \   v      v        v
            //     >(2) --> (3) <----(6)
            this.list =
                    new GraphEdge[][] {
                        new GraphEdge[] {
                            new GraphEdge(1, 3), new GraphEdge(2, 1),
                        },
                        new GraphEdge[] {new GraphEdge(4, 1)},
                        new GraphEdge[] {new GraphEdge(3, 7)},
                        new GraphEdge[] {},
                        new GraphEdge[] {
                            new GraphEdge(1, 1), new GraphEdge(3, 5), new GraphEdge(5, 2),
                        },
                        new GraphEdge[] {
                            new GraphEdge(2, 18), new GraphEdge(6, 1),
                        },
                        new GraphEdge[] {
                            new GraphEdge(3, 1),
                        },
                    };
        }

        public class GraphEdge {
            int to;
            int weight;

            GraphEdge(int to, int weight) {
                this.to = to;
                this.weight = weight;
            }
        }
    }

    class Dijkstra {
        private static boolean hasUnvisited(boolean[] seen, int[] dists) {
            for (int i = 0; i < seen.length; i++) {
                if (!seen[i] && dists[i] < 1000) {
                    return true;
                }
            }
            return false;
        }

        private static int getLowestUnvisited(boolean[] seen, int[] dists) {
            int idx = -1;
            int ld = 1000;

            for (int i = 0; i < seen.length; i++) {
                if (!seen[i]) {
                    if (dists[i] < ld) {
                        ld = dists[i];
                        idx = i;
                    }
                }
            }

            return idx;
        }

        static int[] dijkstra_list(GraphEdge[][] list, int source, int needle) {
            int[] dists = new int[list.length];
            for (int i = 0; i < dists.length; i++) dists[i] = 1000;
            dists[source] = 0;

            int[] prev = new int[list.length];
            for (int i = 0; i < list.length; i++) prev[i] = -1;

            boolean[] seen = new boolean[list.length];

            while (hasUnvisited(seen, dists)) {
                int curr = getLowestUnvisited(seen, dists);
                seen[curr] = true;

                for (int i = 0; i < list[curr].length; i++) {
                    GraphEdge e = list[curr][i];

                    if (!seen[e.to]) {
                        int dist = dists[curr] + e.weight;
                        if (dist < dists[e.to]) {
                            dists[e.to] = dist;
                            prev[e.to] = curr;
                        }
                    }
                }
            }

            if (needle >= list.length || prev[needle] == -1) return new int[0];

            ArrayList<Integer> l = new ArrayList<>();
            int curr = needle;

            while (curr != source) {
                l.add(curr);
                curr = prev[curr];
            }
            l.add(source);

            int[] out = new int[l.size()];
            for (int i = 0; i < l.size(); i++) out[i] = l.get(l.size() - 1 - i);
            return out;
        }
    }

    static boolean _DFSList_r(
            GraphEdge[][] list, int curr, int needle, ArrayList<Integer> path, boolean[] seen) {

        if (curr == needle) {
            path.add(curr);
            return true;
        }

        if (seen[curr]) return false;

        path.add(curr);
        seen[curr] = true;

        for (int i = 0; i < list[curr].length; i++) {
            if (_DFSList_r(list, list[curr][i].to, needle, path, seen)) {
                return true;
            }
        }

        path.removeLast();

        return false;
    }

    static int[] DFSList(GraphEdge[][] list, int source, int needle) {
        ArrayList<Integer> tpath = new ArrayList<>();
        boolean[] seen = new boolean[list.length];

        if (!_DFSList_r(list, source, needle, tpath, seen)) return null;

        int[] path = new int[tpath.size()];
        for (int i = 0; i < path.length; i++) path[i] = tpath.get(i);
        return path;
    }

    static int[] BFSMatrix(int[][] graph, int source, int needle) {
        ArrayList<Integer> queue = new ArrayList<>();
        queue.add(source);

        boolean[] seen = new boolean[graph.length];
        seen[source] = true;

        int[] prev = new int[graph.length];
        for (int i = 0; i < graph.length; i++) prev[i] = -1;

        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();

            if (curr == needle) break;

            int[] adj = graph[curr];
            for (int i = 0; i < graph.length; i++) {
                if (adj[i] > 0) {
                    if (!seen[i]) {
                        queue.add(i);
                        prev[i] = curr;
                    }
                    seen[i] = true;
                }
            }
        }

        if (needle >= graph.length || prev[needle] == -1) return null;

        ArrayList<Integer> tpath = new ArrayList<>();

        int curr = needle;
        do {
            tpath.add(curr);
            curr = prev[curr];
        } while (curr != -1);

        int[] path = new int[tpath.size()];
        for (int i = 0; i < path.length; i++) path[i] = tpath.get(tpath.size() - 1 - i);
        return path;
    }
}
