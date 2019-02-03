package com.coding.play.tasks;

import kotlin.ranges.LongRange;

import java.util.stream.LongStream;

public class Task4 {
    public static LongStream createPrimesFilteringStream(long rangeBegin, long rangeEnd) {
        return LongStream.rangeClosed(rangeBegin, rangeEnd).filter(n -> isPrime(n));
    }

    public static boolean isPrime(long n) {
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
