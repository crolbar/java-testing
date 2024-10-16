package leetcode.Heap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public
class _355
{
    Twitter t;
  public
    _355() { t = new Twitter(); }
}

class Twitter
{
    class Tweet implements Comparable<Tweet>
    {
        int id;
        int timestamp;
        Tweet(int id, int timestamp)
        {
            this.id = id;
            this.timestamp = timestamp;
        }

        @Override public int compareTo(Tweet that)
        {
            return Integer.compare(that.timestamp, this.timestamp);
        }

        @Override public String toString()
        {
            return "{id:" + this.id + ", timestamp: " + this.timestamp + "}";
        }
    }

    int timestamp;
    HashMap<Integer, HashSet<Integer>> followMap;
    HashMap<Integer, Tweet[]> tweetMap;

  public
    Twitter()
    {
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }

  public
    void postTweet(int userId, int tweetId)
    {
        Tweet[] tweetList = tweetMap.getOrDefault(userId, new Tweet[0]);

        Tweet[] newTweetList = Arrays.copyOf(tweetList, tweetList.length + 1);

        newTweetList[newTweetList.length - 1] = new Tweet(tweetId, timestamp++);

        tweetMap.put(userId, newTweetList);
    }

  public
    List<Integer> getNewsFeed(int userId)
    {
        PriorityQueue<Tweet> pq = new PriorityQueue<>();

        for (Entry<Integer, Tweet[]> e : this.tweetMap.entrySet()) {
            if (e.getKey() != userId && !followMap.containsKey(userId)) {
                continue;
            }

            if (e.getKey() != userId &&
                !followMap.get(userId).contains(e.getKey())) {
                continue;
            }

            Tweet[] list = e.getValue();
            for (Tweet t : list) {
                pq.offer(t);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (!pq.isEmpty() && res.size() < 10) {
            res.add(pq.poll().id);
        }

        return res;
    }

  public
    void follow(int followerId, int followeeId)
    {
        HashSet<Integer> followedList =
          followMap.getOrDefault(followerId, new HashSet<>());

        followedList.add(followeeId);
        followMap.put(followerId, followedList);
    }

  public
    void unfollow(int followerId, int followeeId)
    {
        HashSet<Integer> followedList =
          followMap.getOrDefault(followerId, new HashSet<>());

        followedList.remove(Integer.valueOf(followeeId));
        followMap.put(followerId, followedList);
    }
}
