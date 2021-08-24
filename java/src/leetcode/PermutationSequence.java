package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class PermutationSequence {
	public String getPermutation(int n, int k) {
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            candidates.add(i);
        }
        return generate(candidates, k);
    }
    
    String generate(List<Integer> candidates, int k) {
        if (k == 1) {
            return candidates.stream().map(e -> e.toString()).collect(Collectors.joining());
        }
        int size = candidates.size();
        int lowerDigitCombinition = fact(size - 1);
        int thisDigit = (k - 1) / lowerDigitCombinition;
        String res = candidates.get(thisDigit).toString();
        candidates.remove(thisDigit);
        return res + generate(candidates, k - lowerDigitCombinition * thisDigit);
    }
    
    int fact(int n) {
        if (n <= 1) {
            return n;
        }
        return n * fact(n - 1);
    }
}