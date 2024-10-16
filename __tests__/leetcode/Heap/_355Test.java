package leetcode.Heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _355Test
{
    _355 o;

    @BeforeEach void setup() { o = new _355(); }

    @Test void test()
    {
        o.t.postTweet(1, 5);
        System.out.println(o.t.getNewsFeed(1));

        o.t.follow(1, 2);
        o.t.postTweet(2, 6);

        System.out.println(o.t.getNewsFeed(1));

        o.t.unfollow(1, 2);

        System.out.println(o.t.getNewsFeed(1));
    }

    @Test void test0()
    {
        o.t.follow(1, 2);
        o.t.follow(1, 3);
        o.t.follow(1, 5);
        o.t.follow(2, 1);
        o.t.follow(2, 3);

        o.t.unfollow(2, 3);

        System.out.println(o.t.followMap);
    }
}
