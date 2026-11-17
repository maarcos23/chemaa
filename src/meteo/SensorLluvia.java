package meteo;

public class SensorLluvia implements Runnable {
    private int[] litros;
    private int total = 0;
    private int horasConLluvia = 0;
    private int rachaMaxima = 0;

    public SensorLluvia(int[] litros) {
        this.litros = litros;
    }

    public int getTotal() { return total; }
    public int getHorasConLluvia() { return horasConLluvia; }
    public int getRachaMaxima() { return rachaMaxima; }

    @Override
    public void run() {
        String nombre = Thread.currentThread().getName();
        int prioridad = Thread.currentThread().getPriority();
        System.out.println(nombre + " empieza (prioridad " + prioridad + ")");

        int rachaActual = 0;

        try {
            for (int i = 0; i < litros.length; i++) {
                Thread.sleep(100);
                
                total += litros[i];
                if (litros[i] > 0) {
                    horasConLluvia++;
                    rachaActual++;
                    if (rachaActual > rachaMaxima) {
                        rachaMaxima = rachaActual;
                    }
                } else {
                    rachaActual = 0;
                }

                if ((i + 1) % 6 == 0) {
                    System.out.println(nombre + ": " + (i + 1) + " horas procesadas.");
                }
            }
        } catch (InterruptedException e) {
            System.out.println(nombre + " fue interrumpido.");
        }

        System.out.println(nombre + " termina: " + total + " l/m2, " + horasConLluvia + " horas con lluvia, racha máxima " + rachaMaxima + " h.");
    }
}