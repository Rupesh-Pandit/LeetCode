class Solution {
    public void rec(int arr[], int idx, List<List<Integer>> ans) {
        if(idx == arr.length){
            List<Integer> list = new ArrayList<>();
            for(int a: arr){
                list.add(a);
            }
            ans.add(list);
            return;
        }

        for(int i=idx; i< arr.length; i++){
            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;

            rec(arr, idx+1, ans);

            int t = arr[idx];
            arr[idx] = arr[i];
            arr[i] = t;

        }
    }
       
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<>();

        rec(nums, 0,ans);
        return ans;
        }
}