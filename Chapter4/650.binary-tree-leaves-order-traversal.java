/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
     
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans);

        return ans;
    }
    
    private int dfs(TreeNode root, List<List<Integer>> ans) {
        if (root == null) {
            return 0;
        }
        
        int left = dfs(root.left, ans);
        int right = dfs(root.right, ans);
        int level = Math.max(left, right) + 1;
        
        // keep track of results
        if (ans.size() < level) {
            ans.add(new ArrayList<>());
        }
        ans.get(level - 1).add(root.val);

        return level;
    }
}