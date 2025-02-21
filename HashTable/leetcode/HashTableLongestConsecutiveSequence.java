import java.util.*;

class HashTableLongestConsecutiveSequence{
	public static int longestConsecutiveSequence(int[] input){
		int result = 0;
		//if emty array return 0
		if (input.length == 0) return 0;
		Set<Integer> inputHashSet = new HashSet<Integer>();
		//Create set for getting list of unique values
		for(int i: input){
			inputHashSet.add(i);
		}
		int longestStreak = 1;
		for(Integer inputVal: inputHashSet){
			int counter = 1;
			//check whether the consecutive element is present in set
			int incrementer = inputVal + 1;
			while(counter > 0){
				if(inputHashSet.contains(incrementer)){
					incrementer += 1;
					counter++;
				}
				else{
					//check if longest streak is greater than current streak
					if(longestStreak < counter) longestStreak = counter;
					counter = 0;
				}
			}
		}
		return longestStreak;
	}
	
	public static void main(String[] args){
		System.out.println(longestConsecutiveSequence(new int[] {1, 2, 3, 4, 5}));
	}
	
}