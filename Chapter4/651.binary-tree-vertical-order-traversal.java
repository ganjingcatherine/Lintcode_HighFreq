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
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
     
    Map<TreeNode, Integer> map = new HashMap<>();
    int minCol = Integer.MAX_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        // dfs generate the column index:
        //  go left -> index - 1, go right -> index + 1        
        dfs(root, 0);
        
        // bfs guarantee the top to bottom, and left to right order
        bfs(root, map, ans);

        return ans;
    }
    
    private void dfs(TreeNode root, int col) {
        if (root == null) {
            return ;
        }
        
        dfs(root.left, col - 1);
        dfs(root.right, col + 1);
        
        map.put(root, col);
        minCol = Math.min(minCol, col);
    }
    
    private void bfs(TreeNode root, Map<TreeNode, Integer> map, List<List<Integer>> ans) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode head = q.poll();
            
            if (head.left != null) {
                q.offer(head.left);
            }
            if (head.right != null) {
                q.offer(head.right);
            }
            
            int col = map.get(head) - minCol;
            while (ans.size() <= col) {
                ans.add(new ArrayList<>());
            }
            ans.get(col).add(head.val);
        }
    }
}