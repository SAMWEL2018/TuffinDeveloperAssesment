package org.example;

import java.util.Arrays;
import java.util.List;

/**
 * @author samwel.wafula
 * Created on 9/17/2025
 * Time 4:51 PM
 */
public class Rotation {

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
