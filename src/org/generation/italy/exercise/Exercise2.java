package org.generation.italy.exercise;

import java.util.Random;


public class Exercise2 {
    final static Random luck = new Random();

    static void main(){
        int n1= luck.nextInt(1000);
        System.out.println(n1);
        int n2 = luck.nextInt(1000);
        System.out.println(n2);
        int somma =  addNumbers(n1, n2);
        System.out.println(somma);
    }
    static int addNumbers(int i, int y){
        int sum = i+y;
        return sum;
    }
}