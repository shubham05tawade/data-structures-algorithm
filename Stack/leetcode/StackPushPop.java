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
}

class StackPushPop{
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(Integer.valueOf(7));
		stack.push(Integer.valueOf(8));
		stack.push(Integer.valueOf(9));
		stack.push(Integer.valueOf(10));
		stack.pop();
		stack.printStack();
	}
}