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
    int preIdx =0;
    public int search(int inorder[], int left, int right, int node){
        for(int i=left; i<= right; i++){
            if(inorder[i]== node)  return i;
        }
       return -1;
    }

    public TreeNode Tree(int[] preorder, int[] inorder,int left, int right){
        if(left > right) return null;
        TreeNode root = new TreeNode(preorder[preIdx++]);

        int inIdx = search(inorder, left, right, root.val);
        root.left= Tree(preorder, inorder,  left, inIdx-1);
        root.right = Tree(preorder, inorder, inIdx + 1, right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
       TreeNode  node=  Tree(preorder, inorder, 0, inorder.length-1);
return node;


   }
}