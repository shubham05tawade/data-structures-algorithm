import java.util.*;

class Stack<T>{
	private ArrayList<T> stack = new ArrayList<T>();
	
	//Generic Type Parameter (T)
	public void push(T value){
		stack.add(value);
	}
	
	//Generic Type Return
	public T pop(){
		if(stack.size() == 0) return null;
		T node = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);
		return node;
	}
	
	public void printStack(){
		if(stack.size() > 0){
			stack.forEach(s -> System.out.println(s));
		}
	}
	
	public T get(int index){
		if(index < 0 || index > stack.size()) return null;
		return stack.get(index);
	}
	
	public int size(){
		if(stack == null) return 0;
		return stack.size();
	}
	
	public T peek(){
		return stack.get(stack.size() - 1);
	}
	
	public boolean isEmpty(){
		if(stack.size() == 0) return true;
		return false;
	}
}

class StackSort{
	
	static void sortStack(Stack<Integer> stack){
		//Create a temp stack
		Stack<Integer> tempStack = new Stack<Integer>();
		//Push top element from original stack into temp stack
		tempStack.push(stack.pop());
		while(!stack.isEmpty()){
			Integer topStackElement = stack.pop();
			if(topStackElement.intValue() < (tempStack.peek()).intValue()){
				//If top element from original stack is less than top element from temp stack then push the element into temp stack
				tempStack.push(topStackElement);
			}
			else{
				//Move all the elements from temp stack to original stack till you find any element in temp stack which is greater than the top element from original stack
				while(!tempStack.isEmpty() && ((tempStack.peek()).intValue() < topStackElement.intValue())){
					stack.push(tempStack.pop());
				}
				//Move the top element from original stack to temp stack
				tempStack.push(topStackElement);
			}
		}
		tempStack.printStack();
	}
	public static void main(String[] args){
		Stack<Integer> originalStack = new Stack<Integer>();
		originalStack.push(4);
		originalStack.push(1);
		originalStack.push(5);
		originalStack.push(2);
		originalStack.push(3);
		StackSort.sortStack(originalStack);
	}
}