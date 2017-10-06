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
     * @return: new root
     */
     
    private TreeNode newRoot = null;
    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        dfs(root);
        return newRoot;
    }
    
    private void dfs(TreeNode root) {
        if (root.left == null) {
            newRoot = root;
            return ;
        }
        
        dfs(root.left);
        // flip
        TreeNode flippedRoot = root.left;
        flippedRoot.left = root.right;
        flippedRoot.right = root;
        // break the link
        root.left = null;
        root.right = null;
        
    }
}