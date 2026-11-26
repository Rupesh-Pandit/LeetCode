class Solution {
    HashMap<String, Boolean> memo = new HashMap<>();
    public class Node {
        Node children[] = new Node[26];
        boolean eow = false;

      public  Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public boolean search(String key) {
        Node curr = root;

        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (curr.children[idx] == null)
                return false;
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }
    
    public boolean Break(String key){
        if(key.length() == 0) return true;
        if(memo.containsKey(key)) return memo.get(key);
        for(int i=1; i<= key.length(); i++){
            if(search(key.substring(0, i)) && Break(key.substring(i))){
            memo.put(key, true);
            return true;
            }
        }
        memo.put(key, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {
            insert(wordDict.get(i));
        }

        return Break(s);
    }
}