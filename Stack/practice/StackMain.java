import java.util.*;

class Stack{
	Node top;
	int height = 0;
	
	class Node{
		int value;
		Node next;
		public Node(int value){
			this.value = value;
			this.next = null;
		}
	}
	
	public Stack(int value){
		Node newNode = new Node(value);
		top = newNode;
		height = 1;
	}
	
	//Push element in the stack
	public void push(int value){
		Node newNode = new Node(value);
		if(height == 0){
			top = newNode;
		}
		else{
			newNode.next = top;
			top = newNode;
		}
		height++;
	}
	
	//Remove element from the stack
	public Node pop(){
		if (height == 0) return null;
		Node temp = top;
		top = top.next;
		temp.next = null;
		return temp;
	}
	
	//Print stack elements
	public void printStack(){
		Node temp = top;
		while(temp != null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	public int getTop(){
		return top.value;
	}
	
	public int getHeight(){
		return this.height;
	}
}

class StackMain{
	public static void main(String[] args){
		Stack stack = new Stack(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		stack.push(11);
		System.out.println(stack.pop());
		stack.printStack();
		
	}
}