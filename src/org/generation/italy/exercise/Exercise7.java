package org.generation.italy.exercise;

import com.generation.library.Console;

public class Exercise7 {
    static void main(){
        int n;
        System.out.println("inserisci un numero: ");
        n = Console.readInt();
        int[][] arrayBD = populateArray(n);
    }
    public static int[][] populateArray(int n){
        int[][] array = new int[n][n];

        return array;
    }
}
