import java.util.*;

class LinkedList{
	private Node head;
	private Node headResult = null;
	private Node result = null;
	
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
		}
	}
	
	//Remove Duplicate from List
	public void removeDuplicates(){
		
		Node headTemp = head;
		while(headTemp != null){
			if(!valuePresentInUniqueLinkedList(headTemp.value)){
				createUniqueLinkedList(headTemp.value);
			}
			headTemp = headTemp.next;
		}
		Node tempResult = headResult;
		while(tempResult != null){
			System.out.println(tempResult.value);
			tempResult = tempResult.next;
		}
	}
	
	//Check if value is present in the unique linked list
	public boolean valuePresentInUniqueLinkedList(int value){
		if(result != null && headResult != null){
			Node temp = headResult;
			while(temp != null){
				if(temp.value == value) return true;
				temp = temp.next;
			}
			return false;
		}
		return false;
	}
	
	//append value in the unique linked list
	public void createUniqueLinkedList(int value){
		Node newNode = new Node(value);
		if(result != null){
			while(result.next != null){
				result = result.next;
			}
			result.next = newNode;
		}
		else{
			result = newNode;
			headResult = newNode;
		}
	}
	
}

class LinkedListRemoveDuplicates{
	public static void main(String[] args){
		int[] input = {1, 1, 1, 3, 3, 4, 4, 5, 6};
		LinkedList linkedList = new LinkedList(input);
		linkedList.removeDuplicates();
	}
}