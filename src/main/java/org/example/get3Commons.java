package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author samwel.wafula
 * Created on 9/17/2025
 * Time 4:51 PM
 */
public class get3Commons {
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
}
