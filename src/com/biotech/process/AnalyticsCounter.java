package com.biotech.process;

import java.io.*;

public class AnalyticsCounter {

    private static int headacheCount = 0;    // initialize to 0
    private static int rashCount = 0;        // initialize to 0
    private static int pupilCount = 0;        // initialize to 0

    public static void main(String[] args) throws Exception {

        String path = "D:\\Patrick\\Documents\\Projets\\RaspberryPi\\CEFIM-Java-SE-algo\\src\\com\\biotech\\";

        try {
            // first get input
            BufferedReader reader = new BufferedReader(new FileReader(path + "symptoms.txt"));
            String line = reader.readLine();

            while (line != null) {
                System.out.println("symptom from file: " + line);
                if (line.equals("headache")) {
                    headacheCount++;
                    System.out.println("number of headaches: " + headacheCount);
                } else if (line.equals("rush")) {
                    rashCount++;
                } else if (line.contains("pupils")) {
                    pupilCount++;
                }
                line = reader.readLine();    // get another symptom
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Concernant le chemin " + path);
            System.out.println(e.getMessage());
        }

        // next generate output
        try {
            FileWriter writer = new FileWriter(path + "result.out");
            writer.write("headache: " + headacheCount + "\n");
            writer.write("rash: " + rashCount + "\n");
            writer.write("dialated pupils: " + pupilCount + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
