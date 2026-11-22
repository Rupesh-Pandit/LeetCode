class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int []> pq = new PriorityQueue<>(
            (a, b)-> Integer.compare(a[0], b[0])
            );

        int k = nums.size();
        int []R  = {0, Integer.MAX_VALUE};  
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i< k; i++){
            int value = nums.get(i).get(0);

            pq.add(new int[]{value, i, 0});
            min = Math.min(min,value );
            max = Math.max(max, value);
        }  

        while(true){
            if(max - min < R[1] - R[0]){
                R[1] = max;
                R[0] = min;
            }

            int [] currVal = pq.poll();

            if(currVal[2] == nums.get(currVal[1]).size()-1)
            break;

            pq.add(new int[]{nums.get(currVal[1]).get(currVal[2]+1), currVal[1], currVal[2]+1});
            max = Math.max(max, nums.get(currVal[1]).get(currVal[2]+1));
            min =  pq.peek()[0];
        }
        return R;
    }
}