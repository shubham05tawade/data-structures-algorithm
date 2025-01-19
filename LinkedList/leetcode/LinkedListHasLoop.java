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
	public boolean hasLoop() {
		if(head == null || head.next == null) return false;
		Node slow = head;
		Node fast = head;
		boolean loopFound = false;
		while(fast.next != null){
			slow = slow.next;
			fast = fast.next;
			if(fast.next != null){
				fast = fast.next;
			}
			if(slow == fast){
				loopFound = true;
				break;
			}
		}
		return loopFound;
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

class LinkedListHasLoop{
	public static void main(String[] args){
		int[] input = {1 ,2 ,3, 4, 5, 6, 7};
		LinkedList linkedList = new LinkedList(input);
		linkedList.printList();
		System.out.println(linkedList.hasLoop());
	}
}