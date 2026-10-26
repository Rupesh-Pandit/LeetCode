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
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int level =0;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
      int l=0;
        while(!q.isEmpty()){
            int len = q.size();
            int sum =0;
            l++;
            for(int i=0; i< len; i++){
                TreeNode curr = q.poll();
                sum += curr.val;

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null)q.add(curr.right);
            }
            if(sum> max){
                max = sum;
                level = l;
            }
        }
        return  level;
    }
}