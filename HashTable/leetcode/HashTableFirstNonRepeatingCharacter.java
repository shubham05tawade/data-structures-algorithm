import java.util.*;

class HashTableFirstNonRepeatingCharacter{
	public static Character firstNonRepeatingCharacter(String word){
		Map<Character, Integer> uniqueCharactersMap = new HashMap<Character, Integer>();
		char[] characters = word.toCharArray();
		for(int i=0; i<characters.length; i++){
			if(uniqueCharactersMap.containsKey(characters[i])){
				uniqueCharactersMap.replace(characters[i], uniqueCharactersMap.get(characters[i]) + 1);
			}
			else{
				uniqueCharactersMap.put(characters[i], 1);
			}
		}
		//entrySet returns a set view of map, through which we filtered out the keys that has only one occurrence and returned the first character from the list 
		Character result = uniqueCharactersMap.entrySet().stream()
		.filter((entry) -> entry.getValue() == 1)
		.map(Map.Entry::getKey)
		.findFirst()
		.orElse(null);
		return result;
	}
	
	
	public static void main(String[] args){
		System.out.println(firstNonRepeatingCharacter("hello"));
	}
	
}