package arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;                                                                
import java.util.Map;
import java.util.Random;

public class GestionArrayLists {
    private final Random random = new Random();

    public void ejecutarEjercicios(String rawData) {
        System.out.println("\n--- EJERCICIOS DE ARRAYLIST ---");
        ejercicio6();
        ejercicio7();
        ejercicio8();
        ejercicio9();
        ejercicio10(rawData);
    }
    private void ejercicio6() {
        ArrayList<Integer> lista = new ArrayList<>();
        int n, suma = 0;
        do {
            n = random.nextInt(21) - 10;
            lista.add(n);
            suma += n;
        } while (n != 10);
        System.out.println("6. Lista: " + lista);
        System.out.println("   Suma: " + suma + " | Media: " + (double)suma/lista.size());
    }
    private void ejercicio7() {
        ArrayList<Integer> pares = new ArrayList<>();
        for (int i = 0; i < 20; i++) pares.add(i * 2);
        System.out.println("7. Inicial: " + pares);
        
        int nuevo = 15; // Simulación de lectura
        int pos = 0;
        while (pos < pares.size() && pares.get(pos) < nuevo) pos++;
        pares.add(pos, nuevo);
        System.out.println("   Insertado 15: " + pares);
        
        pares.remove(Integer.valueOf(15));
        System.out.println("   Retirado 15: " + pares);
    }
    private void ejercicio8() {
        ArrayList<Integer> nums = new ArrayList<>();
        Map<Integer, Integer> frec = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            int n = random.nextInt(20) + 1;
            nums.add(n);
            frec.put(n, frec.getOrDefault(n, 0) + 1);
        }
        System.out.println("8. Tabla de Frecuencias: " + frec);
        int moda = Collections.max(frec.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("   Número más frecuente: " + moda);
    }
    private void ejercicio9() {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 20; i++) nums.add(random.nextInt(100) + 1);
        
        Collections.sort(nums);
        System.out.println("9. Menor a mayor: " + nums);
        Collections.reverse(nums);
        System.out.println("   Mayor a menor: " + nums);
        
        ArrayList<Integer> p = new ArrayList<>(), im = new ArrayList<>();
        for(int n : nums) if(n % 2 == 0) p.add(n); else im.add(n);
        System.out.println("   Pares: " + p + "\n   Impares: " + im);
    }
    private void ejercicio10(String data) {
        ArrayList<Partido> partidos = new ArrayList<>();
        for (String linea : data.split("\n")) {
            if (!linea.trim().isEmpty() && !linea.startsWith("[")) {
                partidos.add(new Partido(linea));
            }
        }

        System.out.println("10. Visitantes ganadores:");
        partidos.stream().filter(Partido::ganoVisitante).limit(5).forEach(System.out::println);

        long barna = partidos.stream().filter(p -> 
            (p.getLocal().equals("Barcelona") && p.ganoLocal()) || 
            (p.getVisitante().equals("Barcelona") && p.ganoVisitante())).count();
        System.out.println("    Barcelona ganó: " + barna + " veces.");

        long localGana = partidos.stream().filter(Partido::ganoLocal).count();
        System.out.println("    Partidos ganados por locales: " + localGana);

        partidos.removeIf(p -> !p.esEmpate());
        System.out.println("    Partidos tras eliminar no empates: " + partidos.size());
    }
}
