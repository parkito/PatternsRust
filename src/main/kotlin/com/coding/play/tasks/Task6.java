package com.coding.play.tasks;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task6 {
    public static void main(String[] args) {
        System.out.println(Stream.of(1, 2).collect(Collectors.reducing(1, (a, b) -> a * b * b)));
    }
}
