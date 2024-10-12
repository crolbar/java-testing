package leetcode.Heap;
import java.util.PriorityQueue;

public class _703 {
    public KthLargest KthLargest(int k, int[] nums) {
        return new KthLargest(k, nums);
    }
}

class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            this.pq.offer(nums[i]);
            if (this.pq.size() > k) {
                this.pq.poll();
            }
        }
    }
    
    public int add(int val) {
        this.pq.add(val);
        if (this.pq.size() > k)
            this.pq.poll();
        return this.pq.peek();
    }
}
