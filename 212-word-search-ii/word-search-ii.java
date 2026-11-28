class Solution {
    public List<String> ans = new ArrayList<>();
    public class Node{
        Node children[] = new Node[26];
        String word;

        public Node(){
            for(int i=0; i<26; i++)
               children[i] = null;

            word = null;   
        }
    }
    Node root = new Node();

    public void insert(String str){
        Node curr = root;
        for(int i=0; i<str.length(); i++){
            int idx = str.charAt(i) -'a';
            if(curr.children[idx] == null)
               curr.children[idx] = new Node();

               curr = curr.children[idx];
        }
        curr.word = str;
    }

    public void dfs(int i, int j, char [][]board, Node curr){
        char ch = board[i][j];
        if(ch == '#') return;

        int idx = ch -'a';
        if(curr.children[idx] == null) return;
        curr = curr.children[idx];

        if(curr.word != null) {
            ans.add(curr.word);
            curr.word = null;
        }
        board[i][j] = '#';

        if(i-1>=0) dfs(i-1, j, board, curr);
        if(i+1<board.length) dfs(i+1, j, board, curr);
        if(j-1 >=0) dfs(i, j-1, board, curr);
        if(j+1<board[0].length) dfs(i, j+1, board, curr);

        board[i][j] = ch;
    }
    public List<String> findWords(char[][] board, String[] words) {
        for(int i=0; i<words.length; i++)
        insert(words[i]);

        for(int i=0;i <board.length; i++){
            for(int j =0; j<board[0].length; j++){
                int idx = board[i][j] -'a';

                if(root.children[idx] != null){
                    dfs(i, j, board, root);
                }
            }
        }
        return ans;
    }
}