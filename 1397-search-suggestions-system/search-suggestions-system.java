class Solution {
    List<String> list;
    List<List<String>> ans= new ArrayList<>();

    public class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node(){
            for(int i=0; i<26; i++)
            children[i] = null;
        }

    }
    Node root = new Node();

    public void insert(String word){
        Node curr = root;

        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) -'a';
            if(curr.children[idx] == null)
            curr.children[idx ] = new Node();

            curr = curr.children[idx];
        }
        curr.eow =  true;
    }
    public void abc(String word){
        Node curr =root;
         StringBuilder sb = new StringBuilder();

        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
               char ch = word.charAt(i);
            if(curr.children[idx] == null){
                ans.add(new ArrayList<>());
                return;
            }
                sb.append(ch);
                curr = curr.children[idx];
        }
        list = new ArrayList<>();
        cde(sb, curr);
        ans.add(list);
    }

    public void cde(StringBuilder sb, Node curr){
        if(list.size() == 3){
         return ;
        }

        if(curr.eow)  list.add(sb.toString());

        for(int i=0; i<26 &&list.size()<3; i++){
            if(curr.children[i] != null){
                char ch = (char) (i +'a');
                sb.append(ch);
                cde(sb, curr.children[i]);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for(int i=0; i<products.length; i++)
        insert(products[i]);

        for(int i=1; i<=searchWord.length(); i++){
            abc(searchWord.substring(0,i ));
        }
        return ans;
    }
}