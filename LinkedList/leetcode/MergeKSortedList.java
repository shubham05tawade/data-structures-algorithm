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

public class MergeKSortedList{
	
	public static ListNode mergeKLists(ListNode[] lists){
		if(lists == null || lists.length == 0){
			return null;
		}
		//use recursion
		return mergeKListsHelper(lists, 0, lists.length - 1);
	}
	
	public static ListNode mergeKListsHelper(ListNode[] lists, int start, int end){
		if(start == end){
			return lists[start];
		}
		//Merge two lists using merge function
		if(start + 1 == end){
			return merge(lists[start], lists[end]);
		}
		int mid = start + (end - start) / 2;
		ListNode left = mergeKListsHelper(lists, start, mid);
		ListNode right = mergeKListsHelper(lists, mid + 1, end);
		//merge left and right list
		return merge(left, right);
	}
	
	public static ListNode merge(ListNode left, ListNode right){
		ListNode result = new ListNode();
		ListNode temp = result;
		while(left != null && right != null){
			if(left.val < right.val){
				temp.next = new ListNode(left.val);
				left = left.next;
			}
			else{
				temp.next = new ListNode(right.val);
				right = right.next;
			}
			temp = temp.next;
		}
		temp.next = left!=null ? left : right;
		return result.next;
	}
	
	public static void main(String args[]){
		int[] arr1 = {1, 4, 5};
		int[] arr2 = {1, 3, 4};
		int[] arr3 = {2, 6};
		ListNode list1 = new ListNode();
		ListNode list1Ref = list1;
		for(int a1: arr1){
			list1.next = new ListNode(a1);
			list1 = list1.next;
		}
		ListNode list2 = new ListNode();
		ListNode list2Ref = list2;
		for(int a2: arr2){
			list2.next = new ListNode(a2);
			list2 = list2.next;
		}
		ListNode list3 = new ListNode();
		ListNode list3Ref = list3;
		for(int a3: arr3){
			list3.next = new ListNode(a3);
			list3 = list3.next;
		}
		ListNode[] lists = {list1Ref.next, list2Ref.next, list3Ref.next}; 
		ListNode res = mergeKLists(lists);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
	}
	
}