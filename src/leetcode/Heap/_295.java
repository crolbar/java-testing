package leetcode.Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public
class _295
{
    MedianFinder m;
  public
    _295() { this.m = new MedianFinder(); }
}

class MedianFinder
{
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

  public
    MedianFinder()
    {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }

  public
    void addNum(int num)
    {
        this.maxHeap.offer(num);

        if (this.minHeap.size() > 0) {
            if (maxHeap.peek() > minHeap.peek()) {
                minHeap.offer(maxHeap.poll());
            }
        }

        if (maxHeap.size() - 1 > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() - 1 > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

  public
    double findMedian()
    {
        if (this.minHeap.size() > this.maxHeap.size()) {
            return (double)minHeap.peek();
        }

        if (this.maxHeap.size() > this.minHeap.size()) {
            return (double)maxHeap.peek();
        }

        return (double)(this.minHeap.peek() + this.maxHeap.peek()) / 2;
    }
}
