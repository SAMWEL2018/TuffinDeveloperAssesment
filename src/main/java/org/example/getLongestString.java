package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author samwel.wafula
 * Created on 9/17/2025
 * Time 4:48 PM
 */
public class getLongestString {
    public static String getLongestString(List<Character> validChars, String[] stringArrays) {
        /* initializing the longest String  */
        String tempLongest = "";

        String validString = validChars.toString();
        /* Use of Streams to filter for valid output and return a List */
        List<String> validValuesString = Arrays.stream(stringArrays).
                filter(arrValue -> {
                    System.out.println("check in " + arrValue);
                    HashSet<Character> values = new HashSet<>();
                    char[] chars = arrValue.toCharArray();
                    /* check if the string consists of valid characters */
                    for (char aChar : chars) {
                        if (!validString.contains(String.valueOf(aChar))) {
                            System.out.println("exited on valid characters check " + arrValue);
                            return false;
                        }
                    }
                    /* check if the string consists of repetitive characters */
                    char previous = '\0';
                    for (char insertCheck : chars) {
                        char current;
                        current = insertCheck;
                        if (previous == current) {
                            System.out.println("exited on repetitive check " + arrValue);
                            return false;
                        }
                        previous = current;
                    }
                    System.out.println("successfully passed checks " + arrValue);
                    return true;
                })
                .toList();
        /* return the longest string if List of String still valid */
        for (String currentString : validValuesString) {
            ;
            if (currentString.length() > tempLongest.length()) {
                tempLongest = currentString;
            }
        }
        return tempLongest;
    }
}
