class Solution {
    public boolean isValid(String s) {
      if(s.length()%2  != 0) return false;
       
       Stack<Character>st = new Stack<>();
       int i=0;
      while(i<s.length()){
      int c =0;
      if(!st.isEmpty()&& s.charAt(i) == ')' && st.peek() == '('){
         st.pop();
         c++;
      } 

      if(!st.isEmpty()&& s.charAt(i) == ']' && st.peek() == '['){
         st.pop();
         c++;
      } 
 
      if(!st.isEmpty()&& s.charAt(i) == '}' && st.peek() == '{') {
         st.pop();
         c++;
      } 
        
        if(c ==0){
            st.push(s.charAt(i));

        } else {
            c=0;
        }

        i++;
      }
         return st.isEmpty();
    }
}