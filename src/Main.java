
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        // 1. Ingreso de datos
        System.out.print("Ingrese la cantidad de numeros a ordenar: ");
        int n = sc.nextInt();
        int[] datos = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el numero " + (i + 1) + ": ");
            datos[i] = sc.nextInt();
        }

        // 2. Copias para cada tipo de ordenamiento
        int[] datosSecuencial = Arrays.copyOf(datos, datos.length);
        int[] datosParalelo = Arrays.copyOf(datos, datos.length);

        // 3. Ordenamiento secuencial
        long inicio = System.currentTimeMillis();
        OrdenamientoSecuencial.ordenar(datosSecuencial);
        long fin = System.currentTimeMillis();
        System.out.println("\nResultado ordenado (Secuencial): " + Arrays.toString(datosSecuencial));
        System.out.println("Tiempo (ms): " + (fin - inicio));

        // 4. Ordenamiento paralelo (2 hilos)
        int medio = datosParalelo.length / 2;
        Thread t1 = new Thread(new OrdenadorHilo(datosParalelo, 0, medio));
        Thread t2 = new Thread(new OrdenadorHilo(datosParalelo, medio, datosParalelo.length));

        inicio = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // Fusión final
        OrdenamientoSecuencial.ordenar(datosParalelo); // Puedes cambiar esto por merge sort
        fin = System.currentTimeMillis();

        System.out.println("\nResultado ordenado (Paralelo):   " + Arrays.toString(datosParalelo));
        System.out.println("Tiempo (ms): " + (fin - inicio));
    }
}
