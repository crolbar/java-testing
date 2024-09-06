package pkgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class leet {
    public static void main() {
        GenerateParentheses.main();
    }
}

class GenerateParentheses {
    public static void main() {
        int n = 3;
        List<String> out = generateParenthesis(n);
        System.out.println(out);
    }

    public static void r(List<String> list, String curr, int n) {
        if (curr.length() >= (n * 2) - 1) {
            curr += ')';

            if (ValidateParentheses.isValid(curr)) {
                list.add(curr);
            }
            return;
        }

        r(list, curr + '(', n);
        r(list, curr + ')', n);

        return;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();

        r(list, "(", n);

        return list;
    }
}

class EvaluateReversePolishNotation {
    public static void main() {
        // String[] tokens = {"1"};
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        // String[] tokens = {"4","13","5","/","+"};
        int out = evalRPN(tokens);

        System.out.println(out);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            // a bit cheeky but works
            boolean is_negative = t.charAt(0) == '-';
            if (Character.isDigit(t.charAt(0))
                    || is_negative && t.length() > 1 && Character.isDigit(t.charAt(1))) {
                int num_t = 0;
                for (int ci = (is_negative) ? 1 : 0; ci < t.length(); ci++) {
                    num_t *= 10;
                    num_t += t.charAt(ci) - '0';
                }
                if (is_negative) num_t *= -1;
                // System.out.printf("num_t: %d\n", num_t);
                stack.push(num_t);

                continue;
            }

            int num_2 = stack.pop();
            int num_1 = stack.pop();

            System.out.printf("1: %d, 2: %d\n", num_1, num_2);

            int res =
                    (t.equals("*"))
                            ? num_1 * num_2
                            : (t.equals("+"))
                                    ? num_1 + num_2
                                    : (t.equals("-")) ? num_1 - num_2 : num_1 / num_2;

            // System.out.println(res);
            stack.push(res);
        }

        return stack.pop();
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
        int minVal;
        int val;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;

    public MinStack() {
        this.head = null;
    }

    public void push(int val) {
        Node newHead = new Node(val);

        if (this.head != null) {
            newHead.next = this.head;
        }

        Integer newMinVal =
                (this.head == null)
                        ? val
                        : (this.head.minVal < newHead.val) ? this.head.minVal : val;

        this.head = newHead;
        this.head.minVal = newMinVal;
    }

    public void pop() {
        Node next = this.head.next;
        this.head = next;
    }

    public int top() {
        return this.head.val;
    }

    public int getMin() {
        return this.head.minVal;
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
