import java.util.*;

class HashTableFindDuplicates{
	public static List<Integer> findDuplicates(int[] nums){
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++){
			//Increment value on every duplicate entry found from array
			if(hashMap.containsKey(nums[i])){
				hashMap.replace(nums[i], hashMap.get(nums[i]) + 1);
			}
			else{
				hashMap.put(nums[i], 1);
			}
		}
		hashMap.forEach((key, value) -> {
			//Add elements to list that has value equal to 1
			if(value > 1){
				result.add(key);
			}
		});
		return result;
	}
	
	public static void main(String[] args){
		int[] nums =  {1, 2, 3, 2, 1, 4, 5, 4};
		List<Integer> duplicates = findDuplicates(nums);
		System.out.println(duplicates);
	}
	
}