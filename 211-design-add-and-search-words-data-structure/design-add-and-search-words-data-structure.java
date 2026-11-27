class WordDictionary {
    public class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++)
                children[i] = null;
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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

    public boolean Search(Node node, String word, int index) {
        if ((index == word.length() - 1) && (word.charAt(index) == '.') ){           
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null && node.children[i].eow)
                        return true;
                }
                return false;           
        }

        if (index == word.length() - 1 && node.children[word.charAt(index) - 'a'] != null) {
            if (node.children[word.charAt(index) - 'a'].eow)
                return true;

                return false;
        }

        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && Search(node.children[i], word, index + 1))
                    return true;
            }
            return false;
        }

        if (node.children[word.charAt(index) - 'a'] != null)
            return Search(node.children[word.charAt(index) - 'a'], word, index + 1);

        return false;

    }

    public boolean search(String word) {
         return Search(root, word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */