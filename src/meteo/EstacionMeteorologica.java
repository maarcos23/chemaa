package meteo;

// Autor: [Tu Nombre]
public class EstacionMeteorologica {
    public static void main(String[] args) {
        // Datos base (Caso 1)
        int[] grados = {-2, -3, -3, -4, -4, -3, -2, 0, 1, 3, 4, 5,
        		6, 6, 5, 4, 3, 2, 1, 0, -1, -1, -2, -2};
        int[] litros = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        		0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 1, 0};
        SensorTemperatura sTemp = new SensorTemperatura(grados);
        SensorLluvia sLluvia = new SensorLluvia(litros);
        GeneradorAlertas sAlertas = new GeneradorAlertas(sTemp, sLluvia);

        Thread hTemperatura = new Thread(sTemp, "Temperatura");
        hTemperatura.setPriority(Thread.MAX_PRIORITY);

        Thread hLluvia = new Thread(sLluvia, "Lluvia");
        hLluvia.setPriority(Thread.MIN_PRIORITY);

        Thread hAlertas = new Thread(sAlertas, "Alertas");
        hAlertas.setPriority(Thread.NORM_PRIORITY);

        hTemperatura.start();
        hLluvia.start();

        try {
            hTemperatura.join();
            hLluvia.join();
            
            System.out.println("Sensores: " + hTemperatura.getState() + " y " + hLluvia.getState() + ". Alertas está " + hAlertas.getState() + ": se le da la orden.");
            
            hAlertas.start();
            hAlertas.join();

            System.out.println("=== Parte del día ===");
            System.out.println("Temperatura: máx " + sTemp.getMaxima() + ", mín " + sTemp.getMinima() + ", media " + sTemp.getMedia());
            System.out.println("Lluvia: " + sLluvia.getTotal() + " l/m2, racha máxima " + sLluvia.getRachaMaxima() + " h y Alerta: " + sAlertas.getAlerta());
            
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }
    }
}