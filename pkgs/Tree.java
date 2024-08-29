package pkgs;

import pkgs.Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public class Tree {
    public static void main() {
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

        ArrayList<TreeNode> list = BinaryTree.getDFSTree(new ArrayList<>(), bt.root);
        for (int i = 0; i < list.size(); i++) System.out.printf("%d,", list.get(i).val);
        System.out.println();
        bt.printTree(list);

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(bt.root);
        list = BinaryTree.getBFSTree(new ArrayList<>(), queue);
        for (int i = 0; i < list.size(); i++) System.out.printf("%d,", list.get(i).val);
    }

    public static class BinaryTree {
        TreeNode root;

        BinaryTree(int val) {
            root = new TreeNode(val);
        }

        static ArrayList<TreeNode> getBFSTree(ArrayList<TreeNode> list, ArrayList<TreeNode> queue) {
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

        static ArrayList<TreeNode> getDFSTree(ArrayList<TreeNode> list, TreeNode node) {
            if (node == null) {
                return list;
            }

            list.add(node);
            getDFSTree(list, node.left);
            getDFSTree(list, node.right);

            return list;
        }

        public static class TreeNode {
            int val;
            TreeNode parrent;
            TreeNode left;
            TreeNode right;

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        public void printTree(ArrayList<TreeNode> list) {

            ArrayList<String> lines = new ArrayList<>();
            for (int i = 0; i <= list.size() / 2; i++) lines.add("");

            HashMap<TreeNode, Integer> line_idx = new HashMap<>();
            HashMap<TreeNode, Integer> line_off = new HashMap<>();

            r(0, list, lines, line_idx, line_off);

            for (int i = 0; i < lines.size(); i++) {
                System.out.println(lines.get(i));
            }
        }

        final int BASE_OFFSET = 50;
        final int ADGST_OFFSET = 4;

        void r(
                int i,
                ArrayList<TreeNode> list,
                ArrayList<String> lines,
                HashMap<TreeNode, Integer> line_idx,
                HashMap<TreeNode, Integer> line_off) {
            if (i >= list.size()) return;

            TreeNode node = list.get(i);

            TreeNode parrent = node.parrent;
            int num_parrents = 0;
            while (parrent != null) {
                num_parrents++;
                parrent = parrent.parrent;
            }

            if (node.parrent != null) {

                if (line_idx.containsKey(node.parrent)) { // right node on line
                    int p_idx = line_idx.get(node.parrent);
                    lines.set(
                            p_idx,
                            lines.get(p_idx)
                                    + " ".repeat(2)
                                    + String.format("%d:%d", node.val, node.parrent.val));

                } else { // left node
                    line_idx.put(node.parrent, num_parrents);

                    // storing the offset in the parrent for the curr line
                    // the parrent's parrent
                    if (line_off.containsKey(node.parrent.parrent)) {
                        line_off.put(
                                node.parrent,
                                line_off.get(node.parrent.parrent)
                                        + ((node.parrent == node.parrent.parrent.left)
                                                ? -ADGST_OFFSET
                                                : ADGST_OFFSET));
                    } else {
                        line_off.put(node.parrent, BASE_OFFSET);
                    }

                    lines.set(
                            num_parrents,
                            " ".repeat(line_off.get(node.parrent))
                                    + String.format("%d:%d", node.val, node.parrent.val));
                }
            } else { // root
                line_off.put(node, BASE_OFFSET);

                lines.set(
                        num_parrents,
                        " ".repeat(line_off.get(node) + 5) + String.format("%d", node.val));
            }

            r(i + 1, list, lines, line_idx, line_off);
        }
    }
}
