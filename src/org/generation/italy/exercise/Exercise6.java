package org.generation.italy.exercise;

import com.generation.library.*;

public class Exercise6 {
    static void main(){
        int n;
        System.out.println("inserisci un numero: ");
        n = Console.readInt();
        int[] result = fibonacci(n);
        for (int i = 0; i < result.length; i++) {
            IO.print(result[i] + ", ");
        }

    }
    public static int[] fibonacci(int n) {
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib;
    }
}