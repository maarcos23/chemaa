package meteo;

public class SensorTemperatura implements Runnable {
    private int[] grados;
    private double maxima;
    private double minima;
    private double media;

    public SensorTemperatura(int[] grados) {
        this.grados = grados;
    }

    public double getMaxima() { return maxima; }
    public double getMinima() { return minima; }
    public double getMedia() { return media; }

    @Override
    public void run() {
        String nombre = Thread.currentThread().getName();
        int prioridad = Thread.currentThread().getPriority();
        System.out.println(nombre + " empieza (prioridad " + prioridad + ")");

        maxima = grados[0];
        minima = grados[0];
        int suma = 0;

        try {
            for (int i = 0; i < grados.length; i++) {
                Thread.sleep(100);
                
                if (grados[i] > maxima) maxima = grados[i];
                if (grados[i] < minima) minima = grados[i];
                suma += grados[i];

                if ((i + 1) % 6 == 0) {
                    System.out.println(nombre + ": " + (i + 1) + " horas procesadas.");
                }
            }
        } catch (InterruptedException e) {
            System.out.println(nombre + " fue interrumpido.");
        }

        media = Math.round(suma * 10.0 / 24) / 10.0;
        System.out.println(nombre + " termina: máx " + maxima + ", mín " + minima + ", media " + media);
    }
}