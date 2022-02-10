package com.biotech.process;

import java.io.*;
import java.util.List;

/**
 * Usage: choose or comment among useful methods
 *    - reverseSortOfSymptoms
 *    - orderByOccurence
 *    - filterTopMostRanked
 */
public class AnalyticsCounter {

    static final String path = "src\\com\\biotech\\";
    static final String srcFileName = "symptoms.txt";
    static final String destFileName = "result.out";
    static final int numberOfResults = 7;

    public static void main(String[] args) throws Exception {

        ReadSymptomDataFromFile r = new ReadSymptomDataFromFile(path + srcFileName);
        List<String> symptomsRaw = r.getSymptoms();
        System.out.println(symptomsRaw);

        FilterSymptoms filter = new FilterSymptoms(symptomsRaw);

        // Next 3 methods can be used separately or together, in a meaningful order!

//        filter.reverseSortOfSymptoms();
        filter.orderByOccurence();
        filter.filterTopMostRanked(numberOfResults);

        System.out.println(filter.getResult());

        // next generate output
        try {
            FileWriter writer = new FileWriter(path + destFileName);
            filter.getResult().forEach((key, value) -> {
                try {
                    writer.write(key + ": " + value + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
