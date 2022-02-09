package com.flux;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 09/02/2022
 * Time: 11:12
 */
public class Flux {

    public static void main(String[] args) {

        final String PATH = "D:\\Patrick\\Documents\\Projets\\RaspberryPi\\CEFIM-Java-SE-algo\\src\\com\\flux\\loremIpsum.txt";

        Flux flux = new Flux();

        try {
            HashMap<Character, Integer> chars = flux.analyseFile(PATH);

            List<Character> sortedKeys = chars.keySet().stream().sorted().toList();
            for (Character c : sortedKeys) {
                System.out.println(c + " (unicode: " + (int) c + ") :" + chars.get(c));
            }

        } catch (IOException e) {
            System.out.println("Le fichier [" + PATH + "] n'a pas été trouvé");
        }

    }

    private HashMap<Character, Integer> analyseFile(String fileName) throws IOException {

        HashMap<Character, Integer> chars = new HashMap<>() ;

        Reader fileReader = new FileReader(fileName);

        int data = fileReader.read();
        while(data != -1) {
            chars.put((char) data, chars.get((char) data) == null ? 1 :  chars.get((char) data) + 1);
            data = fileReader.read();
        }

        fileReader.close();

        return chars;
    }
}
