package com.coding.play.tasks;

import java.util.List;

public class Task32 {

    class A {
        public void doA() {
            System.out.println("A");
        }
    }

    class B extends A {
        public void doB() {
            System.out.println("B");
        }
    }

    class C extends B {
        public void doC() {
            System.out.println("C");
        }
    }

    public static void main(String[] args) {

    }

    public A producer(List<? extends A> list, A a) {
        list.get(0).doA();
//        list.add(a) fail
        return list.get(0);
    }

    public B consumer(List<? super B> list, B b) {
        list.add(b);
//        list.get(0).doA() fail
//        return list.get(0); fail
        return b;
    }

    public B combine(List<? super C> list, C c) {
        list.add(c);
//        return list.get(0);
        return c;
    }
}
