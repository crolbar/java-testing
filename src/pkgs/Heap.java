package pkgs;

import java.util.ArrayList;

public class Heap {
    public static void main() {
        MinHeap mh = new MinHeap();

        assert mh.length == 0;

        mh.insert(5);
        mh.insert(3);
        mh.insert(2);
        mh.insert(7);
        mh.insert(4);
        mh.insert(1);
        mh.insert(0);
        mh.insert(6);

        System.out.println(mh.data);

        assert mh.length == 8;
        assert mh.pop() == 0;
        assert mh.pop() == 1;
        assert mh.pop() == 2;
        assert mh.pop() == 3;
        assert mh.length == 4;
        assert mh.pop() == 4;
        assert mh.pop() == 5;
        assert mh.pop() == 6;
        assert mh.pop() == 7;


        mh.insert(5);
        mh.insert(3);
        mh.insert(69);
        mh.insert(420);
        mh.insert(4);
        mh.insert(1);
        mh.insert(8);
        mh.insert(7);

        System.out.println(mh.data);

        assert mh.length == 8;
        assert mh.pop() == 1;
        assert mh.pop() == 3;
        assert mh.pop() == 4;
        assert mh.pop() == 5;
        assert mh.length == 4;
        assert mh.pop() == 7;
        assert mh.pop() == 8;
        assert mh.pop() == 69;
        assert mh.pop() == 420;
        assert mh.length == 0;

    }
}

class MinHeap {
    int length;
    ArrayList<Integer> data;

    MinHeap() {
        this.length = 0;
        this.data = new ArrayList<>();
    }

    void insert(int val) {
        this.data.add(val);

        this.heapifyUp(this.length);

        this.length++;
    }

    int pop() {
        if (this.length == 0) return -1;

        int o = this.data.get(0);

        if (this.length == 1) {
            this.length--;
            this.data.clear();
            return o;
        }

        this.length--;
        this.data.set(0, this.data.get(this.length));
        this.heapifyDown(0);
        this.data.removeLast();

        return o;
    }

    private void heapifyDown(int i) {
        if (i >= this.length) return;

        int li = this.leftChild(i);
        int ri = this.rightChild(i);

        if (li >= this.length) return;

        int lv = this.data.get(li);
        int rv = this.data.get(ri);
        int v = this.data.get(i);

        if (rv < lv && v > rv) {
            this.data.set(i, rv);
            this.data.set(ri, v);

            i = ri;
        } else if (lv < rv && v > lv) {
            this.data.set(i, lv);
            this.data.set(li, v);

            i = li;
        } else return;

        this.heapifyDown(i);
    }

    private void heapifyUp(int i) {
        if (i == 0) return;

        int pi = this.parent(i);
        int pv = this.data.get(pi);
        int v = this.data.get(i);

        if (v < pv) {
            this.data.set(i, pv);
            this.data.set(pi, v);

            i = pi;
            heapifyUp(i);
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int p) {
        return (p * 2) + 1;
    }

    private int rightChild(int p) {
        return (p * 2) + 2;
    }
}
