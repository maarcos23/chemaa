package examenClaude;

public class Pista {

	private int corredores;
	private int turno=0;
	private int vueltasActuales=0;

	public Pista(int corredores) {
		this.corredores=corredores;
	}
	
	public synchronized void esperarTurno(int miTurno, int vuelta) {
		String nombre = Thread.currentThread().getName();
		while(turno != miTurno) {
			try {
				System.out.println(nombre+" espera: el testigo lo tiene el corredor "+ (turno+1));
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(nombre+" core su tramo nº "+vuelta);
		
	}
	
	public synchronized void pasarTestigo() {
	turno = (turno+1) %corredores;
	if(turno ==0) {
		vueltasActuales++;
		System.out.println("vuelta numero "+vueltasActuales+" completada");
		}
	notifyAll();
	}
	

	public synchronized int getTurno() {
		return turno;
	}

	public synchronized int getVueltasActuales() {
		return vueltasActuales;
	}
}
