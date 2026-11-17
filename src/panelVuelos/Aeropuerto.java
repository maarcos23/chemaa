package panelVuelos;

public class Aeropuerto {
    public static final int LECTURAS = 6;
    public static final int MS_PAUSA = 150;
    public static final int ACTUALIZACIONES = 4;

    public static void main(String[] args) {
        Panel panel = new Panel();
        ControlPanel control = new ControlPanel();

        Pantalla[] pantallas = new Pantalla[3];
        Thread[] hilosPantalla = new Thread[3];

        for (int i = 0; i < 3; i++) {
            pantallas[i] = new Pantalla(panel, control, LECTURAS, MS_PAUSA);
            hilosPantalla[i] = new Thread(pantallas[i], "Pantalla-" + (i + 1));
        }

        Operador tareaOperador = new Operador(panel, control, ACTUALIZACIONES);
        Thread hiloOperador = new Thread(tareaOperador, "Operador");

        long tiempoInicio = System.currentTimeMillis();

        for (int i = 0; i < 3; i++) {
            hilosPantalla[i].start();
        }
        hiloOperador.start();

        try {
            for (int i = 0; i < 3; i++) {
                hilosPantalla[i].join();
            }
            hiloOperador.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }

        long tiempoFin = System.currentTimeMillis();
        long tiempoTotal = tiempoFin - tiempoInicio;

        int sumaIncoherentes = 0;
        for (int i = 0; i < 3; i++) {
            sumaIncoherentes += pantallas[i].getIncoherentes();
        }

        System.out.println("=== Fin de la prueba del panel ===");
        System.out.println("Lecturas incoherentes: " + sumaIncoherentes);
        System.out.println("Máximo de pantallas leyendo a la vez: " + control.getMaxLectores());
        System.out.println("Panel final: retraso " + panel.getRetraso() + " min, salida " + panel.hora(panel.getSalida()));
        System.out.println("Tiempo: " + tiempoTotal + " ms.");
    }
}