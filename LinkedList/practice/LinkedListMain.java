import java.util.*;

class LinkedList{
	private Node head;
	private Node tail;
	private int length = 0;
	
	public LinkedList(int value){
		Node node = new Node(value);
		this.head = node;
		this.tail = node;
	}
	
	public int getHead(){
		return head.value;
	}
	
	public int getTail(){
		return tail.value;
	}
	
	public int getLength(){
		return length;
	}
	
	public void printList(){
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	class Node{
		int value;
		Node next;
		
		public Node(int value){
			this.value = value;
			this.next = null;
		}
	}
}

class LinkedListMain{
	public static void main(String[] args){
		LinkedList linkedList = new LinkedList(7);
		linkedList.printList();
	}
}