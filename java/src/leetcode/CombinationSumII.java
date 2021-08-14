package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class CombinationSumII {
	List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> dq = new ArrayDeque<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, target);
        return res;
    }
    
    void dfs(int index, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(dq));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        int tmp = index + 1;
        while (tmp < candidates.length && candidates[tmp] == candidates[tmp - 1]) {
            tmp++;
        }
        int remains = target;
        for (int i = index; i < tmp; i++) {
            if (candidates[i] <= remains) {
                dq.addLast(candidates[i]);
                dfs(tmp, candidates, remains - candidates[i]);
                remains = remains - candidates[i];
            } else {
                break;
            }
        }
        while (!dq.isEmpty() && dq.peekLast() == candidates[index]) {
            dq.pollLast();
        }
        dfs(tmp, candidates, target);
    }
}