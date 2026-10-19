class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totGas =0, totCost=0;

        for(int i=0; i< gas.length; i++){
            totGas += gas[i];
            totCost += cost[i];
        }

        if(totGas< totCost) return -1;

        int start=0;
        int totalcost =0;

        for(int i=0; i<cost.length;i++){
            totalcost += (gas[i] - cost[i]);
            if(totalcost < 0) {
                totalcost = 0;
                start = i+1;
            }
        }
        return start;
    }
}