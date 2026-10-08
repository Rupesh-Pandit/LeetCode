class Solution {
    HashSet<List<Integer>> set = new HashSet<>();
    public void sumCom(int arr[], int i, List<Integer> list, List<List<Integer>> ans, int tar){
        if(i == arr.length || tar <0) return ;
        if(tar == 0){
            if(!set.contains(list)){
            set.add(list);
            ans.add(new ArrayList<>(list));
            return;
            }
        }
        

           list.add(arr[i]);
        sumCom(arr, i+1, list, ans, tar-arr[i]);
        sumCom(arr, i, list, ans, tar-arr[i]);
        list.remove(list.size()-1);
        sumCom(arr, i+1, list, ans, tar);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      

        List<List<Integer>> ans = new ArrayList<>();

          sumCom(candidates, 0, new ArrayList<>(), ans, target);
        return ans;
    }
}