package pkgs;

import pkgs.Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public
class Tree
{
  public
    static void main()
    {
        BinaryTree bt = new BinaryTree(-1);

        TreeNode node = bt.root;

        for (int i = 20; i < 60; i += 2) {
            node.left = new TreeNode(i);
            node.left.parrent = node;
            node.right = new TreeNode(i + 1);
            node.right.parrent = node;

            if (i == 28 || i == 30 || i == 32) {
                node = node.left;
            } else if (i < 40) {
                node = node.right;
            } else if (i < 50) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        BinaryTree bt2 = new BinaryTree(-1);

        node = bt2.root;

        for (int i = 20; i < 60; i += 2) {
            node.left = new TreeNode(i);
            node.left.parrent = node;
            node.right = new TreeNode(i + 1);
            node.right.parrent = node;

            if (i == 28 || i == 30 || i == 32) {
                node = node.left;
            } else if (i < 40) {
                node = node.right;
            } else if (i < 50) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        ArrayList<TreeNode> list =
          BinaryTree.getDFSTree(new ArrayList<>(), bt.root);
        for (int i = 0; i < list.size(); i++)
            System.out.printf("%d,", list.get(i).val);
        System.out.println();
        bt.printTree(list);

        list = BinaryTree.getDFSTree(new ArrayList<>(), bt2.root);
        System.out.println("bt2");
        for (int i = 0; i < list.size(); i++)
            System.out.printf("%d,", list.get(i).val);
        System.out.println();
        bt2.printTree(list);

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(bt.root);
        list = BinaryTree.getBFSTree(new ArrayList<>(), queue);
        for (int i = 0; i < list.size(); i++)
            System.out.printf("%d,", list.get(i).val);
        System.out.println();

        System.out.println(BinaryTree.compare(bt.root, bt2.root));

        BinarySearchTree bst = new BinarySearchTree(50);
        bst.insert(20);
        bst.insert(25);
        // bst.insert(30);

        bst.insert(17);
        bst.insert(15);
        bst.insert(13);
        bst.insert(12);

        bst.insert(16);

        bst.delete(15);

        queue.clear();
        queue.add(bst.root);

        list = BinarySearchTree.getBFSTree(new ArrayList<>(), queue);
        System.out.printf("[");
        for (int i = 0; i < list.size(); i++)
            System.out.printf("%d,", list.get(i).val);
        System.out.println(']');

        System.out.println(bst.search(520));

        // System.out.println(bst.root.left.left.left.right.val);

        bst.printTree(list);
    }

  public
    static class BinarySearchTree extends BinaryTree
    {
        BinarySearchTree(int val) { super(val); }

      private
        TreeNode delete_r(TreeNode n, int v)
        {
            if (n == null)
                return null;

            if (v > n.val) {
                TreeNode rn = delete_r(n.right, v);
                if (rn != null)
                    rn.parrent = n.right.parrent;
                n.right = rn;
            } else if (v < n.val) {
                TreeNode rn = delete_r(n.left, v);
                if (rn != null)
                    rn.parrent = n.left.parrent;
                n.left = rn;
            } else {
                if (n.left == null)
                    return n.right;
                if (n.right == null)
                    return n.left;

                // largest on smaller side
                TreeNode max = BinarySearchTree.getMax(n.left);

                n.val = max.val;

                n.left = delete_r(n.left, n.val);
            }

            return n;
        }

      public
        void delete(int val)
        {
            if (!search(val)) {
                System.out.println("val is missing");
                return;
            } else if (val == root.val) {
                System.out.println("val is root");
                return;
            }

            delete_r(this.root, val);
        }

      public
        static TreeNode getMax(TreeNode root)
        {
            TreeNode max = root;

            TreeNode t = root;
            while (t.right != null) {
                t = t.right;
                max = t;
            }

            return max;
        }

        boolean search(int val)
        {
            class R
            {
                static boolean r(TreeNode n, int v)
                {
                    if (n == null)
                        return false;
                    if (n.val == v)
                        return true;

                    if (v > n.val) {
                        return r(n.right, v);
                    } else {
                        return r(n.left, v);
                    }
                }
            }

            return R.r(this.root, val);
        }

        void insert(int val)
        {
            class R
            {
                static TreeNode r(TreeNode n, int v)
                {
                    if (n == null)
                        return new TreeNode(v);

                    if (v > n.val) {
                        TreeNode child = r(n.right, v);
                        if (child != null) {
                            if (child.parrent == null) {
                                n.right = child;
                                child.parrent = n;
                            }

                            return child;
                        }
                    } else if (v <= n.val) {
                        TreeNode child = r(n.left, v);
                        if (child != null) {
                            if (child.parrent == null) {
                                n.left = child;
                                child.parrent = n;
                            }

                            return child;
                        }
                    }

                    return null;
                }
            }

            R.r(this.root, val);
        }
    }

    public static class BinaryTree
    {
        TreeNode root;

        BinaryTree() {}

        BinaryTree(int val) { root = new TreeNode(val); }

      public
        static class TreeNode
        {
            int val;
            TreeNode parrent;
            TreeNode left;
            TreeNode right;

            TreeNode(int val) { this.val = val; }

            TreeNode(int val, TreeNode left, TreeNode right)
            {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        static boolean
        compare(TreeNode a, TreeNode b)
        {
            if (a == null && b == null) {
                return true;
            }

            if (a == null || b == null) {
                return false;
            }

            if (a.val != b.val) {
                return false;
            }

            return compare(a.left, b.left) && compare(a.right, b.right);
        }

        static ArrayList<TreeNode> getBFSTree(ArrayList<TreeNode> list,
                                              ArrayList<TreeNode> queue)
        {
            if (queue.isEmpty()) {
                return list;
            }

            TreeNode node = queue.removeFirst();

            if (node == null) {
                getBFSTree(list, queue);
                return list;
            }

            list.add(node);

            queue.add(node.left);
            queue.add(node.right);

            getBFSTree(list, queue);

            return list;
        }

        static ArrayList<TreeNode> getDFSTree(ArrayList<TreeNode> list,
                                              TreeNode node)
        {
            if (node == null) {
                return list;
            }

            list.add(node);
            getDFSTree(list, node.left);
            getDFSTree(list, node.right);

            return list;
        }

      public
        void printTree(ArrayList<TreeNode> list)
        {
            class P
            {
                static final int BASE_OFFSET = 50;
                static final int ADGST_OFFSET = 4;

              public
                static void r(int i,
                              ArrayList<TreeNode> list,
                              ArrayList<String> lines,
                              HashMap<TreeNode, Integer> line_idx,
                              HashMap<TreeNode, Integer> line_off)
                {
                    if (i >= list.size())
                        return;

                    TreeNode node = list.get(i);

                    TreeNode parrent = node.parrent;
                    int num_parrents = 0;
                    while (parrent != null) {
                        num_parrents++;
                        parrent = parrent.parrent;
                    }

                    if (node.parrent != null) {

                        if (line_idx.containsKey(
                              node.parrent)) { // right node on line
                            int p_idx = line_idx.get(node.parrent);
                            lines.set(p_idx,
                                      lines.get(p_idx) + " ".repeat(2) +
                                        String.format(
                                          "%d:%d", node.val, node.parrent.val));

                        } else { // left node
                            line_idx.put(node.parrent, num_parrents);

                            // storing the offset in the parrent for the curr
                            // line the parrent's parrent
                            if (line_off.containsKey(node.parrent.parrent)) {
                                line_off.put(
                                  node.parrent,
                                  line_off.get(node.parrent.parrent) +
                                    ((node.parrent == node.parrent.parrent.left)
                                       ? -ADGST_OFFSET
                                       : ADGST_OFFSET));
                            } else {
                                line_off.put(node.parrent, BASE_OFFSET);
                            }

                            lines.set(num_parrents,
                                      " ".repeat(line_off.get(node.parrent)) +
                                        String.format(
                                          "%d:%d", node.val, node.parrent.val));
                        }
                    } else { // root
                        line_off.put(node, BASE_OFFSET);

                        lines.set(num_parrents,
                                  " ".repeat(line_off.get(node) + 5) +
                                    String.format("%d", node.val));
                    }

                    r(i + 1, list, lines, line_idx, line_off);
                }
            }

            ArrayList<String>
              lines = new ArrayList<>();
            for (int i = 0; i <= list.size(); i++)
                lines.add("");

            HashMap<TreeNode, Integer> line_idx = new HashMap<>();
            HashMap<TreeNode, Integer> line_off = new HashMap<>();

            P.r(0, list, lines, line_idx, line_off);

            for (int i = 0; i < lines.size(); i++) {
                System.out.println(lines.get(i));
            }
        }
    }
}
