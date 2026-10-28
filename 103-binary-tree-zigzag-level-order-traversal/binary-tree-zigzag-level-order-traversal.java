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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
            List<List<Integer>> list= new ArrayList<>();
            if(root ==null)return list;
        q.add(root);

        int flag =0;
        while(!q.isEmpty()){
            List<Integer> l= new ArrayList<>();
            int len = q.size();
            for(int i=0; i< len; i++){
                TreeNode curr =q.poll();
                l.add(curr.val);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);


            }
            if(flag == 0){
                list.add(l);
                flag=1;
            } else{
                Collections.reverse(l);
                list.add(l);
                flag=0;
            }
        }
        return list;
    }
}