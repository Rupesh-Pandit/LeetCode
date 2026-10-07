class Solution {
    List<List<String>>  ans ;
public boolean isPalin(String str){
    int l=0, r=str.length()-1;

    while(l<=r){
        if(str.charAt(l) != str.charAt(r)){
            return false;
        } else {
            l++;
            r--;
        }
    }
        return true;
}

    public void getAllPartition(String s, List<String> list){
        if(s.length()==0){
            ans.add(new ArrayList<>(list));
            return ;
        }

        for(int i=0; i< s.length(); i++){
            String str = s.substring(0, i+1);
            if(isPalin(str)){
                list.add(str);
                getAllPartition(s.substring(i+1), list);
                list.remove(list.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
       ans = new ArrayList<>();
       getAllPartition(s, new ArrayList<>());
       return ans;
    }
}