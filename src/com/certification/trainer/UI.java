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

    public String askMultiple(String message) {
        display(message);
        StringBuilder sb = new StringBuilder();
        String line;
        do {
            line = scan.nextLine();
            if (line.length() > 0) {
                if (sb.length() > 0) {
                    sb.append(System.lineSeparator());
                }
                sb.append(line);
            }
        } while (line.length() > 0);
        return sb.toString();
    }

    public void display(String message) {
        System.out.println(message);
    }

    public String getUserAnswer() {
        return scan.nextLine();
    }

}
