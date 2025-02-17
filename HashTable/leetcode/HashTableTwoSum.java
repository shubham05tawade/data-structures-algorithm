import java.util.*;
import java.util.stream.Collectors;

class HashTableTwoSum{
	
	public static int[] twoSum(int[] input, int target){
		ArrayList<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> inputMap = new HashMap<Integer, Integer>();
		for(int i=0; i<input.length; i++){
			int complement = 0;
			if(target > complement)
				complement = target - input[i];
			else
				complement = input[i] - target;
			//Check in complement is present in map
			if(inputMap.containsKey(complement)){
				//Add the indices of both elements into array
				result.add(inputMap.get(complement));
				result.add(i);
			}
			//Add the element in Hashmp
			inputMap.put(input[i], i);
		}
		if(result.size() > 0)
			return result.stream().mapToInt(Integer::intValue).toArray();
		return new int[0];
	}
	
	public static void main(String[] args){
		System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));
	}
	
}