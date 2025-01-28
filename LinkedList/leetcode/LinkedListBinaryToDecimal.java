import java.util.*;

class LinkedList{
	private Node head;
	int length;
	
	class Node{
		int value;
		Node next;
		
		public Node(int value){
			this.value = value;
			this.next = null;
		}
	}
	
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
			}
			length++;
		}
	}
	
	//Binary To Decimal
	public void binaryToDecimal(){
		//Reverse the List
		reverseList();
		int counter = 0;
		int value = 0;
		Node temp = head;
		while(temp != null){
			if(temp.value == 1 && counter == 0){
				value += 1;
			}
			else if(temp.value == 1){
				int i = 0;
				int k = 1;
				while(i < counter){
					k = k * 2;
					i++;
				}
				value += k;
			}
			counter++;
			temp = temp.next;
		}
		System.out.println(value);
		
	}
	
	public void reverseList(){
		Node prev = null;
		Node current = head;
		Node after;
		while(current != null){
			after = current.next;
			current.next = prev;
			prev = current;
			current = after;
		}
		head = prev;
	}
}

class LinkedListBinaryToDecimal{
	public static void main(String[] args){
		int[] input = {1, 0, 1};
		LinkedList linkedList = new LinkedList(input);
		linkedList.binaryToDecimal();
	}
}