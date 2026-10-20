class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer>s = new Stack<>();

        for(int i=0; i< operations.length; i++){
            if(operations[i].equals("C") && !s.isEmpty()){
                s.pop();
            } else if(operations[i].equals("D") && !s.isEmpty()){
                int d = s.peek();
                s.push(2*d);
            } else if(operations[i].equals("+")){
                int d1 =0, d2=0;
                if(!s.isEmpty()){
                 d1 = s.pop();
                } 
                if(!s.isEmpty())
                 d2 = s.pop();

                int d3 = d1 + d2;

                if(d2 != 0) s.push(d2);
                if(d1 != 0) s.push(d1);
                s.push(d3);
            } else {
                s.push(Integer.parseInt(operations[i]));
            }
        }

        int sum =0;
        while(!s.isEmpty()){
            sum += s.pop();
        }
        return sum;
    }
}