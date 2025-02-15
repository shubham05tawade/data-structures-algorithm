import java.util.HashMap;

class HashTableItemInCommon{
	
	public static boolean itemInCommon(int[] array1, int[] array2){
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for(int arr1: array1){
			hashMap.put(arr1, arr1);
		}
		//check if the key is already present in hashmap
		for(int arr2: array2){
			if(hashMap.get(arr2) != null) return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		int[] array1 = {1, 3, 5};
		int[] array2 = {2, 4, 5};
		System.out.println(itemInCommon(array1, array2));
	}
	
}