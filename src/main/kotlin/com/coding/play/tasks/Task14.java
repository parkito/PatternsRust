package com.coding.play.tasks;

import java.util.Set;
import java.util.stream.Collectors;

public class Task14 {
    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> set = set1.stream()
                .filter(n -> !set2.contains(n))
                .collect(Collectors.toSet());
        set.addAll(set2.stream()
                .filter(n -> !set1.contains(n))
                .collect(Collectors.toSet()));
        return set;
    }
}

//    Set<Integer> result = new HashSet<>(set1);
//    result.addAll(set2);
//            Set<Integer> repetitive = new HashSet<>(set1);
//        repetitive.retainAll(set2);
//        result.removeAll(repetitive);
//        return result;