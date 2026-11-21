class Solution {
    public class pair{
        int idx; 
        int freq;

        pair(int idx, int freq){
            this.idx = idx;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)-> a.freq - b.freq);
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
int c =0;
        for(int i: map.keySet()){
            if(c < k){
                pq.add(new pair(i, map.get(i)));
                c++;
            }
             else if(pq.peek().freq< map.get(i)){
                pq.poll();
                pq.add(new pair(i, map.get(i)));
             }
        }

        int arr[] = new int[k];
        int j=0;
        while(!pq.isEmpty()){
            arr[j] = pq.poll().idx;
            j++;
        }
        return arr;
    }
}