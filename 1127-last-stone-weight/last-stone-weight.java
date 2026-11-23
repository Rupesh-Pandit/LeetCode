class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<int []> pq = new PriorityQueue<>(
            (a,b)-> b[0]-a[0]
        );
    for(int i=0; i< stones.length; i++){
        pq.add(new int[]{stones[i], i});
    }

    while(true){
        if(pq.size() <= 1) break;

        int y[] = pq.poll();
        int x[] = pq.poll();

        if(y[0] == x[0]) continue;

        pq.add(new int[]{y[0]-x[0], y[1]});
    }   

    if(pq.size() == 0 ) return 0;

    return pq.peek()[0];
    }
}