/*
Problem Statement:
Implement a method to perform basic string compression using the counts of repeated characetrs. For example, the string aabcccccaaa would
become a2b1c5a3. If the "compressed" string would not become smaller than the original string, your method should return the oriinal string.
you can assume the string has only uppercase ond lowercase letters(a-z).
*/

public class StringCompression {

    public static String compressString(String str) {

        StringBuilder sbCompressedString = new StringBuilder();
        int repeatCount = 0;
        for (int i = 0; i < str.length(); i++) {
            repeatCount++;
			/*If next character is not similar to the current then append the current character along with the count to result*/
            if(str.length() <= i+1 || str.charAt(i) != str.charAt(i+1)) {
                sbCompressedString.append(str.charAt(i));
                sbCompressedString.append(repeatCount);
                repeatCount = 0;
            }
        }
        /*If compressed string length is less than Original String, then return compressed string*/
        if(sbCompressedString.length() < str.length()) {
            return sbCompressedString.toString();
        } else {
            return str;
        }
    }

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("abcdefg"));
    }
}
