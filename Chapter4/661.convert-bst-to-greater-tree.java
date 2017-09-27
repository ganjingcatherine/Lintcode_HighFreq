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
     * @return: the new root
     */
     
    private int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        bfs(root);
        
        return root;
    }
    
    private void bfs(TreeNode root) {
        if (root == null) {
            return ;
        }
        
        // search right
        bfs(root.right);
        
        // update node
        sum += root.val;
        root.val = sum;
        
        // search left
        bfs(root.left);
    }
}