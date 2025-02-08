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

class StackReverseString{
	static String reverseString(String input){
		if(input.trim() == "") return input;
		Stack<Character> stack = new Stack<Character>();
		//Convert to integer stream through chars() and then convert into character stream using mapToOb()
		//toArray() converts character stream into Character array
		Character inputArr[] = input.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
		for(Character i : inputArr){
			stack.push(i);
		}
		String output = "";
		int counter = inputArr.length;
		while(counter > 0){
			output += stack.pop();
			counter--;
		}
		return output;
	}
	public static void main(String[] args){
		String reverse = reverseString("Hello World");
		System.out.println(reverse);
	}
}