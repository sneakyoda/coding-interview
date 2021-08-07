package leetcode;

import java.util.HashMap;
import java.util.Map;

class RomanToInteger {

	static Map<String, Integer> map = new HashMap<>() {{
        put("M", 1000);
        put("CM", 900);
        put("D", 500);
        put("CD", 400);
        put("C", 100);
        put("XC", 90);
        put("L", 50);
        put("XL", 40);
        put("X", 10);
        put("IX", 9);
        put("V", 5);
        put("IV", 4);
        put("I", 1);
    }};
    
    public int romanToInt(String s) {
        int res = 0, i = 0;
        while (i < s.length()) {
            if (i != s.length() - 1 && map.containsKey(s.substring(i, i + 2))) {
                res += map.get(s.substring(i, i + 2));
                i = i + 2;
                continue;
            }
            res += map.get(s.substring(i, i + 1));
            i++;
        }
        return res;
    }
}