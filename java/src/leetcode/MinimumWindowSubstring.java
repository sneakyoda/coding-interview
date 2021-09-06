package leetcode;

import java.util.HashMap;
import java.util.Map;

class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : t.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        String res = "";
        int begin = -1, end = 0;
        Map<Character, Integer> tmp = new HashMap<>();
        while (end < s.length()) {
            while (end < s.length() && !equal(counter, tmp)) {
                char c = s.charAt(end);
                tmp.put(c, tmp.getOrDefault(c, 0) + 1);
                end++;
            }
            while (equal(counter, tmp)) {
                if (res.equals("") || end - begin - 1 < res.length()) {
                    res = s.substring(begin + 1, end);
                }
                char c = s.charAt(begin + 1);
                tmp.put(c, tmp.getOrDefault(c, 0) - 1);
                begin++;
            }
        }
        return res;
    }
    
    boolean equal(Map<Character, Integer> counter, Map<Character, Integer> tmp) {
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            if (tmp.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}