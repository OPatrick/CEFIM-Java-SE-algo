package com.flux;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 09/02/2022
 * Time: 11:12
 */
public class Flux {

    static final String PATH = "D:\\Patrick\\Documents\\Projets\\RaspberryPi\\CEFIM-Java-SE-algo\\src\\com\\flux\\loremIpsum.txt";

    public static void main(String[] args) {

        Flux flux = new Flux();

        try {
            Map<Character, Integer> chars = flux.analyseFile(PATH);

            // Ordered display
            chars.keySet().stream().sorted().forEach((c)->
                    System.out.println(c + " (unicode: " + (int) c + ") :" + chars.get(c)));

        } catch (IOException e) {
            System.out.println("Le fichier [" + PATH + "] n'a pas été trouvé");
        }

    }

    private Map<Character, Integer> analyseFile(String fileName) throws IOException {

        Map<Character, Integer> chars = new HashMap<>() ;

        try (Reader fileReader = new FileReader(fileName)) {
            int data = fileReader.read();
            while (data != -1) {
                chars.put((char) data, chars.get((char) data) == null ? 1 : chars.get((char) data) + 1);
                data = fileReader.read();
            }
        }

        return chars;
    }
}
