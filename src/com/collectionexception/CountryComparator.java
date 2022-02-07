package com.collectionexception;

import java.util.Comparator;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 07/02/2022
 * Time: 11:09
 */
public class CountryComparator implements Comparator<Country> {

    @Override
    public int compare(Country o1, Country o2) {

        return o1.getName().length() - o2.getName().length();
    }
}
