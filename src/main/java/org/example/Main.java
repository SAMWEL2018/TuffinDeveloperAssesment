package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] stringArrays = {"AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA"};
        String[] products = {"Apple", "Computer", "Sam", "Bag"};
        Character[] validCharacters = {'A', 'B', 'C', 'D'};
        String longest = getLongestString(Arrays.asList(validCharacters), stringArrays);
        System.out.println("Longest " + longest);

        String uniquePr = firstUniqueProduct(products);
        System.out.println("First Unique " + uniquePr);

        int[] values = {1, 2, 3, 1, 4, 5, 2};
        Integer value = distanceOfClosetMinimum(values);
        System.out.println("Distance " + value);
        String commons = getCommons("hi there care to discuss algorithm basis or how to solve algorithm or");
        System.out.println("commons " + commons);
        List<String> vals = new ArrayList<>() {{
            add("ID_A01");
            add("ID_A02");
            add("ID_A03");
            add("ID_A04");
            add("ID_A05");
            add("ID_A06");
        }};
        List<String> rotated = rotate(vals, 2);
        System.out.println("rotated " + rotated);
    }

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

    public static String firstUniqueProduct(String[] products) {
        /* use of hashset as in only stores unique values, if it fails to store another product in implies
         * the product exists, the loop breaks and proceeds to the next element in the array
         * If I can able to insert all other products from the beginning of current array means it only
         * appears once
         * */
        HashSet<String> uniquePrs = new HashSet<>();
        String uniqueProductName = "";
        boolean unique = false;
        for (int i = 0; i < products.length; i++) {
            uniquePrs.clear();
            unique = true;
            System.out.println("----NEW LOOP---");
            String currentProduct = products[i];
            System.out.println("currentProduct: " + currentProduct);
            uniquePrs.add(products[i]);
            for (int j = i + 1; j < products.length; j++) {
                String nextProductOnLoop = products[j];
                System.out.println("nextProductOnLoop: " + nextProductOnLoop);
                if (!uniquePrs.add(products[j])) {
                    /* If the next product in the array is not unique this will be executed */
                    System.out.println("Product exists ---loop breaks--");
                    unique = false;
                    break;
                }
            }
            if (unique) {
                System.out.println("First Unique Occurrence: " + products[i]);
                return products[i];
            }
        }
        return "";
    }

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

    public static String getCommons(String input) {
        /* Used maps to keep count of appearance frequency on key value*/
        Map<String, Integer> proximityStorage = new HashMap<>();
        String[] strArrayInput = input.split(" ");
        System.out.println("array output " + Arrays.toString(strArrayInput));
        for (int i = 0; i < strArrayInput.length; i++) {
            proximityStorage.put(strArrayInput[i], proximityStorage.getOrDefault(strArrayInput[i], 0) + 1);

        }
        List<String> get3Commons = proximityStorage.entrySet()
                .stream()
                .sorted((a, b) -> {
                    /* Comparing the frequencies*/
                    int freq = b.getValue().compareTo(a.getValue());
                    return (freq != 0) ? freq
                            /* if the Frequencies are same use alphabetic ordering  */
                            : a.getKey().compareTo(b.getKey());
                })
                /* Limit to 3 as required*/
                .limit(3)
                .map(Map.Entry::getKey)
                /* Sort in Asc order*/
                .sorted()
                .toList();
        return Arrays.toString(get3Commons.toArray(new String[0]));
    }

    public static List<String> rotate(List<String> values, int rotations) {

        int size = values.size();
        rotations = rotations % size;
        String[] array = values.toArray(new String[0]);
        /* array for rotated values*/
        String[] rotated = new String[size];
        for (int i = 0; i < size; i++) {
            int newIndex = (i + rotations) % size;
            rotated[newIndex] = array[i];
        }
        return Arrays.asList(rotated);
    }

}