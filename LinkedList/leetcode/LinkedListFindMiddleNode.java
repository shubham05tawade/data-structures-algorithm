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
	
	//Find Middle Node
	//Used slow and fast pointer technique
	public Node findMiddleNode(){
		if(head == null) return null;
		Node slow = head;
		Node fast = head;
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
			if(fast.next == null){
				break;
			}
			else{
				fast = fast.next;
			}
		}
		return slow;
		
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

class LinkedListFindMiddleNode{
	public static void main(String[] args){
		int[] input = {1 ,2 ,3, 4, 5, 6, 7};
		LinkedList linkedList = new LinkedList(input);
		linkedList.printList();
		System.out.println(linkedList.findMiddleNode().value);
	}
}