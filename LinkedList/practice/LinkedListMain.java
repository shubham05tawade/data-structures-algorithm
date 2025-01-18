import java.util.*;

class LinkedList{
	private Node head;
	private Node tail;
	private int length = 0;
	
	public LinkedList(int value){
		Node node = new Node(value);
		this.head = node;
		this.tail = node;
		length++;
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
	
	//Appned Node
	public void append(int value){
		Node newNode = new Node(value);
		if(length == 0){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = newNode;
		}
		length++;
	}
	
	//Remove Last Node
	public Node removeLast(){
		if(length == 0) return null;
		Node temp = head;
		Node prev = temp;
		while(temp.next!=null){
			prev = temp;
			temp = temp.next;
		}
		tail = prev;
		prev.next = null;
		length--;
		if(length == 0){
			head = null;
			temp = null;
		}
		return temp;
	}
}

class LinkedListMain{
	public static void main(String[] args){
		LinkedList linkedList = new LinkedList(7);
		linkedList.append(8);
		linkedList.append(9);
		linkedList.append(10);
		System.out.println(linkedList.removeLast());
		linkedList.printList();
	}
}