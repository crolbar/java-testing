package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public
class _210
{
  private
    boolean dfs(HashMap<Integer, ArrayList<Integer>> preMap,
                HashSet<Integer> set,
                HashSet<Integer> currPath,
                int[] i,
                int[] res,
                int course)
    {
        if (currPath.contains(course))
            return false;

        if (set.contains(course))
            return true;

        set.add(course);
        currPath.add(course);

        ArrayList<Integer> prerequisetes = preMap.get(course);
        for (int j = 0, size = prerequisetes.size(); j < size; j++) {
            int pre = prerequisetes.get(0);

            if (!dfs(preMap, set, currPath, i, res, pre))
                return false;

            prerequisetes.remove(0);
        }

        currPath.remove(course);

        res[i[0]++] = course;

        return true;
    }

  public
    int[] findOrder(int numCourses, int[][] prerequisites)
    {
        int[] res = new int[numCourses];

        HashMap<Integer, ArrayList<Integer>> preMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> currPath = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            preMap.putIfAbsent(i, new ArrayList<>());

            for (int j = 0; j < prerequisites.length; j++) {
                if (prerequisites[j][0] == i) {
                    preMap.get(i).add(prerequisites[j][1]);
                }
            }
        }

        int[] idx = new int[]{ 0 };
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(preMap, set, currPath, idx, res, i)) {
                return new int[0];
            }
        }

        return res;
    }
}
