class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[2] - b[2]);
        HashSet<String> set =new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        pq.add(new int[]{0,0, nums1[0]+nums2[0]});
        set.add("0,0");

        while(!pq.isEmpty() && k-->0){
           int min[]= pq.poll();

           int i=min[0];
           int j= min[1];

          ans.add(Arrays.asList(nums1[i], nums2[j]));

          if(i+1<nums1.length && !set.contains((i+1) +","+ j)){
            pq.add(new int[]{i+1, j, nums1[i+1]+ nums2[j]});
            set.add((i+1)+","+ j);
          }

          if(j+1<nums2.length && !set.contains(i+","+ (j+1))){
            pq.add(new int[]{i, j+1, nums1[i]+nums2[j+1]});
            set.add(i+"," +(j+1));
          }
        }

      return ans;
    }
}