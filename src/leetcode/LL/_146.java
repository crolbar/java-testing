package leetcode.LL;

import java.util.HashMap;

public
class _146
{
    LRUCache lru;
  public
    _146(int capacity) { this.lru = new LRUCache(capacity); }
}

class LRUCache
{
    class Node
    {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value)
        {
            this.value = value;
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }

    int capacity;
    int length;
    Node head;
    Node tail;

    HashMap<Integer, Node> map;

  public
    LRUCache(int capacity)
    {
        this.capacity = capacity;
        this.length = 0;
        this.head = null;
        this.tail = null;
        this.map = new HashMap<>();
    }

  public
    void put(int key, int value)
    {
        Node node = this.map.getOrDefault(key, null);

        if (node == null) {
            node = new Node(key, value);
            this.length++;
            this.prepend(node);
            this.trim();
            this.map.put(key, node);
        } else {
            this.remove(node);
            this.prepend(node);
            node.value = value;
        }
    }

  public
    int get(int key)
    {
        Node node = this.map.getOrDefault(key, null);

        if (node == null)
            return -1;

        this.remove(node);
        this.prepend(node);

        return node.value;
    }

  private
    void prepend(Node node)
    {
        if (this.head == null) {
            this.head = this.tail = node;
            return;
        }

        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

  private
    void remove(Node node)
    {
        if (node.prev != null)
            node.prev.next = node.next;

        if (node.next != null)
            node.next.prev = node.prev;

        if (node == this.head)
            this.head = node.next;

        if (node == this.tail)
            this.tail = node.prev;

        node.next = null;
        node.prev = null;
    }

  private
    void trim()
    {
        if (this.length > this.capacity) {
            this.length--;

            Node tail = this.tail;

            this.remove(tail);
            this.map.remove(tail.key);

            tail.next = null;
            tail.prev = null;
        }
    }
}
