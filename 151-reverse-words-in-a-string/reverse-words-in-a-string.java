class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder stb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);

            if(ch != ' '){
                 sb.append(ch);
            } else {
                if(sb.length()>0){
                    sb.reverse();
                    stb.append(sb).append(" ");
                    
                    sb.setLength(0);
                }
            }
        }
        if(sb.length()>0){
            sb.reverse();
         stb.append(sb);
        }
        return stb.toString().trim();
    }
}