class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b)->a[2]-b[2]);

        for(int i=0; i< points.length; i++){
            int val = points[i][0] *points[i][0] + points[i][1]* points[i][1];
            pq.add(new int []{points[i][0], points[i][1], val});
        }
        int [][] arr = new int[k][2];
        for(int i=0; i< k; i++){
            arr[i][0]= pq.peek()[0];
            arr[i][1] = pq.peek()[1];
            pq.poll();
        }
         return arr;
    }
}