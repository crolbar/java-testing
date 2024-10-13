package leetcode.Heap;
import java.util.Arrays;
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
                  return Integer.compare(a[0], b[0]);
              }
          });

        for (int i = 0; i < points.length; i++) {
            int[] c = points[i];
            int n = (c[0] * c[0]) + (c[1] * c[1]);
            pq.offer(new Integer[]{ n, i });
        }

        int [][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            System.out.println(Arrays.toString(pq.peek()));
            res[i] = points[pq.poll()[1]];
        }

        return res;
    }
}
