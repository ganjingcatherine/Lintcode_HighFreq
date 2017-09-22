public class Solution {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        
        if (nums.length == 0) {
            addRange(ans, lower, upper);
            return ans;
        }
        
        addRange(ans, lower, (long) nums[0] - 1);
        for (int i = 1; i < nums.length; i++) {
            addRange(ans, (long) nums[i - 1] + 1, (long) nums[i] - 1);
        }
        addRange(ans, (long) nums[nums.length - 1] + 1, upper);
        
        return ans;
    }
    
    private void addRange(List<String> ans, long lower, long upper) {
        if (lower > upper) {
            return;
        }
        if (lower == upper) {
            ans.add(String.valueOf(lower));
            return;
        }
        ans.add(lower + "->" + upper);
    }
}