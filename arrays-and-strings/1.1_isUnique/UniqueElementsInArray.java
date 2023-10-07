import java.util.Arrays;
import java.util.HashSet;

public class UniqueElementsInArray {

    /*  O(n) - time complexity - where n: length of string and time for iterating the string
    */
    public static boolean isContainingUniqueCharUsingHashset(String str) {

        HashSet hs = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (hs.contains(str.charAt(i))) {
                return false;
            }
            hs.add(str.charAt(i));
        }
        return true;
    }

    /*  O(n^2) - time complexity - where n: length of string and time for iterating the string twice in for loops
    */
    public static boolean isContainingUniqueCharUsingBruteForce(String str) {

        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    /*  O(n log n) - time complexity - where n: length of string and time for iterating the string twice in for loops
    */
    public static boolean isContainingUniqueCharUsingSorting(String str) {

       char[] sortedString = str.toCharArray();
        Arrays.sort(sortedString);

        for (int i = 1; i < sortedString.length; i++) {
            if(sortedString[i] == sortedString[i-1]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isContainingUniqueCharUsingHashset("test"));
        System.out.println(isContainingUniqueCharUsingBruteForce("draw"));
        System.out.println(isContainingUniqueCharUsingSorting("apple"));
    }
}
