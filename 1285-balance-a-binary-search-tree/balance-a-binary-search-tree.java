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
    List<Integer> list = new ArrayList<>();
    int idx =0;

    public void inorder(TreeNode root){
        if(root == null) return ;

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public TreeNode balance(int min, int max){
        if(min > max){
            return null;
        }
        int mid = (min+max)/2;
        TreeNode r = new TreeNode(list.get(mid));
        idx++;
        r.left = balance(min, mid-1);
        r.right = balance(mid+1, max);

        return r;

    }
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        TreeNode r = balance(0, list.size()-1);
        return r;
    }
}