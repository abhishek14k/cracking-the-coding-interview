/*
        Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the
        additional characters, and that you are given the "true" length of the string. (Note: If Implementing in Java, please use a character array
        so that you can perform ths operation in place.)

        Example
        Input:  "Mr John Smith    ", 13
        Output: "Mr%20John%20Smith"
/**
*Time Complexity: O(N)
*Space Complexity: O(1)
* */
public class IsURLify {

    public static String urlifyString(char[] ch, int len) {

        int whiteSpaceCount = 0;
        //Traversing only upto the last char before extra space at the end
        for (int i = 0; i < len; i++) {
            if(ch[i] == ' ') {
                whiteSpaceCount++;
            }
        }
        //Each white space should accomodate '%20', hence: True length + space * 2
        int backwardsPointer = len + whiteSpaceCount*2;

        for (int i=len-1; i>=0; i--) {
            if(ch[i] == ' ') {
                ch[backwardsPointer-1] = '0';
                ch[backwardsPointer-2] = '2';
                ch[backwardsPointer-3] = '%';
                backwardsPointer-=3;
            } else {
                ch[backwardsPointer-1] = ch[i];
                backwardsPointer-=1;
            }
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
//        String str = "Carter McLennan is me         ";
//        String str = "Test A    ";
        System.out.println(str.trim().length());
        System.out.println(urlifyString(str.toCharArray(), str.trim().length()));
    }
}
