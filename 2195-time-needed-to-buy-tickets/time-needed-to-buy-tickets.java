class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time =0;
        int front = tickets.length;
        while(tickets[k] != 0){
             int idx = front%tickets.length;

             if(tickets[idx] != 0){
                tickets[idx]--;
                time++;
             }
             front = front+1;
        }
        return time;
    }
}