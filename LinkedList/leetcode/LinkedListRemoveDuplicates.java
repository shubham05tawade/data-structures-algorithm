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
	
	public void removeDuplicates(){
		HashSet<Integer> uniqueHashSet = new HashSet<Integer>();
		Node prev = null;
		Node current = head;
		while(current != null){
			if(uniqueHashSet.contains(current.value)){
				prev.next = current.next;
				length--;
			}
			else{
				prev = current;
				uniqueHashSet.add(current.value);
			}
			current = current.next;
		}
		Node temp = head;
		while(temp != null){
			System.out.println(temp.value);
			temp = temp.next;
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