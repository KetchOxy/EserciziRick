package org.generation.italy.exercise;

import com.generation.library.*;
import java.util.Random;

public class Exercise11 {

    static char[][] grigliaComputer = new char[8][8];
    static char[][] grigliaGiocatore = new char[8][8];
    static Random random = new Random();
    static int[] lunghezzeNavi = {3, 2, 2, 1, 1, 1};

    static void main(String[] args) {
        inizializzaGriglia(grigliaComputer);
        inizializzaGriglia(grigliaGiocatore);

        posizionaNaviRandom(grigliaComputer);
        posizionaNaviGiocatore();

        System.out.println("=== BATTAGLIA NAVALE ===");

        while (true) {
            System.out.println("--- La tua griglia ---");
            stampaGriglia(grigliaGiocatore);
            System.out.println("--- Griglia nemica ---");
            stampaGrigliaNascostaComputer();

            turnoGiocatore();
            if (tutteAffondate(grigliaComputer)) {
                System.out.println("--- Griglia nemica ---");
                stampaGriglia(grigliaComputer);
                System.out.println("Hai affondato tutte le navi nemiche! Hai vinto!");
                break;
            }

            turnoComputer();
            if (tutteAffondate(grigliaGiocatore)) {
                System.out.println("--- La tua griglia ---");
                stampaGriglia(grigliaGiocatore);
                System.out.println("Il computer ha affondato tutte le tue navi! Hai perso!");
                break;
            }
        }
    }

    static void inizializzaGriglia(char[][] griglia) {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                griglia[i][j] = '?';
    }

    static void stampaGriglia(char[][] griglia) {
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                System.out.print(griglia[i][j] + "  ");
            System.out.println();
        }
        System.out.println();
    }


    static void stampaGrigliaNascostaComputer() {
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (grigliaComputer[i][j] == 'N')
                    System.out.print("? ");
                else
                    System.out.print(grigliaComputer[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }


    static void posizionaNaviRandom(char[][] griglia) {
        for (int i = 0; i < lunghezzeNavi.length; i++) {
            int lunghezza = lunghezzeNavi[i];
            boolean piazzata = false;
            while (!piazzata) {
                int riga = random.nextInt(8);
                int colonna = random.nextInt(8);
                boolean orizzontale = random.nextBoolean();
                piazzata = prova_a_piazzare(griglia, riga, colonna, lunghezza, orizzontale);
            }
        }
    }

    static void posizionaNaviGiocatore() {
        System.out.println("=== POSIZIONA LE TUE NAVI ===");
        for (int i = 0; i < lunghezzeNavi.length; i++) {
            int lunghezza = lunghezzeNavi[i];
            boolean piazzata = false;
            while (!piazzata) {
                stampaGriglia(grigliaGiocatore);
                System.out.println("Posiziona nave di lunghezza: " + lunghezza);
                System.out.print("Riga (1-8): ");
                int riga = Console.readInt() - 1;
                System.out.print("Colonna (1-8): ");
                int colonna = Console.readInt() - 1;
                System.out.print("Orientamento (0=orizzontale, 1=verticale): ");
                boolean orizzontale = Console.readInt() == 0;

                piazzata = prova_a_piazzare(grigliaGiocatore, riga, colonna, lunghezza, orizzontale);
                if (!piazzata)
                    System.out.println("Posizione non valida, riprova.");
            }
        }
    }


    static boolean prova_a_piazzare(char[][] griglia, int riga, int colonna, int lunghezza, boolean orizzontale) {

        if (orizzontale && colonna + lunghezza > 8) return false;
        if (!orizzontale && riga + lunghezza > 8) return false;

        for (int k = 0; k < lunghezza; k++) {
            int r = orizzontale ? riga : riga + k;
            int c = orizzontale ? colonna + k : colonna;
            if (griglia[r][c] != '?') return false;
        }

        for (int k = 0; k < lunghezza; k++) {
            int r = orizzontale ? riga : riga + k;
            int c = orizzontale ? colonna + k : colonna;
            griglia[r][c] = 'N';
        }
        return true;
    }

    static void turnoGiocatore() {
        int riga, colonna;
        while (true) {
            System.out.print("Spara! Riga (1-8): ");
            riga = Console.readInt() - 1;
            System.out.print("Spara! Colonna (1-8): ");
            colonna = Console.readInt() - 1;

            if (riga >= 0 && riga < 8 && colonna >= 0 && colonna < 8
                    && grigliaComputer[riga][colonna] != 'X'
                    && grigliaComputer[riga][colonna] != 'O') {
                if (grigliaComputer[riga][colonna] == 'N') {
                    grigliaComputer[riga][colonna] = 'X';
                    System.out.println("Colpito!");
                } else {
                    grigliaComputer[riga][colonna] = 'O';
                    System.out.println("Mancato!");
                }
                break;
            }
            System.out.println("Cella non valida o già sparata, riprova.");
        }
    }

    static void turnoComputer() {
        int riga, colonna;
        do {
            riga = random.nextInt(8);
            colonna = random.nextInt(8);
        } while (grigliaGiocatore[riga][colonna] == 'X' || grigliaGiocatore[riga][colonna] == 'O');

        if (grigliaGiocatore[riga][colonna] == 'N') {
            grigliaGiocatore[riga][colonna] = 'X';
            System.out.println("Il computer ha sparato in (" + (riga+1) + "," + (colonna+1) + "): Colpito!");
        } else {
            grigliaGiocatore[riga][colonna] = 'O';
            System.out.println("Il computer ha sparato in (" + (riga+1) + "," + (colonna+1) + "): Mancato!");
        }
    }

    static boolean tutteAffondate(char[][] griglia) {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (griglia[i][j] == 'N') return false;
        return true;
    }
}
