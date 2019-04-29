package com.coding.play.tasks;

import java.util.Arrays;
import java.util.List;

public class Task27 {

    static long countTriplets(List<Long> arr, long r) {
        long result = 0;
        for (int i = 0; i < arr.size(); i++) {
            Long t1 = arr.get(i);
            for (int j = i + 1; j < arr.size(); j++) {
                Long t2 = arr.get(j);
                if (t2 == t1 * r) {
                    for (int k = j + 1; k < arr.size(); k++) {
                        if (arr.get(k) == t2 * r) {
                            System.out.println((i + 1) + " " + (j + 1) + " " + (k + 1));
                            result++;
//                            break;
                        }
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(countTriplets(Arrays.asList(1L, 2L, 2L, 4L), 2)); //2
        System.out.println(countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3)); //6
        System.out.println(countTriplets(Arrays.asList(1L, 5L, 5L, 25L, 125L), 5)); //4
    }
}
