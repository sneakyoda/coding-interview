package leetcode;

class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (max.length() < right - left + 1) {
                    max = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (max.length() < right - left + 1) {
                    max = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return max;
    }
}