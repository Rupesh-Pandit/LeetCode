class MedianFinder {
       PriorityQueue<Integer>min ;
       PriorityQueue<Integer>max ;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(max.isEmpty() || max.peek() >= num )
        max.add(num);
        else 
        min.add(num);

        // balance
       if(max.size() > min.size() +1) min.add(max.poll());
       if(min.size() > max.size() + 1 ) max.add(min.poll());
    }
    
    public double findMedian() {
        if(max.size() == min.size()) return (double) (max.peek() + min.peek())/2.0;
        else if(max.size() -min.size() >0) 
        return (double) max.peek();

        return min.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */