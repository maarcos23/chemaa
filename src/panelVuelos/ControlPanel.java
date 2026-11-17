package panelVuelos;

public class ControlPanel {

	private int lectores = 0;
	private boolean escribiendo = false;
	private int maxLectores =0;
	
	public synchronized void empezarLectura() {
		String hilo = Thread.currentThread().getName();
		while(escribiendo) {
			System.out.println(hilo+ " espera: el operador esta escribiendo");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			lectores++;
			if(lectores> maxLectores) {
				maxLectores = lectores;
			}
		}
	public synchronized void terminarLectura() {
		lectores--; 
	    
	    if (lectores == 0) { 
	        notifyAll();
	    }
	}
	public synchronized void empezarEscritura() {
		while(escribiendo || lectores > 0) {
			System.out.println("Operador espera: hay "+lectores+" pantallas letendo");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			escribiendo =true;
	}
	public synchronized void terminarEscritura() {
		escribiendo = false;
		notifyAll();
	}
	
	public synchronized int getMaxLectores() {
		return maxLectores;
	}
	
}
