package org.generation.italy.exercise;

import java.util.Random;

public class Exercise9 {
    final static Random luck = new Random();
    public static void main(String[] args) {
        int righe = 5, colonne = 5;
        int[][] matriceA = new int[righe][colonne];
        int[][] matriceB = new int[righe][colonne];

        matriceA = populateArray(righe, colonne);
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++)
                System.out.printf("%-5d", matriceA[i][j]);
            System.out.println("");
        }
        System.out.println("");
        matriceB = populateArray(righe, colonne);
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++)
                System.out.printf("%-5d", matriceB[i][j]);
            System.out.println("");
        }


        int[][] C = prodottoMatrici(matriceA, matriceB);

        System.out.println("Risultato:");
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++)
                System.out.printf("%-5d", C[i][j]);
            System.out.println();
        }
    }
    public static int[][] populateArray(int r, int c){
        int [][] matrice = new int[r][c];
        for (int i = 0; i< matrice.length; i++){
            for (int j = 0; j < matrice[i].length; j++) {
                matrice [i] [j] = luck.nextInt(5);
            }
        }
        return matrice;
    }

    public static int[][] prodottoMatrici(int[][] A, int[][] B) {
        int righe = A.length;
        int colonne = A[0].length;
        int[][] risultato = new int[righe][colonne];

        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                risultato[i][j] = A[i][j] * B[i][j];
            }
        }
        return risultato;
    }

}