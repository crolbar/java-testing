package leetcode.lib;

import java.util.ArrayList;

public
class TreeNode
{
  public
    int val;

  public
    TreeNode left;

  public
    TreeNode right;

  public
    TreeNode() {}

  public
    TreeNode(int val) { this.val = val; }

  public
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }

  private
    static ArrayList<Integer> rBFS(ArrayList<Integer> list,
                                   ArrayList<TreeNode> queue)
    {
        if (queue.isEmpty()) {
            return list;
        }

        TreeNode node = queue.removeFirst();

        if (node == null) {
            list.add(-1);
            rBFS(list, queue);
            return list;
        }

        list.add(node.val);

        queue.add(node.left);
        queue.add(node.right);

        rBFS(list, queue);

        return list;
    }

  public
    static Integer[] getBFS(TreeNode root)
    {
        ArrayList<TreeNode> q = new ArrayList<>();
        q.add(root);
        return rBFS(new ArrayList<>(), q).toArray(new Integer[0]);
    }

  private
    static ArrayList<Integer> rDFS(ArrayList<Integer> list, TreeNode curr)
    {
        if (curr == null) {
            list.add(-1);
            return list;
        }

        list.add(curr.val);

        rDFS(list, curr.left);
        rDFS(list, curr.right);

        return list;
    }

  public
    static Integer[] getDFS(TreeNode root)
    {
        return rDFS(new ArrayList<Integer>(), root).toArray(new Integer[0]);
    }
}
