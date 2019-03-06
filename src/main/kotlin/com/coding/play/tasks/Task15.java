package com.coding.play.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Task15 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sets = reader.readLine().split(";");

        for (String curSet : sets) {
            String[] inSet = curSet.split(" ");
        }

        Set<Integer> set1 = new HashSet<>();
        for (String s : sets[0].split(" ")) {
            set1.add(Integer.valueOf(s));
        }

        Set<Integer> set2 = new HashSet<>();
        for (String s : sets[1].split(" ")) {
            set2.add(Integer.valueOf(s));
        }

        Set<Integer> set3 = new HashSet<>();
        ;
        for (String s : sets[2].split(" ")) {
            set3.add(Integer.valueOf(s));
        }

        unionTreeLargeNumber(set1, set2, set3)
                .stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    public static TreeSet<Integer> unionTreeLargeNumber(Set<Integer> set1, Set<Integer> set2, Set<Integer> set3) {
        TreeSet<Integer> result = new TreeSet<>();
        result.add(set1.stream().max(Comparator.naturalOrder()).get());
        result.add(set2.stream().max(Comparator.naturalOrder()).get());
        result.add(set3.stream().max(Comparator.naturalOrder()).get());
        return result;
    }

    public static void main1(String[] args) {
        new BufferedReader(new InputStreamReader(System.in)).lines()
                .map(string -> string.split(";"))
                .flatMap(Arrays::stream)
                .map(string -> string.split(" "))
                .map(Arrays::asList)
                .map(x -> x.stream().map(Integer::parseInt).collect(Collectors.toList()))
                .map(Collections::max)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Collections.reverseOrder())))
                .forEach(System.out::println);
    }
}

//        return Stream.of(set1, set2, set3)
//                .flatMap(Collection::stream)
//                .collect(Collectors.toCollection(TreeSet::new));



