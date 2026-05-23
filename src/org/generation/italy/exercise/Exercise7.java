package org.generation.italy.exercise;

import com.generation.library.Console;

public class Exercise7 {
    static void main(){
        int n;
        System.out.println("inserisci un numero: ");
        n = Console.readInt();
        int[][] arrayBD = populateArray(n);
        for (int j = 0; j < arrayBD.length; j++) {
            for (int i = 0; i < arrayBD.length; i++) {
                System.out.printf("%-5s", arrayBD[i][j]);
            }
            System.out.println();
        }
    }
    public static int[][] populateArray(int n){
        int[][] array = new int[n][n];
        for (int i = 0; i< n; i++){
            for (int j = 0; j < n; j++){
                array[i][j] =  i == j ? 1 : 0;
            }
        }
        return array;
    }
}
