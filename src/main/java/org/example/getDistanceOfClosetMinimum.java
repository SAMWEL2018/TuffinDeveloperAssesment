package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author samwel.wafula
 * Created on 9/17/2025
 * Time 4:50 PM
 */
public class getDistanceOfClosetMinimum {

    public static Integer distanceOfClosetMinimum(int[] values) {

        /* Searched through the array for the smallest */
        int counter = 0;
        int current, previous;
        List<Integer> originalValues = new ArrayList<>(Arrays.stream(values).boxed().toList());
        List<Integer> listValues = new ArrayList<>(originalValues);
        /* Sorting to get the smallest value as it's guaranteed the smallest occurs at least twice */
        Collections.sort(listValues);
        int smallestValue = listValues.getFirst();

        /* getting the index of the first occurrence so as to start searching from there*/
        int indexValueOfFirstMinimum = originalValues.indexOf(smallestValue);
        System.out.println("minimum first index value " + indexValueOfFirstMinimum);
        for (int i = indexValueOfFirstMinimum; i < values.length; i++) {
            System.out.println("First occurrence " + values[i]);
            for (int j = i + 1; j < values.length; j++) {
                System.out.println("Next occurrence " + values[j]);
                if (values[i] == values[j]) {
                    System.out.println("Match occurrence Found at point " + i + " and " + j);
                    counter = j - i;
                    return counter;
                }
            }
        }
        return counter;
    }
}
