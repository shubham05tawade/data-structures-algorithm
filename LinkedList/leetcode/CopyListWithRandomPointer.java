class Node{
	int val;
	Node next;
	Node random;
	
	public Node(int val){
		this.val = val;
		this.next = null;
		this.random = null;
	}
}
public class CopyListWithRandomPointer{
	public static Node copyRandomList(Node head){
		if (head == null) return null;

        Node temp = head;
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }

        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        temp = head;
        Node dummy = new Node(0);
        Node copyHead = dummy, copyTemp;

        while (temp != null) {
            copyTemp = temp.next;
            temp.next = copyTemp.next;
            copyHead.next = copyTemp;
            copyHead = copyHead.next; 
            temp = temp.next;
        }

        return dummy.next; 
	}
	public static void main(String... args){
		Integer[][] arr = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
		Node head = new Node(arr[0][0]);
		Node tempHead = head;
		for(int i=1; i < arr.length; i++){
			tempHead.next = new Node(arr[i][0]);
			tempHead = tempHead.next;
		}
		Node headRef = head;
		int counter = 0;
		while(headRef != null){
			if(arr[counter][1] != null){
				int pos = counter;
				Node randomHeadRef = head;
				while(pos > 0){
					randomHeadRef = randomHeadRef.next;
					pos--;
				}
				headRef.random = randomHeadRef;
			}
			counter++;
			headRef = headRef.next;
		}
		Node result = copyRandomList(head);
		System.out.println(head.next.random.val);
	}
}