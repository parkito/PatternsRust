package com.coding.play.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class Task17 {
    public static List<Double> spliteratorWork(List<Double> lst) {
        List<Double> sqrs = new ArrayList<>();
        Spliterator<Double> s = lst.spliterator();
        s.forEachRemaining((i) -> {
            if (i > 1) {
                sqrs.add(Math.sqrt(i));
            }
        });
        return sqrs;
    }

    public static void print(List<Double> list) {
        Spliterator<Double> spliterator = list.spliterator();
        spliterator.trySplit().forEachRemaining((i) -> {
            if (i >= 2) System.out.println(i);
        });
        System.out.println();
        spliterator.forEachRemaining((i) -> {
            if (i >= 10) System.out.println(i);
        });
    }

    public static void main(String[] args) {
        print(Arrays.asList(2.0, 2.0, 2.0, 2.0, 10.0, 10.0, 10.0, 10.0));
    }
}
