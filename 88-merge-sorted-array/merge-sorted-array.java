class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
     List <Integer> list = new ArrayList<>();

     for(int i=0; i< m; i++)
     list.add(nums1[i]);

     for(int k: nums2){
        list.add(k);
     }
     for(int i =0; i< m+n; i++)
     nums1[i] = list.get(i);

     Arrays.sort(nums1);
    }
}