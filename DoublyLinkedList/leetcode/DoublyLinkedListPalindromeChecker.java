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
	
	public boolean isPalindrome(){
		Node tempHead = head;
		Node tempTail = tail;
		if(length <= 1) return false;
		int counter = length;
		while(counter >= (length/2)){
			if(tempHead.value != tempTail.value) return false;
			tempHead = tempHead.next;
			tempTail = tempTail.prev;
			counter--;
		}
		return true;
	}
	
}

class DoublyLinkedListPalindromeChecker{
	public static void main(String args[]){
		int values[] = {1, 3, 5, 3, 1}; 
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList(values);
		System.out.println(doublyLinkedList.isPalindrome());
	}
}