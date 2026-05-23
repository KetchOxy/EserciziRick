package org.generation.italy.exercise;

public class Exercise3 {
    static void main(){
        String stringa1 = IO.readln("Inserisci la prima stringa");
        String stringa2 = IO.readln("Inserisci la seconda stringa");;
        String input = IO.readln("Inserisci il carattere: ");
        char c = input.charAt(0);
        boolean result = containsMoreTimes(stringa1, stringa2, c);
        IO.println("Risultato: " + result);



    }
    public static boolean containsMoreTimes(String first, String second, char c) {
        int countFirst = 0;
        int countSecond = 0;

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == c) {
                countFirst++;
            }
        }

        for (int i = 0; i < second.length(); i++) {
            if (second.charAt(i) == c) {
                countSecond++;
            }
        }

        return countFirst > countSecond;
    }
}
