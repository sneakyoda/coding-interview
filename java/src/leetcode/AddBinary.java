package leetcode;

class AddBinary {
	public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int adder = 0;
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int aunit = i < a.length() ? (a.charAt(a.length() - 1 - i) == '1' ? 1 : 0) : 0;
            int bunit = i < b.length() ? (b.charAt(b.length() - 1 - i) == '1' ? 1 : 0) : 0;
            aunit += bunit + adder;
            if (aunit > 1) {
                aunit -= 2;
                adder = 1;
            } else {
                adder = 0;
            }
            sb.insert(0, aunit);
        }
        if (adder == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}