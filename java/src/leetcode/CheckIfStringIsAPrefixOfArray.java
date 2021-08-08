package leetcode;

class CheckIfStringIsAPrefixOfArray {
	public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            if (s.equals(sb.toString())) {
                return true;
            }
            if (s.length() <= sb.toString().length()) {
                return false;
            }
        }
        return false;
    }
}