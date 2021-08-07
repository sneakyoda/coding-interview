package leetcode;

class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int curIndex = 0;
        while (true) {
            boolean ret = false;
            for (int i = 1; i < strs.length; i++) {
                if (curIndex >= strs[i].length() || curIndex >= strs[i - 1].length()) {
                    ret = true;
                    break;
                }
                if (strs[i].charAt(curIndex) != strs[i - 1].charAt(curIndex)) {
                    ret = true;
                    break;
                }
            }
            if (ret) {
                break;
            } else {
                sb.append(strs[0].charAt(curIndex));
            }
            curIndex++;
        }
        return sb.toString();
    }

}