package leetcode.Heap;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Map;

public
class _621
{
  public
    int leastInterval(char[] tasks, int n)
    {
        PriorityQueue<Integer> pq =
          new PriorityQueue<>(Collections.reverseOrder());

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            int key = tasks[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(e.getValue());
        }

        int c = 0;
        LinkedList<int[]> q = new LinkedList<>();
        while (!pq.isEmpty() || !q.isEmpty()) {
            if (!q.isEmpty() && q.peek()[1] <= c) {
                pq.offer(q.poll()[0]);
            }

            if (!pq.isEmpty()) {
                int top = pq.poll() - 1;
                if (top > 0) {
                    q.offer(new int[]{ top, c + n + 1 });
                }
            }

            c++;
        }

        return c;
    }
}
