package com.collectionexception;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 07/02/2022
 * Time: 10:26
 */
public class Country {

    private String name;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int sort(Country country) {
        return this.name.compareToIgnoreCase(country.getName());
    }
}
