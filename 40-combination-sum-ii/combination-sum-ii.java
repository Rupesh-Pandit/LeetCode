class Solution {
   public void recCom(int arr[], int i, List<Integer> list, List<List<Integer>>ans, int tar){

    if(tar == 0){
            ans.add(new ArrayList<>(list));
            return;
        
    }
       

        for(int j = i; j< arr.length; j++){
            if(j>i && arr[j] == arr[j-1]) continue;

            if(arr[j] > tar) break;

             
        list.add(arr[j]);
        // one time include
        recCom(arr, j+1, list, ans, tar-arr[j]);

        list.remove(list.size()-1);

   
        }
        
   }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();

        recCom(candidates, 0, new ArrayList<>(), ans, target);
        return ans;
    }
}