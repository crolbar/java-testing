package leetcode.DP;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public
class _322Test
{
    _322 o = new _322();

    @Test void test()
    {
        var res = o.coinChange(new int[]{ 1,2,5 }, 11);
        System.out.println(res);
        assertEquals(3, res);
    }

    @Test void test2()
    {
        var res = o.coinChange(new int[]{2}, 3);
        System.out.println(res);
        assertEquals(-1, res);
    }

    @Test void test3()
    {
        var res = o.coinChange(new int[]{1,5,10}, 12);
        System.out.println(res);
        assertEquals(3, res);
    }

    @Test void test4()
    {
        var res = o.coinChange(new int[]{186,419,83,408}, 6249);
        System.out.println(res);
        assertEquals(20, res);
    }
}
