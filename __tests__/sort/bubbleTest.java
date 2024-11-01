package sort;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class bubbleTest
{
    @BeforeEach void setup() {}

    @Test void testInt()
    {
        int[] nums = new int[]{ 2, 6, 1, 3 };

        System.err.println(Arrays.toString(nums));

        bubble.sort(nums);

        System.err.println(Arrays.toString(nums));
    }

    @Test void testInteger()
    {
        Integer[] nums = new Integer[]{ 2, 6, 1, 3 };

        System.err.println(Arrays.toString(nums));

        bubble.sort(nums);

        System.err.println(Arrays.toString(nums));
    }

    @Test void testFloat()
    {
        float[] nums =
          new float[]{ (float)2.2, (float)2.6, (float)2.1, (float)2.3 };

        System.err.println(Arrays.toString(nums));

        bubble.sort(nums);

        System.err.println(Arrays.toString(nums));
    }

    @Test void testClass()
    {
        Num[] nums =
          new Num[]{ new Num(2), new Num(6), new Num(1), new Num(3) };

        System.err.println(Arrays.toString(nums));

        bubble.sort(nums);

        System.err.println(Arrays.toString(nums));
    }
}

class Num implements Comparable<Num>
{
    int val;

  public
    Num(int val) { this.val = val; }

    @Override public int compareTo(Num other)
    {
        return Integer.compare(this.val, other.val);
    }

    @Override public String toString() { return String.format("%d", this.val); }
}
