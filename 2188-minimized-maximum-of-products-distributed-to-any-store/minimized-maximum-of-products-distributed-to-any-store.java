class Solution {
    public boolean valid(int arr[], int n, int mid){
        int pages=0;

        for(int q:arr){
            pages += ((q+mid-1)/mid);
        }
        return pages <= n;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int max = quantities[0];
        int ans =-1;

        for(int i=0; i<quantities.length; i++)
        max= Math.max(max, quantities[i]);

        int l=1, r=max;

        while(l<=r){
            int mid = (l+r)/2;

            if(valid(quantities, n, mid)){
                ans = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return ans;
    }
}