package org.example;

import java.util.HashSet;

/**
 * @author samwel.wafula
 * Created on 9/17/2025
 * Time 4:49 PM
 */
public class getfirstUniqueProduct {
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
}
