/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = Integer.MAX_VALUE;
    TreeNode prev = null;
    public void rec(TreeNode root){
        if(root == null) return;

        if(root.left != null){
          rec(root.left);
        }

        if(prev!=null){
            ans = Math.min(ans, root.val - prev.val);
        }

        prev = root;

        if(root.right != null){
        rec(root.right);
           
        }
    }
    public int minDiffInBST(TreeNode root) {
        rec(root);
        return ans;
    }
}