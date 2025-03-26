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

public class PartitionList{
	public static ListNode partition(ListNode head, int x){
		if(head == null || head.next == null) return head;
		ListNode result = new ListNode();
		ListNode resultRef = result;
		boolean foundx = false;
		while(head != null){
			if(!foundx){
				resultRef.next = new ListNode(head.val);
				resultRef = resultRef.next;
			}
			else{
				if(head.val > x){
					while(resultRef.next != null){
						resultRef = resultRef.next;
					}
					resultRef.next = new ListNode(head.val);
					resultRef = resultRef.next;
				}
				else{
					resultRef = result.next;
					while(resultRef.val < x) resultRef = resultRef.next;
					int swap = resultRef.val;
					resultRef.val = head.val;
					resultRef.next = new ListNode(swap, resultRef.next);
				}
			}
			if(head.val == x) foundx = true;
			head = head.next;
		}
		return result.next;
	}
	public static void main(String... args){
		int arr[] = {1, 4, 3, 2, 5, 2};
		int x = 3;
		ListNode head = new ListNode();
		ListNode tempHead = head;
		for(int a: arr){
			tempHead.next = new ListNode(a);
			tempHead = tempHead.next;
		}
		ListNode result = partition(head.next, x);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}
}