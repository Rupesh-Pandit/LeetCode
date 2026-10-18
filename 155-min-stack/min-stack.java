class MinStack {
    Stack<Integer> s;
    Stack<Integer>minS;

    public MinStack() {
        s = new Stack<>();
        minS = new Stack<>();
    }
    
    public void push(int value) {
        s.push(value);

        if(minS.isEmpty()|| value <= minS.peek())
        minS.push(value);
    }
    
    public void pop() {
       int el = s.pop();
        if(el == minS.peek()) minS.pop();
    }
    
    public int top() {
        if(!s.isEmpty())
         return s.peek();

         return -1;
    }
    
    public int getMin() {
        if(!minS.isEmpty())
        return minS.peek();

        return -1;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.peek();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */