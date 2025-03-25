import java.util.*;

class ListNode{
	int val;
	ListNode next;
	
	public ListNode() {};
	
	public ListNode(int val){
		this.val = val;
	}
	public ListNode(int val, ListNode next){
		this.val = val;
		this.next = next;
	}
}

public class RotateListKtimes{
	
	public static ListNode rotateRight(ListNode head, int k){
		if(head == null || head.next == null || k < 1) return head;
		int length = 0;
		ListNode tempHead = head;
		while(tempHead != null){
			tempHead = tempHead.next;
			length++;
		}
		if(k > length){
			k = k % length;
		}
		if(k > 0){
			while(k > 0){
				ListNode endNode = head; 
				ListNode temp = null;
				while(endNode.next != null){
					temp = endNode;
					endNode = endNode.next;
				}
				endNode.next = head;
				temp.next = null;
				head = endNode;
				k--;
			}
		}
		return head;
	}
	public static void main(String args[]){
		int k = 28;
		int arr[] = {1, 2, 3, 4, 5};
		ListNode head = new ListNode();
		ListNode tempHead = head;
		for(int a: arr){
			tempHead.next = new ListNode(a);
			tempHead = tempHead.next;
		}
		ListNode result = rotateRight(head.next, k);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}
}