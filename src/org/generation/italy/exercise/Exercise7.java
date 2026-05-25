package org.generation.italy.exercise;

import com.generation.library.Console;
import java.util.Random;

public class Exercise7 {

    static Random random = new Random();

    static void main(){
        int n;
        System.out.println("inserisci un numero: ");
        n = Console.readInt();
        int[][] arrayBD = populateArray(n);
        for (int i = 0; i < arrayBD.length; i++) {
            for (int j = 0; j < arrayBD[i].length; j++) {
                System.out.printf("%-5s", arrayBD[i][j]);
            }
            System.out.println();
        }
    }
    public static int[][] populateArray(int n){
        int[][] array = new int[n][n];
        for (int i = 0; i< n; i++){
            for (int j = 0; j < n; j++){
                array[i][j] =  i == j ? random.nextInt(1000) : 0;
            }
        }
        return array;
    }
}
