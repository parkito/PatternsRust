package com.coding.play.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task27 {

    static long countTriplets(List<Long> arr, long r) {
        long result = 0;
        Map<Long, Long> nMap = arr.stream()
                .filter(l -> l % r == 0 || l == 1)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final Set<Long> longs = new TreeSet<>(nMap.keySet());
        Long t1 = null, t2 = null, t3 = null;

        if (longs.size()<=1){
            return countTriplets1(arr, 1);
        }

        for (Long aLong : longs) {
            if (t1 == null) {
                t1 = aLong;
                continue;
            } else if (t2 == null) {
                t2 = aLong;
                continue;
            } else if (t3 == null) {
                t3 = aLong;
            }

            if (t2 == t1 * r && t3 == t2 * r) {
                result += nMap.get(t1) * nMap.get(t2) * nMap.get(t3);
            } else {
                t1 = t2;
                t2 = t3;
                t3 = null;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countTriplets1(Arrays.asList(1L, 1L, 1L, 1L, 1L, 1L, 1L,1L,1L), 1)); //84
        System.out.println(countTriplets(Arrays.asList(1L, 2L, 2L, 4L), 2)); //2
        System.out.println(countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3)); //6
        System.out.println(countTriplets(Arrays.asList(1L, 5L, 5L, 25L, 125L), 5)); //4
    }

    static long countTriplets1(List<Long> arr, long r) {
        long result = 0;
        List<Long> nArr = arr.stream()
                .filter(l -> l % r == 0 || l == 1)
                .collect(Collectors.toList());

        for (int i = 0; i < nArr.size(); i++) {
            Long t1 = nArr.get(i);
            for (int j = i + 1; j < nArr.size(); j++) {
                Long t2 = nArr.get(j);
                if (t2 > t1 * r) {
                    break;
                }
                if (t2 == t1 * r) {
                    for (int k = j + 1; k < nArr.size(); k++) {
                        if (nArr.get(k) > t2 * r) {
                            break;
                        }
                        if (nArr.get(k) == t2 * r) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
