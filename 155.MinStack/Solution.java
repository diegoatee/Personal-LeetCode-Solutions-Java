class MinStack {
    private int top;
    private ArrayList<Integer> nums;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
        this.top = -1;
        this.nums = new ArrayList<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        if (top == -1) {
            min = val;
            minStack.push(min);
            //System.out.println("Added " + min + " to minStack");
        }
        else if (val <= min) {
            min = val;
            minStack.push(min);
            //System.out.println("Added " + min + " to minStack");
        }
        nums.add(val);
        top++;
        //System.out.println("Pushed " + val + " to overall stack");
    }
    
    public void pop() {
        int minTop = minStack.peek();
        int overallTop = nums.get(top);
        if (minTop == overallTop) {
            int removed = minStack.pop();
            //System.out.println("Popped " + removed + " from minStack");
            if (!minStack.isEmpty()) {
                min = minStack.peek();
            }
        }
        //System.out.println("Removed " + nums.get(top) + " from overall stack");
        nums.remove(top);
        top--;
    }
    
    public int top() {
        return nums.get(top);
    }
    
    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        else {
            //System.out.println("Minimum is " + minStack.peek());
            return minStack.peek();
        }
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
