class Solution {
    public boolean isPalindrome(String s) {
   s=s.toLowerCase();
   StringBuilder sb = new StringBuilder();

   for(int i=0; i< s.length(); i++){
      char ch = s.charAt(i);

      if(ch>='a' && ch<='z' || ch>='0' && ch<='9'){
        sb.append(ch);
        }
      }

      int left =0;
      int right = sb.length()-1;
      while(left<right){
        if(sb.charAt(left) != sb.charAt(right)){
            return false;
        } else {
            left++;
            right--;
        }
      }
      return true;
    }
}