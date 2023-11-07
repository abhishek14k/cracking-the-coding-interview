/*
Problem Statement:
Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2,
write code to check if s2 is a rotation of s1 using only one call to isSubstring(e.g., "waterbottle" is a rotation of "erbottlewat").
*/

public class String_Rotation {

    public boolean stringRotation(String s1, String s2) {

        if(s1.length() != s2.length()){
            return false;
        }
        StringBuilder s3 = new StringBuilder();
        s3.append(s1);
        s3.append(s1);

        return (s3.indexOf(s2) != -1);
    }

    public static void main(String[] args) {
        String_Rotation sr = new String_Rotation();
        System.out.println("Is String Rotation?: "+sr.stringRotation("waterbottle", "terbottlewa"));
    }
}
