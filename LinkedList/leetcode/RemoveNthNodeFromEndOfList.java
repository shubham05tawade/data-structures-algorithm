class ListNode{
	int val;
	ListNode next;
	ListNode() {};
	ListNode(int val) {
		this.val = val;
	}
	ListNode(int val, ListNode next){
		this.val = val;
		this.next = next;
	}
}

class RemoveNthNodeFromEndOfList{
	
	public static ListNode removeNthFromEnd(ListNode head, int n){
		//Define result node
		ListNode res = new ListNode(0, head);
		ListNode tempHead = res;
		//Track two nodes : increment head node with n position and create a tempHead node
		for(int i=0; i<n; i++){
			head = head.next;
		}
		//iterate till we reach end of the linkedlist
		while(head != null){
			head = head.next;
			tempHead = tempHead.next;
		}
		//remove value
		tempHead.next = tempHead.next.next;
		return res.next;
	}
	
	public static void main(String args[]){
		ListNode head = new ListNode();
		ListNode tempHead = head;
		int[] arr = {1, 2, 3, 4, 5};
		int n = 2;
		for(int a: arr){
			tempHead.next = new ListNode(a);
			tempHead = tempHead.next;
		}
		ListNode res = removeNthFromEnd(head.next, n);
		while(res != null){
			System.out.print(res.val + ", ");
			res = res.next;
		}
	}
}