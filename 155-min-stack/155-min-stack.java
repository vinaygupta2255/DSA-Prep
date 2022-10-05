
// Great Solution, it will store 2 values for each push, 1 is currentMin and 2nd is actual value.
// similarly will pop 2 values, 1 is for pop and 2nd is for updating the current.
//maintaining currentMin(upto of above element) then element and maintaing it in variable also for next iteration. bcz it is storing in opposite direction in stack
class MinStack {
    private Stack<Integer> _stack;
    private int _currMin;
	
    public MinStack() {
        _stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(_stack.isEmpty())
            _currMin = x;
        
        _stack.push(_currMin);

        if(x < _currMin)
            _currMin = x;
        
        _stack.push(x);
    }
    
    public void pop() {
        _stack.pop();
        _currMin = _stack.pop();
    }
    
    public int top() {
        return _stack.peek();
    }
    
    public int getMin() {
        return _currMin;
    }
}