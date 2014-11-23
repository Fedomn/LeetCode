package MinStack;

import java.util.Stack;
/**
 *	Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *	push(x) -- Push element x onto stack.
 *	pop() -- Removes the element on top of the stack.
 *	top() -- Get the top element.
 *	getMin() -- Retrieve the minimum element in the stack.
 *
 */
public class BestResult {
	class MinStack {
		private Stack<Integer> stack = new Stack<Integer>(); 
		private Stack<Integer> minStack = new Stack<Integer>();
		
		public void push(int x){
			stack.push(x);
			if(stack.isEmpty() || x <= stack.peek()) minStack.push(x); 
		}
		
		public void pop() {
			if(stack.pop().equals(minStack.peek())) minStack.pop();
		}

	    public int top() {
	    	return stack.peek();
	    }

	    public int getMin() {
	    	return minStack.peek();
	    }		
	}
	
	public static void main(String[] args) {
		BestResult.MinStack stack = new BestResult().new MinStack();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		System.out.println(stack.top());
	}
}
