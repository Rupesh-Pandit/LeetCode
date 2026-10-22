class Solution {
    public boolean valid(int nums[]){
        for(int i=1; i< nums.length; i++){
            if(Math.abs(nums[i]-nums[i-1]) !=1 && Math.abs(nums[i]-nums[i-1]) != nums.length-1) return false;
        }
        return true;
    }
    public int minOperations(int[] nums) {
        boolean isSorted = true;

        for(int i=1; i< nums.length; i++){
            if(nums[i] <nums[i-1]){
               isSorted = false;
               break;
            }
        }

        if(isSorted) return 0;

        if(!valid(nums)) return -1;

        int idx =0;
        for(int i=0; i< nums.length; i++){
            if(nums[i]== nums.length-1){
                idx = i;
                break;
            }
        }

        return Math.min(idx+1, nums.length-idx+1);
    }
}