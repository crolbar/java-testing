package pkgs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public
class leet
{
  public
    static void main() { ReorderList.main(); }
}

class ReorderList
{

  public
    static void main()
    {
        ReorderList r = new ReorderList();

        {
            // ListNode head = new ListNode(1);
            // head.next = new ListNode(2);
            // head.next.next = new ListNode(3);
            // head.next.next.next = new ListNode(4);

            ListNode head = new ListNode(3);
            head.next = new ListNode(8);
            head.next.next = new ListNode(0);
            head.next.next.next = new ListNode(5);
            head.next.next.next.next = new ListNode(1);
            head.next.next.next.next.next = new ListNode(98);
            head.next.next.next.next.next.next = new ListNode(-1);

            // ListNode list = new ListNode(1);
            // list.next = new ListNode(4);
            // list.next.next = new ListNode(2);
            // list.next.next.next = new ListNode(3);

            ListNode list = new ListNode(3);
            list.next = new ListNode(-1);
            list.next.next = new ListNode(8);
            list.next.next.next = new ListNode(98);
            list.next.next.next.next = new ListNode(0);
            list.next.next.next.next.next = new ListNode(1);
            list.next.next.next.next.next.next = new ListNode(5);

            r.reorderList(head);

            System.out.println();

            ListNode curr = head;
            ListNode curr2 = list;
            for (int i = 1; i <= 4; i++) {
                System.out.println(curr.val);
                assert curr.val == curr2.val;

                curr = curr.next;
                curr2 = curr2.next;
            }
        }
    }

    class Args
    {
        ListNode leftCurr;
        ListNode listCurr;
        ListNode listHead;
        int count;

        Args(ListNode leftCurr, ListNode listCurr, ListNode listHead, int count)
        {
            this.leftCurr = leftCurr;
            this.listCurr = listCurr;
            this.listHead = listHead;
            this.count = count;
        }
        Args(ListNode listHead) { this.listHead = listHead; }
    }

    Args
    r(ListNode left, ListNode right, ListNode list, int count)
    {
        if (right == null)
            return new Args(left, list, list, count);

        count++;

        Args r = r(left, right.next, list, count);

        if (r.leftCurr == null) {
            return new Args(r.listHead);
        }

        left = r.leftCurr;
        list = r.listCurr;

        // if (count == r.count / 2) {
        System.out.printf(
          "left: %d, r: %d, c: %d\n", left.val, right.val, r.count);
        //}

        if (r.count % 2 != 0 && count - 1 == r.count / 2) {
            list.val = left.val;
            return new Args(r.listHead);
        } else if (count == r.count / 2) {
            return new Args(r.listHead);
        }

        list.val = left.val;
        list.next = new ListNode(right.val);
        if (count - 1 != r.count / 2) {
            list.next.next = new ListNode(0);
        }

        return new Args(left.next, list.next.next, r.listHead, r.count);
    }

  public
    void reorderList(ListNode head)
    {
        Args r = r(head, head, new ListNode(head.val), 0);
        head.val = r.listHead.val;
        head.next = r.listHead.next;

        ListNode curr = r.listHead;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

}

class ListNode
{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }
}

class MergeTwoSortedLists
{
  public
    static void main()
    {
        MergeTwoSortedLists r = new MergeTwoSortedLists();
        r.test();
    }

    void test()
    {
        ListNode list1 = new ListNode(1);
        // list1.val = 1;
        // list1.next = new ListNode(2);
        // list1.next.next = new ListNode(4);
        list1.val = -9;
        list1.next = new ListNode(3);

        ListNode list2 = new ListNode(1);
        // list2.val = 1;
        // list2.next = new ListNode(3);
        // list2.next.next = new ListNode(4);
        list2.val = 5;
        list2.next = new ListNode(7);

        ListNode curr = list1;
        for (int i = 1; i <= 2; i++) {
            System.out.println(curr.val);
            curr = curr.next;
        }

        curr = list2;
        for (int i = 1; i <= 2; i++) {
            System.out.println(curr.val);
            curr = curr.next;
        }

        ListNode res = this.mergeTwoLists(list1, list2);

        System.out.println("\nres");
        curr = res;
        for (int i = 1; i <= 4; i++) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

  public
    ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        if (list1 == null || list2 == null) {
            if (list1 == null && list2 == null)
                return null;
            return (list1 != null) ? list1 : list2;
        }

        ListNode res = new ListNode();

        if (list1.val < list2.val) {
            res.val = list1.val;
            list1 = list1.next;
        } else {
            res.val = list2.val;
            list2 = list2.next;
        }

        res.next = mergeTwoLists(list1, list2);

        return res;
    }
}

class ReverseLinkedList
{
  public
    static void main()
    {
        ReverseLinkedList r = new ReverseLinkedList();
        r.test();
    }

    void test()
    {
        ListNode n = new ListNode(1);

        ListNode curr = n;
        for (int i = 2; i < 6; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        curr = n;
        for (int i = 1; i < 6; i++) {
            System.out.println(curr.val);
            curr = curr.next;
        }

        n = this.reverseList(n);

        curr = n;
        for (int i = 5; i >= 1; i--) {
            assert curr.val == i;
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

  public
    class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next)
        {
            this.val = val;
            this.next = next;
        }
    }

    ListNode
    r(ListNode curr, ListNode prev)
    {
        if (curr == null)
            return prev;

        ListNode next = curr.next;
        curr.next = prev;

        return r(next, curr);
    }

  public
    ListNode reverseList(ListNode head) { return r(head, null); }
}

class MedianofTwoSortedArrays
{
  public
    static void main()
    {
        MedianofTwoSortedArrays m = new MedianofTwoSortedArrays();

        assert m.findMedianSortedArrays(new int[]{ 1, 3 }, new int[]{ 2 }) ==
          2.00000;
        assert m.findMedianSortedArrays(new int[]{ 1, 2 }, new int[]{ 3, 4 }) ==
          2.50000;
    }

  public
    double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int total = nums1.length + nums2.length;

        int half = (total + 1) / 2;

        int l = 0, r = nums1.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int mid2 = half - mid;

            int Right1 = (mid < nums1.length) ? nums1[mid] : Integer.MAX_VALUE;
            int Left1 = (mid > 0) ? nums1[mid - 1] : Integer.MIN_VALUE;

            int Right2 =
              (mid2 < nums2.length) ? nums2[mid2] : Integer.MAX_VALUE;
            int Left2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;

            if (Left1 <= Right2 && Left2 <= Right1) {
                if (total % 2 == 1) {
                    return Math.max(Left1, Left2);
                }
                return (Math.max(Left1, Left2) + Math.min(Right1, Right2)) /
                       2.0;
            } else if (Left1 > Right2) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }
}

class TimeMap
{
  public
    static void main()
    {
        TimeMap timeMap = new TimeMap();

        {
            timeMap.set("alice", "happy", 1);
            assert timeMap.get("alice", 1) == "happy";
            assert timeMap.get("alice", 2) == "happy";
            timeMap.set("alice", "sad", 3);
            assert timeMap.get("alice", 3) == "sad";
        }

        timeMap = new TimeMap();

        {
            timeMap.set("foo", "bar", 1);
            assert timeMap.get("foo", 1) == "bar";
            assert timeMap.get("foo", 3) == "bar";
            timeMap.set("foo", "bar2", 4);
            assert timeMap.get("foo", 4) == "bar2";
            assert timeMap.get("foo", 5) == "bar2";
        }
    }

  private
    static class Pair<K, V>
    {
        K key;
        V value;

      public
        Pair(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<String, ArrayList<Pair<Integer, String>>>
      map;

  public
    TimeMap() { map = new HashMap<>(); }

  public
    void set(String key, String value, int timestamp)
    {
        ArrayList<Pair<Integer, String>> tsList =
          this.map.getOrDefault(key, new ArrayList<>());
        tsList.add(new Pair<>(timestamp, value));

        this.map.put(key, tsList);
    }

  public
    String get(String key, int timestamp)
    {
        if (!this.map.containsKey(key))
            return "";

        ArrayList<Pair<Integer, String>> tsList = this.map.get(key);

        String res = "";

        int l = 0, r = tsList.size() - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (tsList.get(m).key <= timestamp) {
                res = tsList.get(m).value;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }
}

class FindTargetinRotatedSortedArray
{
  public
    static void main()
    {
        FindTargetinRotatedSortedArray f = new FindTargetinRotatedSortedArray();
        assert f.search(new int[]{ 4, 5, 6, 7, 0, 1, 2 }, 0) == 4;
        assert f.search(new int[]{ 4, 5, 6, 7, 0, 1, 2 }, 3) == -1;
        assert f.search(new int[]{ 1 }, 0) == -1;
        assert f.search(new int[]{ 3, 4, 5, 6, 1, 2 }, 1) == 4;
        assert f.search(new int[]{ 3, 5, 6, 0, 1, 2 }, 4) == -1;
        assert f.search(new int[]{ 1, 2, 3, 4, 5, 6 }, 4) == 3;
        assert f.search(new int[]{ 5, 1, 3 }, 5) == 0;
        assert f.search(new int[]{ 5, 1, 2, 3, 4 }, 1) == 1;
    }

  public
    int search(int[] nums, int target)
    {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int curr = nums[m];

            if (curr == target) {
                return m;
            }

            if (curr >= nums[l]) {
                if (target > curr || target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }

            } else {
                if (target < curr || target > nums[r]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }

        return -1;
    }
}

class FindMinimuminRotatedSortedArray
{
  public
    static void main()
    {
        FindMinimuminRotatedSortedArray f =
          new FindMinimuminRotatedSortedArray();
        assert f.findMin(new int[]{ 3, 4, 5, 1, 2 }) == 1;
        assert f.findMin(new int[]{ 4, 5, 6, 7, 0, 1, 2 }) == 0;
        assert f.findMin(new int[]{ 11, 13, 15, 17 }) == 11;
    }

  public
    int findMin(int[] nums)
    {
        int l = 0, r = nums.length - 1;

        int res = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (m != 0 && nums[m - 1] > nums[m]) {
                res = nums[m];
                break;
            }

            if (nums[m] >= nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m - 1;
            }
        }

        if (res == -1)
            return nums[0];

        return res;
    }
}

class KokoEatingBananas
{
  public
    static void main()
    {
        KokoEatingBananas k = new KokoEatingBananas();
        assert k.minEatingSpeed(new int[]{ 3, 6, 7, 11 }, 8) == 4;
        assert k.minEatingSpeed(new int[]{ 30, 11, 23, 4, 20 }, 5) == 30;
        assert k.minEatingSpeed(new int[]{ 30, 11, 23, 4, 20 }, 6) == 23;
        assert k.minEatingSpeed(new int[]{ 1, 4, 3, 2 }, 9) == 2;
        assert k.minEatingSpeed(new int[]{ 25, 10, 23, 4 }, 4) == 25;
    }

  public
    int minEatingSpeed(int[] piles, int h)
    {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int res = max;

        int r = max, l = 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int time = 0;
            for (int i = 0; i < piles.length; i++) {
                time += Math.ceil((float)piles[i] / m);
            }

            if (time <= h) {
                res = m;
                r = m - 1;
            } else if (time > h) {
                l = m + 1;
            }
        }

        return res;
    }
}

class Search2DMatrix
{
  public
    static void main()
    {
        Search2DMatrix s = new Search2DMatrix();
        assert s.searchMatrix(
          new int[][]{ { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } },
          3) == true;
        assert s.searchMatrix(
          new int[][]{ { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } },
          13) == false;
        assert s.searchMatrix(
          new int[][]{ { 1, 2, 4, 8 }, { 10, 11, 12, 13 }, { 14, 20, 30, 40 } },
          10) == true;
        assert s.searchMatrix(
          new int[][]{ { 1, 2, 4, 8 }, { 10, 11, 12, 13 }, { 14, 20, 30, 40 } },
          15) == false;
    }

  public
    boolean searchMatrix(int[][] matrix, int target)
    {
        int m = matrix[0].length;
        int l = 0, r = (m * matrix.length) - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int mv = matrix[mid / m][mid % m];

            if (mv == target) {
                return true;
            } else if (target > mv) {
                l = mid + 1;
            } else if (target < mv) {
                r = mid - 1;
            }
        }

        return false;
    }
}

class BinarySearch
{
  public
    static void main()
    {
        BinarySearch bs = new BinarySearch();
        assert bs.search(new int[]{ -1, 0, 3, 5, 9, 12 }, 9) == 4;
        assert bs.search(new int[]{ -1, 0, 3, 5, 9, 12 }, 2) == -1;
    }

  public
    int search(int[] nums, int target)
    {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int mv = nums[m];

            if (mv == target) {
                return m;
            } else if (target > mv) {
                l = m + 1;
            } else if (target < mv) {
                r = m - 1;
            }
        }

        return -1;
    }
}

class SlidingWindowMaximum
{
    SlidingWindowMaximum() {}

  public
    static void main()
    {
        SlidingWindowMaximum s = new SlidingWindowMaximum();

        assert Arrays.equals(
          s.maxSliingWindow(new int[]{ 1, 2, 1, 0, 4, 2, 6 }, 3),
          new int[]{ 2, 2, 4, 4, 6 });
        assert Arrays.equals(
          s.maxSliingWindow(new int[]{ 1, 3, -1, -3, 5, 3, 6, 7 }, 3),
          new int[]{ 3, 3, 5, 5, 6, 7 });

        assert Arrays.equals(s.maxSliingWindow(new int[]{ 1 }, 1),
                             new int[]{ 1 });
        assert Arrays.equals(s.maxSliingWindow(new int[]{ 1, -1 }, 1),
                             new int[]{ 1, -1 });
    }

  public
    int[] maxSliingWindow(int[] nums, int k)
    {
        Deque<Integer> q = new ArrayDeque<>();

        int[] res = new int[(nums.length - k) + 1];

        int l = 0, r = 0;

        for (; r < nums.length; r++) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }

            q.offer(r);

            if (l > q.peekFirst()) {
                q.pollFirst();
            }

            if (r < k - 1)
                continue;

            res[l] = nums[q.peekFirst()];

            l++;
        }

        return res;
    }
}

class MinimumWindowSubstring
{
    MinimumWindowSubstring() {}

  public
    static void main()
    {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        assert m.minWindow("ADOBECODEBANC", "ABC").equals("BANC");
        assert m.minWindow("a", "a").equals("a");
        assert m.minWindow("a", "aa").equals("");
        assert m.minWindow("OUZODYXAZV", "XYZ").equals("YXAZ");
        assert m.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd").equals("abbbbbcdd");
    }

  public
    String minWindow(String s, String t)
    {
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int min = s.length() + 1;

        int[] res = new int[2];

        int m = 0;
        int l = 0;
        int r;
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if (sMap.get(c).equals(tMap.get(c)))
                    m++;
            } else
                continue;

            if (m < tMap.size())
                continue;

            do {
                int newMin = r - l + 1;
                if (newMin < min) {
                    min = newMin;
                    res[0] = l;
                    res[1] = r + 1;
                }

                char lc = s.charAt(l);
                if (sMap.containsKey(lc)) {
                    if (sMap.get(lc).equals(tMap.get(lc)))
                        m--;
                    sMap.put(lc, sMap.get(lc) - 1);
                }

                l++;
            } while (m >= tMap.size() && l < s.length());
        }

        return s.substring(res[0], res[1]);
    }
}

class PermutationinString
{
    PermutationinString() {}

  public
    static void main()
    {
        System.out.println("hi");
        PermutationinString p = new PermutationinString();
        assert p.checkInclusion("abc", "abc") == true;
        assert p.checkInclusion("acb", "abc") == true;
        assert p.checkInclusion("ab", "eidbaooo") == true;
        assert p.checkInclusion("ab", "eidboaoo") == false;
        assert p.checkInclusion("abc", "lecabee") == true;
        assert p.checkInclusion("abbcc", "abbccdcl") == true;
        assert p.checkInclusion("ccbba", "ccbbcccccccccccccccccccdcl") == false;
        assert p.checkInclusion("ccbba", "ccbbacccccccccccccccccccdcl") == true;
        assert p.checkInclusion("abc", "lecaabee") == false;
        assert p.checkInclusion("adc", "dcda") == true;
        assert p.checkInclusion("a", "b") == false;
        assert p.checkInclusion("ab", "a") == false;
    }

  public
    boolean checkInclusion(String s1, String s2)
    {
        HashMap<Character, Integer> minMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);

            minMap.put(c, minMap.getOrDefault(c, 0) + 1);
        }

        int l = 0;

        HashMap<Character, Integer> tmpMap = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);

            tmpMap.put(c, tmpMap.getOrDefault(c, 0) + 1);

            if (i - l + 1 > s1.length()) {
                char firstChar = s2.charAt(l);

                if (tmpMap.get(firstChar) > 1) {
                    tmpMap.put(firstChar, tmpMap.get(firstChar) - 1);
                } else {
                    tmpMap.remove(firstChar);
                }

                l++;
            }

            if (minMap.equals(tmpMap))
                return true;
        }

        return false;
    }
}

class LongestRepeatingSubstringWithReplacement
{
    LongestRepeatingSubstringWithReplacement() {}

  public
    static void main()
    {
        LongestRepeatingSubstringWithReplacement l =
          new LongestRepeatingSubstringWithReplacement();

        assert l.characterReplacement("AAABABB", 1) == 5;
        assert l.characterReplacement("XYYX", 2) == 4;
        assert l.characterReplacement("ABAB", 2) == 4;
        assert l.characterReplacement("AABABBA", 1) == 4;
        assert l.characterReplacement("BBBBBAABBAABBBBBB", 2) == 10;
        assert l.characterReplacement("ABBB", 2) == 4;
        assert l.characterReplacement("ABCDE", 1) == 2;
    }

  public
    int characterReplacement(String s, int k)
    {
        int ans = 0;
        System.out.println();
        System.out.println(s);
        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int max = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            map.put(c, map.getOrDefault(c, 0) + 1);

            max = Math.max(max, map.get(c));

            if (r - l + 1 - max > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            ans = Math.max(ans, r - l + 1);
            // System.out.printf("atchar: %c, %d, max: %d\n", c, map.get(c),
            // max);
        }

        // System.out.printf("ans: %d, max: %d\n\n", ans, max);
        return ans;
    }
}

class LongestSubstringWithoutDuplicates
{
    LongestSubstringWithoutDuplicates() {}

  public
    static void main()
    {
        System.out.println("hi");
        LongestSubstringWithoutDuplicates l =
          new LongestSubstringWithoutDuplicates();
        assert l.lengthOfLongestSubstring("zxyzxyz") == 3;
        assert l.lengthOfLongestSubstring("xxxx") == 1;
        assert l.lengthOfLongestSubstring("pwwkew") == 3;
        assert l.lengthOfLongestSubstring("bbbbb") == 1;
        assert l.lengthOfLongestSubstring("abcabcbb") == 3;
        assert l.lengthOfLongestSubstring(" ") == 1;
        assert l.lengthOfLongestSubstring("dvdf") == 3;
        assert l.lengthOfLongestSubstring("aaaadvdfo") == 4;
    }

  public
    int lengthOfLongestSubstring(String s)
    {
        int length = 0;
        HashSet<Character> set = new HashSet<>();

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(c);
            length = Math.max(length, r - l + 1);
        }

        return length;
    }
}

class BestTimetoBuyandSellStock
{
    BestTimetoBuyandSellStock() {}

  public
    static void main()
    {
        System.out.println("hi");
        BestTimetoBuyandSellStock b = new BestTimetoBuyandSellStock();

        assert b.maxProfit(new int[]{ 7, 1, 5, 3, 6, 4 }) == 5;
        assert b.maxProfit(new int[]{ 7, 6, 4, 3, 1 }) == 0;
    }

  public
    int maxProfit(int[] prices)
    {
        int ans = 0;

        int l = 0;
        for (int r = 0; r < prices.length; r++) {
            while (l < prices.length && prices[l] > prices[r])
                l++;

            ans = Math.max(ans, prices[r] - prices[l]);
        }

        return ans;
    }
}

class TrappingRainWater
{
    TrappingRainWater() {}

  public
    static void main()
    {
        TrappingRainWater trw = new TrappingRainWater();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int out = trw.trap(height);

        assert out == 6;
        System.out.println(out);
    }

  public
    int trap(int[] height)
    {
        if (height.length == 0)
            return 0;

        int ans = 0;
        int r = height.length - 1, l = 0;

        int leftMax = height[l], rightMax = height[r];

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                ans += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                ans += rightMax - height[r];
            }
        }

        return ans;
    }
}

class MaxWaterContainer
{
    MaxWaterContainer() {}

  public
    static void main()
    {
        MaxWaterContainer mc = new MaxWaterContainer();
        //// int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        // int[] heights = {1,1};
        int[] heights = { 1, 2, 4, 3 }; // 4
        int out = mc.maxArea(heights);
        System.out.println(out);
        // System.out.println(Math.abs(0));
    }

  public
    int maxArea(int[] height)
    {
        int l = 0, r = height.length - 1;
        int max = 0;

        while (l < r) {
            int c = r - l;

            System.out.printf("l: %d, r: %d, c: %d\n", l, r, c);

            int area = c * Math.min(height[r], height[l]);

            System.out.println(area);

            max = Math.max(area, max);

            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return max;
    }
}

class ThreeSum
{
    ThreeSum() {}

  public
    static void main()
    {
        System.out.println("hi");

        ThreeSum ts = new ThreeSum();

        // int[] nums = {-1, 0, 1, 2, -1, -4};
        // int[] nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        int[] nums = { 6,  -5, -6, -1, -2, 8, -1, 4,  -10, -8, -10, -2,
                       -4, -1, -8, -2, 8,  9, -5, -2, -8,  -9, -3,  -5 };
        // Last case:
        // [6,-5,-6,-1,-2,8,-1,4,-10,-8,-10,-2,-4,-1,-8,-2,8,9,-5,-2,-8,-9,-3,-5]
        // Output:
        // [[-8,-1,9],[-5,-1,6],[-6,-2,8],[-4,-2,6],[-6,-3,9],[-5,-3,8],[-5,-4,9],[-10,4,6]]
        // Expected:
        // [[-10,4,6],[-8,-1,9],[-6,-3,9],[-6,-2,8],[-5,-4,9],[-5,-3,8],[-5,-1,6],[-4,-2,6],[-3,-1,4],[-2,-2,4]]
        // missing:

        List<List<Integer>> out = ts.threeSum(nums);

        System.out.println("\n" + out);
        System.out.println(
          "[[-10, 4, 6], [-8, -1, 9], [-6, -3, 9], [-6, -2, 8], [-5, -4, 9]," +
          "[-5, -3, 8]," +
          "[-5, -1, 6], [-4, -2, 6], [-3, -1, 4], [-2, -2, 4]]");
    }

  public
    List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> l = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int li = i + 1;
            int hi = nums.length - 1;

            while (li < hi) {
                int sum = nums[i] + nums[li] + nums[hi];

                if (sum > 0)
                    hi--;
                else if (sum < 0)
                    li++;
                else {
                    l.add(Arrays.asList(nums[i], nums[li], nums[hi]));

                    hi--;
                    li++;

                    // not adjusting hi because the loop will adjust it for us
                    // the sum will not be the same
                    while (li < hi && nums[li] == nums[li - 1])
                        li++;
                }
            }
        }

        return l;
    }
}

class TwoSumII
{
    TwoSumII() {}

  public
    static void main()
    {
        TwoSumII ts = new TwoSumII();
        // int[] numbers = {2,7,11,15};
        // int target = 9;
        int[] numbers = { 2, 3, 4 };
        int target = 6;

        int[] out = ts.twoSum(numbers, target);
        System.out.println(Arrays.toString(out));
    }

  public
    int[] twoSum(int[] numbers, int target)
    {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int s = numbers[l] + numbers[r];

            if (s > target) {
                r--;
            } else if (s < target) {
                l++;
            } else {
                return new int[]{ l + 1, r + 1 };
            }
        }
        return new int[0];
    }
}

class LargestRectangleInHistogram
{
    LargestRectangleInHistogram() {}

  public
    static void main()
    {
        LargestRectangleInHistogram o = new LargestRectangleInHistogram();

        int[] heights = { 7, 1, 7, 2, 2, 4 };
        // int[] heights = {1,3,7};
        int out = o.largestRectangleArea(heights);
        System.out.println(out);

        System.out.println("LargestRectangleInHistogram");
    }

  public
    int largestRectangleArea(int[] heights)
    {
        int ans = 0;

        int[] prevSmallest = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            prevSmallest[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        int[] nextSmallest = new int[heights.length];
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            nextSmallest[i] = (stack.isEmpty()) ? heights.length : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            int area = ((nextSmallest[i] - prevSmallest[i]) - 1) * heights[i];
            ans = Math.max(ans, area);
        }

        return ans;
    }
}

class CarFleet
{
    CarFleet() {}

  public
    static void main()
    {
        // int[] position = {0, 2, 4};
        // int[] speed = {4, 2, 1};
        int target = 12;
        int[] position = { 10, 8, 0, 5, 3 };
        int[] speed = { 2, 4, 1, 1, 3 };
        // int target = 10;
        // int[] position = {0, 4, 2};
        // int[] speed = {2, 1, 3};

        CarFleet cf = new CarFleet();
        int out = cf.carFleet(target, position, speed);
        System.out.println(out);
    }

    class car
    {
        int position;
        int speed;

        car(int position, int speed)
        {
            this.position = position;
            this.speed = speed;
        }
    }

    public int
    carFleet(int target, int[] position, int[] speed)
    {
        LinkedList<car> list = new LinkedList<>();
        for (int i = 0; i < position.length; i++) {
            list.add(new car(position[i], speed[i]));
        }
        list.sort((a, b)->Integer.compare(b.position, a.position));

        int count = 0;
        double[] times = new double[position.length];
        for (int i = 0; i < position.length; i++) {
            car n = list.pop();
            System.out.println(n.position);

            times[i] = (double)(target - n.position) / n.speed;

            if (count != 0 && times[i] <= times[i - 1]) {
                times[i] = times[i - 1];
            } else
                count++;
        }

        return count;
    }
}

class DailyTemperatures
{
  public
    static void main()
    {
        // int[] temperatures = {30, 38, 30, 36, 35, 40, 28};
        // int[] temperatures = {22,21,20};
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };

        DailyTemperatures d = new DailyTemperatures();
        int[] out = d.dailyTemperatures(temperatures);

        System.out.println(Arrays.toString(out));
    }

    class Node
    {
        Node next;
        int tmp;
        int idx;

        Node(int tmp, int idx)
        {
            this.tmp = tmp;
            this.idx = idx;
        }
    }

    Node head;

    DailyTemperatures() { this.head = null; }

  public
    int[] dailyTemperatures(int[] temperatures)
    {
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            Node n = new Node(temperatures[i], i);

            while (this.head != null && this.head.tmp < n.tmp) {
                Node p = this.head;
                this.head = p.next;

                res[p.idx] = i - p.idx;
            }

            n.next = this.head;
            this.head = n;
        }

        return res;
    }
}

class GenerateParentheses
{
  public
    static void main()
    {
        int n = 3;
        List<String> out = generateParenthesis(n);
        System.out.println(out);
    }

  public
    static void r(List<String> list, String curr, int n, int openC, int closeC)
    {
        if (curr.length() >= (n * 2) - 1) {
            curr += ')';

            if (openC == closeC) {
                list.add(curr);
            }
            return;
        }

        r(list, curr + '(', n, openC + 1, closeC);
        if (closeC - 1 < openC) {
            r(list, curr + ')', n, openC, closeC + 1);
        }

        return;
    }

  public
    static List<String> generateParenthesis(int n)
    {
        List<String> list = new ArrayList<String>();

        r(list, "(", n, 1, 1);

        return list;
    }
}

class EvaluateReversePolishNotation
{
  public
    static void main()
    {
        // String[] tokens = {"1"};
        String[] tokens = { "10", "6", "9",  "3", "+", "-11", "*",
                            "/",  "*", "17", "+", "5", "+" };
        // String[] tokens = {"4","13","5","/","+"};
        int out = evalRPN(tokens);

        System.out.println(out);
    }

  public
    static int evalRPN(String[] tokens)
    {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            // a bit cheeky but works
            boolean is_negative = t.charAt(0) == '-';
            if (Character.isDigit(t.charAt(0)) ||
                is_negative && t.length() > 1 &&
                  Character.isDigit(t.charAt(1))) {
                int num_t = 0;
                for (int ci = (is_negative) ? 1 : 0; ci < t.length(); ci++) {
                    num_t *= 10;
                    num_t += t.charAt(ci) - '0';
                }
                if (is_negative)
                    num_t *= -1;
                // System.out.printf("num_t: %d\n", num_t);
                stack.push(num_t);

                continue;
            }

            int num_2 = stack.pop();
            int num_1 = stack.pop();

            System.out.printf("1: %d, 2: %d\n", num_1, num_2);

            int res = (t.equals("*"))   ? num_1 * num_2
                      : (t.equals("+")) ? num_1 + num_2
                      : (t.equals("-")) ? num_1 - num_2
                                        : num_1 / num_2;

            // System.out.println(res);
            stack.push(res);
        }

        return stack.pop();
    }
}

class MinStack
{
  public
    static void main()
    {
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

    class Node
    {
        Node next;
        int minVal;
        int val;

        Node(int val)
        {
            this.val = val;
            this.next = null;
        }
    }

    Node head;

  public
    MinStack() { this.head = null; }

  public
    void push(int val)
    {
        Node newHead = new Node(val);

        if (this.head != null) {
            newHead.next = this.head;
        }

        Integer newMinVal = (this.head == null) ? val
                            : (this.head.minVal < newHead.val)
                              ? this.head.minVal
                              : val;

        this.head = newHead;
        this.head.minVal = newMinVal;
    }

  public
    void pop()
    {
        Node next = this.head.next;
        this.head = next;
    }

  public
    int top() { return this.head.val; }

  public
    int getMin() { return this.head.minVal; }
}

class ValidateParentheses
{
  public
    static void main() { System.out.println(isValid("([])()")); }

  public
    static boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;

                char tc = (c == '}') ? '{' : (c == ']') ? '[' : '(';

                if (stack.peek() != tc)
                    return false;

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}

class ValidSudoku
{
  public
    static void main()
    {
        char[][] board = { { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
                           { '4', '.', '.', '5', '.', '.', '.', '.', '.' },
                           { '.', '9', '8', '.', '.', '.', '.', '.', '3' },
                           { '5', '.', '.', '.', '6', '.', '.', '.', '4' },
                           { '.', '.', '.', '8', '.', '3', '.', '.', '5' },
                           { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                           { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                           { '.', '.', '.', '4', '1', '9', '.', '.', '8' },
                           { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        boolean out = isValidSudoku(board);

        System.out.println(out);
    }

    static class Point
    {
        int x;
        int y;

        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean
    isValidSudoku(char[][] board)
    {
        HashMap<Character, ArrayList<Point>> map = new HashMap<>();

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                char c = board[x][y];
                Point curr_point = new Point(x, y);

                if (c == '.')
                    continue;

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

class ValidPalindrome
{
  public
    static void main()
    {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

  public
    static boolean isPalindrome(String s)
    {
        int li = 0;
        int ri = s.length() - 1;

        while (li <= ri) {
            while (!Character.isAlphabetic(s.charAt(li)) &&
                   !Character.isDigit(s.charAt(li)) && li < ri)
                li++;
            while (!Character.isAlphabetic(s.charAt(ri)) &&
                   !Character.isDigit(s.charAt(ri)) && li < ri)
                ri--;

            char lc = Character.toLowerCase(s.charAt(li));
            char rc = Character.toLowerCase(s.charAt(ri));

            if (lc != rc)
                return false;

            li++;
            ri--;
        }

        return true;
    }
}

class pES
{
  public
    static int[] productExceptSelf(int[] nums)
    {
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

  public
    static void main()
    {
        int[] nums = { 1, 2, 4, 6 };

        System.out.println(Arrays.toString(nums));
        int[] out = productExceptSelf(nums);

        System.out.println(Arrays.toString(out));
    }
}

class LongestConsecutiveSequence
{
  public
    static int longestConsecutive(int[] nums)
    {
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

  public
    static void main()
    {
        // int[] nums = {0, 0, 2};
        int[] nums = { 2, 20, 4, 10, 3, 4, 5 };
        // int[] nums = {0, 3, 2, 5, 4, 6, 1, 1};
        // int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};

        System.out.println(Arrays.toString(nums));
        int out = longestConsecutive(nums);
        System.out.println(out);
    }
}
