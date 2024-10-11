package leetcode.Trees;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.lib.TreeNode;

public
class _297
{
  public
    String serialize(TreeNode root)
    {
        Codec c = new Codec();
        return c.serialize(root);
    }

  public
    TreeNode deserialize(String data)
    {
        Codec c = new Codec();
        return c.deserialize(data);
    }
}

class Codec
{
    String bfs(Queue<TreeNode> q)
    {
        if (q.isEmpty())
            return "";

        TreeNode curr = q.poll();

        if (curr == null)
            return "n," + bfs(q);

        q.add(curr.left);
        q.add(curr.right);

        return curr.val + "," + bfs(q);
    }
  public
    String serialize(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        String bfs = bfs(q);
        return "[" + bfs.substring(0, bfs.length() - 1) + "]";
    }

    Integer getNextNum(String data, int[] i)
    {
        int start = i[0];
        int end = start;

        while (i[0] < data.length()) {
            char c = data.charAt(i[0]++);

            if (c == '[') {
                start++;
                continue;
            }

            if (c == ',') {
                end = i[0] - 1;
                break;
            }
        }

        if (data.charAt(start) == 'n') {
            return null;
        }

        return Integer.parseInt(data.substring(start, end));
    }

    void de(Queue<TreeNode> q, int[] i, String data)
    {
        if (i[0] >= data.length())
            return;

        TreeNode curr = q.poll();

        Integer l = getNextNum(data, i);
        Integer r = getNextNum(data, i);

        if (l != null) {
            curr.left = new TreeNode(l);
            q.add(curr.left);
        }

        if (r != null) {
            curr.right = new TreeNode(r);
            q.add(curr.right);
        }

        de(q, i, data);

        return;
    }

  public
    TreeNode deserialize(String data)
    {
        int[] i = new int[]{ 0 };
        Queue<TreeNode> q = new LinkedList<>();

        Integer n = getNextNum(data, i);

        if (n == null)
            return null;

        TreeNode root = new TreeNode(n);
        q.add(root);

        de(q, i, data);

        return root;
    }
}
