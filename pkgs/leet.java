package pkgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class leet {
    public static void main() {
        MinStack.main();
    }
}

class MinStack {
    public static void main() {
        MinStack ms = new MinStack();

        ms.push(-2);
        ms.push(4);
        ms.push(-5);
        ms.push(3);
        ms.push(200);

        assert ms.top() == 200;
        assert ms.getMin() == -5;
        ms.pop();
        assert ms.top() == 3;
        assert ms.getMin() == -5;
        ms.pop();
        assert ms.top() == -5;
        assert ms.getMin() == -5;
        ms.pop();
        assert ms.top() == 4;
        assert ms.getMin() == -2;
        ms.pop();
        assert ms.top() == -2;
        assert ms.getMin() == -2;
        ms.pop();
    }

    class Node {
        Node next;
        int val;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    Node minHead;

    public MinStack() {
        this.head = null;
        this.minHead = null;
    }

    public void push(int val) {
        Node new_head = new Node(val);

        if (this.head != null) {
            new_head.next = this.head;
        }

        this.head = new_head;

        Node new_min_head =
                (this.minHead == null)
                        ? new Node(val)
                        : (this.minHead.val < this.head.val) ? new Node(this.minHead.val) : new Node(val);

        if (this.minHead != null) {
            new_min_head.next = this.minHead;
        }

        this.minHead = new_min_head;
    }

    public void pop() {
        Node min_next = this.minHead.next;
        this.minHead = min_next;

        Node next = this.head.next;
        this.head = next;
    }

    public int top() {
        return this.head.val;
    }

    public int getMin() {
        return this.minHead.val;
    }
}

class ValidateParentheses {
    public static void main() {
        System.out.println(isValid("([])()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char tc = (c == '}') ? '{' : (c == ']') ? '[' : '(';

                if (stack.peek() != tc) return false;

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}

class ValidSudoku {
    public static void main() {
        char[][] board = {
            {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
            {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
            {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
            {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean out = isValidSudoku(board);

        System.out.println(out);
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isValidSudoku(char[][] board) {
        HashMap<Character, ArrayList<Point>> map = new HashMap<>();

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                char c = board[x][y];
                Point curr_point = new Point(x, y);

                if (c == '.') continue;

                ArrayList<Point> list = map.get(c);

                if (list != null) {
                    for (int li = 0; li < list.size(); li++) {
                        Point lp = list.get(li);

                        if (curr_point.x == lp.x || curr_point.y == lp.y) {
                            return false;
                        }

                        int tx = lp.x - ((x >= 6) ? 6 : (x >= 3) ? 3 : 0);
                        int ty = lp.y - ((y >= 6) ? 6 : (y >= 3) ? 3 : 0);

                        if (tx >= 0 && tx < 3 && ty >= 0 && ty < 3) {
                            return false;
                        }
                    }
                } else {
                    list = new ArrayList<>();
                }

                list.add(curr_point);
                map.put(c, list);
            }
        }

        return true;
    }
}

class ValidPalindrome {
    public static void main() {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int li = 0;
        int ri = s.length() - 1;

        while (li <= ri) {
            while (!Character.isAlphabetic(s.charAt(li))
                    && !Character.isDigit(s.charAt(li))
                    && li < ri) li++;
            while (!Character.isAlphabetic(s.charAt(ri))
                    && !Character.isDigit(s.charAt(ri))
                    && li < ri) ri--;

            char lc = Character.toLowerCase(s.charAt(li));
            char rc = Character.toLowerCase(s.charAt(ri));

            if (lc != rc) return false;

            li++;
            ri--;
        }

        return true;
    }
}

class pES {
    public static int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];

        // store the prod of all element to the left of i in out[i]
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            out[i] += prod;
            prod *= nums[i];
        }

        // reset var so we can start to track the prod from the right
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // then use the prod to the left and multiply it with the prod
            // to the right (that's why we start from the end)
            out[i] = out[i] * prod;
            prod *= nums[i];
        }

        // basicly we get
        //
        // left prod
        // [1, 1, 2, 8]
        //
        // right prod
        // [48, 24, 6, 1]
        //
        // and we just multiply them
        //
        // [48, 24, 12, 8]

        return out;
    }

    public static void main() {
        int[] nums = {1, 2, 4, 6};

        System.out.println(Arrays.toString(nums));
        int[] out = productExceptSelf(nums);

        System.out.println(Arrays.toString(out));
    }
}

class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            if (!set.contains(n - 1)) {
                int count = 0;

                while (set.contains(n)) {
                    n++;
                    count++;
                }

                num = Math.max(num, count);
            }
        }

        return num;
    }

    public static void main() {
        // int[] nums = {0, 0, 2};
        int[] nums = {2, 20, 4, 10, 3, 4, 5};
        // int[] nums = {0, 3, 2, 5, 4, 6, 1, 1};
        // int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};

        System.out.println(Arrays.toString(nums));
        int out = longestConsecutive(nums);
        System.out.println(out);
    }
}
