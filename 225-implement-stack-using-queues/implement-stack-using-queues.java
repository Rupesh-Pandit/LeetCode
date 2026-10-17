class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }

    
    public int pop() {
        int n = q1.size();

        int i=0;
        for(i=0; i< n-1; i++)
        q2.add(q1.remove());

        int el = q1.remove();

        while(!q2.isEmpty()) q1.add(q2.remove());
        return el;
    }
    
    public int top() {
        if(q1.isEmpty() )return -1;
        int n = q1.size();
        int i=0;
        for(i =0; i< n-1; i++ ){
            q2.add(q1.remove());
        }
        int el = q1.remove();

        while(!q2.isEmpty()) q1.add(q2.remove());

        q1.add(el);
        return el;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */