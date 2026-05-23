package org.generation.italy.exercise;

import java.util.Random;


public class Exercise1 {
    final static Random luck = new Random();

    static void main() {
        int n1 = luck.nextInt(1000);
        System.out.println(n1);
        int n2 = luck.nextInt(1000);
        System.out.println(n2);
        int somma = n1 + n2;
        System.out.println(somma);
    }
}
