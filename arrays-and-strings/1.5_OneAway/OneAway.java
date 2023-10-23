
/*
Problem Statement:
There are three types o edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two 
Strings, write a function to check if they are one edit(or zero edit) away.

Example:
abcd, abce -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
*/

public class OneAway {

    private static boolean isOneAway(String s1, String s2) {

        if(s1.length() == s2.length()) {
            return replaceOnce(s1,s2);
        } else if (Math.abs(s1.length() - s2.length()) == 1) {
            if(s1.length() < s2.length()) {
                return insertOnce(s1, s2);
            } else {
                return insertOnce(s2, s1);
            }
        }
    return false;
    }

    private static boolean replaceOnce(String s1, String s2) {
        boolean replaced = false;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(replaced){
                    return false;
                }
                replaced = true;
            }
        }
        return true;
    }


    private static boolean insertOnce(String minStr, String maxStr) {
        int min_ptr = 0, max_ptr = 0;

        while(min_ptr < minStr.length() && max_ptr < maxStr.length()) {
            if(minStr.charAt(min_ptr) != maxStr.charAt(max_ptr)) {
                if(min_ptr != max_ptr) {
                    return false;
                }
                max_ptr++;
            } else {
                max_ptr++;
                min_ptr++;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isOneAway("abcd", "abce"));
        System.out.println(isOneAway("pale", "pable"));
        System.out.println(isOneAway("pale", "bae"));
    }
}
