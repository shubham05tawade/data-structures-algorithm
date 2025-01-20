import java.util.*;

class LinkedList{
	private Node head;
	private Node tail;
	
	public LinkedList(int[] value){
		for(int i=0; i<value.length; i++){
			Node newNode = new Node(value[i]);
			if(i == 0){
				head = newNode;
			}
			else{
				Node temp = head;
				while(temp.next != null){
					temp = temp.next;
				}
				temp.next = newNode;
				if(i == (value.length - 1)){
					tail = newNode;
				}
			}
		}
	}
	
	public int getHead(){
		return head.value;
	}
	
	public int getTail(){
		return tail.value;
	}
	
	
	public void printList(){
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	//Used Two pointer technique to trace the loop
	public Node findKthFromEnd(int k){
		if(head == null || k < 0) return null;
		Node temp = head;
		Node nextNode = null;
		while(temp.next != null){
			nextNode = temp;
			int count = 1;
			while(nextNode.next != null){
				nextNode = nextNode.next;
				count++;
			}
			if(count == k){
				break;
			}
			temp = temp.next;
		}
		return temp;
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

class LinkedListKthNodeFromEnd{
	public static void main(String[] args){
		int[] input = {1 ,2 ,3, 4, 5, 6, 7};
		LinkedList linkedList = new LinkedList(input);
		linkedList.printList();
		System.out.println(linkedList.findKthFromEnd(2).value);
	}
}