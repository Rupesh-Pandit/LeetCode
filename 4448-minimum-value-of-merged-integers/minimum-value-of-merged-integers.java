class Solution {
    public int minMergedInteger(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0; i+1< nums.length;i= i+2){
            String s = Integer.toString(nums[i])+Integer.toString(nums[i+1]);
            int v = Integer.parseInt(s);
            min = Math.min(v, min);
        }

        return min;
    }
}