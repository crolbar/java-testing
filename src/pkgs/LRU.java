package pkgs;

import java.util.HashMap;

public
class LRU
{
  public
    static void main()
    {
        LRU lru = new LRU(3);

        assert lru.get("foo") == null;
        lru.update("foo", 69);
        assert lru.get("foo") == 69;

        lru.update("bar", 420);
        assert lru.get("bar") == 420;

        lru.update("baz", 1337);
        assert lru.get("baz") == 1337;

        lru.update("ball", 69420);
        assert lru.get("ball") == 69420;
        assert lru.get("foo") == null;

        assert lru.get("bar") == 420;

        lru.update("foo", 69);
        assert lru.get("bar") == 420;
        assert lru.head.val == lru.get("bar");

        assert lru.get("foo") == 69;
        assert lru.head.val == lru.get("foo");

        lru.update("first", 1);
        lru.update("sec", 2);
        lru.update("third", 3);

        assert lru.get("first") == 1;
        assert lru.get("sec") == 2;
        assert lru.get("third") == 3;
        assert lru.tail.val == lru.get("first");
        assert lru.head.val == lru.get("first");
        assert lru.tail.val == lru.get("sec");

        assert lru.get("baz") == null;
    }

    int length;
    int capacity;
    Node tail;
    Node head;

    HashMap<String, Node> lookup;
    HashMap<Node, String> revLookup;

  public
    class Node
    {
        int val;
        Node prev;
        Node next;

        Node(int val) { this.val = val; }
    }

    LRU(int capacity)
    {
        this.length = 0;
        this.lookup = new HashMap<>();
        this.revLookup = new HashMap<>();
        this.capacity = capacity;
    }

    void update(String key, int val)
    {
        Node node = this.lookup.get(key);

        if (node == null) {
            node = new Node(val);
            this.length++;
            this.prepend(node);
            this.trimCache();

            this.lookup.put(key, node);
            this.revLookup.put(node, key);

        } else {
            this.detatch(node);
            this.prepend(node);
            node.val = val;
        }
    }

    Integer get(String key)
    {
        Node node = this.lookup.get(key);

        if (node == null)
            return null;

        this.detatch(node);
        this.prepend(node);

        return node.val;
    }

    void detatch(Node node)
    {
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (this.head == node) {
            this.head = node.next;
        }

        if (this.tail == node) {
            this.tail = node.prev;
        }

        node.next = null;
        node.prev = null;
    }

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

    void trimCache()
    {
        if (this.length <= this.capacity) {
            return;
        }

        Node tail = this.tail;

        this.detatch(tail);

        String key = this.revLookup.get(tail);
        this.lookup.remove(key);
        this.revLookup.remove(tail);
        this.length--;
    }
}
