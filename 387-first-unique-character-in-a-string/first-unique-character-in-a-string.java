class Solution {
  Set<Character> set = new HashSet<>();
    public int firstUniqChar(String s) {
        Stack<Character> st = new Stack<>();
        int i=0;
        while(i< s.length()){
          
            if(set.contains(s.charAt(i))){
            
                Stack<Character> temp = new Stack<>();
                while(!st.isEmpty()){
                    char el = st.pop();
                    if(el != s.charAt(i)){
                       temp.push(el);
                    } else {
                        break;
                    }
                    
                }

                while(!temp.isEmpty()){
                    st.push(temp.pop());
                }
            } else {
                st.push(s.charAt(i));
                set.add(s.charAt(i));
            }
            i++;
        }
       
       HashSet<Character> survivor = new HashSet<>();

       while(!st.isEmpty()) survivor.add(st.pop());

        for( i=0; i<s.length(); i++ ){
           if(survivor.contains(s.charAt(i))) return i;
        }
      

       return -1;
    }
}