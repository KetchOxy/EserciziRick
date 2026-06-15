package org.generation.italy.battleship;

public abstract class Grid {

    public static final int SIZE = 8;
    protected static final char EMPTY = '?';
    protected static final char SHIP  = 'N';
    protected static final char HIT   = 'X';
    protected static final char MISS  = 'O';

    private char[][] cells;

    public Grid() {
        cells = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                cells[i][j] = EMPTY;
    }

    // --- Accesso incapsulato alle celle ---

    protected char getCell(int r, int c) {
        return cells[r][c];
    }

    public boolean cellaValida(int r, int c) {
        return r >= 0 && r < SIZE && c >= 0 && c < SIZE;
    }

    public boolean cellaGiaSparata(int r, int c) {
        return cells[r][c] == HIT || cells[r][c] == MISS;
    }

    // --- Logica comune ---

    public String riceviBomba(int r, int c) {
        if (cells[r][c] == SHIP) {
            cells[r][c] = HIT;
            return "Colpito!";
        }
        cells[r][c] = MISS;
        return "Mancato!";
    }

    public boolean tutteAffondate() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (cells[i][j] == SHIP) return false;
        return true;
    }

    protected boolean provaPiazzare(int riga, int colonna, int lunghezza, boolean orizzontale) {
        if (orizzontale && colonna + lunghezza > SIZE) return false;
        if (!orizzontale && riga + lunghezza > SIZE) return false;

        for (int k = 0; k < lunghezza; k++) {
            int r = orizzontale ? riga : riga + k;
            int c = orizzontale ? colonna + k : colonna;
            if (cells[r][c] != EMPTY) return false;
        }

        for (int k = 0; k < lunghezza; k++) {
            int r = orizzontale ? riga : riga + k;
            int c = orizzontale ? colonna + k : colonna;
            cells[r][c] = SHIP;
        }
        return true;
    }

    // --- Contratto astratto specializzato dalle sottoclassi ---

    public abstract void posizionaNavi(int[] lunghezze);

    public abstract void stampaGriglia();
}