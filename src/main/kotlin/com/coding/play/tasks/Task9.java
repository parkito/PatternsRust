package com.coding.play.tasks;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Task9{
    public static void main(String[] args) {
        BiFunction<Integer, Integer, BiFunction<Integer, Integer, Function<Integer, Integer>>> a =
                (arg1, arg2) -> (arg3, arg4) -> (arg5) -> arg1 + arg2 + arg3 + arg4 + arg5;
    }
}
