class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
       int index=0;

       for(int i=0; i<n; i++){
        int count =0;
        char ch = chars[i];

        while(i<n && ch == chars[i]){
            count++;
            i++;
        }

        if(count ==1){
            chars[index++]= ch;
        } else {
            String str = Integer.toString(count);
            chars[index++] = ch;
            for(char c : str.toCharArray()){
              chars[index++]= c;
            }
        }
        i--;
       }
       return index;
    }
}