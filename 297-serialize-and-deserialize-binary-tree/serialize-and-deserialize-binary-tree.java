/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.

    public void ser(TreeNode root, StringBuilder sb){
     if(root == null) {
        sb.append("n,");
        return;
     }
     
        sb.append(root.val).append(",");
        ser(root.left, sb);
        ser(root.right, sb);

         }
    public String serialize(TreeNode root) {
       StringBuilder sb = new StringBuilder();
        ser(root, sb);
       return sb.toString();
    }
   public TreeNode der(String st[] , int idx[]){
    if(idx[0] <st.length && st[idx[0]].equals("n") ){
        idx[0]++;
        return null;
    }

    TreeNode root =  new TreeNode(Integer.parseInt(st[idx[0]]));
    idx[0]++;
    root.left = der(st, idx);
    root.right = der(st, idx);

    return root;
   }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      String st[] = data.split(",");
       int[]idx = {0};
      return der(st, idx);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));