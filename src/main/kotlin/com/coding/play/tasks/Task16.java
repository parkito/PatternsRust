package com.coding.play.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Task16 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        ListIterator<String> iterator = list.listIterator();

        for (String str : reader.readLine().split(" ")) {
            if (str.startsWith("J")) {
                iterator.add(str.replace("J", ""));
            }
        }

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}

/*
* public static void main(String[] args) throws IOException {
    new BufferedReader(new InputStreamReader(System.in)).lines()
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .filter(s -> s.startsWith("J"))
                .map(s -> s.substring(1))
                .collect(LinkedList<String>::new, LinkedList::push, (l1, l2) -> {})
                .forEach(System.out::println);
}*/