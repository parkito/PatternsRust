package com.coding.play.tasks;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
* Write a collector that partitions all words in a stream into two groups: palindromes (true) and usual words (false).
 * The collector should return Map<Boolean, List<String>>. All input words will be in the same case (lower).

Let's remind, a palindrome is a word or phrase which reads the same backward or forward,
such as noon or level. In our case, a palindrome is always a word. For details, see https://en.wikipedia.org/wiki/Palindrome

Hint: the method reverse() of StringBuilder may help you.

Important. You should write only the collector in any valid formats but without ; on the end.
It will be passed as an ﻿argument to the collect() method of a stream as shown below.

String[] words = ...
Map<Boolean, List<String>> palindromeOrNoMap =
        Arrays.stream(words)
              .collect(...your_collector_will_be_passed_here...);


Examples of the valid solution formats: Collectors.reducing(...) or reducing(...)

Sample Input 1:

aaaa aaa a aa

Sample Output 1:

{false=[], true=[aaaa, aaa, a, aa]}

Sample Input 2:

level bbaa ac

Sample Output 2:

{false=[bbaa, ac], true=[level]}
*
*
* */


public class Task2 {

    public static void main(String[] args) {
        String[] param = {"aaaa", "aaa", "ab", "aa"};
        Map<Boolean, List<String>> collect = Arrays.stream(param)
                .collect(new PointToPointsCollector());

        System.out.println(collect);

        Map<Boolean, List<String>> res = Arrays.stream(param)
                .collect(Collector.of(
                        ArrayList::new,
                        List::add,
                        (acc, ps) -> {
                            acc.addAll(ps);
                            return acc;
                        },
                        (s) -> {
                            Map<Boolean, List<String>> map = new HashMap<>();
                            map.put(true, new ArrayList<>());
                            map.put(false, new ArrayList<>());

                            s.forEach(el -> map.get(el.equals(new StringBuilder().append(el).reverse().toString())).add((String) el));

                            return map;
                        }
                ));

        Collectors.partitioningBy(word -> new StringBuilder().append(word).reverse().toString().equals(word));
    }

    static class PointToPointsCollector implements Collector<String, List<String>, Map<Boolean, List<String>>> {


        @Override
        public Supplier<List<String>> supplier() {
            return ArrayList::new;
        }

        @Override
        public BiConsumer<List<String>, String> accumulator() {
            return List::add;
        }

        @Override
        public BinaryOperator<List<String>> combiner() {
            return (acc, ps) -> {
                acc.addAll(ps);
                return acc;
            };
        }

        @Override
        public Function<List<String>, Map<Boolean, List<String>>> finisher() {
            return (s) -> {
                Map<Boolean, List<String>> map = new HashMap<>();
                map.put(true, new ArrayList<>());
                map.put(false, new ArrayList<>());

                s.forEach(el -> map.get(el.equals(new StringBuilder().append(el).reverse().toString())).add(el));

                return map;
            };
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
        }
    }
}