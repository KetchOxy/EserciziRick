package org.generation.italy.exercise;

public class Exercise4 {
    static void main() {
        System.out.println(readYesOrNo());
    }

        public static String readYesOrNo() {
            String input;
            do {
                input = IO.readln("Inserisci yes o no: ");
            } while (!input.equals("yes") && !input.equals("no"));
            return input;
        }

}
