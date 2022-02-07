package com.collectionexception.exercice6;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 07/02/2022
 * Time: 15:47
 */
public class AdresseIP {
    public static void main(String[] args) {
        try {
            AdresseIP adr = new AdresseIP(247, 217, 19, 10);
            System.out.println(adr);
        } catch (ExceptionAdrIP e) {
            System.out.println(e);
        }
    }

    private int[] octet;

    public AdresseIP(int... list) throws ExceptionAdrIP {
        for (int i=0; i<list.length; i++) {
            if ( list[i] < 0 ||  list[i] > 255) {
                throw new ExceptionAdrIP("valeur incorrecte pour l'octet " + (i+1));
            }
        }
        octet = list;
    }

    public String toString() {
        return octet[0] + "." + octet[1] + "." + octet[2] + "." + octet[3];
    }
}
