import java.util.*;

class ListNode{
	int val;
	ListNode next;
	ListNode(){}
	ListNode(int val){
		this.val = val;
	}
	ListNode(int val, ListNode next){
		this.val = val;
		this.next = next;

	}
}

class AddTwoNumbers{
	public static void addTwoNumbers(ListNode l1, ListNode l2){
		int sum = 0, carry = 0;
		ListNode tempResult = new ListNode();
		ListNode result = tempResult;
		while(l1!=null || l2!=null || carry != 0){
			sum = carry;
			if(l1!=null){
				sum = sum + l1.val;
				l1 = l1.next;
			}
			if(l2!=null){
				sum = sum + l2.val;
				l2 = l2.next;
			}
			carry = sum / 10;
			int num = sum % 10;
			tempResult.next = new ListNode(num);
			tempResult = tempResult.next;
		}
		while(result != null){
			System.out.print(result.val);
			result = result.next;
		}
	}
	
	public static void main(String args[]){
		ListNode l1 = new ListNode(9);
		ListNode templ1 = l1; 
		ListNode l2 = new ListNode(1);
		ListNode templ2 = l2;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		l2 = l2.next;
		addTwoNumbers(templ1, templ2);
	}
}