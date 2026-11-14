package brigadaCocina;

public class Cocinero implements Runnable{

	private String plato;
	private int pasos;
	
	public Cocinero(String plato, int pasos) {
		this.plato=plato;
		this.pasos=pasos;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String nombre = Thread.currentThread().getName();
		try {
		for (int i =0; i< pasos; i++) {
			System.out.println(nombre + ": paso "+ (i+1)+"/"+pasos+" de "+ plato);
			
				Thread.sleep(500);
		}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(nombre+ " plato terminado "+ plato);
		
	}		
}

