class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    HashSet<List<Integer>> set = new HashSet<>();

    public void allSubset(int arr[], int i, List<Integer> list){
        if(i == arr.length) {
            if(!set.contains(list)){
            ans.add(new ArrayList<>(list));
            set.add(new ArrayList<>(list));
            }
            return;
        }

        // include
        list.add(arr[i]);
        allSubset(arr, i+1, list);
        list.remove(list.size()-1);
        allSubset(arr, i+1, list);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        allSubset(nums, 0, new ArrayList<>());
        return ans;
    }
}