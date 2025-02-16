import java.util.*;
import java.util.stream.Collectors;

class HashTableGroupAnagrams{
	
	public static List<List<String>> groupAnagrams(String[] strings){
		Map<String, List<String>> anagramsMap = new HashMap<String, List<String>>();
		List<List<String>> result = new ArrayList<>();
		for(String string : strings){
			//Convert the string to character array to store in list
			List<Character> characterList = new ArrayList<Character>(string.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
			//sort the list for generating unique for anagrams
			Collections.sort(characterList);
			String key = characterList.stream().map(String::valueOf).collect(Collectors.joining());
			if(anagramsMap.containsKey(key)){
				//Store anagrams in list
				List<String> anagramElementList = anagramsMap.get(key);
				anagramElementList.add(string);
				anagramsMap.replace(key, anagramElementList);
			}
			else{
				List<String> anagramElementList = new ArrayList<String>();
				anagramElementList.add(string);
				anagramsMap.put(key, anagramElementList);
			}
		}
		//combine values pf map to return list of anagrams
		result = anagramsMap.values().stream().collect(Collectors.toList());
		return result;
	}
	
	public static void main(String[] args){
		System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
	
}