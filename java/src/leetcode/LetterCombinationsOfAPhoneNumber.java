package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LetterCombinationsOfAPhoneNumber {

	StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<>();
    static Map<Character, char[]> map = new HashMap<>() {{
        put('2', new char[]{'a', 'b', 'c'});
        put('3', new char[]{'d', 'e', 'f'});
        put('4', new char[]{'g', 'h', 'i'});
        put('5', new char[]{'j', 'k', 'l'});
        put('6', new char[]{'m', 'n', 'o'});
        put('7', new char[]{'p', 'q', 'r', 's'});
        put('8', new char[]{'t', 'u', 'v'});
        put('9', new char[]{'w', 'x', 'y', 'z'});
    }};
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() > 0) {
            dfs(digits, 0);
        }
        return res;
    }
    
    void dfs(String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        for (char candidate : map.get(c)) {
            sb.append(candidate);
            dfs(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}