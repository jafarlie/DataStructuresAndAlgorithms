package InterviewQuestions;

import java.util.Arrays;

public class InterviewQuestions {

    // 1) Determine if a string has all Unique Characters
    final static int MAX_CHAR = 256;

    // runtime is O(n)
    public boolean uniqueCharacters(String str){
        if(str.length() > 256){
            return false;
        }
        boolean[] chars = new boolean[MAX_CHAR];
        Arrays.fill(chars, false);

        for(int i=0; i<str.length();i++){
            int index = (int)str.charAt(i);
            System.out.println(index);
            /*
            If the value is already true, hence the string has duplicate char
               */
            if(chars[i]){
                return false;
            }
            chars[index] = true;
        }
        /* No duplicates encountered, return true */
        return true;
    }
    // end of Question 1

    // 2) There are three types of edits that can be performed on strings: insert a character,
    //remove a character, or replace a character. Given two strings, write a function to check if they are
    //one edit (or zero edits) away.

    public boolean checkEditDistance(String s1, String s2){
        int m = s1.length(), n = s2.length();

        // If difference between lengths is
        // more than 1, then strings can't
        // be at one distance
        if (Math.abs(m - n) > 1)
            return false;

        int count = 0; // Count of edits

        int i = 0, j = 0;
        while (i < m && j < n)
        {
            // If current characters don't match
            if (s1.charAt(i) != s2.charAt(j))
            {
                if (count == 1)
                    return false;

                // If length of one string is
                // more, then only possible edit
                // is to remove a character
                if (m > n)
                    i++;
                else if (m< n)
                    j++;
                else // If lengths of both strings
                // is same
                {
                    i++;
                    j++;
                }

                // Increment count of edits
                count++;
            }

            else // If current characters match
            {
                i++;
                j++;
            }
        }

        // If last character is extra
        // in any string
        if (i < m || j < n)
            count++;

        return count == 1;
    }


    // End of question 2

    // 3) String Rotation; Given two strings s1 and s2,
    // write a snippet to check whether s2 is a rotation of s1. Strings may contain duplicates.

    public boolean isRotation(String s1, String s2){
        return (s1.length() == s2.length()) && ((s1+s1).contains(s2));
    }





    public static void main(String[] args){
        InterviewQuestions interview = new InterviewQuestions();
        //String str = "tinder";
        //if(interview.uniqueCharacters(str)){
        //    System.out.println("The string has unique characters: " + str);
        //}else{
        //    System.out.println("The string has not unique characters: " + str);
        //}
        //String s1 = "gfg";
        //String s2 = "gf";
        //if(interview.checkEditDistance(s1, s2))
        //    System.out.print("Yes");
        //else
        //    System.out.print("No");

        /*String w1 = "waterbottle";
        String w2 = "erbottlewat";
        if(interview.isRotation(w1, w2)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        */
    }

}

