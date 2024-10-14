package leetcode.Heap;
import java.util.Comparator;
import java.util.PriorityQueue;

public
class _973
{
  public
    int[][] kClosest(int[][] points, int k)
    {
        PriorityQueue<Integer[]> pq =
          new PriorityQueue<>(new Comparator<Integer[]>() {
              @Override public int compare(Integer[] a, Integer[] b)
              {
                  return Integer.compare(b[0], a[0]);
              }
          });

        for (int i = 0; i < points.length; i++) {
            int[] c = points[i];
            int n = (c[0] * c[0]) + (c[1] * c[1]);
            pq.offer(new Integer[]{ n, i });

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = points[pq.poll()[1]];
        }

        return res;
    }
}
