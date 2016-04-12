class MyQueue {
    Stack<Integer> s = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        s.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> t = new Stack<Integer>();
        while(!s.isEmpty()){
            t.push(s.pop());
        }
        t.pop();
        while(!t.isEmpty()){
            s.push(t.pop());
        }
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> t = new Stack<Integer>();
        while(!s.isEmpty()){
            t.push(s.pop());
        }
        int result=t.pop();
        t.push(result);
        while(!t.isEmpty()){
            s.push(t.pop());
        }
        return result;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s.isEmpty();
    }
}