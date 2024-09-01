package pkgs;

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

        int[] t = {0, 1, 4, 5, 6};
        assert Arrays.equals(t, BFSMatrix(graphMatrix, 0, 6));
        assert null == BFSMatrix(graphMatrix, 6, 0);

        System.out.println("test ran");
        System.out.println(Arrays.toString(BFSMatrix(graphMatrix, 0, 6)));
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
