package com.company;

import java.util.*;

public class MySort {
    public static void main(String[] args) {
        Random RND = new Random(100);
        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 0; i < 5000; i++) {
            integers.add(RND.nextInt(1000));
        }
        long before = System.currentTimeMillis();
//        customSort(integers); //if you want to check speed of my sort do this
//        TreeSet<Integer> treeSort = new TreeSet<>(integers);// if you want to check the speed of Tree set
        long after = System.currentTimeMillis();
        System.out.println((after-before));
    }

    public static void customSort(List<Integer> customers) {
        for (int i = 0; i < customers.size() - 1; i++) {
            for (int k = i + 1; k < customers.size(); k++) {
                // Compare left to right, not right to left.
                if (customers.get(i)>customers.get(k)) {
                    Integer temp = customers.get(i);
                    customers.set(i, customers.get(k));
                    customers.set(k, temp);
                }
            }
        }
    }
}
