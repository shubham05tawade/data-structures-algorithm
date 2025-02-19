import java.util.*;

class HashSetRemoveDuplicates{
	
	public static List<Integer> removeDuplicates(List<Integer> input){
		Set<Integer> result = new HashSet<Integer>();
		input.forEach(value -> result.add(value));
		return new ArrayList<Integer>(result);
	}
	
	public static void main(String args[]){
		List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
		List<Integer> newList = removeDuplicates(myList);
		System.out.println(newList);
	}
}