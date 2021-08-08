package leetcode;

class MinimumNumberOfSwapsToMakeTheStringBalanced {
	public int minSwaps(String s) {
        int i = 0, j = s.length() - 1;
        int res = 0;
        int leftCount = 0;
        int rightCount = 0;
        while (i < j) {
            for (int k = i; k < j; k++) {
                i = k;
                if (s.charAt(k) == '[') {
                    leftCount++;
                } else {
                    if (leftCount == 0) {
                        leftCount--;
                        break;
                    } else {
                        leftCount--;
                    }
                }
            }
            for (int k = j; k > i; k--) {
                j = k;
                if (s.charAt(k) == ']') {
                    rightCount++;
                } else {
                    if (rightCount == 0) {
                        rightCount--;
                        break;
                    } else {
                        rightCount--;
                    }
                }
            }
           
            if (i == j - 1 && rightCount == leftCount && rightCount != -1) {
                break;
            } 
            if (i < j) {
                res++;
                i++;
                j--;
                leftCount = 1;
                rightCount = 1;    
            }
        }
        return res;
    }
}