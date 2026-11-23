class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < score.length; i++) {
            pq.add(new int[] { score[i], i });
        }
        int c = 1;
        String st[] = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            if (c > 3) {
                st[pq.peek()[1]] = Integer.toString(c);
                pq.poll();
                c++;
            } else
            if (c == 1) {
                st[pq.peek()[1]] = "Gold Medal";
                pq.poll();
                c++;
            } else
            if (c == 2) {
                st[pq.peek()[1]] = "Silver Medal";
                pq.poll();
                c++;
            } else
            if(c == 3) {
                st[pq.peek()[1]] = "Bronze Medal";
                pq.poll();
                c++;
            }
        }
        return st;
    }
}