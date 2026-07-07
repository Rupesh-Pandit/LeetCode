class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i< s.length(); i++){
            char ch= s.charAt(i);

            if(ch != ' '){
                sb.append(ch);
            } else{
                if(sb.length()>0)
                st.push(sb.toString());
                sb.setLength(0);
            }
           
        }

         if(sb.length()>0)
            st.push(sb.toString());
        sb = new StringBuilder();
        while(!st.isEmpty()){
          sb.append(st.pop());

          if(!st.isEmpty()){
            sb.append(" ");
          }
        }
        return sb.toString();
    }
}