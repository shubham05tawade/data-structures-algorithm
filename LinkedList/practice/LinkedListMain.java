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
	
	//Prepend Node
	public void prepend(int value){
		Node newNode = new Node(value);
		if(length == 0){
			head = newNode;
			tail = newNode;
		}
		else{
			newNode.next = head;
			head = newNode;
			length++;
		}
	}
	
	//Remove First
	public Node removeFirst(){
		if(length == 0) return null;
		Node temp = head;
		head = head.next;
		temp.next = null;
		length--;
		if(length == 0){
			tail = null;
		}
		return temp;
	}
	
	//Get Node
	public Node get(int index){
		if(index < 0 || index >= length) return null;
		Node temp = head;
		for(int i=0; i<index; i++){
			temp = temp.next;
		}
		return temp;
	}
	
	//Set Node
	public boolean set(int index, int value){
		if(index < 0 || index >= length) return false;
		Node temp = head;
		for(int i=0; i<index; i++){
			temp = temp.next;
		}
		temp.value = value;
		return true;
	}
	
	//Insert Node
	public boolean insert(int index, int value){
		if(index < 0 || index > length) return false;
		if(index == 0){
			prepend(value);
			return true;
		}
		if(index == length){
			append(value);
			return true;
		}
		Node temp = get(index - 1);
		Node newNode = new Node(value);
		newNode.next = temp.next;
		temp.next = newNode;
		length++;
		return true;
	}
	
	//Remove Node
	public Node remove(int index){
		if(index < 0 || index > length) return null;
		if(index == 0){
			return removeFirst();
		}
		if(index == length){
			return removeLast();
		}
		Node prev = get(index - 1);
		Node temp = prev.next;
		prev.next = temp.next;
		temp.next = null;
		length--;
		return temp;
	}
	
	//Reverse List
	public void reverse(){
		Node temp = head;
		head = tail;
		tail = temp;
		Node after = temp.next;
		Node before = null;
		for(int i=0; i<length; i++){
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}
	}
	
}

class LinkedListMain{
	public static void main(String[] args){
		LinkedList linkedList = new LinkedList(7);
		linkedList.append(8);
		linkedList.append(9);
		linkedList.append(10);
		linkedList.append(11);
		System.out.println(linkedList.removeLast());
		linkedList.prepend(7);
		linkedList.removeFirst();
		System.out.println(linkedList.get(2));
		System.out.println(linkedList.set(1, 15));
		linkedList.insert(1, 18);
		linkedList.remove(2);
		linkedList.printList();
		linkedList.reverse();
		linkedList.printList();
	}
}