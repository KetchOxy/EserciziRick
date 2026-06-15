package org.generation.italy.battleship;

import com.generation.library.*;

public class PlayerGrid extends Grid {

    @Override
    public void stampaGriglia() {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(getCell(i, j) + "  ");
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void posizionaNavi(int[] lunghezze) {
        System.out.println("=== POSIZIONA LE TUE NAVI ===");
        for (int lunghezza : lunghezze) {
            boolean piazzata = false;
            while (!piazzata) {
                stampaGriglia();
                System.out.println("Posiziona nave di lunghezza: " + lunghezza);
                System.out.print("Riga (1-" + SIZE + "): ");
                int riga = Console.readInt() - 1;
                System.out.print("Colonna (1-" + SIZE + "): ");
                int colonna = Console.readInt() - 1;
                System.out.print("Orientamento (0=orizzontale, 1=verticale): ");
                boolean orizzontale = Console.readInt() == 0;

                piazzata = provaPiazzare(riga, colonna, lunghezza, orizzontale);
                if (!piazzata)
                    System.out.println("Posizione non valida, riprova.");
            }
        }
    }

    public int[] scegliBersaglio(Grid avversario) {
        while (true) {
            System.out.print("Spara! Riga (1-" + SIZE + "): ");
            int riga = Console.readInt() - 1;
            System.out.print("Spara! Colonna (1-" + SIZE + "): ");
            int colonna = Console.readInt() - 1;

            if (avversario.cellaValida(riga, colonna) && !avversario.cellaGiaSparata(riga, colonna))
                return new int[]{riga, colonna};

            System.out.println("Cella non valida o già sparata, riprova.");
        }
    }
}