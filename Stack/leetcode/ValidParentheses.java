import java.util.*;

public class ValidParentheses{
	public static boolean isValid(String s){
		Stack<Character> stringStack = new Stack<Character>();
		char[] charArr = s.toCharArray();
		for(char c: charArr){
			if(c == '(' || c == '{' || c == '[') stringStack.push(c);
			if(c == ')')
				if(stringStack.size() > 0 && stringStack.peek() == '(')
					stringStack.pop(); 
				else return false;
			if(c == '}')
				if(stringStack.size() > 0 && stringStack.peek() == '{')
					stringStack.pop(); 
				else return false;
			if(c == ']')
				if(stringStack.size() > 0 && stringStack.peek() == '[')
					stringStack.pop(); 
				else return false;
		}
		if(stringStack.size() == 0) return true;
		return false;
		
	}
	public static void main(String... args){
		String input = "())";
		System.out.println(isValid(input));
	}
}