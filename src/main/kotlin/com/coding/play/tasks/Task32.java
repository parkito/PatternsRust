package com.coding.play.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Task32 {
    public static void main(String[] args) {
        Set<Integer> integers = Set.of(1, 3, 5);
        Set<Double> doubles = Set.of(2.0, 4.0, 6.0);
        var numbers = union(integers, doubles);
        System.out.println(numbers);
    }


    public static <E> Set<E> union(Set<? extends E> s1,
                                   Set<? extends E> s2) {
        return null;
    }
}
