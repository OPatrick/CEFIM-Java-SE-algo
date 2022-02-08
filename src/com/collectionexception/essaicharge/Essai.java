package com.collectionexception.essaicharge;

import java.util.Arrays;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 08/02/2022
 * Time: 09:55
 */
public class Essai {

    public static void main(String[] args) {

        try {
            method();
        } catch (ChargedException ce) {
            System.out.println(ce.getMessage() + " avec le numéro " + ce.getErrorNumber());
        }
        try {
            method2();
        } catch (ChargedException ce) {
            System.out.println(ce.getMessage() + " avec le numéro " + Arrays.toString((int[])ce.getO()));
        }
    }

    public static void method() throws ChargedException {
        throw new ChargedException("Message", 128);
    }

    public static void method2() throws ChargedException {
        throw new ChargedException("Message", 128, new int[] {1,2,3,4});
    }
}
