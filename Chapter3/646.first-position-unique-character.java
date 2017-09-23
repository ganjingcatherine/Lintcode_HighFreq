public class Solution {
    /*
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        int[] hash = new int[256];  // Assuming ASCII chars only
        
        // Count
        char[] sc = s.toCharArray();
        for (char c : sc) {
            hash[(int) c]++;
        }
        
        // Search for the answer
        int i = 0;
        for (char c : sc) {
            if (hash[(int) c] == 1) {
                return i;
            }
            i++;
        }
        
        return -1;
    }
}