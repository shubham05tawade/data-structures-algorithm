import java.util.*;

class Queue{
	
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	public Queue(){
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}
	
	public int peek(){
		return stack1.peek();
	}
	
	public boolean isEmpty(){
		return stack1.isEmpty();
	}
	
	public void enqueue(int value){
		if(stack1.size() == 0) stack1.push(value);
		else{
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			stack1.push(value);
			while(!stack2.isEmpty()){
				stack1.push(stack2.pop());
			}
		}
	}
}

class EnqueueWithStack{
	public static void main(String[] args){
		Queue queue = new Queue();
		queue.enqueue(4);
	}
}