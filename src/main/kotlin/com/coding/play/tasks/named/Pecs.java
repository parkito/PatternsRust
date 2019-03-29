package com.coding.play.tasks.named;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pecs {

    class A0 {
        void doA0() {

        }
    }

    class A extends A0 {
        void doA() {

        }
    }

    class B extends A {
        void doB() {

        }
    }

    class C<T> {
    }

    public static void main(String[] args) {
        List<? extends A> producer = new ArrayList<>();
        producer.get(0).doA0();
        producer.get(0).doA();

        List<? super A> consumer = new ArrayList<>();
        consumer.get(0);//no methods. We just store data


//        funA(new ArrayList<A0>());
        funA(new ArrayList<A>());
        funA(new ArrayList<B>());


        funB(new ArrayList<A0>());
        funB(new ArrayList<A>());
//        funB(new ArrayList<B>());
    }

    private static void funA(List<? extends A> collection) {
        collection.get(0).doA0();
        collection.get(0).doA();

    }

    private static void funB(List<? super A> collection) {
        collection.get(0);
    }
}
