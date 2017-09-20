public class Solution {
    /*
     * @param input: an abstract file system
     * @return: return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        
        String[] lines = input.split("\n");
        int[] levels = new int[input.length() + 1];
        
        int ans = 0;
        for (String line : lines) {
            int level = line.lastIndexOf('\t') + 2; // offset level by 2
            // int len = line.length() - ( line.lastIndexof("\t") + 1);
            int len = line.length() - (level - 1);
            
            if (line.contains(".")) { // this is a file
                ans = Math.max(ans, levels[level - 1] + len);
            } else {
                levels[level] = levels[level - 1] + len + 1;
            }
        }
        return ans;
    }
}