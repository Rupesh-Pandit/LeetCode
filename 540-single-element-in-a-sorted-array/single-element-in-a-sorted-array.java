class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0, r=nums.length-1;
        if(nums.length ==1) return nums[0];

        while(l<=r){
            int mid =l+(r-l)/2;
           if(mid==0 && nums[mid]!= nums[mid+1]) return nums[mid];
            if(mid== nums.length-1 && nums[mid] != nums[nums.length-2]) return nums[mid];
             if(mid-1>=0 && mid+1 <=nums.length-1 && nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid]) return nums[mid];

            if(mid%2 ==0){
              if(mid-1>=0 && nums[mid-1]== nums[mid]){
                r=mid-1;
              } else {
                l=mid+1;
              }
            } else {
                if(mid >=0 && nums[mid-1] == nums[mid]){
                    l=mid+1;
                } else if(mid+1 <= nums.length-1 && nums[mid]== nums[mid+1]){
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}