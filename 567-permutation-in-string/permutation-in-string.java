class Solution {
    public boolean isSame(int freq[], int win[]){
        for(int i=0; i< 26; i++){
            if(freq[i] != win[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int freq[]= new int  [26];
        int win[]= new int [26];
        
        for(int i=0; i< s1.length(); i++)
        freq[s1.charAt(i)-'a']++;

        for(int i=0; i< s2.length(); i++){
            int st=0;
            int end=s1.length();
            int window=i;
            win = new int[26];

            while(st<end && window<s2.length()){
                win[s2.charAt(window) - 'a']++;

                window++;
                st++;
            }
            if(isSame(freq, win)) return true;
        }
        return false;
    }
}