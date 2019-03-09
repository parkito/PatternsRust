package com.coding.play.tasks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Task18 {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.offer("a");
        queue.offer("c");
        queue.offer("b");

        String name = queue.peek();
        String name1 = queue.poll();
        String name2 = queue.poll();
        queue.offer(name);

        queue.forEach(System.out::print);

        Deque<String> states = new ArrayDeque<String>();
        states.add("Germany");
        states.add("France");
        states.push("UK");
        states.offerLast("Norway");

        String sFirst = states.pop();
        String s = states.peek();
        String sLast = states.peekLast();
        states.offer(sFirst);
        String s1 = states.pollLast();

        while (states.peek() != null) {
            System.out.print(states.pop());
        }
    }
}
