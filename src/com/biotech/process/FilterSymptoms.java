package com.biotech.process;

import java.util.*;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 10/02/2022
 * Time: 11:45
 */
public class FilterSymptoms {

    private final List<String> list;
    private Map<String, Integer> tmp;
    private Map<String, Integer> results;

    public FilterSymptoms(List<String> list) {
        this.list = list;
        this.tmp = new LinkedHashMap<>();
        this.results = new LinkedHashMap<>();
        this.filterUnique();
    }

    public void filterUnique() {
        tmp = results;
        results = new LinkedHashMap<>();
        this.list.forEach((String word) -> results.put(word, (results.getOrDefault(word, 0)) +1));
    }

    public void orderByOccurence() {

        tmp = results;
        results = new TreeMap<>(new SymptomOccurenceComparator(tmp));
        results.putAll(tmp);
        setResults();
    }

    public void reverseSortOfSymptoms() {

        tmp = results;
        results = new TreeMap<>(Collections.reverseOrder());
        results.putAll(tmp);
        setResults();
    }

    public void filterTopMostRanked(int number) {

        tmp = results;
        results = new LinkedHashMap<>();
        tmp.entrySet().stream().limit(number).forEach( entry -> results.put(entry.getKey(), entry.getValue()));
    }

    public Map<String, Integer> getResult() {
        return results;
    }

    public void setResults() {

        tmp = results;
        results = new LinkedHashMap<>();
        results.putAll(tmp);
    }

    static class SymptomOccurenceComparator implements Comparator<Object> {
        Map<String, Integer> map;
        public SymptomOccurenceComparator(Map<String, Integer> map) {
            this.map = map;
        }
        public int compare(Object o1, Object o2) {
            Integer c1 = map.get(o1);
            Integer c2 = map.get(o2);
            if (Objects.equals(c2, c1)) {
                return 1;
            } else {
                return (c2).compareTo(c1);
            }
        }
    }
}
