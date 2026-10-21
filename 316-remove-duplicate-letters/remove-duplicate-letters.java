class Solution {
    public String removeDuplicateLetters(String s) {
       HashMap<Character, Integer> map = new HashMap<>();
       HashSet<Character> set = new HashSet<>();
       StringBuilder sb = new StringBuilder();
       Stack<Character>st = new Stack<>();
       int n = s.length();

       for(int i=0; i< n; i++){
        map.put(s.charAt(i), i);
       }

       for(int i=0;i< n; i++){
        char ch = s.charAt(i);

        if(set.contains(ch)) continue;

        while(!st.isEmpty() && st.peek() > ch && map.get(st.peek()) > i){
            set.remove(st.pop());
        }

        st.push(ch);
        set.add(ch);
       }
      while(!st.isEmpty()){
        sb.append(st.pop());
      }

      return sb.reverse().toString();
    }
}