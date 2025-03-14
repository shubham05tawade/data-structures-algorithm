class LinkedList{
	private Node head;
	
	public LinkedList(){
		this.head = null;
	}
	
	class Node{
		
		private int value;
		private Node next;	
		
		public Node(int value){
			this.value = value;
			this.next = null;
		}
	}
	
	public Node getHead(){
		return this.head;
	}
	
	public void insert(int value){
		if(head == null){
			head = new Node(value);
		}
		else{
			Node temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = new Node(value);
		}
	}
	
	public void printList(Node current){
		while(current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
	}
	
	public void mergeTwoLinkedList(Node head1, Node head2){
		Node mergeHead = null;
		while(head1 != null && head2 != null){
			int currentValue = head1.value < head2.value ? head1.value : head2.value;
			if(head1.value < head2.value){
				head1 = head1.next;
			}
			else{
				head2 = head2.next;
			}
			if(mergeHead == null) mergeHead = new Node(currentValue);
			else{
				Node temp = mergeHead;
				while(temp.next != null){
					temp = temp.next;
				}
				temp.next = new Node(currentValue);
			}
		}
		while(head1 != null){
			if(mergeHead == null) mergeHead = new Node(head1.value);
			else{
				Node temp = mergeHead;
				while(temp.next != null){
					temp = temp.next;
				}
				temp.next = new Node(head1.value);
			}
			head1 = head1.next;
		}
		while(head2 != null){
			if(mergeHead == null) mergeHead = new Node(head2.value);
			else{
				Node temp = mergeHead;
				while(temp.next != null){
					temp = temp.next;
				}
				temp.next = new Node(head2.value);
			}
			head2 = head2.next;
		}
		printList(mergeHead);
	}
	
}

public class MergeTwoSortedList{
	public static void mergeTwoLists(int[] arr1, int[] arr2){
		LinkedList linkedlist1 = new LinkedList();
		LinkedList linkedlist2 = new LinkedList();
		for(int a1: arr1) linkedlist1.insert(a1);
		for(int a2: arr2) linkedlist2.insert(a2);
		linkedlist1.mergeTwoLinkedList(linkedlist1.getHead(), linkedlist2.getHead());
		
	}
	public static void main(String args[]){
		int[] arr1 = { 1, 2, 4};
		int[] arr2 = { 1, 3, 4};
		mergeTwoLists(arr1, arr2);
	}
}