class LinkedList{
	
	Node head;
	
	public LinkedList(){
		this.head = null;
	}
	
	class Node{
		char value;
		Node next;
		
		public Node(char value){
			this.value = value;
			this.next = null;
		}
	}
	
	public void insert(char value){
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
	
	public void printlist(){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.value);
			temp = temp.next;
		}
	}
	
	public void reverse(){
		Node prev = null;
		Node current = head;
		Node after = head;
		while(current != null){
			after = current.next;
			current.next = prev;
			prev = current;
			current = after;
		}
		head = prev;
	}
}

public class ReverseStringLinkedList{
	
	public static void reverseString(String word){
		LinkedList linkedlist = new LinkedList();
		char[] letters = word.toCharArray();
		for(char letter: letters){
			linkedlist.insert(letter);
		}
		linkedlist.reverse();
		linkedlist.printlist();
		System.out.print(" ");
	}
	
	public static void main(String args[]){
		String input[] = {"emoclew", "ot", "gnidoc", "dlrow"};
		for(String word: input){
			reverseString(word);
		}
	}
	
}