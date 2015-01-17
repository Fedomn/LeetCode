package MinStack;

public class MyMinStack {
    
	private Node top = new Node(0,null,0);
	private int pushMin = Integer.MAX_VALUE;
	
	class Node{
		public int data;
		public Node next;
		public int min;
		public Node(int data, Node next, int min) {
			this.data=data;
			this.next=next;
			this.min = min;
		}
	}
	
    public void push(int x) {
    	pushMin = top.next == null ? x : Math.min(top.next.min, x);
    	Node temp = new Node(x,top.next,pushMin);
    	top.next = temp; 
    }

    public void pop() {
    	if(top.next != null){
        	top.next = top.next.next;
    	}
    }

    public int top() {
    	if(top.next != null){
    		int data = top.next.data;        	
        	return  data;
    	}
    	return Integer.MIN_VALUE;
    }

    public int getMin(){
    	if(top.next != null){
    		return top.next.min;
    	}
    	return Integer.MIN_VALUE;
    }
}
