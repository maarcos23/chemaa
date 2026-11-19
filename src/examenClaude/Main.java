package examenClaude;

public class Main {

	private final static int CORREDORES =4;
	private final static int VUELTAS =3;
	private final static int[] TIEMPOS = {150, 200, 250, 100};
	
	public static void main (String[]args) {
		
		Pantalla pantalla = new Pantalla(CORREDORES);
		Corredor[] corredor= new Corredor[CORREDORES];
		Thread[]hilos = new Thread[CORREDORES];
		
		for(int i=0; i < CORREDORES; i++) {
			corredor[i] = new Corredor(pantalla, i, VUELTAS, TIEMPOS[i]);
			hilos[i] = new Thread(corredor[i], "Corredor-"+(i+1));
		}
		
		long inicio = System.currentTimeMillis();
	
		for(int i=CORREDORES -1; i>=0; i--) {
			hilos[i].start();
		}
		
		for(int i=0; i<CORREDORES; i++) {
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		long tiempo = System.currentTimeMillis() - inicio;
		  int totalTramos = 0;
	        for (int i = 0; i < CORREDORES; i++) {
	            totalTramos += corredor[i].getTramos();
	        }

	        System.out.println("=== Fin de la carrera ===");
	        System.out.println("Vueltas completadas: " + pantalla.getVueltasCompletadas());
	        System.out.println("Tramos corridos: " + totalTramos);
	        System.out.println("Tiempo: " + tiempo + " ms");
	    }
	}