public class Solution {
    /*
     * @param s: Roman representation
     * @return: an integer
     */
     
    private Map<Character, Integer> dict; 
    public Solution() {
        // https://en.wikipedia.org/wiki/Roman_numerals
        dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
    }
    
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        char[] sc = s.toCharArray();
        
        int prev = 0;
        int ans = 0;
        for (char c : sc) {
            int cur = dict.get(c);
            ans += cur;
            if (prev < cur) {
                ans -= 2*prev;
            }
            prev = cur;
        }
        return ans;
    }
}