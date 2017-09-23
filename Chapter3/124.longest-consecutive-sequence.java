public class Solution {
    /*
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        if (num == null) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int v : num) {
            set.add(v);
        }
        
        int ans = 0;
        for (int v : num) {
            int l = 1;
            
            // search forward
            int next = v + 1;
            while (set.contains(next)) {
                set.remove(next++);
                l++;
            }
            
            // search backword
            int prev = v - 1;
            while (set.contains(prev)) {
                set.remove(prev--);
                l++;
            }
            
            ans = Math.max(ans, l);
        }
        return ans;
    }
}