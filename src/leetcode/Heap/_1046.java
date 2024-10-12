package leetcode.Heap;
import java.util.Collections;
import java.util.PriorityQueue;

public
class _1046
{
  public
    int lastStoneWeight(int[] stones)
    {
        PriorityQueue<Integer> pq =
          new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }

        while (pq.size() > 1) {
            int res = pq.poll() - pq.poll();
            if (res > 0)
                pq.offer(res);
        }

        if (pq.size() > 0)
            return pq.poll();

        return 0;
    }
}
