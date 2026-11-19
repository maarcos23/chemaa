package examenClaude;

public class Pantalla {

	private int corredores;
	private int turno=0;
	private int tVueltas=0;
	
	public Pantalla(int corredores) {
		this.corredores=corredores;
	}

	public synchronized void correr(int miTurno, int vuelta) {
        String nombre = Thread.currentThread().getName();
        while (turno != miTurno) {                       // no es mi turno: espero
            System.out.println(nombre + " espera: el testigo lo tiene el corredor " + (turno + 1));
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " corre su tramo (vuelta " + vuelta + ")");
    }
	
	 public synchronized void darTestigo() {
	        turno = (turno + 1) % corredores;                // pasa al siguiente; tras el último vuelve a 0
	        if (turno == 0) {                                // el último acaba de entregarlo: vuelta completa
	            tVueltas++;
	            System.out.println("*** Vuelta " + tVueltas + " completada ***");
	        }
	     
	        notifyAll();
	    }

	   public synchronized int getVueltasCompletadas() {
	        return tVueltas;
	    }
	}