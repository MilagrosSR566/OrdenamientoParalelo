
public class OrdenadorHilo implements Runnable {
    private int[] arreglo;
    private int inicio, fin;

    public OrdenadorHilo(int[] arreglo, int inicio, int fin) {
        this.arreglo = arreglo;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int i = inicio; i < fin - 1; i++) {
            for (int j = inicio; j < fin - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }
}
