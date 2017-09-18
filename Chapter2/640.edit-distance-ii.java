public class Solution {
    /*
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        // Assume s is the shorter one.
        if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }
        
        // One edit distance can be:
        // - add a char
        // - remove a char
        // - replace a char
        
        // not one edit distance 
        if (t.length() - s.length() > 1) {
            return false;
        }
        
        // same length, only one char can be replaced
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
            
        if (s.length() == t.length()) {
            int count = 0;
            for (int i = 0; i < sc.length; i++) {
                if (sc[i] != tc[i]) {
                    count++;
                }
            }
            return count == 1;
        }
        
        // different length. Either add a char, or remove a char.
        if (s.length() < t.length()) {
            // find the first idx that are different
            for (int i = 0; i < sc.length; i++) {
                if (sc[i] != tc[i]) {
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        return true;
        
        
    }
}