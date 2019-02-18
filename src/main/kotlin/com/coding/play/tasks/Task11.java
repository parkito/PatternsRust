package com.coding.play.tasks;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Task11 {
    /**
     * The operator combines all values in the given range into one value
     * using combiner and initial value (seed)
     */
    public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator = (i, o) ->
            (l, r) -> IntStream.rangeClosed(i, r).reduce(i, o);

    /**
     * The operator calculates the sum in the given range (inclusively)
     */
    public static final IntBinaryOperator sumOperator = reduceIntOperator.apply(1, (a, b) -> a + b);

    /**
     * The operator calculates the product in the given range (inclusively)
     */
    public static final IntBinaryOperator productOperator = reduceIntOperator.apply(1, (a, b) -> a * b);


//    public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator =
//            (seed, combiner) ->
//                    (l, r) -> {
//                        int acc = seed;
//                        for (int el = l; el <= r; el++) {
//                            acc = combiner.applyAsInt(acc, el);
//                        }
//                        return acc;
//                    };
//
//    public static final IntBinaryOperator sumOperator = reduceIntOperator.apply(0, (x, y) -> x + y);
//
//    public static final IntBinaryOperator productOperator = reduceIntOperator.apply(1, (x, y) -> x * y);
}
