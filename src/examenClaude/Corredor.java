package examenClaude;

public class Corredor implements Runnable{

	private Pantalla pantalla;
	private int miTurno;
	private int vueltas;
	private int ms;
	private int tramos;
	public Corredor(Pantalla pantalla, int miTurno, int vueltas, int ms) {
		super();
		this.pantalla = pantalla;
		this.miTurno = miTurno;
		this.vueltas = vueltas;
		this.ms = ms;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int vuelta =1; vuelta <= vueltas; vuelta++) {
		
			try {
				pantalla.correr(miTurno, vuelta);
				Thread.sleep(ms);
				pantalla.darTestigo();
				tramos++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public int getTramos() {
	    return tramos;
	}	
}
