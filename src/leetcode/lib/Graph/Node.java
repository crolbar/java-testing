package leetcode.lib.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public
class Node
{
  public
    int val;

  public
    List<Node> neighbors;

  public
    Node()
    {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

  public
    Node(int _val)
    {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

  public
    Node(int _val, ArrayList<Node> _neighbors)
    {
        val = _val;
        neighbors = _neighbors;
    }

  @Override
  public String toString() {
      ArrayList<Integer> l = new ArrayList<>();
      Iterator<Node> i = this.neighbors.iterator();

      while (i.hasNext()) {
          Node next = i.next();
          l.add(next.val);
      }
      
      return this.val + "," + l.toString();
  }
}
