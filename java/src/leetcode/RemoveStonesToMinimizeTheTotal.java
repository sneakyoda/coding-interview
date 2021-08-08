package leetcode;

import java.util.PriorityQueue;

class RemoveStonesToMinimizeTheTotal {
	public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int val : piles) {
            pq.add(val);
            sum += val;
        }
        for (int i = 0; i < k; i++) {
            Integer ss = pq.poll();
            sum -= ss / 2;
            pq.add(ss - ss / 2);
        }
        return sum;
    }
}