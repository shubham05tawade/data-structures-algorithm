import java.util.*;

class HashSetContainsUniqueCharacters{
	
	public static boolean hasUniqueChars(String input){
		Set<Character> charSet = new HashSet<Character>();
		char inputArr[] = input.toCharArray();
		for(char c: inputArr){
			if(charSet.contains(c)){
				return false;
			}
			charSet.add(c);
		}
		return true;
	}
	
	public static void main(String args[]){
		System.out.println(hasUniqueChars("abcdefg"));
        System.out.println(hasUniqueChars("hello"));
        System.out.println(hasUniqueChars(""));
        System.out.println(hasUniqueChars("0123456789"));
        System.out.println(hasUniqueChars("abacadaeaf"));
	}
}