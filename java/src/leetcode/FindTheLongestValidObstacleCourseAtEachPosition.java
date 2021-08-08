package leetcode;

import java.util.TreeMap;

class FindTheLongestValidObstacleCourseAtEachPosition {
	public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[obstacles.length];
        map.put(Integer.MIN_VALUE, 0);
        for (int i = 0; i < obstacles.length; i++) {
            int val = obstacles[i];
            int key = map.floorKey(val);
            res[i] = map.get(key) + 1;
            map.put(val, res[i]);
            while (true) {
                Integer kk = map.ceilingKey(val + 1);
                if (kk == null || map.get(kk) >= res[i]) {
                    break;
                }
                map.remove(kk);
            }
        }
        return res;
    }
}
