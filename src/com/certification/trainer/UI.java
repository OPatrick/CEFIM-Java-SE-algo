package com.certification.trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 11/02/2022
 * Time: 10:54
 */
public class UI {

    private static final Scanner scan = new Scanner(System.in);

    public UI() {
        display("\nBienvenue sur le programme d'entrainement CEFIM");
    }

    public String ask(String message) {
        display(message);
        return scan.nextLine();
    }

    public void display(String message) {
        System.out.println(message);
    }

    public String getUserAnswer() {
        return scan.nextLine();
    }

}
