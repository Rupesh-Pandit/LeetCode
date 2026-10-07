class Solution {
    public void rec( List<Integer> list, List<Integer> cal, List<List<Integer>> ans ){
        if(list.size() == 0){
         ans.add(new ArrayList<>(cal));
      return;
        } 

        for(int i=0; i< list.size(); i++){
            int num = list.get(i);

            cal.add(num);
            List<Integer> newList = new ArrayList<>(list);
            newList.remove(i);

           rec(newList, cal, ans);

           cal.remove(cal.size()-1);
          
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
      
        for(int a : nums)
        list.add(a);

        List<List<Integer>> ans = new ArrayList<>();

        rec(list, new ArrayList<>(), ans);

        return ans;
    }
}