package leetcode;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PermutationsII {
	List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> dq = new ArrayDeque<>();
    Map<Integer, Integer> map = new HashMap<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        dfs(0, nums); 
        return res;
    }
    
    void dfs(int index, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<>(dq));
            return;
        }
        for (int num : map.keySet()) {
            if (map.getOrDefault(num, 0) > 0) {
                dq.addLast(num);
                map.put(num, map.get(num) - 1);
                dfs(index + 1, nums);
                dq.removeLast();
                map.put(num, map.get(num) + 1);
            }
        }
    }
}