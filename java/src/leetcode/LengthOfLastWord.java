package leetcode;

class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        int count = 0;
        boolean openForNewWord = true;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                openForNewWord = true;
            } else {
                if (openForNewWord) {
                    count = 0;
                }
                count++;
                openForNewWord = false;
            }
        }
        return count;
    }
}