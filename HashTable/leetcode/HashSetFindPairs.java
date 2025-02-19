import java.util.*;

class HashSetFindPairs{
	
	public static List<int[]> findPairs(int[] input1, int[] input2, int target){
		List<int[]> result = new ArrayList<int[]>();
		//Set for storing unique element from array1
		Set<Integer> input1Set = new HashSet<Integer>(); 
		for(int input: input1){
			input1Set.add(input);
		}
		for(int input: input2){
			//check if complement exists in set
			int complement = target - input;
			if(input1Set.contains(complement)){
				//Add the pair to result list
				int[] pair = {input, complement};
				result.add(pair);
			}
		}
		return result;
	}
	
	public static void main(String args[]){
		int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;
		List<int[]> pairs = findPairs(arr1, arr2, target);
		for(int[] pair : pairs){
			System.out.println(Arrays.toString(pair));
		}
	}
}