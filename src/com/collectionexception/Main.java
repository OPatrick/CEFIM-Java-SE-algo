package com.collectionexception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 07/02/2022
 * Time: 10:22
 */
public class Main {

    public static void main(String[] args) {

        // Question a
        List<Country> list = new ArrayList<>();

        Country france = new Country("France");
        list.add(france);
        Country germany = new Country("Germany");
        list.add(germany);
        Country italia = new Country("Italy");
        list.add(italia);
        Country espania = new Country("Espania");
        list.add(espania);
        System.out.println("La collection contient " + list.size() + " pays :");
        System.out.println();

        // Question b
        try {
            displayCountryList(list);

            // Question c
            list.clear();
            if (list.isEmpty()) System.out.println("Liste vide");
            displayCountryList(list);
        } catch (ListEmptyException e) {
            System.out.println(e);
        }

        // Question d
        list.add(france);
        list.add(germany);
        list.add(italia);
        list.add(espania);
        list.set(list.indexOf(espania), new Country("Liberia"));
        italia.setName("Ital");
        System.out.println();

        try {
            // Question e
            System.out.println("OrdreAlphabetix");
//        list.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
            list.sort(Country::sort);
            displayCountryList(list);

            System.out.println("Longueur croissante");
//        list.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
            Collections.sort(list, new CountryComparator());
            displayCountryList(list);
        } catch (ListEmptyException e) {
            System.out.println(e);
        }

        // Exercice 1
        int a = 0;
        int b = 2;
        boolean doIt = true;

        // Exercice 2
        while (doIt) {
            try {
                System.out.println(b / a);    // ArithmeticException
                doIt = false;
            } catch (ArithmeticException e) {
                System.out.println(e);
                a = 1;
            }
        }

        try {
            getAgeCap("50");
//            getAgeCap("5");
            getAgeCap("50.5");
        } catch (Exception e) {
            System.out.println(e);
        }

        Scanner scan = new Scanner(System.in);

        int i = 10;
        while (i > 0) {
            try {
                System.out.println("Quel est l'âge du capitaine ?");
                getAgeCap(scan.nextLine());
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                i--;
            }
        }

        scan.close();
    }

    private static void displayCountryList(List<Country> list) throws ListEmptyException {

        if (list.isEmpty()) throw new ListEmptyException();

        for (Country country : list) {
            System.out.println(country.getName());
        }
        System.out.println();
    }

    public static void getAgeCap(String age) throws Exception {

        try {
            int ageAsInt = Integer.parseInt(age);
            if (ageAsInt < 18 || ageAsInt > 65) {
                throw new AgeCapException(age);
            }
            System.out.println("Le capitaine a " + age + " ans");
        } catch (NumberFormatException e) {
            throw new AgeCapException(age);
        }
    }
}
