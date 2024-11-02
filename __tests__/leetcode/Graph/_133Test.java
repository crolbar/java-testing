package leetcode.Graph;

import leetcode.lib.Graph.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class _133Test {
    _133 o = new _133();;

    @Test
    void test() {
        Node root = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        root.neighbors = new ArrayList<>(Arrays.asList(two, four));
        two.neighbors = new ArrayList<>(Arrays.asList(root, three));
        three.neighbors = new ArrayList<>(Arrays.asList(two, four));
        four.neighbors = new ArrayList<>(Arrays.asList(root, three));

        var res = o.cloneGraph(root);

        System.out.println(res);
        System.out.println(res.neighbors.get(0));
        System.out.println(res.neighbors.get(0).neighbors.get(1));
        System.out.println(res.neighbors.get(1));
    }

}
