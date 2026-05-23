package org.generation.italy.exercise;

import com.generation.library.*;
import java.util.Random;

public class Exercise10 {

    static char[][] griglia = new char[3][3];
    static Random random = new Random();

    public static void main(String[] args) {
        inizializzaGriglia();
        System.out.println("=== GIOCO DEL TRIS ===");
        System.out.println("Tu sei X, il computer è O");

        while (true) {
            stampaGriglia();

            turnoGiocatore();
            if (controllaVittoria('X')) {
                stampaGriglia();
                System.out.println("Hai vinto!");
                break;
            }
            if (pareggio()) {
                stampaGriglia();
                System.out.println("Pareggio!");
                break;
            }

            turnoComputer();
            if (controllaVittoria('O')) {
                stampaGriglia();
                System.out.println("Ha vinto il computer!");
                break;
            }
            if (pareggio()) {
                stampaGriglia();
                System.out.println("Pareggio!");
                break;
            }
        }
    }

    static void inizializzaGriglia() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                griglia[i][j] = '?';
    }

    static void stampaGriglia() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(griglia[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    static void turnoGiocatore() {
        int riga, colonna;
        while (true) {
            System.out.print("Inserisci riga (1-3): ");
            riga = Console.readInt() - 1;
            System.out.print("Inserisci colonna (1-3): ");
            colonna = Console.readInt() - 1;

            if (riga >= 0 && riga < 3 && colonna >= 0 && colonna < 3 && griglia[riga][colonna] == '?') {
                griglia[riga][colonna] = 'X';
                break;
            }
            System.out.println("Cella non valida o già occupata, riprova.");
        }
    }

    static void turnoComputer() {
        int riga, colonna;
        do {
            riga = random.nextInt(3);
            colonna = random.nextInt(3);
        } while (griglia[riga][colonna] != '?');

        griglia[riga][colonna] = 'O';
        System.out.println("Il computer ha scelto: riga " + (riga + 1) + ", colonna " + (colonna + 1));
    }


    static boolean controllaVittoria(char s) {
            // 3 righe
        if (griglia[0][0] == s && griglia[0][1] == s && griglia[0][2] == s) return true;
        if (griglia[1][0] == s && griglia[1][1] == s && griglia[1][2] == s) return true;
        if (griglia[2][0] == s && griglia[2][1] == s && griglia[2][2] == s) return true;

            // 3 colonne
        if (griglia[0][0] == s && griglia[1][0] == s && griglia[2][0] == s) return true;
        if (griglia[0][1] == s && griglia[1][1] == s && griglia[2][1] == s) return true;
        if (griglia[0][2] == s && griglia[1][2] == s && griglia[2][2] == s) return true;

            // 2 diagonali
        if (griglia[0][0] == s && griglia[1][1] == s && griglia[2][2] == s) return true;
        if (griglia[0][2] == s && griglia[1][1] == s && griglia[2][0] == s) return true;

            return false;
        }


    static boolean pareggio() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (griglia[i][j] == '?') return false;
        return true;
    }
}