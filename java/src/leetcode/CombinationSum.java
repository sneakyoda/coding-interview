package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class CombinationSum {
	List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> q = new ArrayDeque<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, target);
        return res;
    }
    
    void dfs(int index, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(q));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            q.addLast(candidates[i]);
            dfs(i, candidates, target - candidates[i]);
            q.pollLast();
        }
    }
}