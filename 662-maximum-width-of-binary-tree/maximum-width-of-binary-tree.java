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
    public class Pair{
        TreeNode node;
        long idx;
        Pair(TreeNode node, long idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));
        long width=0;
        while(!q.isEmpty()){
          long last =0;
          long first=0;
            int len = q.size();
             
            for(int j =0;j<len; j++){

               Pair pair = q.poll();
               TreeNode curr = pair.node;
               long i= pair.idx;
               if(j==0)first=i;
               if(j==len-1)last=i;
            
               if(curr.left != null ){
                q.add(new Pair(curr.left, 2*i+1));
               } 

               if(curr.right != null){
                q.add(new Pair(curr.right, 2*i+2));
               }
               
            }
            width= Math.max(width, last-first+1);
        }
        return (int)width;
    }
}