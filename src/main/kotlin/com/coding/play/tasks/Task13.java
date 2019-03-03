package com.coding.play.tasks;

import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int element = scanner.nextInt();
        int result = 0;
        int arrEl;
        while (true) {
            arrEl = scanner.nextInt();
            if (arrEl == element) {
                result++;
            }
            if (arrEl == 0) {
                break;
            }
        }
        System.out.println(result);

        //best sol

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt(), count = 0;
        while (scan.hasNextInt()) if (a == scan.nextInt()) count++;
        System.out.println(count);
    }
}

//import java.util.*;
//class Main {
//    public static void main(String[] args) {
//        int sum = 0, cur = 0;
//        try(Scanner sc = new Scanner(System.in)){
//            while ((cur = sc.nextInt())!=0){
//                sum+=cur;
//            }
//        }
//        System.out.println(sum);
//    }
//}

