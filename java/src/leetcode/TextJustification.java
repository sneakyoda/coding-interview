package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        List<String> candidates = new ArrayList<>();
        int totalLen = 0;
        while (i < words.length) {
            if (totalLen + (candidates.size() == 0 ? 0 : 1) + words[i].length() > maxWidth) {
                res.add(format(candidates, totalLen, maxWidth, false));
                totalLen = 0;
                candidates = new ArrayList<>();
            }
            totalLen += (candidates.size() == 0 ? 0 : 1) + words[i].length();
            candidates.add(words[i]);
            i++;
        }
        if (candidates.size() != 0) {
            res.add(format(candidates, totalLen, maxWidth, true));
        }
        return res;
    }
    
    String format(List<String> candidates, int totalLen, int maxWidth, boolean lastLine) {
        StringBuilder sb = new StringBuilder();
        int spaces = maxWidth - candidates.stream().map(e -> e.length()).reduce((a, b) -> a + b).get();
        if (candidates.size() == 1) {
            sb.append(candidates.get(0));
            sb.append(spaces(spaces));
        } else if (lastLine) {
            sb.append(candidates.stream().collect(Collectors.joining(" ")));
            sb.append(spaces(spaces - candidates.size() + 1));
        } else {
            while (candidates.size() != 0) {
                sb.insert(0, candidates.get(candidates.size() - 1));
                candidates.remove(candidates.size() - 1);
                if (spaces != 0) {
                    sb.insert(0, spaces(spaces / candidates.size()));
                    spaces -= spaces / candidates.size();
                }
            }
        }
        return sb.toString();
    }
    
    String spaces(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}