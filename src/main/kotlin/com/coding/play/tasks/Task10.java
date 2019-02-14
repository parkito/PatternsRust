package com.coding.play.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Task10 {
    /**
     * The function accepts a list of mappers and returns an operator that accepts a list of integers
     * and sequentially applies each mapper to each value (perform a transformation)
     */
    public static final Function<List<IntUnaryOperator>, UnaryOperator<List<Integer>>> multifunctionalMapper = ol ->
            lst -> lst.stream()
                    .map(i -> {
                        int res = i;
                        for (IntUnaryOperator unaryOperator : ol) {
                            res = unaryOperator.applyAsInt(res);
                        }
                        return res;
                    })
                    .collect(Collectors.toList());


    public static final Function<List<IntUnaryOperator>, UnaryOperator<List<Integer>>> multifunctionalMapperBest =
            mappers -> list -> {
                List<Integer> transformedValues = new ArrayList<>();
                list.forEach((el) -> {
                    int curVal = el;
                    for (IntUnaryOperator mapper : mappers) {
                        curVal = mapper.applyAsInt(curVal);
                    }
                    transformedValues.add(curVal);
                });
                return transformedValues;
            };


    /**
     * EXAMPLE: the operator transforms each number to the same number (perform the identity transformation)
     * <p>
     * It returns a list of the same numbers.
     */
    public static final UnaryOperator<List<Integer>> identityTransformation = il -> il;

    /**
     * The operator accepts an integer list.
     * It multiplies by two each integer number and then add one to its.
     * <p>
     * The operator returns transformed integer list.
     */
    public static final UnaryOperator<List<Integer>> multTwoAndThenAddOneTransformation = il ->
            il.stream()
                    .map(i -> i * 2 + 1)
                    .collect(Collectors.toList());

    /**
     * The operator accepts an integer list.
     * It squares each integer number and then get the next even number following it.
     * <p>
     * The operator returns transformed integer list.
     */
    public static final UnaryOperator<List<Integer>> squareAndThenGetNextEvenNumberTransformation = il ->
            il.stream()
                    .map(i -> (i * i + 1) % 2 == 0 ? i * i + 1 : i * i + 2)
                    .collect(Collectors.toList());

}
