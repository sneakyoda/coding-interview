package leetcode;

class IntegerToRoman {
	static Symbol[] symbols = new Symbol[]{
        new Symbol("M", 1000),
        new Symbol("CM", 900),
        new Symbol("D", 500),
        new Symbol("CD", 400),
        new Symbol("C", 100),
        new Symbol("XC", 90),
        new Symbol("L", 50),
        new Symbol("XL", 40),
        new Symbol("X", 10),
        new Symbol("IX", 9),
        new Symbol("V", 5),
        new Symbol("IV", 4),
        new Symbol("I", 1)
    };
    
    public String intToRoman(int num) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if (symbols[i].val > num) {
                i++;
                continue;
            }
            sb.append(symbols[i].symbol);
            num -= symbols[i].val;
        }
        return sb.toString();
    }
    
    static class Symbol {
        String symbol;
        int val;
        
        Symbol(String symbol, int val) {
            this.symbol = symbol;
            this.val = val;
        }
    }
}