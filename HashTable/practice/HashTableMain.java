class HashTable{
	
	private int size = 7;
	private Node[] dataMap;
	
	public HashTable(){
		this.dataMap = new Node[size];
	}
	
	class Node{
		String key;
		int value;
		Node next;
		
		public Node(String key, int value){
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	public void printTable(){
		for(int i=0; i<size; i++){
			System.out.print(i+": ");
			Node temp = dataMap[i];
			while(temp != null){
				System.out.print("{ " + temp.key + " : " + temp.value + " },");
				temp = temp.next;
			}
			System.out.println("");
		}
	}
	
	public int hash(String key){
		char[] keyCharArray = key.toCharArray();
		int hash = 0;
		for(int i=0; i<keyCharArray.length; i++){
			int asciiValueOfChar = keyCharArray[i];
			hash = asciiValueOfChar * 23 % size;
		}
		return hash;
	}
	
	public void set(String key, int value){
		int index = hash(key);
		Node newNode = new Node(key, value);
		if(dataMap[index] == null) dataMap[index] = newNode;
		else{
			Node temp = dataMap[index];
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}
}

class HashTableMain{
	public static void main(String[] args){
		HashTable hashTable = new HashTable();
		hashTable.set("hello", 123);
		hashTable.set("hello", 456);
		hashTable.set("world", 876);
		hashTable.printTable();
	}
}