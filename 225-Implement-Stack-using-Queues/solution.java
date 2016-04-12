class MyStack {
    
    Queue<Integer> in = new LinkedList<Integer>();
    Queue<Integer> out = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        in.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(in.size()>1) {
            out.offer(in.poll());
        }
        in.poll();
        while(!out.isEmpty()) {
            in.offer(out.poll());
        }
    }

    // Get the top element.
    public int top() {
        while(in.size()>1) {
            out.offer(in.poll());
        }
        int res = in.poll();
        out.offer(res);
        while(!out.isEmpty()) {
            in.offer(out.poll());
        }
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return in.isEmpty();
    }
}