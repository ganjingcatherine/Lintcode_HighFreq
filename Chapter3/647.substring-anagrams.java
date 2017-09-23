// O(n)
public class Solution {
    /*
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return ans;
        }
        
        if (s.length() < p.length()) {
            return ans;
        }
        
        // The difference map between current substring in s and p. 
        // s - p
        int[] diff = new int[256];
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        
        // Initial map
        for (int i = 0; i < p.length(); i++) {
            diff[pc[i]]--;
            diff[sc[i]]++;
        }
        
        // Current difference sum
        int sum = 0;
        for (int v : diff) {
            sum += Math.abs(v);
        }
        
        if (sum == 0) {
            ans.add(0);
        }
        
        // Iterate through the rest of the array
        for (int i = p.length(); i < s.length(); i++) {
            int l = sc[i - p.length()];
            int r = sc[i];
            
            sum = sum - Math.abs(diff[l]) - Math.abs(diff[r]);
            
            diff[l]--;
            diff[r]++;
            
            sum = sum + Math.abs(diff[l]) + Math.abs(diff[r]);
            
            if (sum == 0) {
                ans.add(i - p.length() + 1);
            }
        }
        
        return ans;
    }
}

// O(256*n)
public class Solution {
    /*
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return ans;
        }
        
        if (s.length() < p.length()) {
            return ans;
        }
        
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        
        int[] sMap = new int[256];
        int[] pMap = new int[256];
        
        // Initial map
        for (int i = 0; i < p.length(); i++) {
            sMap[sc[i]]++;
            pMap[pc[i]]++;
        }
        if (compare(sMap, pMap)) {
            ans.add(0);
        }
        
        // Sliding window
        for (int i = p.length(); i < s.length(); i++) {
            // remove left
            sMap[sc[i - p.length()]]--;
            // add right
            sMap[sc[i]]++;
            // compare sMap with pMap
            if (compare(sMap, pMap)) {
                ans.add(i - p.length() + 1);
            }
        }
        
        return ans;
    }
    
    private boolean compare(int[] sMap, int[] pMap) {
        for (int i = 0; i < 256; i++) {
            if (sMap[i] != pMap[i]) {
                return false;
            }
        }
        return true;
    }
}