package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public
class _207
{
  private
    boolean dfs(HashMap<Integer, ArrayList<Integer>> preMap,
                HashSet<Integer> set,
                int i)
    {
        if (set.contains(i))
            return false;

        set.add(i);

        ArrayList<Integer> prerequisetes = preMap.get(i);
        for (int j = 0; j < prerequisetes.size(); j++) {
            if (!dfs(preMap, set, prerequisetes.get(j))) {
                return false;
            }
            prerequisetes.remove(j);
        }

        set.remove(i);

        return true;
    }

  public
    boolean canFinish(int numCourses, int[][] prerequisites)
    {
        HashMap<Integer, ArrayList<Integer>> preMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            preMap.putIfAbsent(i, new ArrayList<>());

            for (int j = 0; j < prerequisites.length; j++) {
                if (prerequisites[j][0] == i) {
                    preMap.get(i).add(prerequisites[j][1]);
                }
            }
        }

        System.out.println(preMap);

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(preMap, set, i))
                return false;
        }
        return true;
    }
}
