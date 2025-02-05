import java.util.*;

class Queue{
	Node first;
	Node last;
	int length = 0;
	
	class Node{
		int value;
		Node next;
		
		public Node(int value){
			this.value = value;
			this.next = null;
		}
	}
	
	public Queue(int value){
		Node newNode = new Node(value);
		this.first = newNode;
		this.last = newNode;
		this.length = 1;
	}
	
	public Node getFirst(){
		return this.first;
	}
	
	public Node getLast(){
		return this.last;
	}
	
	public int getLength(){
		return this.length;
	}
	
	public void printQueue(){
		Node temp = first;
		while(temp != null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	//Add element in the queue
	public void enqueue(int value){
		Node newNode = new Node(value);
		if(length == 0){
			first = newNode;
			last = newNode;
		}
		else{
			last.next = newNode;
			last = newNode;
		}
		length++;
	}
	
	//Remove element from queue
	public Node dequeue(){
		if (length == 0) return null;
		Node temp = first;
		if (length == 1){
			first = null;
			last = null;
		}
		else {
			first = first.next;
		}
		temp.next = null;
		length--;
		return temp;
	}
}

class QueueMain{
	public static void main(String[] args){
		Queue queue = new Queue(7);
		System.out.println(queue.getFirst());
		System.out.println(queue.getLast());
		System.out.println(queue.getLength());
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);
		queue.enqueue(11);
		System.out.println(queue.dequeue());
		queue.printQueue();
		
	}
}