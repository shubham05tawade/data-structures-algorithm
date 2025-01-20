class DoublyLinkedList{
	Node head;
	Node tail;
	int length;
	
	public DoublyLinkedList(int value){
		Node node = new Node(value);
		this.head = node;
		this.tail = node;
		length = 1;
	}
	
	class Node{
		int value;
		Node next;
		Node prev;
		
		public Node(int value){
			this.value = value;
			this.next = null;
			this.prev = null;
			
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
		while(temp != null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
}

class DoublyLinkedListMain{
	public static void main(String args[]){
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList(7);
		System.out.println("Head: " + doublyLinkedList.getHead());
		System.out.println("Tail: " + doublyLinkedList.getTail());
		doublyLinkedList.printList();
	}
}