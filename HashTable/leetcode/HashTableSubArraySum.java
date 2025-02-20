import java.util.*;
import java.util.stream.*;

class HashTableSubArraySum{
	
	static int[] subarraySum(int[] input, int target){
        if(input.length == 0) return new int[0];
		Map<Integer, Integer> inputMap = new HashMap<Integer, Integer>();
		int[] result = {-1, -1};
		for(int i=0; i<input.length; i++){
			inputMap.put(i, input[i]);
		}
		//loop map to calculate sum
		inputMap.forEach((key, value) -> {
			int sum = value;
			int counter = key + 1;
			do{
				//if sum equals target, then return the indices
			    if(sum == target){
					result[0] = key;
					result[1] = counter - 1;
					return;
				}
				//calculate sum
				if(counter < input.length)
				    sum = sum + input[counter];
				counter++;
			}
			//calculate sum of element till we reach end of an array
			while(counter < input.length);
		});
		//if array is not updated then return empty array
		if(result[0] == -1 && result[1] == -1) return new int[0];
		return result;
	}
	
	public static void main(String[] args){
		int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        int[] result1 = subarraySum(nums1, target1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");
	}
	
}