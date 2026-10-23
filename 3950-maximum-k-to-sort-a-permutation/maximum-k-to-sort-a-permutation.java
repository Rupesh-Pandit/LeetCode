class Solution {
    public int sortPermutation(int[] nums) {
        boolean isSorted = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                isSorted = false;
        }
        if (isSorted)
            return 0;
           int ans =-1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
         
            if (nums[i] != i){
                int cal = nums[i] & i;

                if(ans ==-1)
                ans = cal;
                else ans = ans & cal;

            }
        }

       
        return ans;
    }
}