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
	
	//Remove Last Node
	public Node removeLast(){
		if(length == 0) return null;
		Node temp = tail;
		if(length == 0){
			head = null;
			tail = null;
		}
		tail = tail.prev;
		tail.next = null;
		temp.prev = null;
		length--;
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
			Node temp = head;
			head.prev = newNode;
			newNode.next = head; 
			head = newNode;
		}
		length++;
	}
	
	//Remove Last Node
	public Node removeFirst(){
		if(length == 0) return null;
		Node temp = head;
		if(head.next != null){
			head = head.next;
			head.prev = null;
			temp.next = null;
		}
		else{
			head = null;
			tail = null;
		}
		length--;
		return temp;
	}
	
	//Get Node
	public Node get(int index){
		if(index < 0 || index >= length) return null;
		if(index < length/2){
			Node temp = head;
			for(int i=0; i<index; i++){
				head = head.next;
			}
			return head;
		}
		else{
			Node temp = tail;
			for(int i= length -1; i > index ; i--){
				tail = tail.prev;
			}
			return tail;
		}
	}
	
	//Set Node
	public boolean set(int index, int value) {
		Node temp = get(index);
		if(temp != null){
			temp.value = value;
			return true;
		}
		return false;
	}
}

class DoublyLinkedListMain{
	public static void main(String args[]){
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList(7);
		System.out.println("Head: " + doublyLinkedList.getHead());
		System.out.println("Tail: " + doublyLinkedList.getTail());
		doublyLinkedList.append(8);
		doublyLinkedList.append(9);
		doublyLinkedList.append(10);
		doublyLinkedList.removeLast();
		doublyLinkedList.prepend(6);
		doublyLinkedList.removeFirst();
		System.out.println(doublyLinkedList.get(1).value);
		doublyLinkedList.set(2, 17);
		doublyLinkedList.printList();
	}
}