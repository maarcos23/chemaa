package montaje;

public class Operario implements Runnable{
	
	private LineaMontaje linea;
	private int miFase;
	private String trabajo;
	private int cantidad;
	private int ms;
	
	
	public Operario(LineaMontaje linea, int miFase, String trabajo, int cantidad, int ms) {
		this.linea = linea;
		this.miFase = miFase;
		this.trabajo = trabajo;
		this.cantidad = cantidad;
		this.ms = ms;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String nombre = Thread.currentThread().getName();
		
		for(int i =0; i<= cantidad; i++) {
			linea.esperarTurno(miFase);
			System.out.println(nombre + " " + trabajo + " la bicicleta " + i);
		}
	}

}
