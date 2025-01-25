import java.util.*;

class LinkedList{
	private Node head;
	
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
	
	
	//Used Two Nodes and Two pointers for maintaining list of nodes containing values less than X and values greater than X
	public void partitionList(int x){
		Node currentNode = head;
		//Node for creating less than X List
		Node lessThanXList = null;
		//Pointer for less than X List
		Node headLessThanXList = null;
		//Node for creating greater than X List
		Node greaterThanXList = null;
		//Pointer for greater than X List
		Node headGreaterThanXList = null;
		if(currentNode != null){
			while(currentNode != null){
				if(currentNode.value < x){
					if(lessThanXList == null){
						headLessThanXList = new Node(currentNode.value);
						lessThanXList = headLessThanXList;
					}
					else{
						Node temp = headLessThanXList;
						while(temp.next != null){
							temp = temp.next;
						}
						temp.next = new Node(currentNode.value);
						lessThanXList = temp;
					}
				}
				else{
					if(greaterThanXList == null){
						headGreaterThanXList = new Node(currentNode.value);
						greaterThanXList = headGreaterThanXList;
					}
					else{
						Node temp = headGreaterThanXList;
						while(temp.next != null){
							temp = temp.next;
						}
						temp.next = new Node(currentNode.value);
						greaterThanXList = temp;
					}
				}
				currentNode = currentNode.next;
			}
			//Merge both LinkedList
			Node temp = null;
			Node tempHead = null;
			if(headLessThanXList != null){
				temp = headLessThanXList;
				tempHead = temp;
				while(headLessThanXList.next != null){
					temp.next = headLessThanXList.next;
					temp = temp.next;
					headLessThanXList = headLessThanXList.next;
				}
			}
			if(headGreaterThanXList != null){
				if(headLessThanXList == null){
					temp = headGreaterThanXList;
					tempHead = temp;
				}
				else{
					temp.next = headGreaterThanXList;
					temp = temp.next;					
				}
				while(headGreaterThanXList.next != null){
					temp.next = headGreaterThanXList.next;
					temp = temp.next;
					headGreaterThanXList = headGreaterThanXList.next;
				}				
			}
			printPartitionList(tempHead);
		}
	}
	
	//To print the list
	public void printPartitionList(Node temp){
		while(temp != null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
}

class LinkedListPartitionList{
	public static void main(String[] args){
		int[] input = {1, 8, 10, 5, 4, 2, 11, 3};
		LinkedList linkedList = new LinkedList(input);
		linkedList.partitionList(5);
	}
}