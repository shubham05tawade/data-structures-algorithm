class DoublyLinkedList{
	Node head;
	Node tail;
	int length = 0;
	
	public DoublyLinkedList(int[] values){
		for(int value: values){
			append(value);
		}
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
	
	public void printList(){
		Node temp = head;
		while(temp != null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	//Append Node
	public void append(int value){
		Node newNode = new Node(value);
		if(length == 0){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		length++;
	}
	
	public void swapFirstAndLast(){
		if(length > 2){
			int temp = head.value;
			head.value = tail.value;
			tail.value = temp;
		}
	}
	
}

class DoublyLinkedListSwapFirstAndLast{
	public static void main(String args[]){
		int values[] = {1, 3, 5, 7, 9}; 
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList(values);
		doublyLinkedList.swapFirstAndLast();
		doublyLinkedList.printList();
	}
}