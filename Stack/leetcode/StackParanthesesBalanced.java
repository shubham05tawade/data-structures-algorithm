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

class StackParanthesesBalanced{
	static boolean isBalancedParentheses(String input){
		Stack<Character> stack = new Stack<Character>();
		Character[] inputArr = input.chars().mapToObj((c) -> (char) c).toArray(Character[] :: new);
		int openParanthesesCount = 0;
		char openParantheses = '(';
		int closeParanthesesCount = 0;
		char closeParantheses = ')';
		for(Character letter : inputArr){
			stack.push(letter);
		}
		int counter = inputArr.length;
		while(counter > 0){
			Character popNode = stack.pop();
			if(popNode.charValue() == openParantheses){
				openParanthesesCount++;
			}
			else if(popNode.charValue() == closeParantheses){
				closeParanthesesCount++;
			}
			counter--;
			if(openParanthesesCount > closeParanthesesCount) return false;
		}
		if(closeParanthesesCount > openParanthesesCount) return false;
		return true;
	}
	
	public static void main(String[] args){
		System.out.println("is Parantheses Balanced: " + isBalancedParentheses("()"));
	}
}