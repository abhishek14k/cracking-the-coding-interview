import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckStringPermutation {

    // O(n log n)
    public static boolean isPermutationUsingSorting(String s1, String s2) {

        if(s1.length() != s2.length()) return false;
        char arr1[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // O(n)
    public static boolean isPermutationUsingHashMap(String s1, String s2) {

        if(s1.length() != s2.length()) return false;
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if(map.get(c) != null) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            if(map.get(c) == null || map.get(c) == 0) {
                return false;
            } else {
                map.put(c, map.get(c)-1);
            }
        }
       return true;
    }

    public static void main(String[] args) {

        System.out.println(isPermutationUsingSorting("", ""));
        System.out.println(isPermutationUsingSorting("abc", "bac"));
        System.out.println(isPermutationUsingSorting("test", "bac"));

        System.out.println(isPermutationUsingHashMap("abc", "bac"));
        System.out.println(isPermutationUsingHashMap("abab", "baba"));
        System.out.println(isPermutationUsingHashMap("test", "bac"));
    }
}
