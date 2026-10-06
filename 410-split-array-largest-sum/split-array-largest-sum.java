class Solution {

    public boolean valid(int []nums, int k, int mid){
        int pages=1;
        int sum=0;

        for( int n: nums){
            if(sum + n <= mid){
                sum += n;
            } else{
                pages++;
                sum = n;
            }
        }
            return pages <= k;
    }
    public int splitArray(int[] nums, int k) {
        int st=Arrays.stream(nums).max().getAsInt(); 
        int end=Arrays.stream(nums).sum();
        int ans= end;

           while(st<=end){
            int mid = st+ (end-st)/2;

            if(valid(nums, k, mid)){
               ans = mid;
               end = mid-1;
            } else {
                st = mid+1;

            }
           } 
           return ans;
    }
}