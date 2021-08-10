package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<String, Integer> indexedMap = new HashMap<>();
        int size = words[0].length();
        int index = 0;
        for (int i = 0; i < words.length; i++) {
            if (!indexedMap.containsKey(words[i])) {
                indexedMap.put(words[i], index++);
            }
            int theIndex = indexedMap.get(words[i]);
            countMap.put(theIndex, countMap.getOrDefault(theIndex, 0) + 1);
        }
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i + size > s.length()) {
                arr[i] = -1;
                continue;
            }
            arr[i] = indexedMap.getOrDefault(s.substring(i, i + size), -1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int begin = i, end = i, cur = i;
            Map<Integer, Integer> mmap = new HashMap<>();
            while (cur < s.length()) {
                if (arr[cur] == -1) {
                    mmap.clear();
                    begin = cur + size;
                    end = cur + size;
                    cur += size;
                    continue;
                }
                if (mmap.getOrDefault(arr[cur], 0) < countMap.get(arr[cur])) {
                    end = cur + size;
                } else {
                    while (mmap.getOrDefault(arr[cur], 0) == countMap.get(arr[cur])) {
                        mmap.put(arr[begin], mmap.getOrDefault(arr[begin], 0) - 1);
                        begin += size;
                    }
                    end = cur + size;
                }
                mmap.put(arr[cur], mmap.getOrDefault(arr[cur], 0) + 1);
                if (end - begin == words.length * size) {
                    res.add(begin);
                }
                cur += size;
            }
        }
        return res;
    }
}