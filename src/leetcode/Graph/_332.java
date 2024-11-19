package leetcode.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public
class _332
{

    void dfs(List<String> res,
             HashMap<String, PriorityQueue<String>> adj,
             String curr)
    {
        if (!adj.containsKey(curr)) {
            res.add(curr);
            return;
        }

        while (!adj.get(curr).isEmpty()) {
            String nei = adj.get(curr).poll();
            dfs(res, adj, nei);
        }

        res.add(curr);
    }

  public
    List<String> findItinerary(List<List<String>> tickets)
    {
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (List<String> ticket : tickets) {
            adj.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs(res, adj, "JFK");

        Collections.reverse(res);
        return res;
    }
}
