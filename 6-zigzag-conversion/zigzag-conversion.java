class Solution {
    public String convert(String s, int numRows) {
        String []str = new String[numRows];
        for(int i=0;i< numRows; i++)
        str[i]="";
int n=0;
        while(n<s.length()){

            for(int i=0; i<numRows && n<s.length(); i++){
               str[i] += s.charAt(n++);
            }

            for(int i=numRows-2; i>0 && n< s.length(); i--)
            str[i] += s.charAt(n++);

        }

        String res="";
        for(String st:str)
        res += st;

        return res;
    }
}