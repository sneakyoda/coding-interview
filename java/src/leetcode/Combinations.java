package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Combinations {
	List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> dq = new ArrayDeque<>();
    
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }
    
    void backtrack(int index, int to, int count) {
        if (dq.size() == count) {
            res.add(new ArrayList<>(dq));
            return;
        }
        if (index > to) {
            return;
        }
        dq.addLast(index);
        backtrack(index + 1, to, count);
        dq.removeLast();
        backtrack(index + 1, to, count);
    }
}