public class MinStack {
    
    private Stack<Integer> min;
    private Stack<Integer> all;
    
    /** initialize your data structure here. */
    public MinStack() {
        this.min = new Stack<Integer>();
        this.all = new Stack<Integer>();
    }
    
    public void push(int x) {
        this.all.push(x);
        if (this.min.isEmpty() || this.min.peek() >= x) {
            this.min.push(x);
        }
    }
    
    public void pop() {
        int x = this.all.pop();
        if (this.min.peek() == x) {
            this.min.pop();
        }
    }
    
    public int top() {
        return this.all.peek();
    }
    
    public int getMin() {
        return this.min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */