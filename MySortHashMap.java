package com.company;

import java.util.*;

public class MySortHashMap {
    public static void main(String[] args) {
        Random RND = new Random(100);
        ArrayList<Integer> integers = new ArrayList<>();
        Map<Integer, Object> startMap = new HashMap<>();
        Object mapValue = new Object();
        for (int i = 0; i < 5000; i++) {
            int value = RND.nextInt(1000);
            integers.add(value);
            startMap.put(value,mapValue);
        }
        long before = System.currentTimeMillis();
        customSort(integers); //if you want to check speed of my sort do this
//        TreeMap<Integer, Object> integerObjectTreeMap = new TreeMap<>(startMap);//if you want to check speed of map do this

        long after = System.currentTimeMillis();
        System.out.println((after - before));
    }

    public static void customSort(List<Integer> customers) {
        for (int i = 0; i < customers.size() - 1; i++) {
            for (int k = i + 1; k < customers.size(); k++) {
                // Compare left to right, not right to left.
                if (customers.get(i) > customers.get(k)) {
                    Integer temp = customers.get(i);
                    customers.set(i, customers.get(k));
                    customers.set(k, temp);
                }
            }
        }
    }
}
