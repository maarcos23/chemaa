package meteo;

public class GeneradorAlertas implements Runnable {
    private SensorTemperatura temperatura;
    private SensorLluvia lluvia;
    private String alerta;

    public GeneradorAlertas(SensorTemperatura temperatura, SensorLluvia lluvia) {
        this.temperatura = temperatura;
        this.lluvia = lluvia;
    }

    public String getAlerta() { return alerta; }

    @Override
    public void run() {
        String nombre = Thread.currentThread().getName();
        int prioridad = Thread.currentThread().getPriority();
        System.out.println(nombre + " empieza (prioridad " + prioridad + ")");

        if (lluvia.getTotal() >= 40) {
            alerta = "ALERTA NARANJA: lluvias intensas";
        } else if (lluvia.getRachaMaxima() >= 6) {
            alerta = "ALERTA AMARILLA: lluvia persistente";
        } else if (temperatura.getMaxima() >= 35) {
            alerta = "ALERTA AMARILLA: calor";
        } else if (temperatura.getMinima() <= 0 && lluvia.getTotal() > 0) {
            alerta = "AVISO: posible nieve";
        } else {
            alerta = "Sin alertas";
        }

        System.out.println(nombre + " termina: " + alerta);
    }
}