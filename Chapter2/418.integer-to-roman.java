public class Solution {
    /*
     * @param n: The integer
     * @return: Roman representation
     */
    
    private String[] I, X, C, M;
    public Solution() {
        // https://en.wikipedia.org/wiki/Roman_numerals
        I = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        X = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        C = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "DM"};
        M = new String[]{"", "M", "MM", "MMM"};
    }
    
    
    public String intToRoman(int n) {
        if (n <= 0 || n > 4000) {
            return "";
        }
        
        // n = 1234
        // 4 = n % 10 = 1234 % 10 = 4
        // 3 = (n / 10) % 10 = 123 % 10 = 3
        // 2 = (n / 100) % 10 = 12 % 10 = 2
        // 1 = (n / 1000) = 1
        
        return M[n / 1000] + C[(n / 100) % 10] + X[(n / 10) % 10] + I[n % 10];
    }
}