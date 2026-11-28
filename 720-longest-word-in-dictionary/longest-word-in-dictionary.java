class Solution {
    StringBuilder ans = new StringBuilder();

    public class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++)
                children[i] = null;
        }
    }

    Node root = new Node();

    public void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null)
                curr.children[idx] = new Node();

            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public void rec(String word, StringBuilder sb) {

        Node curr = root;
        for (int i=0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) return;
            curr = curr.children[idx];
            
            if(curr.eow== false) return;

        }
        sb.append(word);
    }

    public String longestWord(String[] words) {
        for (int i = 0; i < words.length; i++)
            insert(words[i]);
        StringBuilder sb;

        for (int i = 0; i < words.length; i++) {
            sb = new StringBuilder();
            rec(words[i], sb);
            if (sb.length() > ans.length()) {
                ans = new StringBuilder(sb);
                
            } else if(sb.length() == ans.length() && 
                      (sb.toString().compareTo(ans.toString()) <0))
                      ans = new StringBuilder(sb);
        }
        return ans.toString();
    }
}