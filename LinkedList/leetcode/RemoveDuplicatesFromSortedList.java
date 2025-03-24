import java.util.*;

class ListNode{
	int val;
    ListNode next;
	
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	
}

class RemoveDuplicatesFromSortedList{
	
	public static ListNode deleteDuplicates(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode res = new ListNode(head.val);
		ListNode current = res;
		while(head != null){
			if(current.val != head.val){
				current.next = new ListNode(head.val);
				current = current.next;
			}
			head = head.next;
		}
		return res;
		
	}
	
	public static void main(String args[]){
		int arr[] = {1, 1, 2};
		ListNode head = new ListNode();
		ListNode tempHead = head;
		for(int a: arr){
			tempHead.next = new ListNode(a);
			tempHead = tempHead.next;
		}
		ListNode result = deleteDuplicates(head.next);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}
}