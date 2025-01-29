package exer;

import java.util.ArrayList;
import java.util.List;

class PriorityQueue
{
    private List<Integer> data;
    private int length;

    PriorityQueue() { this.data = new ArrayList<>(); }

    public void offer(int val)
    {
        // add the value to the end
        this.data.add(val);
        this.length++;

        // heapify up from the end
        heapifyUp(this.length - 1);
    }

    public int poll()
    {
        if (this.length == 0)
            return -1;

        // store the value of the root element
        int out = this.data.get(0);

        // overwite the root ellement with the last one
        this.data.set(0, this.data.get(this.length - 1));

        // remove the unneeded last element
        this.data.removeLast();
        this.length--;

        // heapify down from the root
        heapifyDown(0);

        return out;
    }

    public boolean isEmpty() { return this.length == 0; }

    private int getLeftChildOf(int idx) { return idx * 2 + 1; }
    private int getRightChildOf(int idx) { return idx * 2 + 2; }
    private int getParent(int idx) { return (idx - 1) / 2; }

    private void heapifyUp(int ni)
    {
        // if we reached the root node we are done
        if (ni == 0)
            return;

        int pi = getParent(ni);
        int pv = this.data.get(pi);
        int nv = this.data.get(ni);

        // if our parent is smaller we are done
        if (nv > pv)
            return;

        // swap with our parent
        this.data.set(pi, nv);
        this.data.set(ni, pv);

        // continue form our new point
        heapifyUp(pi);
    }

    private void heapifyDown(int ni)
    {
        int ri = getRightChildOf(ni);
        int li = getLeftChildOf(ni);

        if (ri >= this.length)
            return;

        if (li >= this.length)
            return;

        int nv = this.data.get(ni);
        int rv = this.data.get(ri);
        int lv = this.data.get(li);

        // if the right child's val is less than the left and ours
        if (rv < lv && rv < nv) {
            this.data.set(ri, nv);
            this.data.set(ni, rv);

            heapifyDown(ri);
            return;
        }

        // if the left is less than the right and ours
        if (lv < rv && lv < nv) {
            this.data.set(li, nv);
            this.data.set(ni, lv);

            heapifyDown(li);
            return;
        }
    }

    @Override public String toString() { return this.data.toString(); }
}

public class PQ
{

    public static void main()
    {
        PriorityQueue pq = new PriorityQueue();

        pq.offer(2);
        pq.offer(3);
        pq.offer(8);
        pq.offer(0);
        pq.offer(-2);
        pq.offer(100);

        System.out.println(pq.toString());

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        pq.offer(8);
        pq.offer(0);
        pq.offer(6);

        System.out.println(pq.poll());

        pq.offer(888);
        pq.offer(8234);
        pq.offer(-8234);

        System.out.println(pq.toString());

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        System.out.println(pq.toString());
    }
}
