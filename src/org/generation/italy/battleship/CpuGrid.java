package org.generation.italy.battleship;

import java.util.Random;

public class CpuGrid extends Grid {

    private final Random random = new Random();

    @Override
    public void stampaGriglia() {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                char cell = getCell(i, j);
                System.out.print((cell == SHIP ? EMPTY : cell) + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void posizionaNavi(int[] lunghezze) {
        for (int lunghezza : lunghezze) {
            boolean piazzata = false;
            while (!piazzata) {
                int riga = random.nextInt(SIZE);
                int colonna = random.nextInt(SIZE);
                boolean orizzontale = random.nextBoolean();
                piazzata = provaPiazzare(riga, colonna, lunghezza, orizzontale);
            }
        }
    }

    public int[] scegliBersaglio(Grid avversario) {
        int riga, colonna;
        do {
            riga = random.nextInt(SIZE);
            colonna = random.nextInt(SIZE);
        } while (avversario.cellaGiaSparata(riga, colonna));
        return new int[]{riga, colonna};
    }
}