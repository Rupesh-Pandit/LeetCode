class Solution {
    public int[] nextGreaterElements(int[] nums) {
       int []temp = new int[nums.length];
        if( nums.length==1) {
            temp[0]=-1;
            return temp;
        }

       for(int i=nums.length -1; i>=0; i--){
        int idx = i;
        int font = (i+1) %nums.length;

        while(font != idx){
            if(nums[idx] < nums[font]){
                temp[idx] = nums[font];
                break;
            } else {
                font = (font+1)%nums.length;
                temp[idx] = -1;
            }

        }

       }
        return temp;
    }
}