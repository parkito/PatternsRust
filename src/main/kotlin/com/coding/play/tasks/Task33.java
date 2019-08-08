package com.coding.play.tasks;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Task33 {

    static void dangerous(List<String>... stringLists) {
        List<String>[] stringLists1 = stringLists;
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists1;
        objects[0] = intList; // Heap pollution
        String s = stringLists[0].get(0); // ClassCastException
    }

    // UNSAFE - Exposes a reference to its generic parameter array!
    static <T> T[] toArray(T... args) {
        System.out.println(args[0].getClass()); //String
        System.out.println(args.getClass()); //Object
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError(); // Can't get here
    }

    public static void main(String[] args) {
        String[] attributes = pickTwo("Good", "Fast", "Cheap");
    }
}
