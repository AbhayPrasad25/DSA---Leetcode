class MinStack {
    Stack<Integer> stck;
    Stack<Integer> minstack;
    int min;
    public MinStack() {
        stck = new Stack<>();
        minstack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = Math.min(val , min);
        stck.push(val);
        minstack.push(min);
    }
    
    public void pop() {
        minstack.pop();
        int el = stck.pop();
        if(!minstack.isEmpty()){
            min = minstack.peek();
        }
        else{
            min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return stck.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */