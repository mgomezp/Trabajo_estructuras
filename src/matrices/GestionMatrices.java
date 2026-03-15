package matrices;

import java.util.Random;

public class GestionMatrices {
    private final Random random = new Random();

    public void ejecutarEjercicios() {
        System.out.println("\n--- EJERCICIOS DE MATRICES ---");
        ejercicio11(4, 4);
        ejercicio12(3);
        ejercicio13(3);
        ejercicio14(3, 2);
        ejercicio15(3, 3);
    }

    private void ejercicio11(int m, int n) {
        int[][] mat = generarMatriz(m, n, 50);
        int buscar = 10;
        System.out.println("11. Buscando el 10 en matriz...");
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(mat[i][j] == buscar) {
                    System.out.println("    Encontrado en: ["+i+"]["+j+"]");
                    return;
                }
        System.out.println("    No se encontró el número.");
    }

    private void ejercicio12(int n) {
        int[][] mat = new int[n][n];
        int suma = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                mat[i][j] = random.nextInt(101) - 50;
                if(i + j == n - 1) suma += mat[i][j];
            }
        }
        System.out.println("12. Suma diagonal opuesta: " + suma);
    }

    private void ejercicio13(int n) {
        int[][] mat = {{1,2,3},{2,1,4},{3,4,1}}; // Simétrica
        boolean sim = true;
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                if(mat[i][j] != mat[j][i]) sim = false;
        
        System.out.println("13. ¿Es simétrica?: " + sim);
        System.out.println("    Esquinas: " + mat[0][0] + ", " + mat[0][n-1] + ", " + mat[n-1][0] + ", " + mat[n-1][n-1]);
    }

    private void ejercicio14(int m, int n) {
        int[][] mat = {{1, 2}, {3, 4}, {5, 6}};
        int[][] trans = new int[n][m];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                trans[j][i] = mat[i][j];
        System.out.println("14. Transpuesta generada con éxito.");
    }
    private void ejercicio15(int m, int n) {
        int[][] mat = generarMatriz(m, n, 100);
        System.out.println("15. Intercambiando fila 1 y 2...");
        int[] temp = mat[0];
        mat[0] = mat[1];
        mat[1] = temp;
        System.out.println("    Intercambio realizado.");
    }
    private int[][] generarMatriz(int m, int n, int limite) {
        int[][] mat = new int[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                mat[i][j] = random.nextInt(limite);
        return mat;
    }

}
