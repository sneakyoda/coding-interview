package leetcode;

class ZigZagConversion {

	public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int roundCount = numRows * 2 - 2;
        for (int i = 0; i < numRows; i++) {
            int firstOffset = i;
            int secondOffset = roundCount - i;
            int curIndex = 0;
            while (curIndex < s.length()) {
                if (curIndex + firstOffset >= s.length()) {
                    break;
                }
                sb.append(s.charAt(curIndex + firstOffset));
                if (firstOffset != 0 && firstOffset != secondOffset) {
                    if (curIndex + secondOffset >= s.length()) {
                        break;
                    }
                    sb.append(s.charAt(curIndex + secondOffset));
                }
                curIndex += roundCount;
            }
        }
        return sb.toString();
    }

}