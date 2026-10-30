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
    int sum =0;
    public void sumN(TreeNode root, int s){
        if(root == null) return;
        if( root.left== null && root.right == null){
              s = s*10+root.val;
              sum+= s;
              return ;
        }

        s =s*10+ root.val;
        sumN(root.left, s);
        sumN(root.right, s);
        s= s/10;
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return sum;
        sumN(root, 0);
        return sum;

    }
}