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
    int s=0;
    public void sum(TreeNode root){
        if(root == null){
            return ;
        }
        
        sum(root.right);
        s+= root.val;
        root.val = s;

        sum(root.left);


    }

    public TreeNode bstToGst(TreeNode root) {
        sum(root);
        return root;
    }
}