/* A string can form a palindrome if at most one character occurs odd number of times 
* and all other characters occur even number of times
*/

import java.util.HashMap;
import java.util.Map;

public class Palindrome_Permutation {

    private static boolean isPalindromePermutation(String s1) {
        /* If length is 0 return true */
        if(s1.length() == 0) return true;

        Map<Character, Integer> map = new HashMap<>();
        /* Single non-letter is replaced by "" */
        s1 = s1.replaceAll("[^a-zA-Z]+", "");
		
		/* Populating a hashmap to find number of 
		occurrences of each character in the string*/
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if(map.get(c) != null) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        int oddFreqCount = 0;
        /* Map traversal to check count of chars with Odd number of occurrences */
        for (int freq: map.values()) {
            if(freq % 2 != 0) {
                oddFreqCount++;
            }
            /* If more than 1 Odd number of occurrences then false is returned */
            if (oddFreqCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("racecar"));
        System.out.println(isPalindromePermutation("tact coa"));
        System.out.println(isPalindromePermutation("fafa"));
        System.out.println(isPalindromePermutation("fa a&*&*f"));
        System.out.println(isPalindromePermutation("bcded"));
    }
}
