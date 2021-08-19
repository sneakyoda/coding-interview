package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<Key, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Key key = new Key(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    class Key {
        int[] counter;

        Key(String s) {
            this.counter = new int[26];
            for (char c : s.toCharArray()) {
                this.counter[c - 'a']++;
            }
        }

        @Override
        public int hashCode() {
            int hash = 0;
            for (int i = 0; i < counter.length; i++) {
                hash += counter[i] * (i + 1);
            }
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            Key key = (Key) o;
            for (int i = 0; i < 26; i++) {
                if (key.counter[i] != counter[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}