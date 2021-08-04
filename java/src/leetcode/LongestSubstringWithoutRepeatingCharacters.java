package leetcode;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int res = 0;
        while (j < s.length()) {
            char jc = s.charAt(j);
            if (map.getOrDefault(jc, -1) >= i) {
                i = map.getOrDefault(jc, -1) + 1;
            } else {
                res = Math.max(res, j - i + 1);
            }
            map.put(jc, j);
            j++;
        }
        return res;
    }
}