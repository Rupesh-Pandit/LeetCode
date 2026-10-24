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
    public class data{
        int d;
        int h;
        data(int d, int h){
            this.d  = d;
            this.h =  h;
        }
    }

    public data Diameter(TreeNode root){
        if(root == null)
        return new data(0, 0);

        data Ldata = Diameter(root.left);
        data Rdata = Diameter(root.right);
        int high = Math.max(Ldata.h , Rdata.h)+1;
        int diam = Math.max(Math.max(Ldata.d, Rdata.d), Ldata.h+Rdata.h);

        return new data(diam, high);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        data diameter= Diameter(root);
        return diameter.d;
    }
}