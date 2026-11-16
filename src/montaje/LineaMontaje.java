package montaje;

public class LineaMontaje {

	private int turno =0;
	private int fases;
	private int bicicletas=0;
	
	public LineaMontaje(int fases) {
		this.fases=fases;
	}
	
	public synchronized void esperarTurno(int miFase) {
		String hilo= Thread.currentThread().getName();
	
		while(turno != miFase) {
			System.out.println(hilo + "espera: es el turno de la fase "+ turno+ 
					" y espera");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(hilo+" fue interrumpido");
			}
		}
	}
	public synchronized void pasaTurno() {
		turno++;
		if(turno>= fases) {
			turno =0;
			bicicletas++;
			System.out.println("*** Bicicleta "+ bicicletas+" terminada ***.");
		}
		/*
		 * Uso notifyAll por que si uso notify solo puede despertar a
		 * un hilo que no le toque y que se vuelva al wait, lo que haría
		 * que el programa se bloqueara
		 */
		notifyAll();
	}
	public synchronized int getBicicletas() {
        return bicicletas;
    }
}
