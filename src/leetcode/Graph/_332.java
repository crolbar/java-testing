package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public
class _332
{
    boolean dfs(List<String> res,
                HashMap<String, List<String>> adj,
                HashMap<String, Integer> used,
                String curr,
                int[] usedTickets,
                int numOfTickets)
    {
        res.add(curr);

        // we have reached an sink node
        if (!adj.containsKey(curr)) {

            System.out.printf("backing: %s, num: %d, used: %d\n",
                              curr,
                              numOfTickets,
                              usedTickets[0]);

            // did not use all tickets
            if (usedTickets[0] < numOfTickets) {
                return true;
            }

            return false;
        }

        List<String> neis = new ArrayList<>(adj.get(curr));

        System.out.printf("curr: %s, neis: %s\n", curr, neis.toString());

        for (String nei : neis) {
            if (used.get(curr + nei) == 0)
                continue;

            used.put(curr + nei, used.get(curr + nei) - 1);
            usedTickets[0]++;

            if (dfs(res, adj, used, nei, usedTickets, numOfTickets)) {
                System.out.printf("removing last: %s\n", res.getLast());
                res.removeLast();
                usedTickets[0]--;
                used.put(curr + nei, used.get(curr + nei) + 1);
            }
        }
        if (usedTickets[0] < numOfTickets) {
            return true;
        }

        // we have used all tickets
        return false;
    }

  public
    List<String> findItinerary(List<List<String>> tickets)
    {
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));

        HashMap<String, List<String>> adj = new HashMap<>();
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> used = new HashMap<>();

        for (List<String> ticket : tickets) {
            adj.putIfAbsent(ticket.get(0), new ArrayList<>());
            adj.get(ticket.get(0)).add(ticket.get(1));

            String currTicket = ticket.get(0) + ticket.get(1);
            used.putIfAbsent(currTicket, 0);
            used.put(currTicket, used.get(currTicket) + 1);
        }

        System.out.println(adj);
        System.out.println(used);

        dfs(res, adj, used, "JFK", new int[]{ 0 }, tickets.size());

        System.out.printf(
          "used: %d, overall: %d\n", used.size(), tickets.size());

        return res;
    }
}
