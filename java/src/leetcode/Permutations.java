package leetcode;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Permutations {
	List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> dq = new ArrayDeque<>();
    
    public List<List<Integer>> permute(int[] nums) {
        dfs(0, nums);
        return res;
    }
    
    void dfs(int index, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<>(dq));
            return;
        }
        for (int num : nums) {
            if (!dq.contains(num)) {
                dq.addLast(num);
                dfs(index + 1, nums);
                dq.removeLast();
            }
        }
    }
}