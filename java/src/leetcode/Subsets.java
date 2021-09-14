package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Subsets {
	List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> q = new LinkedList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }
    
    void backtrack(int[] nums, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(q));
            return;
        }
        q.add(nums[i]);
        backtrack(nums, i + 1);
        q.removeLast();
        backtrack(nums, i + 1);
    }
}