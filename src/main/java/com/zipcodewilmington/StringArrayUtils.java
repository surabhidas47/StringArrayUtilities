package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {

        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {

        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {

        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {

        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {

        for (int i = 0; i<array.length;i++) {
            if (array[i]==value);
        }
        return true;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {

       String [] ans = new String[array.length];

       int j = 0;
        for (int i =array.length-1;i>=0;i--) {

            ans[j] = array[i];
            j++;

        }


        return ans;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {

        String [] reverse = new String[array.length];

        int j = 0;

        //reverse array
        for (int i =array.length-1;i>=0;i--) {
            reverse[j] = array[i];
            j++;
        }

        return Arrays.equals(array,reverse);
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        //new boolean array that tracks each letter of alphabet, size set to 26
        boolean[] alphabet = new boolean[26];

        /*here, the outer for loop is iterating through each word of the input array
            we put the iteration array[i] into a string var... we then use that string
             to iterate throuh each character of each word*/
        for (int i = 0; i < array.length; i++) {
            String stringEachWord = array[i];
            //iterating through each word
            for (int j = 0; j < stringEachWord.length(); j++) {
                /*stringEachWord.charAt(j) this part allows us to access each character
                of each word (bc we did the for loop to go through each word)
                the Character.toLowerCase is method that makes each retrieved char lower case
                */
                char charofWord = Character.toLowerCase(stringEachWord.charAt(j));
                //the Character.isLetter method cheks if charofWord is infact a letter
                if (Character.isLetter(charofWord)) {
                    //starting to get confused here...
                    int index = charofWord - 'a';
                    alphabet[index] = true;
                }

            }
        }
        for (boolean letterCheck : alphabet) {
            if (!letterCheck) {
                return false;
            }

        }
        return true;
    }

        /*String letter = "abcdefghijklmnopqrstuvwxyz";
        char Panagramic;
        char letterElements;
        for(String element: array) {
            for (int i=0;i<=element.length();i++){
                 Panagramic= element.charAt(i);
            }
        }
        for (int j=0;j<=letter.length();j++) {
            letterElements=letter.charAt(j);
        } if (Panagramic==letterElements)

        return false;*/


    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int c=0;

        for (int i=0;i<array.length;i++){
            if (value.equals(array[i])) {

                c++;
            }
        }


        return c;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {

        String[] noDupe = new String[array.length];
        int j = 0;

        for (int i = 0; i<array.length; i++) {


            if (valueToRemove.equals(array[i])) {
                //skips adding if a match is found
                continue;
            }
            noDupe[j] = array[i];
            j++;
        }
        //here we create a new array with the leftover words length
        String[] result = new String[j];
        System.arraycopy(noDupe, 0, result, 0, j);
        return result;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {

        String[] update = new String[array.length];
        int j =0;

        for (int i=0;i<array.length-1;i++) {

            if(array[i].equals(array[i+1])) {
                continue;
            }
            update[j]=array[i];
            j++;

        }
        update[j] =array[array.length-1];

        String [] result = new String[j+1];
        System.arraycopy(update, 0, result, 0, j+1);
        return result;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> newArray = new ArrayList<>(Arrays.asList(array));

        for (int i=0; i<newArray.size()-1;i++) {

            String firChar =newArray.get(i);
            String secChar =newArray.get(i+1);

            if(firChar.charAt(0)== secChar.charAt(0)) {
                newArray.set(i,firChar + secChar);
                newArray.remove(secChar);
                i--;
            }
        }

        return newArray.toArray(new String[0]);
    }


}
