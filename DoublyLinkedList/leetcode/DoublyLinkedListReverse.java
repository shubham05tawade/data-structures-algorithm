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
	
	//Swap prev and next pointer for reversing the doubly linked list
	public void reverse(){
		if(length < 2) return;
		Node temp = head;
		head = tail;
		tail = temp;
		Node tempAfter = temp;
		while(tempAfter != null){
			tempAfter = temp.next;
			temp.next = temp.prev;
			temp.prev = tempAfter;
			temp = tempAfter;
		}
	}
	
}

class DoublyLinkedListReverse{
	public static void main(String args[]){
		int values[] = {1, 3, 5, 7, 9}; 
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList(values);
		doublyLinkedList.reverse();
		doublyLinkedList.printList();
	}
}