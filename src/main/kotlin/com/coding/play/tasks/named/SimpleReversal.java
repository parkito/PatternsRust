package com.coding.play.tasks.named;

import java.util.stream.IntStream;

public class SimpleReversal {

    public static int[] reverseLambda(int[] a) {
        return IntStream.range(0, a.length)
                .map(i -> a[a.length - 1 - i])
                .toArray();
    }

    public static int[] reverse(int[] a) {
        for (int i = 0, j = a.length - 1; i <= j; i++, j--) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        return a;
    }
}
