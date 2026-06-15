package org.generation.italy.battleship;

public class BattleshipGame {

    private static final int[] LUNGHEZZE_NAVI = {3, 2, 2, 1, 1, 1};

    public static void main(String[] args) {
        PlayerGrid playerGrid = new PlayerGrid();
        CpuGrid cpuGrid = new CpuGrid();

        playerGrid.posizionaNavi(LUNGHEZZE_NAVI);
        cpuGrid.posizionaNavi(LUNGHEZZE_NAVI);

        System.out.println("\n=== BATTAGLIA NAVALE ===");

        while (true) {
            System.out.println("--- La tua griglia ---");
            playerGrid.stampaGriglia();   // mostra tutto
            System.out.println("--- Griglia nemica ---");
            cpuGrid.stampaGriglia();      // nasconde le navi

            // Turno giocatore
            int[] bersaglio = playerGrid.scegliBersaglio(cpuGrid);
            System.out.println(cpuGrid.riceviBomba(bersaglio[0], bersaglio[1]));

            if (cpuGrid.tutteAffondate()) {
                System.out.println("--- Griglia nemica (rivelata) ---");
                cpuGrid.stampaGriglia();
                System.out.println("Hai affondato tutte le navi nemiche! Hai vinto!");
                break;
            }

            // Turno computer
            int[] bersaglioCpu = cpuGrid.scegliBersaglio(playerGrid);
            String risultato = playerGrid.riceviBomba(bersaglioCpu[0], bersaglioCpu[1]);
            System.out.println("Il computer ha sparato in ("
                    + (bersaglioCpu[0] + 1) + "," + (bersaglioCpu[1] + 1) + "): " + risultato);

            if (playerGrid.tutteAffondate()) {
                System.out.println("--- La tua griglia ---");
                playerGrid.stampaGriglia();
                System.out.println("Il computer ha affondato tutte le tue navi! Hai perso!");
                break;
            }
        }
    }
}