package arreglos;

import java.util.Arrays;
import java.util.Random;

public class GestionArreglos {
    private final Random random = new Random();

    public void ejecutarEjercicios() {
        System.out.println("\n--- EJERCICIOS DE ARREGLOS ---");
        ejercicio1();
        ejercicio2();
        ejercicio3(5); // n = 5 aleatorios
        ejercicio4();
        ejercicio5();
    }

    private void ejercicio1() {
        int[] primos = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        System.out.println("1. Primos: " + Arrays.toString(primos));
    }
    private void ejercicio2() {
        int[] pares = new int[100];
        for (int i = 0; i < 100; i++) pares[i] = i * 2;
        System.out.println("2. Pares (línea única): " + Arrays.toString(pares));
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) System.out.print("\nFila " + (i/10 + 1) + ": ");
            System.out.print(pares[i] + " ");
        }
        System.out.println();
    }
    private void ejercicio3(int n) {
        int[] nums = new int[n];
        long[] factoriales = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(13); // Máximo 12 para evitar overflow de long
            factoriales[i] = calcularFactorial(nums[i]);
        }
        System.out.println("3. Números: " + Arrays.toString(nums));
        System.out.println("   Factoriales: " + Arrays.toString(factoriales));
    }
    private long calcularFactorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }
    private void ejercicio4() {
        int[] nums = random.ints(25, -50, 51).toArray();
        int min = Arrays.stream(nums).min().orElse(0);
        int max = Arrays.stream(nums).max().orElse(0);
        System.out.println("4. Arreglo (-50 a 50): " + Arrays.toString(nums));
        System.out.println("   Menor: " + min + " | Mayor: " + max);
    }
    private void ejercicio5() {
        int[] original = new int[20];
        int[] invertidos = new int[20];
        for (int i = 0; i < 20; i++) {
            original[i] = random.nextInt(900) + 100; // Números de 3 cifras
            invertidos[i] = invertirNumero(original[i]);
        }
        System.out.println("5. Originales: " + Arrays.toString(original));
        System.out.println("   Invertidos: " + Arrays.toString(invertidos));
    }
    private int invertirNumero(int n) {
        int inv = 0;
        while (n != 0) {
            inv = inv * 10 + n % 10;
            n /= 10;
        }
        return inv;
    }
}
