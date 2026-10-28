package brigadaCocina;

public class Cocinero implements Runnable {

	private String platos;
	private int pasos;
	public Cocinero(String platos, int pasos) {
		this.pasos = pasos;
		this.platos= platos;
	}
	
	//Contener tarea a realizar por el hilo
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		String nombre_cocinero = Thread.currentThread().getName();
		for(int i = 1; i <= pasos; i++) {
			System.out.println(nombre_cocinero+": paso "+ i+ "/"+ pasos + " de "+ platos);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
