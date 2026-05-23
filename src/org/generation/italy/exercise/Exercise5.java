package org.generation.italy.exercise;

import com.generation.library.*;

public class Exercise5 {
    static void main(){
        int n;
        System.out.println("inserisci un numero: ");
        n = Console.readInt();
        int nFattoriale=fattorialeDiN(n);
        System.out.println("Il fattoriale di " + n + " e' " + nFattoriale);
    }
    public static int fattorialeDiN(int n){
        for (int i = n-1; i > 0;i--){
            n = n*i;
        }
        return n;
    }
}
