package com.coding.play.tasks;

import java.util.Arrays;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task19 {
    public static SortedMap<String, Integer> wordCount(String[] strings) {
        SortedMap<String, Integer> map = new TreeMap<>();
        for (String srt : strings) {
            Integer integer = map.get(srt);
            if (integer == null) {
                map.put(srt, 0);
            } else {
                map.put(srt, ++integer);
            }
        }
        return map;
    }

    public static void printMap(Map<String, Integer> map) {
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    public static SortedMap<String, Integer> wordCount1(String[] strings) {
        return Stream.of(strings)
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum, TreeMap::new));
    }

    public static void printMap1(Map<String, Integer> map) {
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    public static SortedMap<String, Integer> wordCount2(String[] strings) {
        SortedMap<String, Integer> map = new TreeMap<>();

        for (String word : strings) {
            map.merge(word, 1, Integer::sum);
        }
        return map;
    }

    public static SortedMap<String, Integer> wordCount3(String[] strings) {
        final SortedMap<String, Integer> map = new TreeMap<>();

        Arrays.stream(strings).forEach(x -> map.compute(x, (k, v) -> (v == null ? 1 : (v + 1))));

        return map;
    }
}
